/*
 * Point.cpp
 *
 *  Created on: 2015. 7. 31.
 *      Author: boojongmin
 */
#include "Point.h"
#include <iostream>
using namespace std;

Point::Point(COOR_T x, COOR_T y)
{
	this->x = x;
	this->y = y;
}

Point::Point()
{
	x, y =0;
}

void Point::Print()
{
	cout << "{ x: " << x << ", y: " << y  << "}\n";
}
