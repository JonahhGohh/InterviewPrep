package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsNoDuplicates {
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
        HashSet<Integer> set = new HashSet<>();
        for (int i = l; i < n; i++) {
            boolean contains = set.contains(nums[i]);
            if (!contains) {
                swap(nums, l, i);
                permuteHelper(finalLst, nums, l + 1, n);
                swap(nums, l, i);
                set.add(nums[i]);
            }
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
