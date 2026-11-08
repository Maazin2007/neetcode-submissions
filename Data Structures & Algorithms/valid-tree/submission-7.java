class Solution {
    /**
    * for a valid tree we need:
    * no cycles (there is more than one path between 2 nodes)
    * all nodes should be able to reach each other
    */
    public boolean validTree(int n, int[][] edges) {
        // create the hashmap to store the tree
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        // we need a visited hash set to store all the visited nodes
        HashSet<Integer> visited = new HashSet<>();
        // create the intial graph
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        // store all the values
        for (int[] elem : edges) {
            graph.get(elem[0]).add(elem[1]);
            graph.get(elem[1]).add(elem[0]);
        }
        // we only need to do this for one node not all nodes 
        if (!dfs(graph, visited, 0, -1)) return false;
        return visited.size() == n;
    }

    private boolean dfs(HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited, int curr, int parent) {
        visited.add(curr);
        for (Integer num : graph.get(curr)) {
            if (num == parent) continue;
            if (visited.contains(num)) return false;
            if (!dfs(graph, visited, num, curr)) return false;
        }
        return true;
    }
}
