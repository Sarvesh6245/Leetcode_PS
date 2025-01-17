class Solution {
    public int[] findOrder(int v, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            list.get(pre[1]).add(pre[0]);
        }

        boolean vis[] = new boolean[v];
        boolean[] visi = new boolean[v];
        boolean[] visit = new boolean[v];
        Stack<Integer> stack = new Stack<>(); // result

        for (int i = 0; i < v; i++) {
            if(!vis[i]) {
                if(util(list, visi, visit, i)) return new int[] {};
                dfs(list, vis, stack, i);
            }
        }

        int i=0;
        int[] result = new int[v];
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }

        return result;
    }

    public void dfs(ArrayList<ArrayList<Integer>> list, boolean[] vis, Stack<Integer> stack, int u) {
        vis[u] = true;
        for(int v:list.get(u)) {
            if(!vis[v]){
                dfs(list, vis, stack, v);
            }
        }
        stack.push(u); 
    }

    public boolean util(ArrayList<ArrayList<Integer>> graph, boolean[] vis, boolean[] visit, int u) { // has cycle
        vis[u] = true;
        visit[u] = true;
        for (int v : graph.get(u)) {
            if (!vis[v]) {
                if (util(graph, vis, visit, v)) return true;
            }
            if (visit[v]) {
                return true;
            }
        }
        visit[u] = false;
        return false;
    }
}