// BookExamples.cpp : �⺻ ������Ʈ �����Դϴ�.

#include "stdafx.h"
#include "linkedlist.h"
#include "memoryexamples.h"
#include <iostream>


using namespace System;

int main(array<System::String ^> ^args)
{
    Console::WriteLine(L"Hello World");
	linkedlistRun();
	std::cout << "memory examples run\n";
	memoryexamplesrun();
	memoryexamplesrun2();
	std::cout << "auto_ptr run\n";
	auto_pointerrun();
    return 0;
}
