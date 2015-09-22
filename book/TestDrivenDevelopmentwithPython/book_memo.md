기능테스트(functional test) : 사용자 관점에서 에플리케이션 외부를 테스트
단위테스트(unit test) : 프로그래머 관점에서 그 내부를 테스트

TDD 접근법은 기능/단위 테스트 모두 적용한다. 
TDD 작업순서 (완료후 반복)
1. 기능 테스트를 작성해서 사용자 관점의 새로운 기능성을 정의
1. 기능 테스트가 실패하고 나면 어떻게 코드를 작성해야 테스트를 통과할지(또는 적어도 현재 문제를 해결할 수 있는 방법)를 생각해보도록 한다. 이 시점에서 하나 또는 그 이상의 단위 테스트를 이용해서 어떻게 코드가 동작해야 하는지 정의한다(기본적으로 모든 코드가 (적어도) 하나 이상의 단위 테스트에 의해 테스트 돼야 한다.
1. 단위 테스트가 실패하고 나면 단위 테스트를 통과할 수 있을 정도의 최소한의 코드만 작성한다. 기능 테스트가 완전해질 때까지 과정 2와 3을 반복해야 할 수도 있다.
1. 기 테스트를 재실행해서 통과하는지 또는 제대로 동작하는지 확인하낟. 이 과정에서 새로운 단위 테스트를 작성해야 할 수도 있다. 


TDD는 훈련이다. 성과가 즉시 보여지는 것이 아니
1. 단위 테스트가 실패하고 나면 단위 테스트를라 오랜 기간을 거쳐야 보이기 때문디ㅏ.

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

** 책에서 사용한 특징 **
'/new', '/new/'의 차이처럼 꼬리슬래시를 사용한 경우는 일반적인 URL, 없는 경우는 데이터베이스에 변경을 가하는 ACTION URL인 경우로 사용함


** 알아두면 유용한 TDD 개념과 일반적인 법칙**
- 테스트 격리(Test Isolation)와 전역 상태(Global State): 각각의 테스트가 다른 테스트에 영향을 끼쳐서는 안 된다. each test, initialize persistence
- 동작 상태 확인 후 다음 동작 상태 확인(테스트고트 vs 리팩터링 캣): 일반적으로 모든 것을 한 번에 수정하는 것이 쉽다. 하지만 주의하지 않으면 결국 리팩터링 캣 처지가 되서 오히려 많은 코드를 재수정 하거나 아무것도 동작하지 않는 상태가 된다. 테스트 고트님은 우리가 한 단계씩 수정해서 동작하는지 확인 후에 다음 다녜로 넘어가도록 격려하고 있다.
- YAGNI('You ain't gonna need it!') : 나중에 도움이 될 것이라는 생각에 코드를 작성하려고 하느 ㄴ유혹을 이겨내야 한다. 그것을 사용하지 않을 수도 있고, 무엇보다 이후에 발생한 요구사항 변경을 예측할 수 없기 때문이다. (극복방법은 책 18장에서 다룸)

서버 구축 절차
1. 도메인명 취득
2. 수동으로 서버를 호스트 사이트로 프로비저닝하기
   - 신규 서버를 프로비저닝해서 코드를 호스팅할 수 있도록한다.
   - 신규 버전의 코드를 기존 서버에 배포한다.
3. 사이트를 호스트할 곳 정하기
4. 서버 구축하기
5. 사용자 계정, SSH, 권한
[docker]
root@b32bef0e8269:/home# useradd -m -s /bin/bash elspeth
root@b32bef0e8269:/home# usermod -a -G sudo elspeth
root@b32bef0e8269:/# passwd
Enter new UNIX password: 
Retype new UNIX password: 
passwd: password updated successfull
root@b32bef0e8269:/# passwd elspeth
Enter new UNIX password: 
Retype new UNIX password: 
passwd: password updated successfully
root@b32bef0e8269:/home# su - elspeth
elspeth@b32bef0e8269:~$  
ssh 생성 참조 링크
https://www.linode.com/docs/networking/ssh/use-public-key-authentication-with-ssh/
1. nginx 설치
elspeth@b32bef0e8269:~$ sudo apt-get install nginx
elspeth@b32bef0e8269:~$ sudo service nginx start
elspeth@b32bef0e8269:~$ sudo service nginx status
 * nginx is running
elspeth@b32bef0e8269:~/nginx$ sudo apt-get install git
elspeth@b32bef0e8269:~/nginx$ sudo apt-get install python3-setuptools
elspeth@b32bef0e8269:~/nginx$ sudo easy_install3 pip
elspeth@b32bef0e8269:~/nginx$ pip --version
pip 7.1.2 from /usr/local/lib/python3.4/dist-packages/pip-7.1.2-py3.4.egg (python 3.4)
elspeth@b32bef0e8269:~/nginx/superlists$ sudo apt-get install ufw
elspeth@b32bef0e8269:~/nginx/superlists$ sudo ufw disable
elspeth@b32bef0e8269:~/nginx/superlists$ sudo pip install selenium
elspeth@b32bef0e8269:~/nginx/superlists$ sudo pip install django

git에서 clone한후 ~/site하위에 django 폴더 복사
python3 manage.py makemigrations
python3 manage.py migrate



(사이트 폴더명은 domain을 이용하면 좋다.)
~/site/www.boojongmin.com

** virtualenv 생성 **
elspeth@b32bef0e8269:~/nginx$ sudo pip3 install virtualenv
elspeth@3111c33338ef:~/nginx$ virtualenv --python=python3 ./virtualenv
elspeth@3111c33338ef:~/nginx$ source ./virtualenv/bin/activate
(virtualenv)elspeth@3111c33338ef:~/nginx$ 
(virtualenv)elspeth@3111c33338ef:~/nginx$ pip install django
(virtualenv)elspeth@3111c33338ef:~/nginx$ pip freeze > ./superlists/requirements.txt
(virtualenv)elspeth@3111c33338ef:~/nginx$ deactivate
elspeth@3111c33338ef:~/nginx$ 

** Nginx 설정 ** 

boojongmin@boojongmin-ThinkPad-E550:/usr/local/nginx-1.9.3$ sudo ps -aux | grep nginx
root      1161  0.0  0.0  28472   560 ?        Ss   21:25   0:00 nginx: master process /usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf

vi /usr/local/nginx/conf/nginx.conf

// root html 주석처리한 부분으로 하려면 심볼릭 링크 생성
boojongmin@boojongmin-ThinkPad-E550:/usr/local/nginx/html$ sudo ln -s /home/boojongmin/dev/ci/openshift/boojongmin/python/wsgi/static ./static
//
boojongmin@boojongmin-ThinkPad-E550:/usr/local/nginx/html$ sudo vi ../conf/nginx.conf

 	#	location /static/ {
	 #        root html;
	 #      }
        
        location /static {
          alias /home/boojongmin/dev/ci/openshift/boojongmin/python/wsgi/static;
        }


        location / {
            proxy_pass http://localhost:8000;
        }

boojongmin@boojongmin-ThinkPad-E550:/usr/local/nginx/html$ sudo service nginx reload


** gunicorn 설치 ** 
boojongmin@boojongmin-ThinkPad-E550:~/dev/cm/github/study/book/TestDrivenDevelopmentwithPython/example$ source ./virtualenv/bin/activate
(virtualenv)boojongmin@boojongmin-ThinkPad-E550:~/dev/cm/github/study/book/TestDrivenDevelopmentwithPython/example$ pip install gunicorn
(gunicorn은 application이라고 하는 함수를 가지고 있는 WSGI 서버 경로를 알고 있어야한다. Django는 superlists/wsgi.py 파일을 통해 이 함수를 제공한다.)
(virtualenv)boojongmin@boojongmin-ThinkPad-E550:~/dev/cm/github/study/book/TestDrivenDevelopmentwithPython/example$ cd superlists/
(virtualenv)boojongmin@boojongmin-ThinkPad-E550:~/dev/cm/github/study/book/TestDrivenDevelopmentwithPython/example/superlists$ gunicorn superlists.wsgi:application

** gunicorn을 이용하여 unix socket 사용 ** 

nginx.conf 수정

	location / { 
          proxy_set_header Host $host; 
          proxy_pass http://unix:/tmp/superlists.socket; 
        }

(virtualenv)boojongmin@boojongmin-ThinkPad-E550:~/dev/cm/github/study/book/TestDrivenDevelopmentwithPython/example/superlists$ sudo service nginx reload
(virtualenv)boojongmin@boojongmin-ThinkPad-E550:~/dev/cm/github/study/book/TestDrivenDevelopmentwithPython/example/superlists$ gunicorn --bind unix:/tmp/superlists.socket superlists.wsgi:application

** Debug를 False로 설정하고 ALLOWED_HOSTS 설정하기(운영서버에만 작업) ** 

superlists/settings.py

	DEBUG = False
    TEMPLATE_DEBUG = False
    ALLOWED_HOSTS = ['python-boojongmin.rhcloud.com']

** Upstart를 이용한 부팅시 Gunicorn가동 **

** Fabric python을 이용한 배포 자동화 **
참고: http://www.fabfile.org/
```python
from fabric.contrib.files import append, exists, sed
from fabric.api import env, local, run
import random


REPO_URL = 'https://github.com/hjwp/book-example.git'

def deploy():
    site_folder = '/home/%s/sites/%s' % (env.user, env.host)
    source_folder = site_folder + '/source'
    _create_directory_structure_if_necessary(site_folder)
    _get_latest_source(source_folder)
    _update_settings(source_folder, env.host)
    _update_virtualenv(source_folder)
    _update_static_files(source_folder)
    _update_database(source_folder)


def _create_directory_structure_if_necessary(site_folder):
    for subfolder in ('database', 'static', 'virtualenv', 'source'):
        run('mkdir -p %s/%s' % (site_folder, subfolder))

def _get_latest_source(source_folder):
    if exists(source_folder + '/.git'):
        run('cd %s && git fetch' % (source_folder,))
    else:
        run('git clone %s %s' % (REPO_URL, source_folder))
    current_commit = local("git log -n 1 --format=%H", capture=True)
    run('cd %s && git reset --hard %s' % (source_folder, current_commit))

def _update_settings(source_folder, site_name):
    settings_path = source_folder + '/superlists/settings.py'
    sed(settings_path, "DEBUG = True", "DEBUG = False")
    sed(settings_path,
        'ALLOWED_HOSTS =.+$',
        'ALLOWED_HOSTS = ["%s"]' % (site_name,)
    )
    secret_key_file = source_folder + '/superlists/secret_key.py'
    if not exists(secret_key_file):
        chars = 'abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*(-_=+)'
        key = ''.join(random.SystemRandom().choice(chars) for _ in range(50))
        append(secret_key_file, "SECRET_KEY = '%s'" % (key,))
    append(settings_path, '\nfrom .secret_key import SECRET_KEY')

def _update_virtualenv(source_folder):
    virtualenv_folder = source_folder + '/../virtualenv'
    if not exists(virtualenv_folder + '/bin/pip'):
        run('virtualenv --python=python3 %s' % (virtualenv_folder,))
    run('%s/bin/pip install -r %s/requirements.txt' % (
            virtualenv_folder, source_folder
    ))


def _update_static_files(source_folder):
    run('cd %s && ../virtualenv/bin/python3 manage.py collectstatic --noinput' % (
        source_folder,
    ))


def _update_database(source_folder):
    run('cd %s && ../virtualenv/bin/python3 manage.py migrate --noinput' % (
        source_folder,
    ))

```



tip : fabric은 python2로 만들어졌다, 운영애 베포할 개발pc에 설치해야함.

sudo apt-get install fabric
cat /home/user/.ssh/id_rsa.pub >> /root/.ssh/authorized_keys

(example file)fabfile.py
```python
from fabric.api import run

def host_type():
    run('uname -s')
```
(exampe run command)
fab -H localhost,linuxbox host_type



(fab run command)
fab deploy:host=elspeth@172.17.0.1



[openshift]
http://rhcloud.com/
https://www.openshift.com/
http://python-boojongmin.rhcloud.com/
ssh://55f90e4789f5cfb7a00000b0@python-boojongmin.rhcloud.com/~/git/python.git/


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

** 참조URL **
http://bootstrapk.com/

** 더 찾아봐야할 내용들 ** 
- LESS를 이용한 부트스트랩 커스터마이징
- DRY와 손위운 URL 코딩을 위한 {% static %} 템플릿 태그 : https://docs.djangoproject.com/en/1.8/howto/static-files/
- bower 같은 클라이언트 측 패키징 툴

** 디자인 및 레이아웃 테스트 **
디자인과 레이아웃용 테스트는 작성할 필요가 없다. 이는 상수를 테스트하는것과 마찬가지다. 스모트테스트를 이용해서 CSS와 정적 파일이 동작하는지만 확인하는 것이 좋다.

command 
django-admin.py startproject superlists <- superlist project 생성
python3 manage.py startapp lists
python3 funcional_test.py   <- 기능테스트용
pythone3 manage.py runserver
python3 manage.py test      <- 단위테스트용(lists/test.py 실행)
python3 manage.py makemigrations <- migration for testunit's database
python3 manage.py migrate
python3 manage.py collectstatic <- settings.py의 STATIC_ROOT 작업후 실행.

(db 초기화)
rm db.sqlite3
python3 manage.py migrate --noinput

 ========
** grep tip ** 
grep -E "class|def" lists/tests.py






git command
git log --oneline