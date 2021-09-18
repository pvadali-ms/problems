package linkedin;

import leetcode.utility.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PV029500 on 11/26/2016.
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * <p>
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> result = new ArrayList<Interval>();
        int i;
        //co relate the loop with above [4, 9] example. An interval should end after the new begins, for overlapping
        //hence currInterval.end < newInterval.start check
        for (i = 0; i < intervals.size() && intervals.get(i).end < newInterval.start; i++) {
            result.add(intervals.get(i));
        }

        //The end of the new interval will overlap with all those that begin before it's end. If one of those has longer end times,
        //the overlap will be until the max of both end times (currInterval's and newInterval's)
        for (; i < intervals.size() && intervals.get(i).start <= newInterval.end; i++) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
        }
        result.add(newInterval);
        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;
    }
}
