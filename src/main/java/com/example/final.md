## 一、剩下的模式  

### 1、桥接模式（Bridge Pattern）

- 概念：不只改变你的实现，也改变你的抽象。桥接模式的主要特点是把抽象(Abstraction)与行为实现(Implementation)分离开来，从而可以保持各部分的独立性以及应对他们的功能扩展。  
- 角色：  
&emsp;1. 实现类接口（Implementor）：定义行为实现接口。  
&emsp;2. 具体实现类（ConcreteImplementor）：实现 Implementor 接口，提供不同的行为实现。  
&emsp;3. 桥接抽象类（Abstraction）：用于定义抽象类的接口，它一般是抽象类而不是接口，其中定义了一个Implementor（实现类接口）类型的对象并可以维护该对象，它与Implementor之间具有关联关系，它既可以包含抽象业务方法，也可以包含具体业务方法。   
&emsp;4. 扩充抽象类（RefinedAbstraction）：扩充由 Abstraction 定义的接口，通常情况下它不再是抽象类而是具体类，它实现了在 Abstraction 中声明的抽象业务方法，在 RefinedAbstraction 中可以调用在 Implementor 中定义的业务方法。  
- UML图：  
![](https://img2018.cnblogs.com/blog/1153954/201902/1153954-20190213175715135-119471929.png)

- 优点：将抽象与行为实现解耦，二者可以独立扩展，不会影响到对方。  
- 适用场景：当需要使用不同的方式改变接口和实现时。  
- Demo 实现：[<font color=#0000ff>https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/bridge</font>](https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/bridge)  


### 2、建造者模式（Builder Pattern）

- 概念：封装一个产品的构造过程，并允许按步骤构造。建造者模式可以将一个产品的内部表象与产品的生成过程分割开来，从而使一个建造过程生成具有不同的内部表象的产品对象。  
- 角色：  
&emsp;1. 抽象建造者（Builder）：给出一个抽象接口，以规范产品对象的各个组成成分的建造。  
&emsp;2. 具体建造者（Concrete Builder）：实现 Builder 角色提供的接口，一步一步完成创建产品实例的过程；在建造过程完成后，提供产品的实例。  
&emsp;3. 指导者（Director）：与客户端打交道，调用具体建造者角色以创建产品对象，指导者并没有产品类的具体知识。  
&emsp;4. 产品（Product）：具体建造者构建的复杂对象。  
- UML图：  
![](https://img2018.cnblogs.com/blog/1153954/201902/1153954-20190214090752090-1738771515.png)

- 优点：  
&emsp;1. 将一个复杂对象的创建过程封装起来；向客户隐藏产品内部的实现。  
&emsp;2. 允许对象通过多个步骤来创建，并且可以改变过程（这和只有一个步骤的工厂模式不同）。  
&emsp;3. 产品的实现可以被替换，因为客户只看到一个抽象的接口。  
- 建造者模式和模板方法模式的比较区别？  
&emsp;1. 建造者是使用组合方式实现不同的表示，而模板方法使用的是继承的方式。  
&emsp;2. 建造者抽象的是构建过程，而模板方法提取的是实现公共。  
- Demo 实现：[<font color=#0000ff>https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/builder</font>](https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/builder)  

### 3、责任链模式（Chain of Responsibility Pattern）  

- 概念：让一个以上的对象有机会能够处理某个请求。责任链模式为请求创建了一条接收者对象的链，每个接收者都包含对另一个接收者的引用，当某个接受者不能处理该请求时，会将该请求转给下一个接受者处理。  
- 角色：  
&emsp;1. 抽象请求处理者（Handler）：是所有具体请求处理者的父类。  
&emsp;2. 具体请求处理者（Concrete Handler）：实现抽象请求处理者，包含下一个具体请求处理者的引用。
- UML图：  
![](https://img2018.cnblogs.com/blog/1153954/201902/1153954-20190214182534489-595586103.png)

- 优点：  
&emsp;1. 弱化了发出请求的人和处理请求的人之间的关系。发出请求的人只需要向第一个具体的处理者发送请求，然后就可以不用管了，处理者会在责任链上自己寻找处理的方法。  
&emsp;2. 通过改变链内的成员或调动他们的次序，允许你动态地新增或删除责任。   
- 缺点：请求需要在责任链上传播责任，直至找到合适的处理对象。这样虽然提高了程序的灵活性，但同时也出现了处理的延迟。  
- 应用场景：在视窗系统中，经常会使用到责任链模式，尤其是事件的处理，熟悉 javaScript 开发的朋友，可能会知道，浏览器中的事件有冒泡机制，就是事件的是向父控件传播的，如果自己处理不了，就会传播给父控件去处理。  
- Demo 实现：[<font color=#0000ff>https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/chain_of_responsibility</font>](https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/chain_of_responsibility)   

**<font color="red">tips</font>**：Struts 的拦截器，Servlet 的过滤器，Netty 的 ChannelPipeline 都是责任链模式~  

### 4、蝇量模式（Flyweight Pattern）

- 概念：让某个类的一个实例能用来提供许多“虚拟实例”。蝇量模式主要用于减少创建对象的数量，以减少内存占用和提高性能。蝇量模式尝试重用现有的同类对象，如果未找到匹配的对象，则创建新对象。  
- 角色：  
&emsp;1. 抽象蝇量（Flyweight）：定义了对蝇量对象外部状态的操作接口。使用该接口，可在Client中修改蝇量对象的外部状态。  
&emsp;2. 可共享内部状态的具体蝇量（ConcreteFlyweight）：维护可以共享的内部状态；实现操作外部状态的接口。  
&emsp;3. 无可共享内部状态的具体蝇量（UnsharedConcreteFlyweight）：无内部状态，所以只实现操作外部状态的接口。  
&emsp;4. 蝇量工厂（FlyweightFactory）：负责管理蝇量对象，形成一个对象池，提供对取出对象的方法，取出时若池中对象足够，就直接返回，若对象不足则创建后返回。  
- UML：  
![](https://img2018.cnblogs.com/blog/1153954/201902/1153954-20190215202242174-183906234.png)

- 优点： 
&emsp;1. 减少运行时对象实例的个数，节省内存。   
&emsp;2. 将许多“虚拟”对象（可共享内部状态的具体蝇量）的状态集中管理。    
- 缺点：单个的逻辑实例将无法拥有独立而不同的行为。  
- 应用场景：当一个类有许多的实例，而这些实例能被同一方法控制的时候。  
- Demo 实现：[<font color=#0000ff>https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/flyweight</font>](https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/flyweight)  

### 5、解释器模式（Interpreter Pattern）  

- 概念：给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。  
- 角色：  
&emsp;1. 抽象表达式（Expression）：声明一个所有的具体表达式都需要实现的抽象接口；这个接口主要是一个interpret()方法，称做解释操作。  
&emsp;2. 终结符表达式（Terminal Expression）：终结符表达式，实现了抽象表达式所要求的接口；文法中的每一个终结符都有一个具体终结表达式与之相对应。比如公式 R = R1 + R2，R1 和 R2 就是终结符，对应的解析 R1 和 R2 的解释器就是终结符表达式。  
&emsp;3. 非终结符表达式（Nonterminal Expression）：文法中的每一条规则都需要一个具体的非终结符表达式，非终结符表达式一般是文法中的运算符或者其他关键字，比如公式 R = R1 + R2 中，“+"就是非终结符，解析“+”的解释器就是一个非终结符表达式。  
&emsp;4. 上下文（Context）：它的任务一般是用来存放文法中各个终结符所对应的具体值，比如 R = R1 + R2，给 R1 赋值100，给 R2 赋值200，这些信息需要存放到上下文中。  
- UML：  
![](https://img2018.cnblogs.com/blog/1153954/201902/1153954-20190216094055874-1034934455.png)

- 优点：  
&emsp;1. 将每一个语法规则表示成一个类，方便于实现语言。  
&emsp;2. 因为语法由许多类表示，所以你可以轻易的改变或者扩展此语言。  
&emsp;3. 通过在类结构中加入新的方法，可以在解释的同时增加新的行为。例如打印格式的美化或者进行复杂的程序验证。  
- 应用场景：  
&emsp;1. 解释器模式在平常使用的较少，可以用来处理脚本语言和编程语言。  
&emsp;2. 当你需要实现一个简单的语言时，或者简单比效率更重要时，使用解释器模式。  
- Demo 实现：[<font color=#0000ff>https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/interpreter</font>](https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/interpreter)

### 6、中介者模式（Mediator Pattern）  

- 概念：来集中相关对象之间复杂的沟通和控制方式。中介者模式定义了一个中介对象来封装一系列对象之间的交互关系。中介者使各个对象之间不需要显式地相互引用，从而使耦合性降低，而且可以独立地改变它们之间的交互行为。   
- 角色：  
&emsp; 1. 抽象中介者（Mediator）角色：它是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法。
&emsp; 2. 具体中介者（ConcreteMediator）角色：实现中介者接口，定义一个 List 来管理同事对象，协调各个同事角色之间的交互关系，因此它依赖于同事角色。
&emsp; 3. 抽象同事类（Colleague）角色：定义同事类的接口，保存中介者对象，提供同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能。
&emsp; 4. 具体同事类（Concrete Colleague）角色：是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互。
- UML：
![](https://img2018.cnblogs.com/blog/1153954/201902/1153954-20190218093713202-26832515.png)  

- 优点： 
&emsp;1. 通过将对象彼此解耦，可以增加对象的复用性。  
&emsp;2. 通过将控制逻辑集中，可以简化系统维护。  
&emsp;3. 将对象间的一对多关联转变为一对一的关联，可以让对象之间所传递的消息变得简单而且大幅减少。  
- 缺点：如果设计不当，中介者对象本身会变得过于复杂。  
- 应用场景：    
&emsp;1. 中介者模式常常被用来协调相关的 GUI 组件。   
&emsp;2. 当一组对象要进行沟通或者业务上的交互，但是其关系却又很复杂混乱时。  
- Demo 实现：[<font color=#0000ff>https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/mediator</font>](https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/mediator)  

### 7、备忘录模式（Memento Pattern）

- 概念：在不破坏封闭的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。备忘录模式的目标包括：储存系统关键对象的重要状态；维护关键对象的封装。  
- 角色：
&emsp;1. 备忘录（Memento）角色：备忘录角色存储“备忘发起角色”的内部状态。“备忘发起角色”根据需要决定备忘录角色存储“备忘发起角色”的哪些内部状态。为了防止“备忘发起角色”以外的其他对象访问备忘录。备忘录实际上有两个接口，“备忘录管理者角色”只能看到备忘录提供的窄接口——对于备忘录角色中存放的属性是不可见的。“备忘发起角色”则能够看到一个宽接口——能够得到自己放入备忘录角色中属性。  
&emsp;2. 备忘发起（Originator）角色：“备忘发起角色”创建一个备忘录，用以记录当前时刻它的内部状态。在需要时使用备忘录恢复内部状态。  
&emsp;3. 备忘录管理者（Caretaker）角色：负责保存好备忘录。不能对备忘录的内容进行操作或检查。  
- UML：
![](https://img2018.cnblogs.com/blog/1153954/201902/1153954-20190219105506149-1170330938.png)

- 优点：
&emsp;1. 将被存储的状态放在外面，不要和关键对象混在一起，这可以帮助维护内聚。  
&emsp;2. 保持关键对象的数据封装。  
&emsp;3. 提供了容易实现的恢复能力。  
- 缺点和应用场景：
&emsp;1. 备忘录用于存储状态。  
&emsp;2. 储存和恢复状态的过程可能相当耗时。  
&emsp;3. 在 Java 系统中，其实可以考虑使用序列化机制储存系统的状态。  
- Demo 实现：[<font color=#0000ff>https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/memento</font>](https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/memento)  

### 8、原型模式（ProtoType Pattern）

- 概念：允许通过复制现有的实例来创建新的实例（在 Java 中，这通常意味着使用 clone() 方法，或者反序列化）。这个模式的重点在于，客户的代码在不知道要实例化何种特定类的情况下，可以制造出新的实例。  
- 角色： 
&emsp;1. 抽象原型类（Prototype）：声明克隆自身的接口。在 java 中就是 Cloneable 接口。
&emsp;2. 具体原型类（ConcretePrototype）：实现克隆的具体操作。  
- UML：  
![](https://img2018.cnblogs.com/blog/1153954/201902/1153954-20190221092706787-654648229.png)  

- 优点：  
&emsp;1. 向客户隐藏制造新实例的复杂性。  
&emsp;2. 提供让客户能够产生未知类型对象的选项。  
&emsp;3. 在某些环境下，复制对象比创建新对象更有效。  
- 用途和缺点：  
&emsp;1. 在一个复杂的类层次中，当系统必须从其中的许多类型创建新对象时，可以考虑原型。  
&emsp;2. 使用原型模式的缺点：对象的复制有时相当复杂（浅拷贝和深拷贝）。  
- Demo 实现：[<font color=#0000ff>https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/prototype</font>](https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/prototype)  

### 9、访问者模式（Visitor Pattern）

- 概念：为一个对象的组合增加新的能力，且封装并不重要时。访问者模式将作用于某种数据结构中的各元素的操作分离出来封装成独立的类，使其在不改变数据结构的前提下可以添加作用于这些元素的新的操作，为数据结构中的每个元素提供多种访问方式。它将对数据的操作与数据结构进行分离，是行为类模式中最复杂的一种模式。  
- 角色：
&emsp;1. 抽象访问者（Visitor）角色：定义一个访问具体元素的接口，为每个具体元素类对应一个访问操作 visit() ，该操作中的参数类型标识了被访问的具体元素。
&emsp;2. 具体访问者（ConcreteVisitor）角色：实现抽象访问者角色中声明的各个访问操作，确定访问者访问一个元素时该做什么。
&emsp;3. 抽象元素（Element）角色：声明一个包含接受操作 accept() 的接口，被接受的访问者对象作为 accept() 方法的参数。
&emsp;4. 具体元素（ConcreteElement）角色：实现抽象元素角色提供的 accept() 操作，其方法体通常都是 visitor.visit(this) ，另外具体元素中可能还包含本身业务逻辑的相关操作。
&emsp;5. 对象结构（Object Structure）角色：是一个包含元素角色的容器，提供让访问者对象遍历容器中的所有元素的方法，通常由 List、Set、Map 等聚合类实现。
- UML：  
![](https://img2018.cnblogs.com/blog/1153954/201902/1153954-20190222093713087-1181610377.png)  

- 优点：  
&emsp;1. 允许你对组合结构加入新的操作，而无需改变结构本身。  
&emsp;2. 想要加入新的行为，相对容易。  
&emsp;3. 访问者所进行的操作，其代码是集中在一起的。
- 缺点：
&emsp;1. 当采用访问者模式的时候，就会打破组合类的封装。
&emsp;2. 因为游走的功能牵涉其中，所以对组合结构的改变就更加困难。  
&emsp;3. 违反了依赖倒置原则。访问者模式依赖了具体类，而没有依赖抽象类。    
- Demo 实现：[<font color=#0000ff>https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/visitor</font>](https://github.com/JMCuixy/design-patterns/tree/master/src/main/java/com/example/visitor)  

## 二、其他  

### 1、复合模式

- 复合模式：在一个解决方案中结合两个或多个模式，以解决一般或重复发生的问题。  
- MVC 是复合模式，结合了观察者模式、策略模式和组合模式（视图）。这些模式携手合作，把 MVC 模型的三层解耦，这样可以保持设计干净又有弹性。    
- 模型使用观察者模式，以便观察者（视图）更新，同时保持两者之间解耦。  
- 控制器是视图的策略，视图可以使用不同的控制器实现，得到不同的行为。  
- Model 2是 MVC 在 Web 上的应用。  
- 在Model 2中，控制器实现成 Servlet，而 JSP/HTML 是实现视图。  

### 2、设计模式概论

- 模式是在某情境（context）下，针对某问题的某种解决方案。设计模式是解决一个经常重复发生的设计问题。  
- 模式不是法律或准则，模式只是指导方针，你可以改变模式来符合你的需要，真实世界中的许多实例，都不符合经典的设计模式。  
- 请务必牢记在心，模式是被“发现的”，而不是被创建的。所以，任何人都可能发现某个设计模式，然后写出它的描述。  
- 一般来说，必须要通过“三次准则”，才算是一个合格的模式。也就是说，只有在真实世界中被应用三次以上，才能算是一个模式。  
- 根据模式的目标，我们将设计模式分成三个不同的类目：创建型、行为型（对象之间的沟通和互联）和结构型（动态的组合对象）：  
![](https://img2018.cnblogs.com/blog/1153954/201902/1153954-20190213154656045-2015954303.png)  

- 模式只是一种工具，只有在需要时才使用这种工具，而我们时刻要遵守的是模式中的设计原则。  
- 尽可能地用最简单的方式解决问题，不要刻意去使用设计模式！当你在设计的时候，如果确定在你的设计中可以利用某个模式解决某个问题，那么就使用这个模式！如果有更简单的解决方案，那么在决定使用模式之前应该先考虑这个方案。  
- 有一种情况，即使有更简单的解决方案，你仍然想要使用模式，这种情况就是：你预期系统在未来会发生改变，但是务必要确定一件事，这个改变是可能发生的实际改变，而不是假想的改变。  
- 模式可能带来复杂性，可能导致代码被过度工程化，如果没有必要，我们绝不需要这样的复杂性。  

### 3、设计原则  

- 单一职责原则（single responsibility principle，SPR）：一个类负责一项职责。
- 开闭原则（Open-Close Principe，OCP）：一个软件实体如类、模块和函数应该对扩展开放，对修改关闭。
- 里氏替换原则（Liskov Substitution Principe，LSP）：一个软件实体如果使用的是一个父类的话，那么一定适用于其他子类，二且他察觉不出父类对象和子类对象的区别。
- 依赖倒置原则（Dependence Inversion Principle）：高层模块不应该依赖低层模块，二者都应该依赖其抽象；抽象不应该依赖细节；细节应该依赖抽象。即针对接口编程，不要针对实现编程。
- 接口隔离原则（Interface  Segregation Principle, ISP）：建立单一接口，不要建立庞大臃肿的接口，尽量细化接口，接口中的方法尽量少。
- 迪米特法则（Law of Demeter,LoD）：最少知识原则，清掉了类之间的松耦合，降低了系统的耦合度。
- 组合/聚合复用原则（Composite Reuse Principe，CRP）：尽量使用组合和聚合少使用继承的关系来达到复用的原则。

### 4、反模式  

- 反模式告诉你如何采用一个不好的解决方案解决一个问题。虽然反模式看起来总像是一个好的解决方案，但是当它被真正采用后，就会带来麻烦。   
- 反模式的工作内容包括：警告你不要陷入某种致命的诱惑；为何这个解决方案从长远看会造成不同的影响；建议改用其他的模式以提供更好的解决方案。