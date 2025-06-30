// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

TC: N*logK
N - Total No of elements
K - Size of Heap

SC : K
K is the size of heap

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
