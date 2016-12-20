public class Solution {
    public boolean firstWillWin(int n) {
        boolean[] f = new boolean[n + 1];
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            f[n] = true;
        } else if (n == 2) {
            f[n] = true;
        } else if (n == 3) {
            f[n] = false;
        } else if (n == 4) {
            f[n] = true;
        } else {
            f[1] = true;
            f[2] = true;
            f[3] = false;
            f[4] = true;
        }
        for (int i = 5; i <= n; i++) {
            f[i] = (f[i - 2] && f[i - 3]) || (f[i - 3] && f[i - 4]);
        }
        return f[n];
    }
}
