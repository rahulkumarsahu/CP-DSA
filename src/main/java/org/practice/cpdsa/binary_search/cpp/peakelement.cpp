#include<iostream>
#include<vector>
using namespace std;

int peakElement(std::vector<int> v){
  int low = 0;
  int high = v.size()-1;
  while(low < high){
    int mid = low + (high - low)/2;
    if(v[mid] < v[mid+1]){
      low = mid +1;
    }
    else{
      high = mid ;
    }
  }
  return low;
}
int main(int argc, char const *argv[]) {
  std::vector<int> v = {1,4,3,2,0};
  int res = peakElement(v);
  std::cout << res << '\n';
  return 0;
}
