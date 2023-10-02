//This program will rotate the array by k steps


#include<bits/stdc++.h>
using namespace std;

    void rotate(vector<int>& nums, int k) {
        vector<int> temp(nums.size());
        for( int i=0 ; i<nums.size(); i++ ){
            temp[ (i+k)%nums.size()]=nums[i];
            
        }
       nums=temp;
       
    }



int main(){
    vector<int> vc={1,2,3,4,5};
    int k=3;

    rotate(vc,k);

    for(auto it:vc){
        cout<<it<<" ";
    }

    return 0;
}