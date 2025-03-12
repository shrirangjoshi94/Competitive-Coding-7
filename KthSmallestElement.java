// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

//Time Complexity: O(nlog(max-min))
// where n is the length of the matrix and max and min are maximum and minimum values in the matrix
// Space Complexity : O(1) - constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//The approach here is to use binary search to find mid element of the matrix and if the kth smallest element lies from low to mid, if it does, we move high to mid - 1, else, we move low to mid + 1
//To see if the kth smalles element lies in the low to mid range, we will calculate the count of number of elements less than or equal to k in the range.
//We terminate if low>high and low pointer points to the kth smallest element
//For finding the count, we start from bottom left index and we check if the element is less than or equal to the mid, if yes, we add to the count the column value and move right, if not, we move top and continue

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take low as the element at 0,0 and high as element at m-1, n-1. While low<high find mid and find the count of elements before
 * mid and if count is lessthan k then move low to mid + 1 and perform the same and when count will bw equal to k increase high to mid
 * and finally return low. To find the count take row as the last row and col as the 1st col and check if element at that place is
 * lessthan or equal to target which is mid, if yes take count of all the elements of that col i,e., row value+1 and increase col else
 * decrease row by 2.
 */

class KthSmallestElement {
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];

        while(left < right) {
            int mid = left + (right - left)/2;
            int count = getCount(matrix, mid);

            if(count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public int getCount(int[][] matrix, int mid) {
        int count  = 0;
        int n = matrix.length;
        int  i = n - 1;
        int j = 0;

        while(i >= 0 && j < n) {
            if(matrix[i][j] <= mid) {
                count += i + 1;

                j++;  // move right
            } else {
                i--;
            }
        }

        return count;
    }
}