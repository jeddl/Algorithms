public class Solution {
    private void pushIn(Deque<Integer> deque, int num) {
        // Make sure that the numbers in the window are in descending order
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        
        deque.offer(num);
    }
    
    private void pollOut(Deque<Integer> deque, int num) {
        // The largest is always the first
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }

    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        
        if (k <= 0 || nums.length == 0 || nums == null) {
            return ans;
        }
        
        for (int i = 0; i < k - 1; ++i) {
            pushIn(deque, nums[i]);
        }
        
        for (int i = k - 1; i < nums.length; ++i) {
            pushIn(deque, nums[i]);
            ans.add(deque.peekFirst());
            pollOut(deque, nums[i - k + 1]);
        }
        
        return ans;
    }
}
