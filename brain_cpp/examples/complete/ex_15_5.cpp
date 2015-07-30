#include <iostream> 
#include <string.h>
using namespace std;

char* ReversString(char* src, int len);

int main(){
  char original[] = "BOOJONGMIN";
  cout << original << "\n";
  char* copy = original;
  cout << copy << "\n";
  cout << strlen(original) << "\n";
  copy = ReversString(original, strlen(original));
  cout << copy << "\n";
  delete[] copy;
  copy = NULL;
  return 0;
}

char* ReversString(char* src, int len){
  char* reverseString = new char[len + 1];
  for(int i=0; i< len; i++){
    reverseString[i] = src[len -i -1];
  }
  reverseString[len] = NULL;
  return reverseString;
}

