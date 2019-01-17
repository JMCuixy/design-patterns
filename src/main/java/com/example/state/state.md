## 一、概念  
- 状态模式：允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它的类。这个模式将状态封装成为独立的类，并将动作委托到代表当前状态的对象，我们知道行为会随着内部状态而改变。
- 一个对象“看起来好像修改了它的类”是什么意思呢？从客户的视角来看：如果说你使用的对象能够完全改变它的行为，那么你会觉得，这个对象实际上是从别的类实例化而来的。然而，实际上，状态模式是在使用组合通过简单引用不同的状态对象来造成类改变的假象。
- 角色：   
&emsp;1、上下文（Context）: 定义客户感兴趣的接口。通常负责具体状态的切换。维护多个 ConcreteState 子类的实例，每个实例分别代表不同的状态。    
&emsp;2、抽象状态类（State）: 定义一个接口或抽象类以封装与 Context 的状态相关的行为。  
&emsp;3、具体状态类（ConcreteState）: 实现 State，实现与 Context 的一个状态相关的行为。每个 ConcreteState 都表示 Context 的一个状态。   
  
![](https://img2018.cnblogs.com/blog/1153954/201901/1153954-20190114092307139-965922926.png)

## 二、Demo 实现  
&emsp;我们以一个网约车订单场景来做一个简单的 Demo 示例。订单分为四个状态 —— New（新建）、Running（进行中）、Cancel（取消）、End（结束）。当乘客下单时，订单状态进入 New 状态。这时，如果有司机接单，订单状态进入 Running 状态；如果无司机接单，乘客取消订单，订单进入 Cancel 状态。最后，乘客评价，Running 状态的订单进入 End 状态。
![](https://img2018.cnblogs.com/blog/1153954/201901/1153954-20190116084835767-1105088551.png)
### 1、抽象状态类  
```
 * @Description: 抽象状态
 * @author: cuixiuyin
 * @date: 2019/01/16 08:57
 */
public interface State {
    /***
     * @Description 乘客下单，订单创建
     * @author cuixiuyin
     * @date 2019/01/16 08:59
     */
    void orderCreate();

    /***
     * @Description 乘客取消，订单取消
     * @author cuixiuyin
     * @date 2019/01/16 08:59
     */
    void orderCancel();

    /***
     * @Description 司机接单，订单匹配
     * @author cuixiuyin
     * @date 2019/01/16 08:59
     */
    void orderMatch();

    /***
     * @Description 乘客评价，订单结束
     * @author cuixiuyin
     * @date 2019/01/16 08:59
     */
    void evaluation();
}
```
这里，我们定义了一个抽象状态类，封装了与 Context 的状态有关的行为 —— 乘客下单、乘客取消、司机接单、乘客评价。  
### 2、具体状态类 
- New 状态：     
```
public class NewState implements State {

    private Order order;

    public NewState(Order order) {
        this.order = order;
    }

    @Override
    public void orderCreate() {
        System.out.println("您有一个订单等待司机接单，不可新建订单");
    }

    @Override
    public void orderCancel() {
        System.out.println("乘客取消订单，订单取消中...");
        // 改变状态 New -> Cancel
        order.setState(order.getCancelState());
    }

    @Override
    public void orderMatch() {
        System.out.println("司机接单中...");
        // 改变状态 New -> Running
        order.setState(order.getRunningState());
    }

    @Override
    public void evaluation() {
        System.out.println("新创建订单，不可评价");
    }
}
```
- Cancel 状态：
```
public class CancelState implements State {

    private Order order;

    public CancelState(Order order) {
        this.order = order;
    }

    @Override
    public void orderCreate() {
        System.out.println("乘客下单，订单新建中...");
        // 改变状态(取消后可以开始新一轮叫单) Cancel -> New
        order.setState(order.getNewState());
    }

    @Override
    public void orderCancel() {
        System.out.println("订单已被取消，无可取消订单...");
    }

    @Override
    public void orderMatch() {
        System.out.println("无法接单，该订单已被乘客取消...");
    }

    @Override
    public void evaluation() {
        System.out.println("已取消订单不可评价...");
    }
}
```
- Running 状态： 
```
public class RunningState implements State {

    private Order order;

    public RunningState(Order order) {
        this.order = order;
    }

    @Override
    public void orderCreate() {
        System.out.println("您有订单在进行中，不可新建订单...");
    }

    @Override
    public void orderCancel() {
        System.out.println("正在行程中的订单，无法取消");
    }

    @Override
    public void orderMatch() {
        System.out.println("您有订单在进行中，不可接其他单");
    }

    @Override
    public void evaluation() {
        System.out.println("乘客评价订单，订单结束...");
        // 改变状态 Running -> End
        order.setState(order.getEndState());
    }
}
```
- End 状态： 
```
public class EndState implements State {

    private Order order;

    public EndState(Order order) {
        this.order = order;
    }

    @Override
    public void orderCreate() {
        System.out.println("乘客下单，订单新建中...");
        // 改变状态(订单结束后可以开始新一轮叫单) End -> New
        order.setState(order.getNewState());
    }

    @Override
    public void orderCancel() {
        System.out.println("无可取消订单");
    }

    @Override
    public void orderMatch() {
        System.out.println("无可匹配订单");
    }

    @Override
    public void evaluation() {
        System.out.println("无可评价订单");
    }
}
```
这里，我们定义了四个具体状态类（New、Cancel、Running、End），每个状态类都持有 Context 的引用，状态之间的切换由 Context 实例来进行。  
### 3、Context 上下文  
```
public class Order {

    private State newState;
    private State cancelState;
    private State runningState;
    private State endState;

    // 默认订单已结束，可开始新一轮叫单
    private State state;

    public Order() {
        newState = new NewState(this);
        cancelState = new CancelState(this);
        runningState = new RunningState(this);
        endState = new EndState(this);
        state = endState;
    }
    
    void orderCreate() {
        state.orderCreate();
    }
    
    void orderCancel() {
        state.orderCancel();
    }
    
    void orderMatch() {
        state.orderMatch();
    }
    
    void evaluation() {
        state.evaluation();
    }


    public void setState(State state) {
        this.state = state;
    }


    public State getNewState() {
        return newState;
    }

    public State getCancelState() {
        return cancelState;
    }

    public State getRunningState() {
        return runningState;
    }

    public State getEndState() {
        return endState;
    }
}
```
这里，我们定义了Context，Context 持有所有需要转换的状态实例，并把每一个行为动作都委托给状态来进行。  
### 4、测试    
```
public class Test {

    public static void main(String[] args) {
        Order order = new Order();
        //1、新建订单
        order.orderCreate();
        //2、取消订单
        order.orderCancel();
        //3、新建订单
        order.orderCreate();
        //4、司机接单
        order.orderMatch();
        //5、尝试取消订单
        order.orderCancel();
        //6、乘客评价
        order.evaluation();
    }
}
```
![](https://img2018.cnblogs.com/blog/1153954/201901/1153954-20190117090902305-1429381712.png)

![](https://img2018.cnblogs.com/blog/1153954/201901/1153954-20190117085908784-1143782854.png)

演示源代码：[<font color=#0000ff>https://github.com/JMCuixy/design-patterns</font>](https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/state)    


## 三、总结  
- 状态模式允许一个对象基于内部状态而拥有不同的行为。  
- 通过将每个状态封装进一个类，我们把以后需要做的任何改变局部化了,便于扩展和理解。  
- 客户不会直接改变 Context 的状态。全盘了解状态是 Context 的工作。Context 会将行为委托给当前状态对象。  
- 状态类可以被多个 Context 实例共享。  
- 基本常识：策略模式和状态模式时双胞胎（它们有相同的类图），在出生时才分开（它们的意图不同）。策略模式和状态模式有什么区别呢？  
&emsp;1、以状态模式而言，我们将一群行为封装在状态对象中，Context 的行为可委托到那些状态对象中的一个。随着时间的流逝，当前状态在状态对象集合中游走改变，以反映出 Context 内部的状态，因此， Context 的行为也会跟着改变。  
&emsp;2、以策略模式而言，客户通常主动指定 Context 所要组合的策略对象是哪一个。现在，固然策略模式让我们具有弹性，能够运行时改变策略，但对于某个 Context 对象来说，通常都只有一个最适合的策略对象。  
&emsp;3、一般来说，我们把状态模式想成是不用在 Context 中放置许多条件判断的替代方案。通过将行为包装进状态对象中，你可以通过在 Context 内简单的改变状态对象来改变 Context 的行为。  
&emsp;4、一般来说，我们将策略模式想成是除了继承之外的一种弹性替代方案。有了策略模式，我们可以通过组合不同的对象来改变行为。  
- 使用状态模式通常会导致设计中类的数目大量增加。（这几乎是所有设计模式的通病）