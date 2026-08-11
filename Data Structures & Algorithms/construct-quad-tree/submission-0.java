/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

public class Solution {
    private final Node falseLeaf = new Node(false, true);
    private final Node trueLeaf = new Node(true, true);

    public Node construct(int[][] grid) {
        return dfs(grid, grid.length, 0, 0);
    }

    private Node dfs(int[][] grid, int n, int r, int c) {
        if (n == 1) {
            return grid[r][c] == 1 ? trueLeaf : falseLeaf;
        }

        n /= 2;
        Node topLeft = dfs(grid, n, r, c);
        Node topRight = dfs(grid, n, r, c + n);
        Node bottomLeft = dfs(grid, n, r + n, c);
        Node bottomRight = dfs(grid, n, r + n, c + n);

        if (topLeft.isLeaf && topRight.isLeaf &&
            bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && topLeft.val == bottomLeft.val &&
            topLeft.val == bottomRight.val) {
            return topLeft;
        }

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}