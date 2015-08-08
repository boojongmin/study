#define CRTDBG_MAP_ALLOC
#include <stdlib.h>
#include <crtdbg.h>
#include <memory>
#include <iostream>

void memleak() {
	int* array = NULL;
	array = (int*)malloc(sizeof(int) * 10);
}

void memoryexamplesrun() {
	memleak();
	_CrtDumpMemoryLeaks(); //memory leak�� �߻� ���� ���Ŀ� ��밡��
	/*
Detected memory leaks!
Dumping objects ->
{316} normal block at 0x00A939A0, 40 bytes long.
 Data: <                > CD CD CD CD CD CD CD CD CD CD CD CD CD CD CD CD 
Object dump complete.
	
	*/
}

void memoryexamplesrun2() {
	_CrtSetDbgFlag(_CRTDBG_ALLOC_MEM_DF | _CRTDBG_LEAK_CHECK_DF);
	_CrtSetBreakAlloc(317);    //break����Ʈ ����
	memleak();
/*
Detected memory leaks!
Dumping objects ->
{317} normal block at 0x00A44EF0, 40 bytes long.
Data: <                > CD CD CD CD CD CD CD CD CD CD CD CD CD CD CD CD
{316} normal block at 0x00A44448, 40 bytes long.
Data: <                > CD CD CD CD CD CD CD CD CD CD CD CD CD CD CD CD
Object dump complete.
*/
}

class MyClass {
public:
	MyClass() {
		std::cout << "MyClass object created\n";
	}
	~MyClass() {
		std::cout <<  "destructor is called\n";
	}
	void morning() {
		std::cout << "good morning\n";
	}
	void evening() {
		std::cout << "good evening\n";
	}
};

void auto_pointerrun() {
	std::auto_ptr<MyClass> p(new MyClass);
	p->morning();
	(*p).evening();
	MyClass* tmp = p.release();
	delete tmp;

	std::cout << "unique_ptr\n";
	std::unique_ptr<MyClass> p2(new MyClass());
	p2->morning();

}