/*
 * HTMLWriter.cpp
 *
 *  Created on: 2015. 8. 4.
 *      Author: boojongmin
 */

#include "ExampleWriter.h"
#include <iostream>
#include <fstream>
#include "..\..\..\..\examples_vs\examples\examples\ExampleWriter.h"
using namespace std;

HTMLWriter::HTMLWriter() {
	_fileName = "NoName.html";

	_fontName = "굴림";
	_fontSize = 3;
	_fontColor = "black";
}

HTMLWriter::~HTMLWriter() {
	cout << "html object destoryed\n";
}

void HTMLWriter::Write()
{
	ofstream of(_fileName.c_str());

	of << "<html><head></head><body>";
	of << "<h1>Content</h1>";

	of << "<font name='" << _fontName << "' size ='" << _fontSize << "' color='" << _fontColor << "'>";
	of << _content ;
	of << "</font></body></html>";
}

void HTMLWriter::SetFont(const string& fontName, int fontSize, const string& fontColor)
{
	_fontName = fontName;
	_fontSize = fontSize;
	_fontColor = fontColor;
}

HTMLWriter::HTMLWriter(const string& fileName, const string& content)
{
	_fileName = fileName;
	_content = content;
	_fontName = "굴림";
	_fontSize = 3;
	_fontColor = "black";
}