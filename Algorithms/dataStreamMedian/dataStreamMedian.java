public class Solution {
    private Queue<Integer> maxHeap, minHeap;
    private int elements;
    
    private void addNumber(int num) {
        maxHeap.add(num);
        
        if (elements % 2 == 0) {
            if (minHeap.isEmpty()) {
                elements++;
                return;
            } else if (minHeap.peek() < maxHeap.peek()) {
                int biggerNumber = maxHeap.poll();
                int smallerNumber = minHeap.poll();
                maxHeap.add(smallerNumber);
                minHeap.add(biggerNumber);
            }
        } else {
            minHeap.add(maxHeap.poll());
        }
        
        elements++;
    }
    
    private int getMedian() {
        return maxHeap.peek();
    }
    
    public int[] medianII(int[] nums) {
        maxHeap = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer c1, Integer c2) {
                return c2 - c1;
            }
        });
        minHeap = new PriorityQueue<Integer>();
        int[] result = new int[nums.length];
        
        for (int i = 0; i < nums.length; ++i) {
            addNumber(nums[i]);
            result[i] = getMedian();
        }
        
        return result;
    }
}
