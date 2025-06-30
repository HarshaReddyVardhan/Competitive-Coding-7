// Time Complexity:
// You traverse all n^2 elements (O(n^2)), and each heap operation (add, poll) takes O(log k).
// Hence, total TC = O(n^2 * log k).

// Space Complexity:
// The max-heap (pq) maintains at most k elements, so SC = O(k).

// Approach:
// You use a max-heap of size k to keep track of the k smallest elements while scanning the entire matrix, 
//   skipping insertion if the current value is larger than the heap's maximum, 
  // ensuring efficient retrieval of the kth smallest element in a fully sorted matrix.

  
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int n = matrix.length;
        for(int i=0 ; i<n;++i){
            for(int j=0;j<n;++j){
                if(pq.size() < k){
                    pq.add(matrix[i][j]);
                } else if(pq.peek() > matrix[i][j]){
                    pq.poll();
                    pq.add(matrix[i][j]);
                }
            }
        }
        return pq.peek();
    }
}
