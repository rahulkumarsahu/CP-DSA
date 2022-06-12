package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class MaximumNumberEventsAttended {

    public int maxEvents(int[][] events) {


        Arrays.sort(events , (obj1, obj2) -> {

            if(obj1[1] == obj2[1]) {

                return Integer.compare(obj1[0], obj2[0]);
            }
            return Integer.compare(obj1[1], obj2[1]);
        });

        HashSet<Integer> set = new HashSet<>();

        for(int[] event : events) {

            for(int i = event[0]; i <= event[1]; i++) {

                if(set.add(i)) {
                    break;
                }
            }
        }

        return set.size();
    }

    public int maxEvents2(int[][] events) {
        /**
         Algo :
         For any event event = [s,e] , we can  attend this on starting day or any of the day in between or finally on ending day . we need to greedily choose it
         1. Create a HashSet(pool) of Days .
         2. Sort Events by end time , in case of conflict , sort by start time
         3. Now For Every event try to get the nearest day to attend, which should be in range of startDay <= d <=endDay . This is what question mention , we can easily do this with TreeSet celing function .
         4. Than remove from the pool of days .


         Lets dry run on this :

         events = [{1,2} , {3,3} , {1,5} , {1,2} , {1,5} ]   daysPool = [1,-----100000]

         1. After  sorting it becomes [{1,2},{1,2},{3,3} ,{1,5},{1,5} ]
         2. Now for 1st event (1,2) , celing function will give 1 and than u remove 1 from daysPool
         3. Now for second event {1,2} celing function will give 2 and than u remove 2 from daysPool
         4. Now for Third Event {3,3} celing function will give 3 and than u remove 3 from daysPool
         5. Now for Third Event {1,5} celing function will give 4 and than u remove 4 from daysPool
         6. 5. Now for Third Event {1,5} celing function will give 5 and than u remove 5 from daysPool
         7. Answer is count =5

         **/

        // O( N Log N)
        // Sort Event by End Time
        Arrays.sort(events , (obj1, obj2) -> {

            if(obj1[1] == obj2[1]) {

                return Integer.compare(obj1[0], obj2[0]);
            }
            return Integer.compare(obj1[1], obj2[1]);
        });


        // N Log N
        TreeSet<Integer> daysPool = new TreeSet<>();
        for(int i=1 ; i <= 100000; i++ ){
            daysPool.add(i);
        }
        int count = 0;

        // O N
        for(int[] event : events){
            int startDay = event[0];
            int endDay = event[1];
            // O(LogN)
            Integer lower = daysPool.ceiling(startDay);
            if(lower == null || lower > endDay){
                continue;
            }
            // LOG N
            daysPool.remove(lower);
            count++;
        }
        return count;
    }

}
