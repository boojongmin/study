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


     