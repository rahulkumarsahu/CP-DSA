package org.practice.cpdsa.leetcode.google;

import java.util.*;

// https://leetcode.com/discuss/interview-question/397524/
public class Project {

    public static void main(String[] args) {
        String delay = "Q S";
        String [] delayed = delay.split(" ");
        String [] arr = new String []{"P Q","P S","Q R","R T","S T"};

        System.out.println("Result : "+solve(delayed,arr));
    }

    public static Set<String> solve(String [] delayedProject, String[] projectName){
        // this map will store the second project as key and respective dependent project
        // Key -> Value
        // Q -> P
        // S -> P
        // R -> Q
        // T -> R, S
        Map<String, Set<String>> projectMap = new HashMap<>();

        for (String project : projectName) {
            // splitting the project name string
            String[] projectArray = project.split(" ");
            // creating a list of project
            Set<String> projectList = new HashSet<>();
            // if key (2nd project) already exist in project map then get all stored list of 1st project as values and add in project list
            if (projectMap.containsKey(projectArray[1])) {
                projectList.addAll(projectMap.get(projectArray[1]));

            }
            // add the new 1st project also in the project list
            projectList.add(projectArray[0]);
            // store the values in map
            projectMap.put(projectArray[1], projectList);
        }

        Map<String, Set<String>> copyMap = new HashMap<>(projectMap);

        // iterate the map
        for(Map.Entry<String, Set<String>> entry : copyMap.entrySet()){
            // get the value from current index
            Set<String> entryList = entry.getValue();
            // get the key from current index
            String key = entry.getKey();
            // iterate by the value list
            for(String data : entryList){
                // if from 1st project list values from project map of current index is key of project map
                if(projectMap.containsKey(data)){
                    // get that key all values
                    Set<String> tempList = projectMap.get(data);
                    Set<String> temp = new HashSet<>();
                    // add all value of key.
                    temp.addAll(projectMap.get(key));
                    // add here that key value
                    temp.addAll(tempList);

                    projectMap.put(key, temp);
                }
            }
        }
        // create unique set from delayed project
        Set<String> result = new HashSet<>(Arrays.asList(delayedProject));
        // iterate over that
        for (String delayed : delayedProject) {
            // get list of project which is delayed from project map
            // and add into the list
            // **delayed project is there as 2nd project name in project name array then 1st will be delayed
            if (projectMap.containsKey(delayed)) {
                result.addAll(projectMap.get(delayed));
            }
        }
        return result;
    }
}
