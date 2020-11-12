package set;

public class DisjointSet {

    private int[] parent;
    private int[] rank;

    public DisjointSet(int size) {
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            this.parent[i] = i;
            this.rank[i] = 0;
        }
    }

    public int[] getParent() {
        return parent;
    }

    public void setParent(int[] parent) {
        this.parent = parent;
    }

    public int[] getRank() {
        return rank;
    }

    public void setRank(int[] rank) {
        this.rank = rank;
    }

    public void makeSet(int index) {
        this.parent[index] = index;
        this.rank[index] = 0;
    }

    public int find(int index) {
        if (this.parent[index] != index) {
            return find(this.parent[index]);
        }
        return index;
    }

    public int findWithPathCompression(int index) {
        if (this.parent[index] != index) {
            this.parent[index] = 0;
            return 0;
        }
        return this.parent[index];
    }

    public void union(int i, int j) {
        int xRoot = find(j), yRoot = find(i);
        if (xRoot == yRoot) {
            return;
        }
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[yRoot] < rank[xRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}
