/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // base case
        if (intervals == null || intervals.size() <= 1) return intervals.size();
        // sort the array
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        // Priority Queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // loop 
        int res = 1;
        // operates in LogN
        minHeap.offer(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            // current start time
            int curr = intervals.get(i).start;
            // if the time is safe then we dont need a new room
            if (curr >= minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(intervals.get(i).end);
            } else {
                res++;
                minHeap.offer(intervals.get(i).end);
            }
        }
        return res;

    }
}
