import java.util.*;

class Sofa {
    int row, col;
    char orientation;
    int steps;

    Sofa(int row, int col, char dir, int steps) {
        this.row = row;
        this.col = col;
        this.orientation = dir;
        this.steps = steps;
    }

    public int[][] getCells() {
        if (orientation == 'H') {
            return new int[][] {
                    { row, col },
                    { row, col + 1 }
            };
        } else {
            return new int[][] {
                    { row, col },
                    { row + 1, col }
            };
        }
    }

}

public class SofaProblem {

    private final static int[][] MOVES = {
            { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 }
    };

    private static final int[][] ROTATE_MOVES = {
            { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 }
    };

    public static Sofa findSofa(char[][] grid, char ch, int R, int C, int steps) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == ch) {
                    if (j + 1 < C && grid[i][j + 1] == ch) {
                        return new Sofa(i, j, 'H', steps);
                    } else {
                        return new Sofa(i, j, 'V', steps);
                    }
                }
            }
        }
        return null;
    }

    public static boolean isFree(char[][] grid, int row, int col, int R, int C) {
        if (row < 0 || row >= R || col < 0 || col >= C)
            return false;
        if (grid[row][col] == 'H')
            return false;
        return true;
    }

    public static boolean isBlockFree(char[][] grid, int row, int col, int R, int C) {
        for(int[] direction : ROTATE_MOVES) {
            if(!isFree(grid, row + direction[0], col + direction[1], R, C)) return false;
        }
        return true;
    }

    public static List<Sofa> getNeighbours(Sofa cur, char[][] grid, int R, int C) {
        ArrayList<Sofa> neighbours = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int ar = cur.row + MOVES[i][0];
            int ac = cur.col + MOVES[i][1];
            Sofa neighbour = new Sofa(ar, ac, cur.orientation, cur.steps + 1);

            boolean ok = true;

            for (int[] cell : neighbour.getCells()) {
                if (!isFree(grid, cell[0], cell[1], R, C)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                neighbours.add(neighbour);
            }
        }

        if (cur.orientation == 'H') {
            for(int row = cur.row-1 ; row <= cur.row ; row++) {
                if(isBlockFree(grid, row, cur.col, R, C)) {
                    neighbours.add(new Sofa(row, cur.col, 'V', cur.steps+1));
                    neighbours.add(new Sofa(row, cur.col+1, 'V', cur.steps+1));
                }
            }
        }
        else {
            for(int col = cur.col-1 ; col <= cur.col ; col++) {
                if(isBlockFree(grid, cur.row, col, R, C)) {
                    neighbours.add(new Sofa(cur.row, col, 'H', cur.steps+1));
                    neighbours.add(new Sofa(cur.row+1, col, 'H', cur.steps+1));
                }
            }
        }

        return neighbours;
    }

    public static int getOrientationIDX(char ch) {
        return (ch == 'H' ? 0 : 1);
    }

    public static int bfs(Sofa start, Sofa target, char[][] grid, int R, int C) {
        Queue<Sofa> queue = new LinkedList<>();
        boolean[][][] vis = new boolean[R][C][2];

        vis[start.row][start.col][getOrientationIDX(start.orientation)] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            Sofa cur = queue.poll();

            if(cur.row == target.row && cur.col == target.col && cur.orientation == target.orientation) {
                return cur.steps;
            }

            for(Sofa neighbour : getNeighbours(cur, grid, R, C)) {
                int oIDX = getOrientationIDX(neighbour.orientation);
                if(!vis[neighbour.row][neighbour.col][oIDX]) {
                    vis[neighbour.row][neighbour.col][oIDX] = true;
                    queue.add(neighbour);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        Sofa start = findSofa(grid, 's', R, C, 0);
        Sofa target = findSofa(grid, 'S', R, C, 0);
        int res = bfs(start, target, grid, R, C);

        System.out.println(res != -1 ? res : "Impossible");

        sc.close();
    }
}