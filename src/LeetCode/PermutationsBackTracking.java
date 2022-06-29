package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PermutationsBackTracking {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalLst = new ArrayList<>();
        permuteHelper(finalLst, nums, 0, nums.length);
        return finalLst;
    }

    public void permuteHelper(List<List<Integer>> finalLst, int[] nums, int l, int n) {
        if (l == n) {
            finalLst.add(convertArrToList(nums));
            return;
        }
        for (int i = l; i < n; i++) {
            swap(nums, l, i);
            permuteHelper(finalLst, nums, l + 1, n);
            swap(nums, l, i);
        }
    }

    public void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public List<Integer> convertArrToList(int[] nums) {
        List<Integer> lst = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            lst.add(nums[i]);
        }
        return lst;
    }
}
