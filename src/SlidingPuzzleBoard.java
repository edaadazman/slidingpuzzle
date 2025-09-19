import java.util.*;

public class SlidingPuzzleBoard implements Board {
    private final int rows;
    private final int cols;
    private final int[][] grid;

    public SlidingPuzzleBoard(int rows, int cols) {
        this(rows, cols, true);
    }

    private SlidingPuzzleBoard(int rows, int cols, boolean shouldShuffle) {
        if (rows < 2 || cols < 2)
            throw new IllegalArgumentException("Minimum board size is 2x2.");
        if (rows > 10 || cols > 10)
            throw new IllegalArgumentException("Maximum board size is 10x10.");
        this.rows = rows;
        this.cols = cols;
        this.grid = new int[rows][cols];
        initSolved();
        if (shouldShuffle) {
            shuffle();
        }
    }

    @Override
    public int rows() {
        return rows;
    }

    @Override
    public int cols() {
        return cols;
    }

    private void initSolved() {
        int v = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = v++;
            }
        }
        grid[rows - 1][cols - 1] = 0;
    }

    public void shuffle() {
        Random rng = new Random();
        for (int i = 0; i < 100; i++) {
            int[] emptyPos = find(0);
            List<int[]> adjacentTiles = getAdjacentTiles(emptyPos[0], emptyPos[1]);
            if (!adjacentTiles.isEmpty()) {
                int[] randomTile = adjacentTiles.get(rng.nextInt(adjacentTiles.size()));
                swap(emptyPos[0], emptyPos[1], randomTile[0], randomTile[1]);
            }
        }
    }

    private List<int[]> getAdjacentTiles(int emptyRow, int emptyCol) {
        int[][] adjacentPositions = getAdjacentPositions(emptyRow, emptyCol);
        List<int[]> adjacent = new ArrayList<>();
        for (int[] pos : adjacentPositions) {
            adjacent.add(pos);
        }
        return adjacent;
    }

    public boolean trySlideTile(int value) {
        if (value <= 0 || value >= rows * cols)
            return false;
        int[] t = find(value);
        int[] e = find(0);
        if (t == null || e == null)
            return false;
        if (isAdjacent(t[0], t[1], e[0], e[1])) {
            swap(t[0], t[1], e[0], e[1]);
            return true;
        }
        return false;
    }

    private int[] find(int v) {
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (grid[r][c] == v)
                    return new int[] { r, c };
        return null;
    }

    private boolean isAdjacent(int r1, int c1, int r2, int c2) {
        return areAdjacent(r1, c1, r2, c2);
    }

    private void swap(int r1, int c1, int r2, int c2) {
        int tmp = grid[r1][c1];
        grid[r1][c1] = grid[r2][c2];
        grid[r2][c2] = tmp;
    }

    @Override
    public boolean isSolved() {
        int k = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == rows - 1 && c == cols - 1) {
                    return grid[r][c] == 0;
                }
                if (grid[r][c] != k++)
                    return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        int maxVal = rows * cols - 1;
        int cellWidth = Integer.toString(maxVal).length() + 2;
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                sb.append("|");
                if (grid[r][c] == 0) {
                    sb.append(String.format("%" + cellWidth + "s", " "));
                } else {
                    sb.append(String.format("%" + cellWidth + "d", grid[r][c]));
                }
            }
            sb.append("|\n");

            for (int c = 0; c < cols; c++) {
                sb.append("+");
                for (int i = 0; i < cellWidth; i++) {
                    sb.append("-");
                }
            }
            sb.append("+\n");
        }
        return sb.toString();
    }

}
