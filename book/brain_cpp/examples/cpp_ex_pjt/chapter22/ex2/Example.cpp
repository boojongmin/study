/*
 * Example.cpp
 *
 *  Created on: 2015. 8. 4.
 *      Author: boojongmin
 */

#include "ExampleWriter.h"
#include <iostream>

void tt1(int a) {
	a++;
}
void tt2(int& a) {
	a++;
}
void tt3(int* a) {
	(*a)++;
}
int main0000000000000000000000000()
{
	DocWriter dw;
	dw.SetFileName("test.txt");
	dw.SetContent("yeah~");
	dw.Write();

	HTMLWriter hw("test.html", "hello HTML!");
	hw.Write();

	Writer& w1 = dw;
	w1.Write();

	//동작안함. dw를 가리킴
	w1 = hw;
	w1.Write();

	Writer& w2 = hw;
	w2.Write();

	Writer* pw = new HTMLWriter("test2.html", "test2 HTML!");
	pw->Write();
	delete pw;

	//DocWriter* pDW = &hw;
	//pDW->Write();

	//((HTMLWriter*)pDW)->Write();

//	HTMLWriter hw2("html_text.html", "hello HTML!223");
////	DocWriter rDW = hw2;
//	DocWriter& rDW = hw2;
////	cout << hw2 << "\n";
//	cout << &hw2 << "\n";
////	cout << rDW << "\n";
//	cout << &rDW << "\n";
//
//	rDW.Write();
	int a = 1;
	tt1(a);
	tt2(a);
	tt3(&a);

	return 0;
}


class Point 
{
public:
	Point();
	void Print();
private:
	int x, y;
};
Point::Point()
{
	x = 0;
	y = 0;
}
void Point::Print()
{
	cout << "x, y";
}

ostream& operator<<(ostream& o, const Point& a)
{
	o << "hh" << "\n";
	return o;
}

int main()
{
	Point a;
	cout << a << "\n";
	return 0;
}