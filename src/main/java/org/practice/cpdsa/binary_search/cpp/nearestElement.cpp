#include<iostream>
#include<vector>
using namespace std;


int nearestElement(std::vector<int> v, int key){
  int low = 0;
  int high = v.size() -1;
  int res = -1;
  while(low < high){
    int mid = low + (high - low)/2;
    if(v[mid] == key){
      return mid;
    }else if(v[mid+1] == key){
      return mid+1;
    }else if(v[mid-1] == key){
      return mid-1;
    }else if(v[mid] < key){
      low = mid+2;
    }else{
      high = mid-2;
    }
  }
  return res;
}
int main(int argc, char const *argv[]) {
  std::vector<int> v = {2,3,10,4,20};
  int key = 1045;
  int res = nearestElement(v,key);
  std::cout << res << '\n';
  return 0;
}
