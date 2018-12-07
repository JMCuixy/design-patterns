## 一、函数接口  

|接口|参数|返回类型|描述|
|:---:|:---:|:---:|:---:|
|Predicate&lt;T&gt;|T|boolean|用来比较操作|
|Consumer&lt;T&gt;|T|void|没有返回值的函数|
|Function<T, R>|T|R|有返回值的函数|
|Supplier&lt;T&gt;|None|T|工厂方法-返回一个对象|
|UnaryOperator&lt;T&gt;|T|T|入参和出参都是相同对象的函数|
|BinaryOperator&lt;T&gt;|(T,T)|T|求两个对象的操作结果|

为什么要先从函数接口说起呢？因为我觉得这是 java8 函数式编程的入口呀！每个函数接口都带有 @FunctionalInterface 注释，有且仅有一个未实现的方法，表示接收 Lambda 表达式，它们存在的意义在于将代码块作为数据打包起来。  

没有必要过分解读这几个函数接口，完全可以把它们看成普通的接口，不过他们有且仅有一个抽象方法（因为要接收 Lambda 表达式啊）。  

@FunctionalInterface 该注释会强制 javac 检查一个接口是否符合函数接口的标准。 如果该注释添加给一个枚举类型、 类或另一个注释， 或者接口包含不止一个抽象方法， javac 就会报错。  


## 二、Lambda 表达式    
### 1、Lambda 表达式和匿名内部类    
先来复习一下匿名内部类的知识：  
- 如果是接口，相当于在内部返回了一个接口的实现类，并且实现方式是在类的内部进行的；  
- 如果是普通类，匿名类相当于继承了父类，是一个子类，并可以重写父类的方法。  
- 需要特别注意的是，匿名类没有名字，不能拥有一个构造器。如果想为匿名类初始化，让匿名类获得一个初始化值，或者说，想使用匿名内部类外部的一个对象，则编译器要求外部对象为final属性，否则在运行期间会报错。  

```
 new Thread(new Runnable() {
     @Override
     public void run() {
         System.out.println(123);
     }
 }).start();
```
```
new Thread(()-> System.out.println(123)).start();
```  

如上，和传入一个实现某接口的对象不同， 我们传入了一段代码块 —— 一个没有名字的函数。() 是参数列表， 和上面匿名内部类示例中的是一样的。 -> 将参数和 Lambda 表达式的主体分开， 而主体是之后操作会运行的一些代码。  

Lambda 表达式简化了匿名内部类的写法，省略了函数名和参数类型。即参数列表 () 中可以仅指定参数名而不指定参数类型。  

Java 是强类型语言，为什么可以不指定参数类型呢？这得益于 javac 的类型推断机制，编译器能够根据上下文信息推断出参数的类型，当然也有推断失败的时候，这时就需要手动指明参数类型了。javac 的类型推断机制如下：  
- 对于类中有重载的方法，javac 在推断类型时，会挑出最具体的类型。  
- 如果只有一个可能的目标类型， 由相应函数接口里的参数类型推导得出；  
- 如果有多个可能的目标类型， 由最具体的类型推导得出；  
- 如果有多个可能的目标类型且最具体的类型不明确， 则需人为指定类型。  

### 2、Lambda 表达式和集合  
java8 在 java.util 包中引入了一个新的类 —— Stream.java。java8 之前我们迭代集合，都只能依赖外部迭代器 Iterator 对集合进行串行化处理。而 Stream 支持对集合顺序和并行聚合操作，将更多的控制权交给集合类，是一种内部迭代方式。这有利于方便用户写出更简单的代码，明确要达到什么转化，而不是如何转化。   
  
Stream 的操作有两种，一种是描述 Stream ，如 filter、map 等最终不产生结果的行为称为"惰性求值"；另外一种像 foreach、collect 等是从 Stream 中产生结果的行为称为"及早求值"。  

接下来让我们瞧瞧 Stream 如何结合 Lambda 表达式优雅的处理集合...    

- **foreach - 迭代集合**
```
list.forEach(e -> System.out.println(e));

map.forEach((k, v) -> {
    System.out.println(k);
    System.out.println(v);
});
```

- **collect(toList()) - 由Stream里的值生成一个列表。**
```
List<String> list = Stream.of("java", "C++", "Python").collect(Collectors.toList());
```
等价于：  
```
List<String> asList = Arrays.asList("java", "C++", "Python");
```

- **filter - 遍历并检查过滤其中的元素。**  
```
long count = list.stream().filter(x -> "java".equals(x)).count();
```

- **map、mapToInt、mapToLong、mapToDouble - 将流中的值转换成一个新的值。**  
```
List<String> mapList = list.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());

List<String> list = Stream.of("java", "javascript", "python").collect(Collectors.toList());
IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(e -> e.length()).summaryStatistics();
System.out.println("最大值：" + intSummaryStatistics.getMax());
System.out.println("最小值：" + intSummaryStatistics.getMin());
System.out.println("平均值：" + intSummaryStatistics.getAverage());
System.out.println("总数：" + intSummaryStatistics.getSum());
```
mapToInt、mapToLong、mapToDouble 和 map 操作类似，只是把函数接口的返回值改为 int、long、double 而已。

- **flatMap - 将多个 Stream 连接成一个 Stream**
```
List<String> streamList = Stream.of(list, asList).flatMap(x -> x.stream()).collect(Collectors.toList());
```
flatMap 方法的相关函数接口和 map 方法的一样， 都是 Function 接口， 只是方法的返回值限定为 Stream 类型罢了。

- **Max-求最大值、Min-求最小值**
```
String maxStr = list.stream().max(Comparator.comparing(e -> e.length())).get();
String minStr = list.stream().min(Comparator.comparing(e -> e.length())).get();
```

- **reduce - 聚合操作，从一组元素中生成一个值，sum()、max()、min()、count() 等都是reduce操作，将他们单独设为函数只是因为常用。**
```
Integer sum1 = Stream.of(1, 2, 3).reduce(0, (acc, e) -> acc + e);
```
上述执行求和操作，有两个参数： 传入 Stream 中初始值和 acc。 将两个参数相加，acc 是累加器，保存着当前的累加结果。

- 待续...

## 三、默认方法   
java8 中新增了 Stream 操作，那么第三方类库中的自定义集合 MyList 要怎么做到兼容呢？总不能升级完 java8，第三方类库中的集合实现全都不能用了吧？  

为此，java8 在接口中引入了"默认方法"的概念！默认方法是指接口中定义的包含方法体的方法，方法名有 default 关键字做前缀。默认方法的出现是为了 java8 能够向后兼容。
```
public interface Iterable<T> {
    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Unless otherwise specified by the implementing class,
     * actions are performed in the order of iteration (if an iteration order
     * is specified).  Exceptions thrown by the action are relayed to the
     * caller.
     *
     * @implSpec
     * <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @since 1.8
     */
    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }
}
```
看 java8 中的这个 Iterable.java 中的默认方法 forEach(Consumer<? super T> action)，表示“如果你们没有实现 forEach 方法，就使用我的吧”。  

默认方法除了添加了一个新的关键字 default，在继承规则上和普通方法也略有差别:    
- 类胜于接口。如果在继承链中有方法体或抽象的方法声明，那么就可以忽略接口中定义的方法。  
- 子类胜于父类。果一个接口继承了另一个接口， 且两个接口都定义了一个默认方法，那么子类中定义的方法胜出。  
- 如果上面两条规则不适用， 子类要么需要实现该方法， 要么将该方法声明为抽象方法。  


## 四、其他

- 使用 Lambda 表达式，就是将复杂性抽象到类库的过程。
- 面向对象编程是对数据进行抽象， 而函数式编程是对行为进行抽象。  
- Java8 虽然在匿名内部类中可以引用非 final 变量， 但是该变量在既成事实上必须是final。即如果你试图给该变量多次赋值， 然后在 Lambda 表达式中引用它， 编译器就会报错。   
- Stream 是用函数式编程方式在集合类上进行复杂操作的工具。   
- 对于需要大量数值运算的算法来说， 装箱和拆箱的计算开销， 以及装箱类型占用的额外内存， 会明显减缓程序的运行速度。为了减小这些性能开销， Stream 类的某些方法对基本类型和装箱类型做了区分。比如 IntStream、LongStream 等。  
- Java8 对为 null 的字段也引进了自己的处理，既不用一直用 if 判断对象是否为 null，来看看?
```
public static List<AssistantVO> getAssistant(Long tenantId) {
    // ofNullable 如果 value 为null，会构建一个空对象。
    Optional<List<AssistantVO>> assistantVO = Optional.ofNullable(ASSISTANT_MAP.get(tenantId));
    // orElse 如果 value 为null，选择默认对象。 
    assistantVO.orElse(ASSISTANT_MAP.get(DEFAULT_TENANT));
    return assistantVO.get();
}
``` 


