class Solution {

    static final int MOD = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {

        long[][][][] dp = new long[zero + 1][one + 1][2][limit + 1];

        if (zero > 0) dp[1][0][0][1] = 1;
        if (one > 0) dp[0][1][1][1] = 1;

        for (int z = 0; z <= zero; z++) {
            for (int o = 0; o <= one; o++) {

                for (int last = 0; last <= 1; last++) {
                    for (int cnt = 1; cnt <= limit; cnt++) {

                        long val = dp[z][o][last][cnt];
                        if (val == 0) continue;

                        if (last == 0) {

                            // add zero again
                            if (z + 1 <= zero && cnt + 1 <= limit) {
                                dp[z+1][o][0][cnt+1] =
                                    (dp[z+1][o][0][cnt+1] + val) % MOD;
                            }

                            // switch to one
                            if (o + 1 <= one) {
                                dp[z][o+1][1][1] =
                                    (dp[z][o+1][1][1] + val) % MOD;
                            }

                        } else {

                            // add one again
                            if (o + 1 <= one && cnt + 1 <= limit) {
                                dp[z][o+1][1][cnt+1] =
                                    (dp[z][o+1][1][cnt+1] + val) % MOD;
                            }

                            // switch to zero
                            if (z + 1 <= zero) {
                                dp[z+1][o][0][1] =
                                    (dp[z+1][o][0][1] + val) % MOD;
                            }
                        }
                    }
                }
            }
        }

        long ans = 0;

        for (int cnt = 1; cnt <= limit; cnt++) {
            ans = (ans + dp[zero][one][0][cnt]) % MOD;
            ans = (ans + dp[zero][one][1][cnt]) % MOD;
        }

        return (int) ans;
    }
}