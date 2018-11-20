## 一、概念
- 工厂方法模式：用来封装对象的创建。工厂方法模式（Factory Method Pattern）通过让**子类**决定该创建的对象是什么，来达到将对象创建的过程封装的目的。这样，关于超类的代码和子类创建对象的代码之间就解耦了。
- 角色：  
&emsp;1、抽象工厂（Creator）：定义了一个抽象的工厂方法，让子类实现此方法制造产品。  
&emsp;2、具体工厂（ConcreteCreator）：实现抽象工厂方法，包含具体生产产品的实现代码，返回一个产品的实例。  
&emsp;3、抽象产品（Product）：定义一个抽象的产品，为了工厂中创建产品类型的匹配。  
&emsp;4、具体产品（ConcreteProduct）：实现抽象产品，包含各自产品的特色代码。  
## 二、Demo 实现  

TOPIC:我们要定义一个披萨店，并允许个人或机构加盟，而且个人或机构可以根据当地不同的口味生产不同的披萨。  

#### 1、抽象工厂 - PizzaStore.java
```
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        System.out.println(pizza.name);
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    
    protected abstract Pizza createPizza(String type);
}
```
这里，我们定义了一个抽象工厂角色，并定义了一个抽象工厂方法。这样产品（Pizza）的实例化过程会交由抽象工厂的子类 —— 具体工厂去创建。  
#### 2、抽象产品 - Pizza.java
```
public abstract class Pizza {
    /**
     * 披萨的名字
     */
    protected String name;

    protected void bake() {
        System.out.println("烘烤25分钟...");
    }

    protected void cut() {
        System.out.println("把匹萨沿着对角线切开...");
    }

    protected void box() {
        System.out.println("包装用官方标准的盒子...");
    }
}
```
这里，我们定义了一个抽象产品角色，之所以把产品定义成抽象的，有两个原因：一是为了在具体工厂中生产的产品可以用统一的抽象父类来接收；二是为了让加盟商可以任意的扩展自己的产品。这种设计符合我们的设计原则 —— 面向接口（或抽象）编程，不面向实现编程。  
#### 3、具体产品  
现在有加盟商要加盟我们的商店，他希望能够按照他们的地方特色，自定义他们要出售的披萨...那么，只要扩展 Pizza 类就可以了！ 
```
public class CheesePizza extends Pizza {
    public CheesePizza() {
        name = "这是一个奶酪披萨";
    }
    @Override
    protected void bake() {
        System.out.println("烘烤30分钟...");
    }
    @Override
    protected void cut() {
        System.out.println("把匹萨按四等分切开...");
    }
    @Override
    protected void box() {
        System.out.println("包装用奶酪披萨特制的盒子...");
    }
}
```
```
public class DurianPizza extends Pizza {
    public DurianPizza() {
        name = "这是一个榴莲披萨";
    }
    @Override
    protected void bake() {
        System.out.println("烘烤45分钟...");
    }
    @Override
    protected void cut() {
        System.out.println("把匹萨按三等分切开...");
    }
    @Override
    protected void box() {
        System.out.println("包装用榴莲披萨特制的盒子...");
    }
}
```
#### 4、具体工厂 - PizzaFactory.java
```
public class PizzaFactory extends PizzaStore {
    
    @Override
    protected Pizza createPizza(String type) {
        switch (type) {
            case "cheese":
                return new CheesePizza();
            case "durian":
                return new DurianPizza();
            default:
                break;
        }
        return null;
    }
}
```
这里，我们定义了一个具体工厂角色，继承自抽象工厂，产品（Pizza）的具体实例化代码在这里实现。  
#### 5、测试
```
public class Test {

    public static void main(String[] args) {
        PizzaStore store = new PizzaFactory();
        store.orderPizza("cheese");
        store.orderPizza("durian");
    }
}
``` 
## 三、总结
- 优点：  
&emsp;1、将创建对象的代码集中在一个对象或方法中，可以避免代码的重复，而且更方便于以后的维护。  
&emsp;2、客户在实例化对象时，只会依赖于接口，而不是具体类。