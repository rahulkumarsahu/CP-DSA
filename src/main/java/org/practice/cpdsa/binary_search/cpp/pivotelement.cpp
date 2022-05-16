#include<iostream>
#include<vector>
using namespace std;


int pivotElement(std::vector<int> v){
  if(v[0] < v[v.size()-1]){
    return 0;
  }
  if(v[0] > v[v.size()-1]){
    return v.size();
  }
  int low = 0;
  int high = v.size() -1;
  while(low < high){
    int mid = low + (high - low)/2;
    if(v[mid] > v[0]){
      low = mid +1;
    }else{
      high = mid;
    }
  }
  return low;
}
int main(int argc, char const *argv[]) {
  std::vector<int> v = {1,2,3,4,5};
  int res = pivotElement(v);
  std::cout << res << '\n';
  return 0;
}
