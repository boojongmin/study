#include <iostream>
#include <string>
using namespace std;

int main(){
  string cstr;

  getline(cin, cstr);
  cout << cstr << "\n";

//  string cstr2 =  cstr.append("i");
  cstr += 'a';
  string cstr2 =  cstr;

  cout << &cstr << "\n";
  cout << cstr << "\n";
  cout << &cstr2 << "\n";
  cout << cstr2 << "\n";

  return 0;
}
