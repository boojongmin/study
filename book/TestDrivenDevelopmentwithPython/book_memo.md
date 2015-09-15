기능테스트(functional test) : 사용자 관점에서 에플리케이션 외부를 테스트
단위테스트(unit test) : 프로그래머 관점에서 그 내부를 테스트

TDD 접근법은 기능/단위 테스트 모두 적용한다. 
TDD 작업순서 (완료후 반복)
1. 기능 테스트를 작성해서 사용자 관점의 새로운 기능성을 정의
1. 기능 테스트가 실패하고 나면 어떻게 코드를 작성해야 테스트를 통과할지(또는 적어도 현재 문제를 해결할 수 있는 방법)를 생각해보도록 한다. 이 시점에서 하나 또는 그 이상의 단위 테스트를 이용해서 어떻게 코드가 동작해야 하는지 정의한다(기본적으로 모든 코드가 (적어도) 하나 이상의 단위 테스트에 의해 테스트 돼야 한다.
1. 단위 테스트가 실패하고 나면 단위 테스트를 통과할 수 있을 정도의 최소한의 코드만 작성한다. 기능 테스트가 완전해질 때까지 과정 2와 3을 반복해야 할 수도 있다.
1. 기 테스트를 재실행해서 통과하는지 또는 제대로 동작하는지 확인하낟. 이 과정에서 새로운 단위 테스트를 작성해야 할 수도 있다. 


TDD는 훈련이다. 성과가 즉시 보여지는 것이 아니라 오랜 기간을 거쳐야 보이기 때문디ㅏ.

시시한 함수에 대한 시시한 테스트의 이점
1. 테스트 자체가 시시하다면 테스트 작성에 시간이 오래 소요 되지 않는다 그냥하자.
1. 틀을 사용하는 것이 도움이 된다는 것이다. 쉬운 함수를 위한 테스트 틀이 있다면, 함수가 복잡해지더라도 심리적 부담을 줄일 수 있다. 테스트를 해야 할 정도로 복잡하다고 판단한 후 테스트를 작성하기 시작한다면, 틀이 없기 때문에 훨씬 많은 수고를 들여서 테스트를 만들고 수정해야한다.


TDD는 Agile 개발 방법과 밀접한 관련이 있다. -> 동작하는 최소한의 애플리케이션을 빠르게 말들고, 이를 이용해서 얻은 실제 사용자 의견을 설계에 점진적으로 반영해 가능 방식

** YAGNI!(You ain't gonna need it)** 




**상수는 테스트하지 마라** 

** Refactoring **
1. 테스트없이 리팩터링할 수 없다.

** 리팩터링시에는 앱 코드와 테스트 코드를 한 번에 수정하는 것이 아니라 하나씩 수정해야 한다.** 
[refactoring cat](https://www.youtube.com/watch?v=wmOofF7FnQA)

TDD 프로세스
1. 기능테스트
1. 단위테스트
1. 단위 테스트-코드 주기
1. 리팩터링

!!page 55 이미지 추가


** 레드/그린/리팩터와 삼각법 **
레드 : 실패할 단위 테스트를 작성함으로써 작업을 시작한다.
그린 : 이 테스트를 통과할 최소 코드를 작성한다. 편법이라도 상관없다.(home.html '1: ' 같은 상수 사용)
리팩터 : 코드를 리팩터링해서 이해할 수 있는 코드로 만든다.

-> 저자는 이 방법을 선호하지 않는다. 저자는 '삼각법'(Triangulation)을 선호한다. 편법을 사용하지 않고 개발

** 데이터베이스 마이그레이션 **
ORM : 데이터베이스 모델을 만드는 것
Migration(마이그레이션) : 데이터베이스 구축을 담당
-> python3 manage.py makemigrations

(참고)TDD 개념 용어
* Regression(퇴행) : 동작하고 있던 애플리케이션 처리가 새롭게 추가된 코드에 의해 망가지는 것
* Unexpected failure(예상치 못한 실패): 테스트를 잘못 작성했거나, 테스트 자체가 코드 퇴행을 발견했다는 것을 의미
* red/green/refactor : TDD 처리를 기술하는 다른 방법. 
테스트를 작성해서 실패하는지 보고(레드), 코드를 수정해서 테스트를 통과하도록 만든다(그린). 그리고 리팩터를 통해 코드를 개선한다.
* Triangulation(삼각법) : 기존 코드에 구체적인 테스트 케이스를 추가해서 일반화(편법이 될 수도 있는)한 처리를 정당화하는 것.
* Three strikes and refactor : 언제 중복 코드를 제거해야하는지 말해주는 일반적인 규칙. 세 번째 동일 코드가 나온다면, 어떤 코드가 공통적이며, 재사용 또는 리팩터링이 가능한지 확실할 수 있게 된다.
* 작업 메모장 : 코딩을 하는 동안 우리가 해야 할 작업을 기록해두는 곳. 이렇게 기록해두면 현재 작업하고 있는 것이나 마저 못한 작업을 나중에라도 끝낼 수 있다.
   
**python app test tip ** 
mkdir functional_tests
cd functional_tests
touch __init__.py
vi tests.py
// test case 작성... //
cd ..
pytyon3 manage.py test functional_tests <- functional_tests folder의 테스트만 실행.
pytyon3 manage.py test lists <- lists folder의 테스트만 실행.
pytyon3 manage.py test <-모든 앱 폴더(functional_tests, lists)의 테스트도 같이 실행됨.


command 
python3 funcional_test.py   <- 기능테스트용
pythone3 manage.py runserver
python3 manage.py test      <- 단위테스트용(lists/test.py 실행)
python3 manage.py makemigrations <- migration for testunit's database
python3 manage.py migrate

(db 초기화)
rm db.sqlite3
python3 manage.py migrate --noinput

 ========
** grep tip ** 
grep -E "class|def" lists/tests.py






git command
git log --oneline