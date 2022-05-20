#include<iostream>
#include<vector>
using namespace std;

int binarySearch(vector<int> v,int key){
  int low = 0;
  int high = v.size() - 1;
  int res = -1;
  while(low <= high){
    int mid = low + (high - low)/2;
    if(v[mid] == key){
      return mid;
    }
    if(v[mid] < key){
      low = mid +1;
    }
    else{
      high = mid -1;
    }
  }
  return res;
}
int main(){
  std::cout << "hello from vivek" << '\n';
  vector<int> v = {1,2,3,4,5};
  int key = 9;
  int res = binarySearch(v,key);
  std::cout << res << '\n';
  return 0;
}
