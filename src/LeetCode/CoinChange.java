package LeetCode;

public class CoinChange {
    // Time Complexity: O(len(coins) * amount)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;

            for (int a = 1; a < amount + 1; a++) {
                for (int coin: coins) {
                    if (a - coin >= 0) {
                        dp[a] = Math.min(dp[a - coin] + 1, dp[a]);
                    }
                }
            }
            if (dp[amount] != amount + 1) {
                return dp[amount];
            }
            return -1;
        }

    }
}
