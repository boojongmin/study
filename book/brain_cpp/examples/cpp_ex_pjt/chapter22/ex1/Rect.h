/*
 * Rect.h
 *
 *  Created on: 2015. 8. 4.
 *      Author: boojongmin
 */

#ifndef CHAPTER22_RECT_H_
#define CHAPTER22_RECT_H_

#include "Point.h"

class Rect
{
public:
	Rect();
	Rect(const Point& topLeft, const Point& bottomRight);
	Rect(int left, int top, int right, int bottom);
	~Rect();

	void SetTopLeft(const Point& topLeft);
	void SetBottomRight(const Point& bottomRight);
	void SetRect(int left, int top, int right, int bottom);
	Point GetTopLeft() const;
	Point GetBottomRight() const;
	void GetRect(int& left, int& top, int& right, int& bottom);

	int GetWidth() const;
	int GetHeight() const;

	void Print() const;

protected:
	Point _topLeft;
	Point _bottomRight;
};

#endif /* CHAPTER22_RECT_H_ */
