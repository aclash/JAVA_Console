package com.company;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static double[][] readFile() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "UTF-8"));
        String line = "";
        String[] arrs = null;
        arrs = br.readLine().split(" ");
        int N = Integer.parseInt(arrs[0]);
        assert(N > 0);
        int row = 1;
        double[][] matrix = new double[N + 2][N + 2];
        for (int i = 0; i < N + 2; ++i)
            matrix[0][i] = Double.MAX_VALUE;
        while ((line = br.readLine()) != null) {
            arrs = line.split(" ");
            matrix[row][0] = Double.MAX_VALUE;
            for (int i = 0; i < N; ++i)
                matrix[row][i + 1] = Double.parseDouble(arrs[i]);
            matrix[row][N + 1] = Double.MAX_VALUE;
            ++row;
         }
        for (int i = 0; i < N + 2; ++i)
            matrix[row][i] = Double.MAX_VALUE;
         br.close();
        return matrix;
    }

    public static boolean isLocalMinimum(double[][] matrix, int x, int y){
        if (matrix[x][y] < matrix[x + 1][y] && matrix[x][y] < matrix[x - 1][y]
                && matrix[x][y] < matrix[x][y + 1] && matrix[x][y] < matrix[x][y - 1]){
            return true;
        }
        else
            return false;
    }

    public static double getLocalMinimum( double[][] matrix, int left, int right, int top, int bottom){
        assert(left <= right);
        assert(top <= bottom);
        int col_mid = (right + left) / 2;
        int row_mid = (bottom + top) / 2;
        Double col_min = 1.1;
        Double row_min = 1.1;
        int col_min_index = -1;
        int row_min_index = -1;
        for (int i = top; i <= bottom; ++i){
            if (matrix[i][col_mid] < col_min) {
                col_min = matrix[i][col_mid];
                col_min_index = i;
            }
        }
        for (int i = left; i <= right; ++i){
            if (matrix[row_mid][i] < row_min) {
                row_min = matrix[row_mid][i];
                row_min_index = i;
            }
        }
        if (col_min <= row_min){
            if (isLocalMinimum(matrix, col_min_index, col_mid)){
                return matrix[col_min_index][col_mid];
            }
            int t = -1;
            int b = -1;
            int l = -1;
            int r = -1;
            if ( col_min_index <= row_mid){
                t = top;
                b = row_mid;
            }
            else{
                t = row_mid + 1;
                b = bottom;
            }
            if (matrix[col_min_index][col_mid - 1] <= matrix[col_min_index][col_mid + 1]){
                l = left;
                r = col_mid;
            }
            else{
                l = col_mid + 1;
                r = right;
            }
            return getLocalMinimum(matrix, l, r, t, b);
        }
        else{
            if (isLocalMinimum(matrix, row_mid, row_min_index)){
                return matrix[row_mid][row_min_index];
            }
            int t = -1;
            int b = -1;
            int l = -1;
            int r = -1;
            if ( row_min_index <= col_mid){
                l = left;
                r = col_mid;
            }
            else{
                l = col_mid + 1;
                r = right;
            }
            if (matrix[row_mid - 1][row_min_index] <= matrix[row_mid + 1][row_min_index]){
                t = top;
                b = row_mid;
            }
            else{
                t = row_mid + 1;
                b = bottom;
            }
            return getLocalMinimum(matrix, l, r, t, b);
        }
    }

    public static int findJudge(int N, int[][] trust) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0;i<trust.length;i++){
            if(map.containsKey(trust[i][0])){
                // map.set(trust[i],map.get(trust[i])+map.get(trust[i]));
                map.get(trust[i][0]).add(trust[i][0]);
            }
            else{
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(trust[i][1]);
                map.put(trust[i][0],arr);
            }
        }

        if(map.size() != N-1) return -1;
        int[] flag = new int[N+1];
        for(Map.Entry<Integer, ArrayList<Integer>> elem:map.entrySet()){
            int key = (int)elem.getKey();
            flag[key] = 1;
        }
        int judge = 0;
        for(int i = 1;i<flag.length;i++){
            if(flag[i]==0)  judge = i;
        }

        for(Map.Entry<Integer, ArrayList<Integer>> elem:map.entrySet()){
            ArrayList<Integer> arr1 = elem.getValue();
            boolean help = false;
            for(int i=0;i<arr1.size();i++){
                if(arr1.get(i)==judge){
                    help = true;
                    break;
                }
            }
            if(!help) return -1;
        }
        return judge;
    }

    public static void main(String[] args) {
        //sub reborn 3
        //sub reborn 2
        //git aclash sub 1
        //sub reborn 1
//        try {
//            double[][] matrix = readFile();
//            int row = matrix.length;
//            int col = matrix[0].length;
//            System.out.println(getLocalMinimum(matrix, 1, col - 2, 1, row - 2));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

//    public static class Interval {
//        int start;
//        int end;
//        Interval() { start = 0; end = 0; }
//        Interval(int s, int e) { start = s; end = e; }
//    }
//
//    public static List<Interval> insert(List<Interval > intervals, Interval newInterval) {
//        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
//        return intervals;
//    }

// ret.add((List<Integer>) (Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
//Character.isUpperCase(word.charAt(i))
//String str = Integer.toString(N);
//int ret = (int)Math.pow(4, str.length() - 1);