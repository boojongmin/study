/*
 * Point.h
 *
 *  Created on: 2015. 7. 31.
 *      Author: boojongmin
 */

#ifndef CHAPTER21_EX_POINT_H_
#define CHAPTER21_EX_POINT_H_

#include <iostream>
using namespace std;

class Point {
public:
	typedef int COOR_T;
	void Print();

	Point();
	Point(COOR_T x, COOR_T y);

	void SetX(COOR_T x) {
		this->x = x;
	}
	COOR_T GetX() {
		return x;
	}

	void WhoAmI(){
		cout << "I am " << this << "\n";
	}

private:
	COOR_T x, y;
};

#endif /* CHAPTER21_EX_POINT_H_ */
