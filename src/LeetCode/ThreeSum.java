package LeetCode;

public class ThreeSum {
    // 15. 3Sum
    // https://leetcode.com/problems/3sum/
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> lst = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                int val = nums[i];
                if (i > 0 && nums[i - 1] == val) {
                    continue;
                }

                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + val;
                    if (sum > 0) {
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        List<Integer> currLst = new ArrayList<>();
                        currLst.add(val);
                        currLst.add(nums[left]);
                        currLst.add(nums[right]);
                        lst.add(currLst);
                        left++;
                        while (nums[left] == nums[left - 1] && left < right) {
                            left++;
                        }
                    }
                }
            }
            return lst;
        }
    }
}
