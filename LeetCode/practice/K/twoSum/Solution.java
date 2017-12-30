/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.\
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/
package LeetCode.practice.K.twoSum
import java.util.*;
public class Solution {
    int[] cp;
    int[] re;
    int f;
    int s;
    public int[] twoSum(int[] nums, int target){
        cp=nums.clone();
        Arrays.sort(cp);
        re=this.myBinarySearch(cp,target);
        f=this.indexOf(nums,re[1],true);
        s=this.indexOf(nums,re[0],false);
        return new int[]{Math.min(f,s),Math.max(f,s)};
    }

    //find the numbers in the sorted array
    private int[] myBinarySearch(int[] a,int t){
        int first=0;
        int last=a.length-1;
        int pointer=last;

        do {
            if (a[first]+a[pointer]==t)
                return new int[]{a[first],a[pointer]};
            else if (a[pointer]+a[first]<t)
                first++;
            else
                pointer = (pointer + first) / 2;
            while (first < pointer - 1&& last > pointer + 1) {
                if (a[first] + a[pointer] == t)
                    return new int[]{a[first], a[pointer]};
                else if (a[pointer] + a[first] < t)
                    pointer = (pointer + last) / 2;
                else {
                    last = pointer;
                    pointer = (pointer + first) / 2;
                }
            }
            if (a[first] + a[pointer] == t)
                return new int[]{a[first], a[pointer]};
            pointer=last;
            first++;
        }while (first<last);
        return null;
    }

    //get index
    private int indexOf(int a[],int num,boolean asc){
        if (asc)
            for (int index=0;index<a.length;index++){
                if (a[index]==num)
                {
                    return index;}
            }
        else
            for (int index=a.length-1;index>=0;index--){
                if (a[index]==num)
                    return index;
            }
        return 0;
    }
}