package LeetCode;

public class ProductOfArrayExceptSelf {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            // O(N) time and O(N) space solution
//         int[] leftProduct = new int[nums.length];
//         int[] rightProduct = new int[nums.length];
//         leftProduct[0] = 1;
//         rightProduct[nums.length - 1] = 1;

//         for (int i = 1; i < nums.length; i++) {
//             leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
//             rightProduct[nums.length - i - 1] = rightProduct[nums.length - i] * nums[nums.length - i];
//         }
//         for (int i = 0; i < nums.length; i++) {
//             nums[i] = leftProduct[i] * rightProduct[i];
//         }
//         return nums;

            // O(N) time and O(1) space solution
            int[] product = new int[nums.length]; // returning this array, so not counted in space complexity
            product[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                product[i] = product[i - 1] * nums[i - 1];
            }
            int runningProduct = 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                runningProduct = runningProduct * nums[i + 1];
                product[i] = product[i] * runningProduct;
            }
            return product;
        }


    }

//     1  2  3  4
// l   1  1  2  6
// r   24 12 4  1

//     -1  1   0  -3  3
// l    1 -1  -1   0  0
// r    0  0  -9   3  1
}
