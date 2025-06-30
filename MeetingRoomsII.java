// Time Complexity:

// Sorting intervals: O(N log N), and each of the N heap operations takes O(log N), so total O(N log N).

// Space Complexity:
// The min-heap (pq) stores at most N end times in the worst case, giving O(N) auxiliary space.
// Approach:
// Sort the intervals by start time, use a min-heap to track the earliest ending meeting room, 
//   and for each meeting, poll the room if it is free; otherwise, 
//   allocate a new room, ensuring the heap size at the end reflects the minimum rooms required.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Sample test case
        int[][] intervals = {{0,30},{5,10},{15,20}};
        int result = sol.minMeetingRooms(intervals);
        System.out.println("Minimum meeting rooms required: " + result);
        int[][] intervals1 = {{0, 10}, {1, 11}, {2, 12}, {3, 13}};
        System.out.println(sol.minMeetingRooms(intervals1)); // Expected: 4
        int[][] intervals2 = {{0, 5}, {5, 10}, {10, 15}, {15, 20}};
        System.out.println(sol.minMeetingRooms(intervals2)); // Expected: 1
        int[][] intervals3 = {{0, 30}, {5, 10}, {15, 20}, {17, 25}, {22, 28}, {29, 35}};
        System.out.println(sol.minMeetingRooms(intervals3)); // Expected: 3

    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // TODO: Implement your logic here
        int n = intervals.length;
        if(intervals == null || n == 0) return 0;
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;++i){
            if(!pq.isEmpty() && pq.peek() <= intervals[i][0])
                pq.poll();
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}

