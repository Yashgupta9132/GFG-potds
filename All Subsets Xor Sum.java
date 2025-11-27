import java.io.*;
import java.util.*;

public class Solution {
    public static int subsetXORSum(int[] arr) {
        int n = arr.length;
        int allOr = 0;
        for (int x : arr) allOr |= x;

        long multiplier = 1L << (n - 1);

        long ans = (long) allOr * multiplier;
        return (int) ans; 
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        String[] parts = line.trim().split("\\s+");
        if (parts.length == 1) {
            int single = Integer.parseInt(parts[0]);
            int[] arr = new int[]{single};
            System.out.println(subsetXORSum(arr));
            return;
        }
        boolean allNumsOnSingleLine = true;
        for (String p : parts) {
            if (!p.matches("-?\\d+")) { allNumsOnSingleLine = false; break; }
        }
        if (allNumsOnSingleLine) {
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i]);
            System.out.println(subsetXORSum(arr));
            return;
        }
        try {
            int t = Integer.parseInt(parts[0]);
            for (int tc = 0; tc < t; tc++) {
                line = br.readLine();
                while (line != null && line.trim().isEmpty()) line = br.readLine();
                if (line == null) break;
                String[] tokens = line.trim().split("\\s+");
                int n = tokens.length;
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(tokens[i]);
                System.out.println(subsetXORSum(arr));
            }
        } catch (NumberFormatException ex) {
        }
    }
}
