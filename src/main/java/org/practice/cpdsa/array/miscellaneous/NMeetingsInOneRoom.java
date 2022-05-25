package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;

public class NMeetingsInOneRoom {

    record Meeting(Integer startTime, int endTime) { }

    public static void main(String[] args) {

        // Starting time
        int[] start = { 10, 12, 20 };

        // Finish time
        int[] end = { 20, 25, 30 };

        Meeting[] meeting = new Meeting[start.length];
        for(int i = 0; i < start.length; i++)
            meeting[i] = (new Meeting(start[i], end[i]));


        System.out.println(maxMeeting(meeting));

    }

    private static Integer maxMeeting(Meeting[] meeting) {
        int numberOfMeetingPossible = 1;

        Arrays.sort(meeting, (m1, m2) -> {
            if(m1.endTime == m2.endTime()) return Integer.compare(m1.startTime, m2.startTime);
            return Integer.compare(m1.endTime(), m2.endTime());
        });

        int i = 1;
        int j = 0;

        while(i < meeting.length) {

            if(meeting[i].startTime > meeting[j].endTime) {
                numberOfMeetingPossible++;
                j = i;
            }
            i++;

        }

        return numberOfMeetingPossible;
    }
}
