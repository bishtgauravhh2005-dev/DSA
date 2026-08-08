class TreeAncestor {

    int[][] up;
    int LOG;

    public TreeAncestor(int n, int[] parent) {

        LOG = 1;

        while ((1 << LOG) <= n) {
            LOG++;
        }

        up = new int[n][LOG];

        // 2^0-th ancestor = direct parent
        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i];
        }

        // Build binary lifting table
        for (int j = 1; j < LOG; j++) {

            for (int i = 0; i < n; i++) {

                int prevAncestor = up[i][j - 1];

                if (prevAncestor != -1) {
                    up[i][j] = up[prevAncestor][j - 1];
                } else {
                    up[i][j] = -1;
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {

        for (int j = 0; j < LOG; j++) {

            // If j-th bit of k is set
            if ((k & (1 << j)) != 0) {

                node = up[node][j];

                if (node == -1) {
                    return -1;
                }
            }
        }

        return node;
    }
}