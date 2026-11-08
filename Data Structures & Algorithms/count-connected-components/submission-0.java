class Solution {
    public int countComponents(int n, int[][] edges) {
        // make the graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] elem : edges) {
            graph.get(elem[0]).add(elem[1]);
            graph.get(elem[1]).add(elem[0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(graph, visited, i, -1);
            }
        }
        return count;
    }

    private void dfs(HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited, int curr, int parent) {
        visited.add(curr);
        for (Integer num : graph.get(curr)) {
            if (num == parent) continue;
            if (visited.contains(num)) continue;
            dfs(graph, visited, num, curr);
        }
        return;
    }
}
