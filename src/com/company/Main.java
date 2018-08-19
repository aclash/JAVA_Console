package com.company;
import java.util.*;

public class Main {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        return intervals;
    }

    // ret.add((List<Integer>) (Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
    //Character.isUpperCase(word.charAt(i))

    public static boolean detectCapitalUse(String word) {
        if (word.length() == 1)
            return true;
        boolean firstBig = false;
        boolean firstTwo = false;
        for (int i = 0; i < word.toCharArray().length; ++i){
            if (i == 0){
                if (Character.isUpperCase(word.charAt(i)))
                    firstBig = true;
            }
            else if (i == 1){
                if (firstBig == true && Character.isLowerCase(word.charAt(i)))
                    firstTwo = true;
                if (firstBig == false && Character.isUpperCase(word.charAt(i)))
                    return false;
            }
            else{
                if (firstTwo == true && Character.isUpperCase(word.charAt(i)))
                    return false;
                if (firstBig == true && firstTwo == false && Character.isLowerCase(word.charAt(i)))
                    return false;
                if(firstBig == false && Character.isUpperCase(word.charAt(i)))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
/*
        char[][] array = new char[][]{
                {'C','A','A'},
                { 'A','A','A'},
                {'B','C','D'}
        };
        */
        int[][] array1 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };

        int[] array2 = new int[]{
                1,2,2,1
        };

        int[] array3 = new int[]{
                2,2
        };

        String[] strArray = new String[]{
                "gin", "zen", "gig", "msg"
        };
        ArrayList<Interval> alist = new ArrayList<Interval>(){{
            add(new Interval(1,2));
            //add(new Interval(3,5));
            add(new Interval(6,8));
          //  add(new Interval(8,10));
            //add(new Interval(12,16));
        }};

        System.out.println(detectCapitalUse("FUCKyou"));
    }
}