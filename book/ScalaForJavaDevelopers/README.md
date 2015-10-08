# 1장 스칼라 맛보기
스칼라의 장점 : 
- 가독성
  영어 문장처럼 표현
  객체지향 -> 코드를 모듈화
  함수형 -> 변환작업을 간결하게 표시
- 높은 생산성
  정적 타입 + 타입 추론 -> IDE에서 실시간으로 컴파일러에서 제공하는 피드백을 통해, 구현 생산성을 높일 수 있다.
- 자바와 찰떡 궁합 
- 뛰어난 비동기 및 동시성 처리
  불변형(immutable) 자료구조
  함수형 프로그래밍 구문
  병렬컬렉션(parallel collection)
  우수한 타입시스템 + 매크로 활용 -> 컴포저블 퓨처(composable future)나 비동기 언어 확장 기능(asynchronous language extension) 같은 비동기 구문에 안전한 DSL(Domain Specific Language) 생성 가능
 
### scala download & install
http://www.scala-lang.org/download/
wget http://downloads.typesafe.com/scala/2.11.7/scala-2.11.7.tgz -O scala.tgz
tar xvf scala-2.10.3.tgz
sudo mv scala-2.10.3 /usr/share/scala
sudo ln -s /usr/share/scala/bin/scala /usr/bin/scala
sudo ln -s /usr/share/scala/bin/scalac /usr/bin/scalac
sudo ln -s /usr/share/scala/bin/fsc /usr/bin/fsc
sudo ln -s /usr/share/scala/bin/sbaz /usr/bin/sbaz
sudo ln -s /usr/share/scala/bin/sbaz-setup /usr/bin/sbaz-setup
sudo ln -s /usr/share/scala/bin/scaladoc /usr/bin/scaladoc
sudo ln -s /usr/share/scala/bin/scalap /usr/bin/

###activator 
http://www.typesafe.com/activator/download
./activator ui

### REPL로 배우는 스칼라 문법

##### 선언
scala> val yourPast : String = "Good Java Programmer"
yourPast: String = Good Java Programmer

scala> val yourPast = "Good Java Programmer"
yourPast: String = Good Java Programmer

##### immutable & mutable
scala> yourPast = "Great Scala Programmer"
<console>:11: error: reassignment to val
       yourPast = "Great Scala Programmer"
                ^

scala> var yourFuture = "Good Java Programmer"
yourFuture: String = Good Java Programmer

scala> yourFuture = "Good Scala Programmer"
yourFuture: String = Good Scala Programmer

##### java primitive type and reference type  => scala all type is object(reference)
scala> 3
res0: Int = 3

scala> 3 + 2
res1: Int = 5
##### 위의 표기법은 아래 표기법의 syntactic sugar로 괄호와 점은 생략하고 연산자(=method name)만 사용가능
scala> (3).+(2)
res2: Int = 5
##### 선언
scala> class Money(amount:Int)
defined class Money

scala> val notMuch = new Money(2)
notMuch: Money = Money@58651fd0

scala> notMuch.
asInstanceOf   isInstanceOf   toString

scala> class Money(val amount:Int)
defined class Money

scala> val notMuch = new Money(2)
notMuch: Money = Money@3234e239

scala> notMuch.
amount   asInstanceOf   isInstanceOf   toString

scala> notMuch.amount
   val amount: Int

scala> notMuch.amount
res3: Int = 2

scala> notMuch.amount = 3
<console>:12: error: reassignment to val
       notMuch.amount = 3
                      ^

scala> class Money(var amount:Int)
defined class Money

scala> val notMuch = new Money(2)
notMuch: Money = Money@366647c2

scala> notMuch.amount = 3         <- var인 경우는 getter와 setter가 자동 생성된다. 좌측의 구문은 변수에 직접 엑세스하는 것이 아니다.
notMuch.amount: Int = 3

##### case class
	 javabean style domain class 자동 생성 : getter/setter, constructor, @Override(hashCode, equals, toString)
     scala's default scope is public (java는 package-private)
     new 없이 인스턴스를 생성할 수 있는 팩토리 메서드 생성(class 명)
     copy method 생성
     
     
scala> case class Money(amount:Int=1, currency:String="USD")
defined class Money

scala> val defaultAmount = Money()
defaultAmount: Money = Money(1,USD)

scala> val defaultAmount = new Money()
defaultAmount: Money = Money(1,USD)

scala> val fifteenDolloars = Money(15, "USD")
fifteenDolloars: Money = Money(15,USD)

scala> val fifteenDollars = Money(15)
fifteenDollars: Money = Money(15,USD)

scala> val someEuros = Money("EUR")
<console>:12: error: type mismatch;
 found   : String("EUR")
 required: Int
       val someEuros = Money("EUR")
                             ^

scala> val someEuros = Money(currency="EUR")
someEuros: Money = Money(1,EUR)

scala> val twentyEuros = Money(amount=20, currency="EUR")
twentyEuros: Money = Money(20,EUR)

scala> val tenEuros = twentyEuros.copy(10)
tenEuros: Money = Money(10,EUR)

scala> val twentyDollars = twentyEuros.copy(currency="USD")
twentyDollars: Money = Money(20,USD)

#### 함수정의
	def keyword 사용
    return keyword 생략 가능(생략하는 것이 대세)
 
scala> case class Money(val amount:Int=1, val currency:String="USD"){
     | def +(other:Money) : Money = Money(amount + other.amount)
     | }
defined class Money

scala> Money(12) + Money(34)


##### collection 사용
	scala의 collection은 기본적으로 immutable
    #가변형 객체에 여러 스레드가 접근할 때는 뮤텍스로 보호해야 하지만, 불변형 객체에 대해서는 이렇게 처리하지 않아도 되므로 멀티스레드로 동작하는 코드를 간결하게 작성할 수 있다. 
scala> 1 to 5
res6: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5)

scala> val numbers = List(1,2,5)
numbers: List[Int] = List(1, 2, 5)

scala> for (n <- numbers) println("Number " + n)
Number 1
Number 2
Number 5

#####  lambda 표현식(closure라고 불림)
	익명 함수(anonymous function)
	파라미터로 전달할 수 있는 함수.
    람다 함수는 파라미터를 입력받아서 함수 바디의 마지막 문장으로 리턴
    { input => 
      body
    }
    return이 없는 경우는 Unit 타입 리턴

scala> numbers.foreach{ n:Int=>
     | println("Number " + n)
     | }
Number 1
Number 2
Number 5
 
##### collection 연산
	콘스(cons)연산자 ::    (List에 Element는 add할 때 사용하는 연산자 ::메소드를 호출.)
    right-associative(오른쪽 우선 결합)
    ::: => 두 리스트를 결합하는 메서드
    
scala> val numbers = List(1,2,3,4,5,6)
numbers: List[Int] = List(1, 2, 3, 4, 5, 6)

scala> val reversedList = numbers.reverse
reversedList: List[Int] = List(6, 5, 4, 3, 2, 1)

scala> val onlyAFew = numbers drop 2 take 3
onlyAFew: List[Int] = List(3, 4, 5)

scala> numbers
res7: List[Int] = List(1, 2, 3, 4, 5, 6)

scala> val onlyAFew = numbers.drop(2).take(3)
onlyAFew: List[Int] = List(3, 4, 5)

scala> val numbers = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: Nil
numbers: List[Int] = List(1, 2, 3, 4, 5, 6)

scala> Nil.::(6)
res8: List[Int] = List(6)

scala> 6.::(Nil)
<console>:11: error: value :: is not a member of Int
       6.::(Nil)
         ^

scala> List(6).::(5)
res10: List[Int] = List(5, 6)

scala> val simpleList = Nil.::(6)
simpleList: List[Int] = List(6)

scala> val twoElementsList = List(6).::(5)
twoElementsList: List[Int] = List(5, 6)

scala> val concatenatedList = simpleList ::: twoElementsList
concatenatedList: List[Int] = List(6, 5, 6)

##### Scala Type system
![scala type system](http://docs.scala-lang.org/resources/images/classhierarchy.img_assist_custom.png)

	http://docs.scala-lang.org/tutorials/tour/unified-types.html  
	java의 Object -> scala Any
    Primitive -> AnyVal
    Reference -> AnyRef
    Nothing

scala> val things = List(0, 1, true)
things: List[AnyVal] = List(0, 1, true)

scala> things(2)
res11: AnyVal = true

scala> val things = List(0, 1, true, "false")
things: List[Any] = List(0, 1, true, false)

##### 복잡한 오브젝트에 대한 컬렉션

scala> val amounts = List(Money(10, "USD"), Money(2, "EUR"), Money(20, "GBP"), Money(50, "USD"))
amounts: List[Money] = List(Money(10,USD), Money(2,EUR), Money(20,GBP), Money(50,USD))


scala> val first = amounts.head
first: Money = Money(10,USD)

scala> val maountsWithoutFirst = amounts.tail
maountsWithoutFirst: List[Money] = List(Money(2,EUR), Money(20,GBP), Money(75,EUR))

##### filter와 partition

scala> val euros = amounts.filter(money => money.currency == "EUR")
euros: List[Money] = List(Money(2,EUR), Money(75,EUR))

filter 함수는 Boolean 값을 리턴 받는 함수(술어함수, Proposition function, Predicate Function)를 인자로 받는다 

scala> val euros = amounts.filter(x => x.currency == "EUR")
euros: List[Money] = List(Money(2,EUR), Money(75,EUR))

	java, python :  self
    groovy :  it
    scala :  _

scala> val euros = amounts.filter(_.currency == "EUR")
euros: List[Money] = List(Money(2,EUR), Money(75,EUR))

filterNot method 
partition method : 2개의 리스트 리턴(filter, filterNot)

scala> val allAmounts = amounts.partition(amt =>
     | amt.currency == "EUR")
allAmounts: (List[Money], List[Money]) = (List(Money(2,EUR), Money(75,EUR)),List(Money(10,USD), Money(20,GBP)))


##### 튜플
	http://www.scala-lang.org/api/current/index.html#scala.Tuple1
    Tuple1 Type ~ Tuple22 Type까지 있음.
	소괄호 안에 콤마로 구분하여 나열한 것
    _1, _2... 순서대로 값을 꺼낼 수 있다.
    
    
    
scala> allAmounts._1
res17: List[Money] = List(Money(2,EUR), Money(75,EUR))

scala> allAmounts _1
warning: there was one feature warning; re-run with -feature for details
res18: List[Money] = List(Money(2,EUR), Money(75,EUR))

scala> allAmounts._2
res19: List[Money] = List(Money(10,USD), Money(20,GBP))

- partition의 결과를 튜플 대신 두 변수에 담을 수 있다.

scala> val (euros, everythingButEuros) = amounts.partition(amt =>
     | amt.currency=="EUR")
euros: List[Money] = List(Money(2,EUR), Money(75,EUR))
everythingButEuros: List[Money] = List(Money(10,USD), Money(20,GBP))

scala> euros
res20: List[Money] = List(Money(2,EUR), Money(75,EUR))

scala> everythingButEuros
res21: List[Money] = List(Money(10,USD), Money(20,GBP))



##### 맵
	튜플을 좀 더 고급스럽게 응용한 컬렉션 타입.
    key와 value 쌍으로 구성
    
val wallet = Map("USD" -> 10, "EUR"->2)
scala> val wallet = Map("USD" -> 10, "EUR"->2)
wallet: scala.collection.immutable.Map[String,Int] = Map(USD -> 10, EUR -> 2)

scala> val tenDollars = "USD" -> 10
tenDollars: (String, Int) = (USD,10)

scala> val tenDollars = ("USD", 10)
tenDollars: (String, Int) = (USD,10)

scala> val updateWallet = wallet + ("GBP"->20)
updateWallet: scala.collection.immutable.Map[String,Int] = Map(USD -> 10, EUR -> 2, GBP -> 20)

scala> val someEuros = wallet("EUR")
someEuros: Int = 2

scala> val somePounds = wallet("GBP")
java.util.NoSuchElementException: key not found: GBP
  at scala.collection.MapLike$class.default(MapLike.scala:228)
  at scala.collection.AbstractMap.default(Map.scala:59)
  at scala.collection.MapLike$class.apply(MapLike.scala:141)
  at scala.collection.AbstractMap.apply(Map.scala:59)
  ... 33 elided

##### 옵션 
	Map의 get 메소드는 Option 타입을 리턴한다. Option은 null인 경우 None 리턴, 아닌경우는 Some(value) 리턴한다.
    
    
##### 패턴 매칭
	두 가지 이상의 복잡한 케이스를 간단히 처리.(<==== 좀더 쉬운 설명으로 교체 필요...)

scala> val status = mayBeSomeEuros match {
     | case None => "Nothing of that currency"
     | case Some(value) => "I have " + value + " Euros"
     | }
status: String = I have 2 Euros


- Hight-order function : 고차함수, 고계함수, 고차원함수 
- 명제함수, 컬렉션에 대한 컨테이너(hm.... ????)

##### map 메소드
    컬렉션에 담긴 모든 원소에 함수를 적용해서 새로운 리스트를 리턴
	Map object란 혼동 주의
    

scala> List(1,2,3,4).map(x=>x+1)
res33: List[Int] = List(2, 3, 4, 5)

scala> List(1,2,3,4) map (x=>x+1)
res35: List[Int] = List(2, 3, 4, 5)

scala> def increment = (x:Int) => x+1
increment: Int => Int

scala> List(1,2,3,4) map increment
res34: List[Int] = List(2, 3, 4, 5)

scala> val printedAmounts = 
| amounts map(m=> "" + m.amount + " " + m.currency)
printedAmounts: List[String] = List(10 USD, 2 EUR, 20 GBP, 75 EUR)

##### 스트링 인터폴레이션(String Interpolation)

scala> val many = 100000.2345
many: Double = 100000.2345

scala> val amount = s"$many euros"
amount: String = 100000.2345 euros

scala> val amount = f"$many%12.2f euros"
amount: String = "   100000.23 euros"

scala> val amount = s"${many*2} euros"
amount: String = 200000.469 euros

scala> val printedAmounts = amounts map (m=>s"${m.amount} ${m.currency}")
printedAmounts: List[String] = List(10 USD, 2 EUR, 20 GBP, 50 USD)

##### groupBy 메소드
scala> val sortedAmounts = amounts groupBy( _.currency )
sortedAmounts: scala.collection.immutable.Map[String,List[Money]] = Map(EUR -> List(Money(2,EUR)), GBP -> List(Money(20,GBP)), USD -> List(Money(10,USD), Money(50,USD)))

##### foldLeft 메소드
	(total, element)은 Tuple2 타입을 의미한다.

scala> val sumOfNumbers = numbers.foldLeft(0) {(total, element) =>
     | total + element
     | }
sumOfNumbers: Int = 15
    
scala> val sumOfNumbers = numbers.sum
sumOfNumbers: Int = 15


#### 코드연동
교재에서는 netbeans를 이용한다.
GUI로 작업이 진행되기 때문에 컨셉만 정리한다.
1. maven 설치
2. derbyDB run (example schema있어야한다. 예제실행했을때는 APP)
3. create maven project -> Webproject
   -> WAS는 glassfish 선택(tomcat선택시 자동 생성되는 모듈에 library가 없음.)
   -> run해봐서 웹페이지 나오는지 확인
4. project 우클릭 -> new -> restful webservice from database
   -> CUSTOMER TABLE 선택
   -> webpage에서 customer테스트
5. 교재 chapter02의 testclass 실행(java)
   -> CustomerTest.java
   -> mvn test
6. chapter02의 scala test 실행
   -> CustomerScalaTest.scala
   -> chapter02 pom.xml 참조
   -> mvn test


### 스칼라와 자바 코드의 연동
##### 컬렉션 타입 변환

scala> import java.util.Arrays
import java.util.Arrays

scala> val javaList = Arrays.asList(1,2,3,4)
javaList: java.util.List[Int] = [1, 2, 3, 4]

scala> import scala.collection.JavaConverters._
import scala.collection.JavaConverters._

scala> val scalaList = javaList.asScala
scalaList: scala.collection.mutable.Buffer[Int] = Buffer(1, 2, 3, 4)

scala> val javaListAgain = scalaList.asJava
javaListAgain: java.util.List[Int] = [1, 2, 3, 4]

scala> assert(javaList eq javaListAgain)

scala> assert(javaList eq scalaList)
<console>:17: warning: java.util.List[Int] and scala.collection.mutable.Buffer[Int] are unrelated: they will most likely never compare equal
       assert(javaList eq scalaList)
                       ^
java.lang.AssertionError: assertion failed
  at scala.Predef$.assert(Predef.scala:151)
  ... 33 elided


##### 자바빈 스타일의 프로퍼티
scala> class Company(var name:String)
defined class Company

scala> val sun = new Company("Sun Microsystems")
sun: Company = Company@702ed190

scala> sun.name
res2: String = Sun Microsystems

scala> sun.name_=("Oracle")

scala> sun.name
res4: String = Oracle

scala> import scala.beans.BeanProperty
import scala.beans.BeanProperty

scala> class Company(@BeanProperty var name:String)
defined class Company

scala> val sun = new Company("Sun Microsystems")
sun: Company = Company@1216eb3f

scala> sun.getName()
res7: String = Sun Microsystems

scala> sun.setName("Oracle")

##### 스칼라와 자바의 객체지향 지원 방식
	기본생성자(primary constructor) 
    클래스 선언시에 만드는 것으로 스칼라에서는 단 하나의 기본 생성자만 정의할 수 있다.
    
	보조 생성자(auxiliary constructor)
    보조생성자는 반드시 this(...)로 기존 생성자를 호출해야 한다.
    마지막에 기본 생성자(primary constructor)를 호출해 모든 파라미터를 초기화해야한다.

scala> class Customer ( var customerId: Int, var zip: String) {
     | def getCustomerId() = customerId
     | def setCustomerId(cust: Int): Unit = {
     |   customerId = cust
     | }
     | }
defined class Customer

scala> val customer = new Customer(1, "123 45")
customer: Customer = Customer@3c9e19de

scala> customer.
asInstanceOf   customerId_=    isInstanceOf    toString   zip_=   
customerId     getCustomerId   setCustomerId   zip                

scala> customer.zip
res10: String = 123 45

scala> val otherCustomer = new Customer("543 21")
<console>:18: error: not enough arguments for constructor Customer: (customerId: Int, zip: String)Customer.
Unspecified value parameter zip.
       val otherCustomer = new Customer("543 21")

scala> class Customer ( var customerId: Int, var zip: String) {
     | def this( zip: String) = this(0, zip)
     | def getCustomerId() = customerId
     | def setCustomerId(cust: Int): Unit = {
     | customerId = cust
     | }
     | }
defined class Customer

scala> val otherCustomer = new Customer("543 21")
otherCustomer: Customer = Customer@35536760

##### 자바 인터페이스를 개선한 스칼라 트레잇
	인터페이스 : 무엇을 하는지를 표현하는 부분(specification)과 이를 구체적으로 어떻게 동작하도록 구현하는 부분(implementation)을 분리해서, 실제 내부 구현 방식에 신경 쓸 필요 없이 간편하게 외부 시스템과 연동하게 해주는 메커니즘.
    자바의 인터페이스는 메소드에 대한 구현 코드를 담을수 없어서, 추상적인 형태로만 정의
    
    스칼아의 트레잇은 일부 메소드에 대해서 구현 코드를 담을 수 있다.
    java의 interface처럼 다중 상속(?) 가능
    트레잇은 with 키워드를 사용하고 호출은 오른쪽에서 왼쪽으로 호출된다.
    
    
    scala> class Customer ( var customerId: Int, var zip: String) {
     | def this( zip: String) = this(0, zip)
     | def getCustomerId() = customerId
     | def setCustomerId(cust: Int): Unit = {
     | customerId = cust
     | }
     | }
defined class Customer

scala> val otherCustomer = new Customer("543 21")
otherCustomer: Customer = Customer@35536760

scala> class Customer(val name:String, val discountCode: String="N"){
     | def discounts(): List[Int] = List(5)
     | override def toString() = "Applied discounts: " +
     | discounts.mkString(" ", " %, ", "% ")
     | }
defined class Customer

scala> trait VIPCustomer extends Customer {
     | override def discounts = super.discounts ::: List(10)
     | }
defined trait VIPCustomer

scala> trait GoldCustomer extends Customer {
     | override def discounts = 
     |   if (discountCode.equals("H"))
     |   super.discounts ::: List(20)
     |   else super.discounts ::: List(15)
     | }
defined trait GoldCustomer

scala> object Main {
     | def main(args: Array[String]) {
     |   val myDiscounts = new Customer("Thomas", "H") with 
     |     VIPCustomer with GoldCustomer
     |   println(myDiscounts)
     | }
     | }
defined object Main

scala> Main.main(Array.empty)
Applied discounts:  5 %, 10 %, 20% 

##### 오브젝트 선언
	java -> static 키워드로 singleton으로 생성
    scala -> object 키워드를 class 키워드 앞에 넣으면 해당 클래스는 singleton으로 생성
    
    companion object - 싱글톤 오브젝트로서 클래스와 동일한 패키지와 파일에서 공존할 수 있다.(????)
    
##### 컴패니언 오브젝트
	class명과 동일한 이름을 쓰는 object class
    해당 class의 private도 접근 가능하다
    
scala> object Customer {
     | def apply() = new Customer("default name")
     | }
defined object Customer

scala> val thomas = Customer()
thomas: Customer = Applied discounts:  5%


##### 예외 처리

scala> def parse(numberAsString: String) = 
     | try {
     | Integer.parseInt(numberAsString)
     | } catch {
     | case nfe: NumberFormatException =>
     |   println("Wrong fromat for number " + numberAsString)
     | case e: Exception => println("Error when parsing number" + numberAsString)
     | }
parse: (numberAsString: String)AnyVal

scala> parse("hello")
Wrong fromat for number hello
res0: AnyVal = ()

scala> parse("1.01")
Wrong fromat for number 1.01
res1: AnyVal = ()

scala> def parse(numberAsString: String) =
     | try {
     |   Integer.parseInt(numberAsString)
     | } catch {
     |   case nfe: NumberFormatException => 
     |     println("Wrong format for number "+ numberAsString)
     |     -1
     |   case _: Throwable =>
     |     println("Error when parsing number " + numberAsString)
     |     -1
     | }
parse: (numberAsString: String)Int

scala> val number = parse("23ab")
Wrong format for number 23ab
number: Int = -1

scala> case class Failure(val reason: String)
defined class Failure

scala> def parse(numberAsString: String) : Either[Failure, Int] = 
     |   try {
     |     val result = Integer.parseInt(numberAsString)
     |     Right(result)
     |   } catch {
     |     case _ : Throwable => Left(Failure("Error when parsing number"))
     |   }
parse: (numberAsString: String)Either[Failure,Int]

scala> val number = parse("12ab")
number: Either[Failure,Int] = Left(Failure(Error when parsing number))

scala> val number = parse("1234")
number: Either[Failure,Int] = Right(1234)

scala> parse("12") match { 
     | case Right(x) => x
     | case Left(x) => "hello" + x
     | }
res1: Any = 12

##### 자바와 스칼라의 코딩 스타일 차이점
	java : 명령형(imperative)을 주로 사용
    scala : 함수형 언어에 뿌리를 두고 있기 때문에, 문장(statement) 대신 표현식(expression)으로 코드를 구성하는 선언적(declarative)인 방식을 주로 사용
    
    모든것을 표현식(특히 불변형 표현식)으로 작성하면 코드를 재활용하거나 결함(composition)하기가 훨씬 쉽다.
    

scala> val amountBought = 5000
amountBought: Int = 5000

scala> val customerLevel = if(amountBought > 3000) "Gold" else "Silver"
customerLevel: String = Gold

##### 코드 레이아웃 다듬기
	한문장으로 표현하는 원라이너로 작성하는 경우가 많기 때문에 두개 공백 문자로 들여쓰기를 하는 것이 좋다.
    http://docs.scala-lang.org/style/naming-conventions.html
    
##### 명명 규칙
	camel case 사용, _가 익명함수나 self, this의 의미를 갖고 있기 때문에 first_name, _first_name처럼 변수 이름에 함부로 사용하면 안 된다.
    상수는 MyConstant처럼 첫글자가 대문자로 시작하는 낙타 표기법을 사용.
    함수명은 최대한 간결하게 표현
    자바에서는 x같은 변수명을 권장하지 않지만, 스칼라에서는 람다 표현식을 더 짧게 표현할 수 있기 때문에 권장한다(원라이너 때문에). _로 표현함.
	amount-> amt 처럼 축약형 추천
    
### 3. 스칼라 에코시스템
##### ide
http://scala-ide.org/

##### sbt
	DSL형태로 스칼라를 작성
    ivy를 이용한 의존성 관리
    메이븐 포멧의 저장소 사용
    점진적으로 컴파일(incremental compilation)
    REPL(??)
    연속적으로 테스팅, 배치, 테스트 프레임워크와 연동

http://www.scala-sbt.org/



wget https://dl.bintray.com/sbt/native-packages/sbt/0.13.9/sbt-0.13.9.zip -O sbt.zip

	

java -Xms512M -Xmx1536M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=384M -jar `dirname $0`/sbt-launch.jar "$@"

$ chmod u+x ~/bin/sbt

	sbt -> 초반에 다운로드 시간이 꽤 걸린다;;;

boojongmin@boojongmin-ThinkPad-E550:~/dev/cm/github/study/book/ScalaForJavaDevelopers/example/SampleProject$ sbt
[info] Set current project to sampleproject (in build file:/home/boojongmin/dev/cm/github/study/book/ScalaForJavaDevelopers/example/SampleProject/)
> run
[info] Compiling 1 Scala source to /home/boojongmin/dev/cm/github/study/book/ScalaForJavaDevelopers/example/SampleProject/target/scala-2.10/classes...
[info] Running Hi 
Hi!
[success] Total time: 3 s, completed 2015. 9. 24 오후 1:21:16
> exit

vi build.sbt
```sbt
name := "SampleProject"

version := "1.0"

scalaVersion := "2.10.3"
```

sbt 파일에서 빈줄은 구분자(delimeter) 역할을 한다.

##### 이클립스 플러그인 설치
https://github.com/typesafehub/sbteclipse

파일 생성 /project/plugins.sbt

    addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "4.0.0")

cd ..
sbt eclipse

(이클립스에서 import)

###intelij
https://github.com/mpeltonen/sbt-idea

/project/plugins.sbt

    addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")
    
    저장소 추가 방법 예제
    resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

cd ..
sbt gen-idea

	IDEA 13부터 스칼라 플러그인에서 SBT를 기본으로 지원하므로 위 방식대로 하지 않아도 된다.

##### netbeans (skip....)


##### 서블릿 컨테이너에서 실행할 웹 애플리케이션 만들기(책대로느 안됨. 아래 링크 참조)

http://earldouglas.com/projects/xsbt-web-plugin/2.0.html

mkdir -p src/main/scala
mkdir -p src/main/webapp/WEB-INF

vi project/plugin.sbt

    addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "2.0.4")

vi build.sbt
	name := "SampleProject"

    organization := "com.samples"

    version := "1.0"

    scalaVersion := "2.10.3"

    libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115"

    libraryDependencies += "org.eclipse.jetty" % "jetty-plus" % "9.1.0.v20131115"

    libraryDependencies += "javax.servlet" % "servlet-api" % "2.5" % "provided"

    libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.0"
    
@@에러발생
    
    
     [error] /home/boojongmin/dev/cm/github/study/book/ScalaForJavaDevelopers/example/SampleProject/src/main/scala/com/samples/SimpleServlet.scala:14: To compile XML syntax, the scala.xml package must be on the classpath.

     Scala 2.11 이후에서 scala xml이 빠짐. 의존성 추가해줘야함.
     libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.2"
     
     
     (책은 container:start로 되어있는데 안된다...;; 플러그인 사이트가서 메뉴얼 찾아보니 jetty:start로 실행하라고함)
     > jetty:start
    [info] waiting for server to shut down...
    [info] starting server ...
    2015-09-24 17:55:28.922:INFO::main: Logging initialized @138ms
    2015-09-24 17:55:28.941:INFO:oejr.Runner:main: Runner
    [success] Total time: 0 s, completed 2015. 9. 24 오후 5:55:29
    2015-09-24 17:55:29.067:INFO:oejs.Server:main: jetty-9.2.1.v20140609
    > 2015-09-24 17:55:30.826:WARN:oeja.AnnotationConfiguration:main: ServletContainerInitializers: detected. Class hierarchy: empty
    2015-09-24 17:55:31.107:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@2d6d8735{/,file:/home/boojongmin/dev/cm/github/study/book/ScalaForJavaDevelopers/example/SampleProject/target/webapp/,AVAILABLE}{file:/home/boojongmin/dev/cm/github/study/book/ScalaForJavaDevelopers/example/SampleProject/target/webapp/}
    2015-09-24 17:55:31.108:WARN:oejsh.RequestLogHandler:main: !RequestLog
    2015-09-24 17:55:31.134:INFO:oejs.ServerConnector:main: Started ServerConnector@128d6de6{HTTP/1.1}{0.0.0.0:8080}
    2015-09-24 17:55:31.135:INFO:oejs.Server:main: Started @2380ms

##### sbt-assembly로 하나의 .jar 파일로 만들기
버전업되면서 책의 내용은 안됨.
https://github.com/sbt/sbt-assembly 참조

##### Scalariform으로 코드 포맷팅

https://github.com/sbt/sbt-scalariform

##### 스칼라 워크시트

sbt의 :replay 명령처럼 REPL 프로젝트의 작업 내용도 저장하는 기능
이클립스 New > Scala Worksheet >> experiment.sc 파일 생성

##### HTTP 다루기
HttpClient facade -> http://dispatch.databinder.net/Dispatch.html


	sbteclipse에서 .class 파일을 생성시키지 않는것을 확인했다. 그래서 새로은 library 추가가 안되고 있다.
	http://stackoverflow.com/questions/28900528/sbt-won%C2%B4t-update-classpath-in-a-play-scala-project
    뭔가 버그가 있는것 같다. typesafe의 activator로 교체
    
    wget https://downloads.typesafe.com/typesafe-activator/1.3.6/typesafe-activator-1.3.6.zip?_ga=1.144562549.1754336652.1443143539 -O activator.zip
	
    으아아아;;; 안됨;;


##### HTTP 다루기
val request = url("http://freegeoip.net/xml/www.google.com")
val result = Http(request OK as.String)
val resultAsString = result() //result.apply()

##### 스칼라의 for문
for {
  elem <- List(1, 2, 3, 4, 5)
} yield "T" + elem

for {
  word <- List("Hello", "Scala")
  char <- word
} yield char.isLower

for {
  word <- List("Hello", "Scala")
  char <- word if char.isUpper
} yield char

for {
  word <- List("Hello", "Scala")
  char <- word
  lowerChar = char.toLower
} yield lowerChar


##### 타입세이프 액티베이터의 활용

activator new
[tab]
play-java-spring
javasample

cd javasample
./activator run

./activator ui

#### REPL을 스크립트 엔진으로 활용
	http://docs.oracle.com/javase/6/docs/technotes/guides/scripting/


### 4. 테스팅 도구
(링크 참조)
http://kukuruku.co/hub/scala/introduction-to-writing-tests-with-scalatest

	TDD
    BDD : https://cucumber.io/ BDD 스타일로 개발을 해야하는 언어.
    
    스칼라에서는 ScalaTest(http://scalatest.org/), 
    Spec2(http://etorreborre.github.io/specs2/) 지원.
    
    
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
	
    error 발생 : can't expand macros compiled by previous versions of Scala
    http://stackoverflow.com/questions/24103043/why-does-sbt-give-cant-expand-macros-compiled-by-previous-versions-of-scala-f
    (해결)
	//libraryDependencies += "org.scalatest" % "scalatest_2.10" % "3.0.0-M9"
	libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"


(background demon 테스트 실행)
> ~test-only scalatest.Test02     
                                                                       
	기존 junit으로 실행시키고 싶으면
    import org.scalatest.FunSuite
    import org.junit.runner.RunWith
    import org.scalatest.junit.JUnitRunner

    @RunWith(classOf[JUnitRunner])

##### BDD 스타일 테스팅
(참조)https://en.wikipedia.org/wiki/Behavior-driven_development


	(문제발생)scala worksheet에서 org.scalatest._가 import되지 않음
	http://stackoverflow.com/questions/26090385/intellij-idea-w-scala-plugin-not-finding-scala-concurrent
    링크대로 캐시 삭제후 리스타트했으나 안됨
    
    build.sbt에 test 스코프로 설정되어있는 것을 확인함.
    //libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
    libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4"
    
    
    
##### 기능 테스트
http://www.seleniumhq.org/

	(추가)
    libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "2.47.1"
    libraryDependencies += "org.seleniumhq.selenium" % "selenium-htmlunit-driver" % "2.47.1"


##### ScalaMock으로 모킹하기

(ScalaMock)
libraryDependencies += "org.scalamock" % "scalamock-scalatest-support_2.11" % "3.2.2"
(Spec2)
libraryDependencies += "org.scalamock" % "scalamock-specs2-support_2.11" % "3.2.2"

(참조)
http://scalamock.org/user-guide/mocking_style/
Expectations-First
Record-then-Verify


##### ScalaCheck를 이용한 테스팅
Fuzz test
https://ko.wikipedia.org/wiki/%ED%8D%BC%EC%A7%95
https://en.wikipedia.org/wiki/Fuzz_testing


### 플레이 프레임워크

##### 클래식 버전으로 플레이 프레임워크 시작하기
https://playframework.com/download
-> 공식 사이트에서 activator로 진행하는 것으로 바뀜

##### 탕비세이프 액티베이터 시작하기
activator ui
hello-play-scala 선택 - 설치 폴더 선택 - create
cd hello-play-scala
./activator run [port-number]

(문제발생)
https://github.com/typesafehub/activator/issues/1060
->위의 내용대로 build.sbt 수정함



### 6 데이터베이스 사용 방법과 ORM의 미래

> sbt
> set name :="sbtjpasample"
> session save


    (문법)???
    override def save(customer: Customer): Unit = ???
    http://stackoverflow.com/questions/31302524/what-does-the-triple-question-mark-mean-in-scala


### 7. 웹서비스
pass


### 8. 비동기와 동시성
SIP-14-Futures and Promises 참조
(Future, Promises)
https://en.wikipedia.org/wiki/Futures_and_promises

    Future는 여러가지 연산을 효율적이며서 논블록킹 방식으로 동시에 실행시키기 위한 뛰어난 방법을 제공한다.

##### Async 라이버르리: SIP-22-Async

- async { <표현식> } : <표현식>에 해당하는 코드가 비동기로 실행된다.
- await { <Future 오브젝트를 리턴하는 표현식> } : async 블록 안에서 사용되며, Future 인자가 완성될 때까지 외부의  async 블록의 실행을 멈춘다.

def async[T](body: => T) : Future[T]
def await[T](future:Future[T]):T

(참조) https://github.com/scala/async


##### 아카 살펴보기
##### 액터 모델의 이해

Actor 모텔을 칼휴이트와 피터 비숍, 리차드 스타이거가 1973년 IJCAI에 발표한 'A Universal Modular Actor Formalism for Artificaial Intelligence' 논문을 통해 처음 소개. 이 모델을 적용해 유명해진 언어가 Erlang

	actor 모델의 특징
    메소드 호출이 아닌 메시지 전달에 기반
    액터라 부르는 연산의 단위를 통해 동작을 캡슐화하고, 다른 액터와 불변형 메시지를 비동기적으로 통신하는 방식으로 연산을 수행
    사람의 커뮤니케이션을 본따서 만들었기 때문에 시스템의 동작을 직관적으로 볼 수 있는 장점이 있다.
    스레드에 비해 간단하고, 상태를 공유하지 않기 때문에 분산 및 병렬 애플리케이션을 작성하기에 안성 맞춤이다.

```scala
class Greeter extends Actor {
  var greeting = ""

  def receive = {
    case WhoToGreet(who) => greeting = s"hello, $who"
    case Greet           => sender ! Greeting(greeting) // Send the current greeting back to the sender
  }
}
```


Actor
  Actor trait을 상속, 추상 메소드 receive 구현해야함. partial 함수이기 때문에, 메시지의 모든 타입에 대해 처리하지 않아도 된다.
  receive는 싱글 스레드로 처리.(이놈의 event-driven....)
  actor의 상태를 추가할 수 있도록 gretting 변수를 가변형으로 선언.
  !메소드는 tell이라고 부름.(actor ! message)
  명시적인 선언 없이 sender라는 변수를 사용 함. 이는 메시지를 전달한 액터에게 응답을 하기 위함.
  ActorRef 인자를 통해 Greet 메시지에 수신자의 주소를 담아 보내도 된다.
  (ex) case Greet(someon) => someone ! Greeting(greeting)
  
```scala
object HelloAkkaScala extends App {

  // Create the 'helloakka' actor system
  val system = ActorSystem("helloakka")

  // Create the 'greeter' actor
  val greeter = system.actorOf(Props[Greeter], "greeter")

  // Create an "actor-in-a-box"
  val inbox = Inbox.create(system)

  // Tell the 'greeter' to change its 'greeting' message
  greeter.tell(WhoToGreet("akka"), ActorRef.noSender)

  // Ask the 'greeter for the latest 'greeting'
  // Reply should go to the "actor-in-a-box"
  inbox.send(greeter, Greet)

  // Wait 5 seconds for the reply with the 'greeting' message
  val Greeting(message1) = inbox.receive(5.seconds)
  println(s"Greeting: $message1")

  // Change the greeting and ask for it again
  greeter.tell(WhoToGreet("typesafe"), ActorRef.noSender)
  inbox.send(greeter, Greet)
  val Greeting(message2) = inbox.receive(5.seconds)
  println(s"Greeting: $message2")

  val greetPrinter = system.actorOf(Props[GreetPrinter])
  // after zero seconds, send a Greet message every second to the greeter with a sender of the greetPrinter
  system.scheduler.schedule(0.seconds, 1.second, greeter, Greet)(system.dispatcher, greetPrinter)
  
}
```
  
 
##### 동작변경
booking 프로그램

intellij run ->
Application
Main class : akka.Main
VM options : -Dakka.loglevel=DEBUG -Dakka.actor.debug.receive=true
Program arguments : se.sfjd.ch8.sample.BookingMain
Working  directory : (선택)
Use classpath of module : helloakka

#### 메시지 처리에 실패했을 경우

	한 오브젝트가 다른 오브젝트의 메소드를 호출하는 방식으로 동작하던 기존 아키텍처에서는 호출한 측의 예외가 전달된다.

	액터 모델에서는 모든 메시지가 비동기적으로 처리되기 때문에, 응답을 받기 전까지 얼마나 걸릴리 알 수 없을 뿐만 아니라, 메시지를 보낸 뒤에느 ㄴ발생한 오류에 대한 어떠한 처리도 할 수 없어서 예외를 다루기가 훨씬 까다롭다.
    
    akka는 '죽게 내버려 두는' 방식을 따름.  -> 액터에 대한 모니터링 기능과 죽은 액터와 여기에 영향을 받는 액터 그룹을 재구동하는 기능을 제공.
    부모 액터에서 자식 액터를 모니터링 할 수 있다.
    
##### 액터 시스템 테스트
	병렬 시스템은 근본적으로 다음 동작을 예측할 수 없기(비결정적 nondeterministic) 때문에 싱글 스테드 아키텍처와는 달리 주의해야함.
    
helloakka -> test -> scalatest 참조


##### 이장에서 다루지 못한 아카의 기능
- DeathWatch API를 이용한 액터의 생명 주기 관리 기능
- 시스템 실패 후 복구한 뒤에도 액터의 상태 유지하는 기능
- 분산 환경에서 액터끼리 원격으로 통신하는 기능
- 클러스터링을 통해 분산 환경에서 오류를 처리하는 기능. 타입세이프 액티베이터 템플릿인 akka-clustering을 통해 클러스터링 기능에 대한 예제 확인 가능

http://akka.io/docs 참조

    