package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalArr = new ArrayList<>();
        permuteHelper(finalArr, convertArrToList(nums), new ArrayList<Integer>(), nums.length);
        return finalArr;
    }

    public void permuteHelper(List<List<Integer>> finalArr, List<Integer> arr, List<Integer> ansArr, int n) {
        if (ansArr.size() == n) {
            finalArr.add(cloneList(ansArr));
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            int val = arr.remove(i);
            ansArr.add(val);
            permuteHelper(finalArr, arr, ansArr, n);
            arr.add(i, val);
            ansArr.remove(ansArr.size() - 1);
        }
    }

    public List<Integer> convertArrToList(int[] nums) {
        List<Integer> lst = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            lst.add(nums[i]);
        }
        return lst;
    }

    public List<Integer> cloneList(List<Integer> lst) {
        List<Integer> newLst = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            newLst.add(lst.get(i));
        }
        return newLst;
    }
}
