package com.company;
import java.util.*;

public class Main {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        return intervals;
    }

    public static void main(String[] args) {
/*
        int[][] array = new int[][]{
                { 1,   3,  5,  7},
                { 10, 11, 16, 20},
                { 23, 30, 34, 50}
        };
        */
        int[] array = new int[]{
                100
        };
        ArrayList<Interval> alist = new ArrayList<Interval>(){{
            add(new Interval(1,4));
            add(new Interval(4,5));
        }};

        System.out.println(merge(alist));
    }
}