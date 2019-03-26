// Backpack I
// Array of items with size. e.g. [1, 3, 2, 4]
// Integer of size of backpack. e.g. 8
// How full can you fill the backpack
public int BackPack(int m, int[] A) {
    // write your code here
    var dp = new int[m + 1];
    for (int i = 0; i < A.Length; i++) {
        // For limited item, narrow j down
        for (int j = m; j >= A[i]; j--) {
            dp[j] = Math.Max(dp[j], dp[j - A[i]] + A[i]);
        } 
    }
    return dp[m];
}


// Backpack II
// Array of items. e.g. [1, 3, 2, 4]
// Array of item values. e.g. [1, 5, 2, 4]
// Integer of size of backpack. e.g. 8
// How full can you fill the backpack
public int BackPack(int m, int[] A, int[] V) {
    // write your code here
    var dp = new int[m + 1];
    for (int i = 0; i < A.Length; i++) {
        // For limited item, narrow j down
        for (int j = m; j >= A[i]; j--) {
            dp[j] = Math.Max(dp[j], dp[j - A[i]] + V[i]);
        } 
    }
    return dp[m];
}


// Backpack III
// Similar as II, but now each item has infinite number in stock
public int BackPack(int m, int[] A, int[] V) {
    // write your code here
    var dp = new int[m + 1];
    for (int i = 0; i < A.Length; i++) {
        // For unlimited item, increment j
        for (int j = A[i]; j <= m; j++) {
            dp[j] = Math.Max(dp[j], dp[j - A[i]] + V[i]);
        } 
    }
    return dp[m];
}


// Backpack IV
// Item array with item size and target size
// Output the number of possible combinations
// Every item is Unlimited
public int BackPack(int[] nums, int target) {
    // write your code here
    var dp = new int[target + 1];
    for (int i = 0; i < nums.Length; i++) {
        // For unlimited item, increment j
        for (int j = nums[i]; j <= target; j++) {
            dp[j] += dp[j - nums[i]];
        } 
    }
    return dp[target];
}


// Backpack V
// Item array with item size and target size
// Output the number of possible combinations
// Every item is limited
public int BackPack(int[] nums, int target) {
    // write your code here
    var dp = new int[target + 1];
    for (int i = 0; i < nums.Length; i++) {
        // For limited item, narrow j down
        for (int j = target; j >= nums[i]; j--) {
            dp[j] += dp[j - nums[i]];
        } 
    }
    return dp[target];
}





