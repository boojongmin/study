T-T 12page까지 작업한거 날려먹음. T-T
간략 내용.
# 소프트웨어 설계의 고고학
##### 의존관계
##### 높은 응집도와 낮은 결합도
##### 5대 원칙 정리
1. 단일 책임의 원칙(SRP; Single Responsibility Principle)
 - 객체는 하나의 책임만을 맡아야 한다.
 책임: 클래스에 할당된 비지니스 로직에 대한 요구.
    note
    리팩토링 기법 책임 분배.

2. 의존 관계 역전의 원칙(DIP; Dependency Inversion Principle)
 - 클라이언트는 구체 클래스가 아닌 인터페이스나 추상 클래스에 의존해야한다.

    note
    상속구조에서 하위 클래스를 사용하는 경우
    1. 개발자의 부주의: List list = new ArrayList 대신 ArrayList list = new ArrayList();
    2. 상속구조 자체가 잘못: is a 관계가 아닌데 사용하는 경우(has a는?)
    3. 상속 구조가 LSP를 지키고 있지 않은 경우.: LSP 를 어기고 상속 구조의 폭주를 막기 위해서일 수 있다.(ex: Collections.unmodifiable(List list))
3. 인터페이스 분리의 원칙(ISP; Interface Segregation Principle)
 - 클라이언트에 특화된 여러 개의 인터페이스가 하나의 범용 인터페이스보다 낫다.
4. 리스코프 대체 원칙(LSP; Liskov Substitution Principle)
 - 기반 클래스는 파생 클래스로 대체 가능해야한다.

5. 개방 폐쇄 원칙(OCP; Open-Closed Principle)
 - 모듈은 확장에는 열려있어야 하고, 변경에는 닫혀 있어야 한다.

##### 아키텍처, 디자인, 마이크로 패턴

표 0-1 패턴 시스템

d|아키텍처|디자인|이디엄
-|-|-|-
From Mud to Structure|Layers, Pipes and Filters, Blackboard| |
Distrubuted System | Broker, Pipes and Filters, Microkernel||
Interactive System| MVC, PAC, ||
Adaptable System | Microkernel, Reflection ||
Structural Decomposition||Whole-Part|
Organization of Work||Master-Slave|
Access Control||Proxy|
Management||Command Processor, View Handler|
Communication||Publisher-Subcriber, Forwarder-Reciever, Client-Dispatcher-Server|
Resource Handling|||Counted Pointer
