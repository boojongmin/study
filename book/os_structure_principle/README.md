OS 구조와 원리 - OS 개발 30일 프로젝트

nasm을 공부하려는데 예제는 nask assembly 를 사용해서 좀더 어셈블을 공부해서 익숙해진후 다시 시작하려한다.

***

참고링크
[NASM설명](http://gurugio.kldp.net/wiki/wiki.php/asm_basic)
[qemu를활용한가상화기초](http://www.joinc.co.kr/modules/moniwiki/wiki.php/Site/cloud/Qemu/Basic)

##1장
PC구조부터 어셈블리 입문까지

[예제 소스](http://www.hanbit.co.kr/exam/1482/)


#####hex 입력으로 hello world 찍기.
hex editor: [링크](http://mh-nexus.de/en/hxd/)
qemu : [링크](http://wiki.qemu.org/Main_Page)
qemu path : C:\Program Files\qemu
qemu 실행 : qemu-system-x86-64 helloos.img

#####어셈블러 
nasm : [링크](http://www.nasm.us/)
nasm path : C:\Users\boojongmin\AppData\Local\nasm
[nasm manual]( http://www.nasm.us/xdoc/2.11.08/html/nasmdoc2.html#section-2.1)
nasm compile : nasm -f bin helloos.nas -o helloos.img
[bin 외 옵션 elf, coff 설명](http://processors.wiki.ti.com/index.php/A_Brief_History_of_TI_Object_File_Formats) -> binaray로출력하기위해 bin옵션을 사용

[projects\01_day\helloos2\helloos.nas 예제 컴파일중 에러발생]
nasm -f bin helloos.nas -o helloos.img
helloos.nas:41: error: invalid operand type

오류 수정
````nasm
(before)
RESB	0x1fe-$				; 0 x001fe까지를 0x00로 채우는 명령
(after)
RESB	0x1fe				; 0 x001fe까지를 0x00로 채우는 명령
````
-> 제대로 동작을 하지 않는다. 좀더 봐야하는데... 오늘은 이만 정리.