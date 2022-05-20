#include<iostream>
#include<vector>
using namespace std;

// here the matrix is sorted in row major order : sorted rowwise and first element in every row is greater than the last element in prev row
bool searchValue(std::vector<std::vector<int>>& matrix, int key){
  int low = 0;
  int high = matrix.size() * matrix[0].size() -1;
  while(low <= high){
    int mid = low + (high-low)/2;
    int row = mid/matrix[0].size(); // to get the row num of the mid element
    int col = mid%matrix[0].size(); // to get the col num of the mid element
    if(matrix[row][col] == key){
      return true;
    }
    else if(key > matrix[row][col]){
      low = mid +1;
    }
    else{
      high = mid -1;
    }
  }
  return false;
}
int main(int argc, char const *argv[]) {
  std::vector<std::vector<int>> v = { { 1, 3, 5, 7 },
                     { 10, 11, 16, 20 },
                     { 23, 30, 34, 50 }
                   };
  int key = 50;
  bool res = searchValue(v,key);
  cout<<res<<endl;
  return 0;
}
