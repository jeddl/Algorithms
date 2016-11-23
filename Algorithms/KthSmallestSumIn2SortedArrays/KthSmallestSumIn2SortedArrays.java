public class Solution {
    public int kthSmallestSum(int[] A, int[] B, int k) {
        Queue<Pair> minSumHeap = new PriorityQueue<Pair>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.sum - p2.sum;
            }
        });
        HashSet<Pair> visited = new HashSet<Pair>();
        int[] dx = new int[]{1, 0};
        int[] dy = new int[]{0, 1};
        minSumHeap.add(new Pair(0, 0, A[0] + B[0]));
        boolean[][] hash = new boolean[A.length][B.length];
        
        for (int i = 0; i < k - 1; ++i) {
            Pair currPair = minSumHeap.poll();
            for (int j = 0; j < 2; ++j) {
                int nextIndexA = currPair.indexA + dx[j];
                int nextIndexB = currPair.indexB + dy[j];
                Pair nextPair = new Pair(nextIndexA, nextIndexB, 0);
                
                if (nextIndexA < A.length && nextIndexB < B.length && !visited.contains(nextPair) && !hash[nextIndexA][nextIndexB]) {
                    hash[nextIndexA][nextIndexB] = true;
                    nextPair.sum = A[nextIndexA] + B[nextIndexB];
                    visited.add(nextPair);
                    minSumHeap.add(nextPair);
                }
            }
        }
        
        return minSumHeap.peek().sum;
    }
}

class Pair {
    int indexA;
    int indexB;
    int sum;
    
    public Pair(int _a, int _b, int _sum) {
        this.indexA = _a;
        this.indexB = _b;
        this.sum = _sum;
    }
}