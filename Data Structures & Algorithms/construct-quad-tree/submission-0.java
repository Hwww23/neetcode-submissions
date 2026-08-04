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

class Solution {
    public Node construct(int[][] grid) {
        return dfs(0, 0, grid.length, grid);
    }

    private Node dfs(int i, int j, int size, int[][] grid) {
        if (size == 1) {
            return new Node(grid[i][j] == 1 ? true : false, true);
        }

        int half = size / 2;

        Node topL = dfs(i, j, half, grid);
        Node topR = dfs(i, j + half, half, grid);
        Node botL = dfs(i + half, j, half, grid);
        Node botR = dfs(i + half, j + half, half, grid);

        if (topL.isLeaf && topR.isLeaf && botL.isLeaf && botR.isLeaf &&
                topL.val == topR.val && topL.val == botL.val && topL.val == botR.val) {
            return topL;
        }
        
        return new Node(true, false, topL, topR, botL, botR);
    }














}