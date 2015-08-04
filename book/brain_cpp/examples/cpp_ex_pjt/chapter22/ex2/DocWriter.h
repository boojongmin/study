/*
 * DocWriter.h
 *
 *  Created on: 2015. 8. 4.
 *      Author: boojongmin
 */

#ifndef CHAPTER22_EX2_DOCWRITER_H_
#define CHAPTER22_EX2_DOCWRITER_H_

#include <string>
using namespace std;

class DocWriter {
public:
	DocWriter();
	DocWriter(const string& fileName, const string& content);
	virtual ~DocWriter();

	void SetFileName(const string& fileName);
	void SetContent(const string& content);
	void Write();

protected:
	string _fileName;
	string _content;
};

#endif /* CHAPTER22_EX2_DOCWRITER_H_ */
