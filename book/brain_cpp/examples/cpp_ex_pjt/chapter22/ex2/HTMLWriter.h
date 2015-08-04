/*
 * HTMLWriter.h
 *
 *  Created on: 2015. 8. 4.
 *      Author: boojongmin
 */

#ifndef CHAPTER22_EX2_HTMLWRITER_H_
#define CHAPTER22_EX2_HTMLWRITER_H_

#include "DocWriter.h"

class HTMLWriter: public DocWriter {
public:
	HTMLWriter();
	HTMLWriter(const string& fileName, const string& content);
	~HTMLWriter();

	void Write();
	void SetFont(const string& fontName, int fontSize, const string& fontColor);

protected:
	string _fontName;
	int _fontSize;
	string _fontColor;
};

#endif /* CHAPTER22_EX2_HTMLWRITER_H_ */
