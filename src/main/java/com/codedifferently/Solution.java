package com.codedifferently;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    /**
     * You will be given an integer called number and an array called possibleFamilyMembers
     * your jobs is to find the number's family members. A family member is any value that's with in
     * 1 of any other number in the family.
     * <p>
     * So for example if the number = 4, and the possibleFamilyMembers is [1,4,3,5]
     * The actualFamilyMembers would be [3,4,5]
     * 3 is 1 away from 4
     * 4 is equal to 4
     * 4 is 1 away from 5
     * while
     * 1 is not included because the closest releation to 1 is 3 and that's 2 away.
     *
     * @param number
     * @param possibleFamilyMembers
     * @return
     */
    public Integer[] numberFamily(Integer number, Integer[] possibleFamilyMembers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //add nums to a hashmap
        for (int i = 0; i < possibleFamilyMembers.length; i++) {
            if (!map.containsKey(possibleFamilyMembers[i])) {
                map.put(possibleFamilyMembers[i], possibleFamilyMembers[i]);
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        //going down
        int index = number;     //inclusive for the number in question
        while (true) {
            if (map.containsKey(index)) {
                answer.add(0, map.get(index));  //Add to the front since every number added is smaller than the previous
            } else {
                break;
            }
            index--;
        }
        //going up
        index = number + 1;   //exclusive of number in question
        while (true) {
            if (map.containsKey(index)) {
                answer.add(map.get(index));         //Normall addition to back of Arraylist since ever number added is larger than previous
            } else {
                break;
            }
            index++;
        }
        Integer[] arr = answer.toArray(new Integer[0]);

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
        return arr;
    }
}

