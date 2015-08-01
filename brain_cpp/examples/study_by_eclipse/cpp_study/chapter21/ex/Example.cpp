/*
 * Example.cpp
 *
 *  Created on: 2015. 7. 31.
 *      Author: boojongmin
 */
#include "Point.h"

typedef void (Point::*FP1)(int);

int main()
{
	Point pt(5, 200);

	pt.Print();
	FP1 fp1 = &Point::SetX;
	cout << &Point::SetX << "\t" << &fp1 << "\n";
//	cout << &Point::SetX << "\t" << *(&fp1) << "\n";
	FP1 fp2 = &Point::SetX;
	cout << &Point::SetX << "\t" << &fp2 << "\n";
	(pt.*fp1)(100);

	pt.Print();

	Point* p = NULL;
	p = new Point(500, 200);


	p->Print();
	(*p).Print();
	delete p;
	p = NULL;

	Point* p1 = new Point(3,3);
	p1->Print();

//	delete p1;
//	p1 = NULL;

	//throw exception but console not happened...
//	p1->Print();
//	cout << "hello";

	cout << &pt << "\n";
	cout << p1 << "\n";
	pt.WhoAmI();
	p1->WhoAmI();



	return 0;
}


