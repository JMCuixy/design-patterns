## 一、概念  
- 代理模式：为另一个对象提供一个替身或占位符已控制对这个对象的访问，管理访问的方式有许多种。    
- 角色：   
&emsp;1、Subject：主题接口，为 RealSubject 和 Proxy 提供了接口。通过实现同一接口，Proxy 在 RealSubject 出现的地方的取代它。  
&emsp;2、RealSubject：具体主题，是真正做事的地方，它是被 proxy 代理和控制访问的对象。  
&emsp;3、Proxy：代理对象，持有 RealSubject 的引用，客户和 RealSubject 的交互都必须通过 Proxy。 在某些场景，Proxy 还会负责 RealSubject 对象的创建和销毁。  
![](https://img2018.cnblogs.com/blog/1153954/201901/1153954-20190126212111349-1347202242.jpg)

## 二、代理模式的几种变体  
### 1、远程代理   
&emsp;之前在看《Spring 实战》的时候，接触到了[<font color="blue">RPC机制</font>](https://www.cnblogs.com/jmcui/p/9044212.html)。现在在读设计模式的时候，才发现 RPC 在设计模式中还有另外一个名字 —— 远程代理。所以这里就不展开讲了，详细了解可参考之前的文章。  

### 2、虚拟代理    
&emsp;虚拟代理作为创建开销大的对象的代表。虚拟代理经常直到我们真正需要一个对象的时候才创建它。当对象在创建前和创建中的时，由虚拟代理来扮演对象的替身。对象创建后，代理就会将请求直接委托给对象。  

&emsp;我们来看一个简单Demo，对于虚拟代理和普通代理的区别就一目了然了~~   
#### Subject.java  
```
/**
 * @Description: 主题接口
 */
public interface Subject {

    void request();
}
```
#### RealSubject.java  
```
/**
 * @Description:具体主题 — 真正做事的地方
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("this is real subject.");
    }
}
```
#### Proxy.java - 普通代理
```
/**
 * @Description: 普通代理
 */
public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        subject.request();
    }
}
```
#### VirtualProxy.java - 虚拟代理
```
/**
 * @Description: 虚拟代理
 */
public class VirtualProxy implements Subject {

    private Subject subject;

    @Override
    public void request() {
        // 在真正使用的时候才创建对象
        if (subject == null) {
            subject = new RealSubject();
        }
        subject.request();
    }
}
```
#### 测试  
```
public class Test {

    public static void main(String[] args) {
        //1、普通代理
        Subject subject = new RealSubject();
        Proxy proxy = new Proxy(subject);
        proxy.request();

        //2、虚拟代理
        Subject virtualProxy = new VirtualProxy();
        virtualProxy.request();
    }
}
```

### 3、保护代理    
&emsp;Java 在java.lang.reflect包中有自己的代理支持，利用这个包你可以在运行时动态的创建一个代理类，并将方法的调用转发到你说指定的类。因为实际的代理类是在运行时创建的，我们称这个Java技术为：动态代理。  

&emsp;我们要利用 Java 的动态代理创建一个保护代理实现。所谓保护代理，有点像权限控制系统，代理会拦截所有的请求并判断该次请求是否有权限访问对应的资源。  

![](https://img2018.cnblogs.com/blog/1153954/201901/1153954-20190130093636175-1635059208.jpg)  

现在我们用保护代理简单的做一个权限控制，具体表现为：顾客可以查看商品的名字、详情、价格，而卖家可以看到商品的所有信息，包括利润等。  
#### 商品 — Goods.java    
```
public interface Goods {
    
    /**
     * @Description 商品的名字、详情、价格 —— 顾客可以查看
     */
    String getName(Long id);

    String getDetail(Long id);

    BigDecimal getPrice(Long id);

    /**
     * @Description 商品的利润 —— 只有卖家可以看到
     */
    BigDecimal getProfit(Long id);
}
```
#### InvocationHandler    
&emsp;InvocationHandler 的工作是响应代理的任何调用。你可以把 InvocationHandler 想成是代理收到方法调用后，请求做实际工作的对象。就是在 InvocationHandler 中，我们对请求进行筛选，判断是否有权限访问相应的资源。  
```
/**
 * @Description: 顾客InvocationHandler — 看不到商品利润信息
 */
public class CustomerInvocationHandler implements InvocationHandler {

    private Goods goods;

    public CustomerInvocationHandler(Goods goods) {
        this.goods = goods;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("getName".equals(method.getName())
                || "getDetail".equals(method.getName())
                || "getPrice".equals(method.getName())) {
            return method.invoke(goods, args);
        }
        if ("getProfit".equals(method.getName())) {
            throw new IllegalAccessException();
        }
        return null;
    }
}
```
```
/**
 * @Description: 商家InvocationHandler — 可以看到所有信息
 */
public class SellerInvocationHandler implements InvocationHandler {

    private Goods goods;

    public SellerInvocationHandler(Goods goods) {
        this.goods = goods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(goods, args);
    }
}
```
#### 测试
```
public class Test {
    
    public static void main(String[] args) {
        Goods goods = new Clothes();
        // 创建顾客代理
        Goods customer = (Goods) Proxy.newProxyInstance(goods.getClass().getClassLoader(),
                goods.getClass().getInterfaces(),
                new CustomerInvocationHandler(goods));
        // 创建卖家代理
        Goods seller = (Goods) Proxy.newProxyInstance(goods.getClass().getClassLoader(),
                goods.getClass().getInterfaces(),
                new SellerInvocationHandler(goods));
        // 判断某个类是不是代理类
        System.out.println(Proxy.isProxyClass(customer.getClass()));
        
        // 卖家代理调用
        System.out.println("-------卖家代理调用开始--------");
        System.out.println(seller.getName(800001L));
        System.out.println(seller.getDetail(800001L));
        System.out.println(seller.getPrice(800001L).doubleValue());
        System.out.println(seller.getProfit(800001L).doubleValue());
        System.out.println("-------卖家代理调用结束--------");

        // 顾客代理调用
        System.out.println("-------顾客代理调用开始--------");
        System.out.println(customer.getName(800001L));
        System.out.println(customer.getDetail(800001L));
        System.out.println(customer.getPrice(800001L).doubleValue());
        System.out.println(customer.getProfit(800001L).doubleValue());
        System.out.println("-------顾客代理调用结束--------");
    }
}
```

## 三、总结  
- 在真实的世界中，代理模式有许多变体，这些变体都有共通点：都会将客户对主题（Subject）施加的方法调用拦截下来。这种间接的级别让我们可以做很多事，包括将请求分发到远程主题 — 远程代理；给创建开销大的对象提供代表 — 虚拟代理；或者提供某些级别的保护 — 保护代理。
- 除了上面看到的代理模式的变体，代理模式还有很多应用场景：  
&emsp;1、防火墙代理（Firewall Proxy）：控制网络资源的访问，保护主题免于“坏客户”的侵害。  
&emsp;2、智能引用代理（Smart Reference Proxy）：当主题被引用时，进行额外的动作，例如计算一个对象被引用的次数。  
&emsp;3、缓存代理（Caching Proxy）：为开销大的运算结果提供暂时的存储：它为允许多个客户共享结果，以减少计算和网络延迟。  
&emsp;4、同步代理（Synchronization Proxy）：在多线程的情况下为主题提供安全的访问。  
&emsp;5、复杂隐藏代理（Complexity Hiding Proxy）：用来隐藏一个类的复杂集合的复杂度，并进行访问控制，有时候也被称为外观代理（Facade Proxy）。看起来有点像外观模式，区别在于外观模式只提供了另一组接口，而外观代理控制访问。  
- 如何让客户使用代理，而不是真正的对象？一个常用的技巧是提供一个工厂，实例化并返回主题 — 代理工厂。因为这是在工厂方法内发生的，我们可以用代理包装主题再返回，而客户不知道也不在乎他使用的是代理还是真东西。  
- 装饰者模式为对象增加行为，而代理模式是控制对象的访问。  
- 适配器模式会改变对象适配的接口，而代理模式则实现相同的接口。   
- 优点：  
&emsp;1、代理模式能够协调调用者和被调用者，在一定程度上降低了系统的耦合度。    
&emsp;2、代理对象可以在客户端和目标对象之间起到中介的作用，这样起到了保护目标对象的作用。  
- 缺点：  
&emsp;1、由于在客户端和真实对象之间增加了代理对象，请求的链路变长，可能会导致请求速度变慢。  
 
**演示源代码：**[<font color=#0000ff>https://github.com/JMCuixy/design-patterns</font>](https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/proxy)  
**<font color="red">tips</font>**：transient 关键字，告诉 jvm 不要序列化这个字段。 

## 四、寄语
&emsp;年前的最后一篇文章了，祝愿大家新年快乐。愿大家早日实现财务自由！愿大家此生想得到的都拥有，得不到的都释怀！