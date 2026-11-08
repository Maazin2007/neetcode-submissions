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
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Fix 1: Handle both empty lists and single-interval lists safely
        if (intervals == null || intervals.size() <= 1) return true;
        
        // Fix 2: Use List.sort() instead of Arrays.sort()
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        
        // Check for overlapping meetings
        for (int i = 1; i < intervals.size(); i++) {
            int prevEnd = intervals.get(i - 1).end;
            int currStart = intervals.get(i).start;
            
            if (currStart < prevEnd) {
                return false; 
            }
        }
        
        return true;
    }
}
