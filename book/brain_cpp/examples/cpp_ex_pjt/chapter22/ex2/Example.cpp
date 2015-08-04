/*
 * Example.cpp
 *
 *  Created on: 2015. 8. 4.
 *      Author: boojongmin
 */

#include "DocWriter.h"
#include "HTMLWriter.h"
#include <iostream>

int main()
{
	DocWriter dw;
	dw.SetFileName("test.txt");
	dw.SetContent("yeah~");
	dw.Write();

	HTMLWriter hw("html_text.html", "hello HTML!");
	hw.Write();

	dw = hw;
	dw.Write();

	DocWriter* pDW = &hw;
	pDW->Write();

	((HTMLWriter*)pDW)->Write();

	HTMLWriter hw2("html_text.html", "hello HTML!223");
//	DocWriter rDW = hw2;
	DocWriter& rDW = hw2;
//	cout << hw2 << "\n";
	cout << &hw2 << "\n";
//	cout << rDW << "\n";
	cout << &rDW << "\n";

	rDW.Write();

	return 0;
}



