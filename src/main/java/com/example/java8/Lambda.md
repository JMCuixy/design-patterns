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


## 二、Lambda 表达式和匿名内部类    
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

## 三、Lambda 表达式和集合  
java8 在 java.util 包中引入了一个新的类 —— Stream.java。java8 之前我们迭代集合，都只能依赖外部迭代器 Iterator 对集合进行串行化处理。而 Stream 支持对集合顺序和并行聚合操作，将更多的控制权交给集合类，是一种内部迭代方式。这有利于方便用户写出更简单的代码，明确要达到什么转化，而不是如何转化。   
  
Stream 的操作有两种，一种是描述 Stream ，如 filter、map、peek 等最终不产生结果的行为称为"惰性求值"；另外一种像 foreach、collect 等是从 Stream 中产生结果的行为称为"及早求值"。  

接下来让我们瞧瞧 Stream 如何结合 Lambda 表达式优雅的处理集合...     

### 1、及早求值

收集器：一种通用的、从流生成复杂值的结构。只要将它传给 collect 方法， 所有的流就都可以使用它了。在 java.util.stream.Collectors 中提供了一些有用的收集器。比如 toList、toSet、toMap 等。

在一个有序集合中创建一个流时，流中的元素就按出现顺序排列；如果集合本身就是无序的，由此生成的流也是无序的。需要注意的是，forEach 方法不能保证元素是按顺序处理的，如果需要保证按顺序处理，应该使用forEachOrdered 方法。当然，我们可以使用 sorted 方法对Stream 中的元素进行自定义排序。

- **foreach/forEachOrdered - 迭代集合**    
```
list.forEach(e -> System.out.println(e));

map.forEach((k, v) -> {
    System.out.println(k);
    System.out.println(v);
});
```

- **对 Stream 进行自定义排序**    
```
List<String> collectSort = collect.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
```

- **allMatch、anyMatch、noneMatch - 检查元素是否匹配**    
```
private boolean isPrime(int number) {
    return IntStream.range(2, number)
            .allMatch(x -> (number % x) != 0);
}
```

- **collect(toList()) - 由Stream里的值生成一个 List/Set/自定义 集合**    
```
List<String> list = Stream.of("java", "C++", "Python").collect(Collectors.toList());
等价于：
List<String> asList = Arrays.asList("java", "C++", "Python");
```
```
Set<String> set = Stream.of("java", "python", "php").collect(Collectors.toSet());
```
```
TreeSet<String> treeSet = Stream.of("java", "python", "php").collect(Collectors.toCollection(() -> new TreeSet<>()));
```

- **collect(toMap()) - 由Stream里的值生成一个 Map 集合**     

使用 toMap() 需要注意的是：Map中的key不能重复，如果重复的话，会抛出异常，因为 JVM 弄不清楚我是用新的Value、还是要用旧的Value呢?所以代码写成了如下的样子~~  
```
Map<String, String> strMap = Stream.of("java", "python", "php").collect(Collectors.toMap(String::new, String::new, (oldValue,newValue) -> oldValue));
```  
如上使用 toMap() 仍然会有一个问题，就是 toMap 转化的时候，如果 value 为 null，会报一个 NullPointerException ，可用如下方式解决：
```
Map<Object, Object> mapResult = Stream.of("java", "python", "php").collect(HashMap::new, (map, str) -> map.put(str, str), HashMap::putAll);
```

- **collect(maxBy())、collect(minBy())、collect(averagingInt()) - 求值操作**
```
Optional<String> optionalMaxBy = Stream.of("java", "python", "php").collect(Collectors.maxBy(Comparator.comparing(str -> str.length())));
System.out.println(optionalMaxBy.get());

Optional<String> optionalMinBy = Stream.of("java", "python", "php").collect(Collectors.minBy(Comparator.comparing(str -> str.length())));
System.out.println(optionalMinBy.get());

Double aDouble = Stream.of("java", "python", "php").collect(Collectors.averagingInt(String::length));
System.out.println(aDouble);
```

- **collect(Collectors.joining()) - 字符串拼接操作**
```
String joinStr = Stream.of("java", "python", "php").collect(Collectors.joining(",", "[", "]"));
```
joining() 的三个参数依次为 分隔符、前缀、后缀。

- **collect(partitioningBy())、collect(groupingBy()) - 聚合统计操作**
```
List<String> collect = Stream.of("java", "python", "php").collect(Collectors.toList());
// 数据分堆，按照 Boolean 值，将数据分成两堆
Map<Boolean, List<String>> listMap = collect.stream().collect(Collectors.partitioningBy(str -> str.equals("java")));

// 数据分组，有点像 SQL 的 GROUP BY 用法，按照对象的某个属性分组
Map<Integer, List<String>> collectGroudBy = collect.stream().collect(Collectors.groupingBy(String::hashCode));

// 分组统计（类似SQL分组统计） - 先将集合分组，然后统计分组的值 - 比如计算每个城市的姓氏集合-> 先按城市分组，再计算姓氏的集合。
Map<Integer, Long> longMap = collect.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
Map<Integer, List<Integer>> listMap = collect.stream().collect(Collectors.groupingBy(String::length, Collectors.mapping(String::length, Collectors.toList())));
```


### 2、惰性求值

- **range - 以步长为1的循环**  
```
private boolean isPrime(int number) {
    return IntStream.range(2, number)
            .allMatch(x -> (number % x) != 0);
}
等价于：
for (int i = 2; i < number ; i++) { ... }
```

- **filter - 遍历并检查过滤其中的元素**  
```
long count = list.stream().filter(x -> "java".equals(x)).count();
```

- **distinct - 对流中的元素去重**      
流中的元素去重根据的是对象的 equal() 方法，对于有序列的流，相同的元素以第一个为准；对于无序列的流，去重的稳定性不做保证。
```
Stream.of("java", "python", "php", "java").distinct().forEach(e -> System.out.println(e));
```

- **findAny、findFirst - 返回一个流中的元素**  
```
Optional<String> first = Stream.of("java", "python", "php").findFirst();
Optional<String> any = Stream.of("java", "python", "php").findAny();
```

- **map、mapToInt、mapToLong、mapToDouble - 将流中的值转换成一个新的值**  
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

- **peek - 逐个处理流中的元素，无返回值**  
```
Stream.of("one", "two", "three", "four")
        .filter(e -> e.length() > 3)
        .peek(e -> System.out.println("Filtered value: " + e))
        .map(String::toUpperCase)
        .peek(e -> System.out.println("Mapped value: " + e))
        .collect(Collectors.toList());
```
peek 和 map 的区别在于：peek 接受的是 Consumer 高阶函数，无返回值；map 接受的是 Function 高阶函数，有返回值。

- **flatMap - 将多个 Stream 连接成一个 Stream**
```
List<String> streamList = Stream.of(list, asList).flatMap(x -> x.stream()).collect(Collectors.toList());
```
flatMap 方法的相关函数接口和 map 方法的一样， 都是 Function 接口， 只是方法的返回值限定为 Stream 类型罢了。


- **reduce - 聚合操作，从一组元素中生成一个值，sum()、max()、min()、count() 等都是reduce操作，将他们单独设为函数只是因为常用**
```
Integer sum1 = Stream.of(1, 2, 3).reduce(0, (acc, e) -> acc + e);

String maxStr = list.stream().max(Comparator.comparing(e -> e.length())).get();
String minStr = list.stream().min(Comparator.comparing(e -> e.length())).get();
```
上述执行求和操作，有两个参数： 传入 Stream 中初始值和 acc。 将两个参数相加，acc 是累加器，保存着当前的累加结果。

### 3、Stream 的并行操作
在 Java8 中，编写并行化的程序很容易。并行化操作流只需改变一个方法调用。如果已经有一个Stream对象，调用它的 parallel 方法就能让其拥有并行操作的能力。如果想从一个集合类创建一个流，调用 parallelStream 就能立即获得一个拥有并行能力的流。在底层，并行流还是沿用了 fork/join 框架。fork 递归式地分解问题，然后每段并行执行，最终由 join 合并结果，返回最后的值。  

 ```
 List<String> paraList = Stream.of("java", "php", "python").parallel().collect(Collectors.toList());
 List<String> resultList = paraList.parallelStream().collect(Collectors.toList());
 ```

需要注意的是：在要对流求值时，不能同时处于两种模式，要么是并行的，要么是串行的。如果同时调用了 parallel 和 sequential 方法，最后调用的那个方法起效。
 
并行化流操作的用武之地是使用操作处理大量数据。在处理少量数据时，效果并不明显，因为要把时间花销在数据的分块上。 

影响并行流性能的五要素是：数据大小、源数据结构、值是否装箱、可用的 CPU 核数量以及处理每个元素所花的时间。   

|性能|例子|描述|
|:---:|:---:|:---:|
|好|ArrayList、数组或IntStream.range|这些数据结构支持随机读取，也就是说它们能轻而易举地被任意分解。|
|一般|HashSet、TreeSet|这些数据结构不易公平地被分解，但是大多数时候分解是可能的。|
|差|LinkedList、Streams.iterate和BufferedReader.lines|数据结构难以分解或是长度未知，很难预测该在哪里分解。|

在讨论流中单独操作每一块的种类时，可以分成两种不同的操作：无状态的和有状态的。无状态操作整个过程中不必维护状态，有状态操作则有维护状态所需的开销和限制。如果能避开有状态，选用无状态操作，就能获得更好的并行性能。无状态操作包括 map、filter 和 flatMap，有状态操作包括 sorted、distinct 和 limit。

## 四、默认方法   
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


## 五、其他

- 使用 Lambda 表达式，就是将复杂性抽象到类库的过程。
- 面向对象编程是对数据进行抽象， 而函数式编程是对行为进行抽象。  
- Java8 虽然在匿名内部类中可以引用非 final 变量， 但是该变量在既成事实上必须是final。即如果你试图给该变量多次赋值， 然后在 Lambda 表达式中引用它， 编译器就会报错。   
- Stream 是用函数式编程方式在集合类上进行复杂操作的工具。   
- 对于需要大量数值运算的算法来说， 装箱和拆箱的计算开销， 以及装箱类型占用的额外内存， 会明显减缓程序的运行速度。为了减小这些性能开销， Stream 类的某些方法对基本类型和装箱类型做了区分。比如 IntStream、LongStream 等。  
- Java8 对为 null 的字段也引进了自己的处理，既不用一直用 if 判断对象是否为 null。
```
public static List<AssistantVO> getAssistant(Long tenantId) {
    // ofNullable 如果 value 为null，会构建一个空对象。
    Optional<List<AssistantVO>> assistantVO = Optional.ofNullable(ASSISTANT_MAP.get(tenantId));
    // orElse 如果 value 为null，选择默认对象。 
    assistantVO.orElse(ASSISTANT_MAP.get(DEFAULT_TENANT));
    return assistantVO.get();
}
``` 
- java8 对Map集合中value为 null 的情况也引起了自己的处理，利用 computeIfAbsent 方法，当 get()方法得到的value为 null 时，会把新的value放进集合并返回。
```
Map<String, String> map = new HashMap<>(8);
map.put("java", "java");
map.put("php", "php");
String python = map.computeIfAbsent("python", k -> k.toUpperCase());
```


