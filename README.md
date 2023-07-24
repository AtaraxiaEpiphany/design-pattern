# 设计模式分类

* **创建型模式**

  用于描述`怎样创建对象`，它的主要特点是`将对象的创建与使用分离`。GoF（四人组）书中提供了单例、原型、工厂方法、抽象工厂、建造者等
  5 种创建型模式。

* **结构型模式**

  用于描述`如何将类或对象按某种布局组成更大的结构`，GoF（四人组）书中提供了代理、适配器、桥接、装饰、外观、享元、组合等 7 种结构型模式。

* **行为型模式**

  用于`描述类或对象之间怎样相互协作共同完成单个对象无法单独完成的任务，以及怎样分配职责`
  。GoF（四人组）书中提供了模板方法、策略、命令、职责链、状态、观察者、中介者、迭代器、访问者、备忘录、解释器等 11 种行为型模式。

# UML类图

## 表示方法

属性/方法名称前加的加号和减号表示了这个属性/方法的可见性，UML类图中表示可见性的符号有三种：

* +：表示public

* -：表示private

* #：表示protected

`属性`的完整表示方式是： **可见性 名称 ：类型 [ = 缺省值]**

`方法`的完整表示方式是： **可见性 名称(参数列表) [ ： 返回类型]**

## 关系的表示

从变量的角度来考虑:

- 关联关系:成员变量
- 依赖关系:局部变量(方法的参数,静态方法调用)
- 组合关系:构造方法注入.
- 聚合关系:set方法注入.
- 继承关系:extends
- 实现关系:implements

## 软件设计原则

> 开闭原则是目标,里氏代换原则是基础,依赖倒转原则是手段.

- 维护性
- 扩展性
- 灵活性
- 扩展性

### 开闭原则(Open Closed Principle)

> 对扩展开放,对修改关闭.是程序易于维护,扩展和升级.
>
> 一般使用接口和抽象类定义规范来满足开闭原则.

### 里氏代换原则(Liskov Substitution Principle)

> 任何基类（父类）能出现的地方，子类也应该能够出现，而且能够替换基类而不影响程序的正确性.
>
> 子类在继承父类时,除了添加新的方法完成新功能外,尽量不重写父类方法.

### 依赖倒转原则(Dependency Inversion Principle)

> 它强调了高层模块不应该依赖于低层模块的具体实现，而应该依赖于抽象接口或抽象类。
>
> Controller依赖于Service接口而不是ServiceImpl.

### 接口隔离原则(Interface Segregation Principle)

> 接口隔离原则的核心思想是：应该将大型接口拆分为更小、更具体的接口，
> 以满足客户端的实际需求。这样可以避免客户端依赖于不需要的接口方法，减少接口的冗余和臃肿。
>
> 实际应用中类可以多实现,将功能拆分成更小的接口,按需实现接口.

### 迪米特法则,又称最少知识原则(Principle of Least Knowledge)

> 一个对象应该对其他对象有尽可能少的了解，只与直接的朋友通信。
>
> 直接的朋友指的是以下几种情况：

- 当前对象本身。
- 被当前对象作为方法参数传入的对象。
- 当前对象的成员变量。

> 为了遵循迪米特原则，需要注意以下几点：

- 尽量减少对象之间的直接交互，通过封装和提供合适的接口进行通信。
- 不要在一个对象的方法中调用其他对象的方法，并且避免链式调用过多的方法。
- 尽量将复杂的业务逻辑封装在对象内部，而不是暴露给外部对象。

### 合成复用原则(Composite Reuse Principle)

> 在系统设计中应该优先使用对象聚合或组合（composition）而不是继承（inheritance）来实现代码的复用。

### 单一职责原则(Single Responsibility Principle)

> 一个类或模块应该有且仅有一个引起它变化的原因.
> 一个类或模块应该只负责一项职责或功能。

# 设计模式

## 创建者模式(Creation Pattern)

> 该模式关注对象的创建机制，帮助解决对象创建过程中的灵活性和复杂性问题。

### 单例设计模式(Singleton Pattern)

单例模式角色

- 单例类:只能创建一个实例的类.
- 访问类:使用单例类.

#### 饿汉式(Eager Initialization)

> 实例在类加载时就被创建，因此它是线程安全的.无论是否使用该实例，都会在类加载时创建实例。

#### 懒汉式(Lazy Initialization)

> 在懒汉式中，实例的创建被延迟到第一次使用时，也就是在调用 getInstance() 方法时才会创建实例。
> 这种方式可以避免不必要的实例创建，但需要注意线程安全性。

- Double check:存在线程安全,若对方法上锁太重.由于绝大部分操作是读操作,线程安全.只需在内部创建对象前双重判断上锁即可.
- Static inner class:静态内部类只有调用其属性或者方法才被加载,因此属于lazy load.并且由于静态内部类的属性被static修饰,因此只会实例化一次.
- Enumeration: 饿汉式,不会被序列化反序列化/反射破坏.

> 反射与序列化都使得单例模式被破坏(得到了两个不同的单例类)

### 工厂设计模式(Factory Design Pattern)

> 它提供了一种创建对象的方式，将对象的创建逻辑封装在工厂类中，而不是直接在代码中使用new关键字来实例化对象。
> 这样可以降低代码的耦合性，提高代码的可维护性和可扩展性。
>
> 工厂设计模式通常涉及以下几个角色：

- 抽象产品（Abstract Product）：定义产品的共同接口或抽象类，具体产品需要实现这个接口或继承这个抽象类。
- 具体产品（Concrete Product）：实现抽象产品接口或继承抽象产品类，是工厂创建的目标对象。
- 抽象工厂（Abstract Factory）：定义创建产品的接口，可以是抽象类或接口。通常包含一个或多个创建产品的方法。
- 具体工厂（Concrete Factory）：实现抽象工厂接口，负责创建具体产品的对象。

#### 简单工厂模式

> 封装了对象创建的过程,可以通过`参数`来获取对象.
> 把对象的创建与业务逻辑分开.
>
> 缺点:增加新产品时需要修改工厂类代码,违背了`单一职责原则`.

### 工厂方法模式

> 符合开闭原则，可以通过添加新的具体工厂和具体产品来扩展系统，而无需修改现有的代码。
>
> 当需要在多个相关的产品系列中选择一个时，可以使用工厂方法模式来实现产品族的创建。

### 抽象工厂模式

> 使用工行方法模式在某些场景会有太多的具体工厂和具体方法(类爆炸),抽象工厂使得工厂的职责更为抽象.
> 遵循了依赖倒装原则.可能违背了单一职责原则(生产一组相关的对象),接口隔离原则,
> 开闭原则(当需要添加产品族到抽象工厂,所有的工厂都得修改).
>
> 使用场景:

- 当需要创建一组相关或相互依赖的产品对象时，可以使用抽象工厂模式。

- 当需要提供一个统一的接口来创建相关或依赖对象的时候，可以使用抽象工厂模式。

- 当系统需要独立于其产品的创建、组合和表示时，可以使用抽象工厂模式。

#### 工厂模式拓展

> 使用简单工厂模式+配置文件解除耦合.

## 结构型模式(Structural Pattern)

> 该模式关注如何组合类和对象以形成更大的结构，以解决系统中不同对象之间的接口和组合问题。

## 行为型模式(Behavioral Pattern)

> 该模式关注对象之间的通信和交互，以解决对象之间的责任分配和算法封装等问题。

