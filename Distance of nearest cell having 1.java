import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        ArrayList<ArrayList<Integer>> dist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dist.add(new ArrayList<>(Collections.nCopies(m, -1)));
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    dist.get(i).set(j, 0);
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];

            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if (newX >= 0 && newY >= 0 && newX < n && newY < m && dist.get(newX).get(newY) == -1) {
                    dist.get(newX).set(newY, dist.get(x).get(y) + 1);
                    q.offer(new int[]{newX, newY});
                }
            }
        }

        return dist;
    }
}
