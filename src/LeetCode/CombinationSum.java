package LeetCode;

public class CombinationSum {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> finalLst = new ArrayList<>();
            recurseHelper(candidates, target, 0, new ArrayList<>(), finalLst);
            return finalLst;
        }

        public void recurseHelper(int[] candidates, int target, int start, List<Integer> lst, List<List<Integer>> finalLst) {
            if (target < 0) return;
            if (target == 0) {
                finalLst.add(new ArrayList<>(lst));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                lst.add(candidates[i]);
                // first loop is what u can form with all numbers
                // second loop is what u can form with all numbers minus first number
                // so and so forth
                recurseHelper(candidates, target - candidates[i], i, lst, finalLst);
                lst.remove(lst.size() - 1);
            }
        }
    }
}
