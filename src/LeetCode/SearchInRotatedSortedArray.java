package LeetCode;

public class SearchInRotatedSortedArray {
    class Solution {
        public int search(int[] nums, int target) {
            int startIndex = 0;
            int endIndex = nums.length -1;
            while (startIndex + 1 < endIndex) {
                int middleIndex = (startIndex + endIndex) / 2;
                int middleValue = nums[middleIndex];
                int startValue = nums[startIndex];
                int endValue = nums[endIndex];
                // System.out.println("begin: " + startIndex + ", " + middleIndex + ", " + endIndex);
                if (startValue < middleValue) {
                    // smooth gradient on the left
                    if (startValue <= target && target <= middleValue) {
                        endIndex = middleIndex;
                    } else {
                        startIndex = middleIndex;
                    }
                } else {
                    // smooth gradient on the right
                    if (middleValue <= target && target <= endValue) {
                        startIndex = middleIndex;
                    } else {
                        endIndex = middleIndex;
                    }
                }
            }
            if (nums[startIndex] == target) return startIndex;
            if (nums[endIndex] == target) return endIndex;
            return -1;
        }
    }
}
