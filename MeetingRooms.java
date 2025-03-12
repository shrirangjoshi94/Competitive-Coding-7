import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/meeting-rooms-ii/

// In this problem, if the endtime of previous meeting is greater than the start time of next meeting, we will need a seperate room
// for both. So sorting the intervals by start time first, then iterating and comparing the start time with the peek element of
// priority queue, as it is having end times sorted in ascending order(min heap). So, if start time is less than or equal, we can
// share the room so poll min element from pq and put the current end time. At last size of heap will give us the number of rooms
// required

//The idea here is to assign a new room for a meeting if it doesn't fit in the existing rooms.
//As we keep iterating through the list, we check if the current meeting could be scheduled to an already existing room.
//For this, to check the room with latest availability, we maintian a priority queue(min heap) which has all the end times of the existing meeting.
//If the current meeting fits in the top most room, we do not put the meeting in a new room, and we replace the top value by end time of the currently added meeting


// Time Complexity : O(nlogn) n is the number of intervals
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

public class MeetingRooms {

    public static void main(String[] args)
    {
        int[][] intervals = {{0, 15}, {13, 20}, {17, 18}};


//        check regarding TC of PQ insert and
        Arrays.sort(intervals, ((a, b) -> (a[0] - b[0])));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] interval : intervals ) {

            if(pq.size() > 0 && interval[1] > pq.peek()) {
                pq.poll();
            }

            pq.add(interval[1]);
        }

        System.out.println(pq.size());


    }
}
