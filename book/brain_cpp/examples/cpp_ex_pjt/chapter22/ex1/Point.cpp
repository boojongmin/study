/*
 * Point.cpp
 *
 *  Created on: 2015. 8. 4.
 *      Author: boojongmin
 */


#include "Point.h"

#include <iostream>
using namespace std;

void Point::Offset(COOR_T x_delta, COOR_T y_delta)
{
	SetX(x + x_delta);
	SetY(y + y_delta);
}

void Point::Offset(const Point& pt)
{
	Offset(pt.x, pt.y);
}

Point::Point(const Point& pt)
{
	x = pt.x;
	y = pt.y;
}

Point::Point(COOR_T initialX, COOR_T initialY)
{
	SetX(initialX);
	SetY(initialY);
}

Point::Point()
{
	cout << "create Point object\n";
	x = 0;
	y = 0;
}

void Point::Print() const
{
	cout << "(" << x << ", " << y << "\n";
}




