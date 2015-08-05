/*
 * DocWriter.h
 *
 *  Created on: 2015. 8. 4.
 *      Author: boojongmin
 */

#ifndef DOCWRITER_H_
#define DOCWRITER_H_

#include <string>
using namespace std;

class Writer
{
public:
	Writer();
	Writer(const string& fileName, const string& content);
	//virtual void Write() =0;
	virtual void Write() ;
protected:
	string _fileName;
	string _content;
};

class DocWriter : public Writer
{
public:
	DocWriter();
	DocWriter(const string& fileName, const string& content);
	virtual ~DocWriter();

	void SetFileName(const string& fileName);
	void SetContent(const string& content);
	virtual void Write();

};

class HTMLWriter  : public Writer {
public:
	HTMLWriter();
	HTMLWriter(const string& fileName, const string& content);
	~HTMLWriter();

	virtual void Write();
	void SetFont(const string& fontName, int fontSize, const string& fontColor);

protected:
	string _fontName;
	int _fontSize;
	string _fontColor;
};

#endif /* CHAPTER22_EX2_DOCWRITER_H_ */
