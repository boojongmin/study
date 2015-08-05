#include "ExampleWriter.h"
#include <iostream>
#include <string>
using namespace std;


Writer::Writer() 
{
	_fileName = "nonamed.txt";
	_content = "content is nothing.";
}
Writer::Writer(const string& fileName, const string& content)
{
	_fileName = fileName;
	_content = content;
}
Writer::~Writer()
{
	cout << "writer deleted.";
}
