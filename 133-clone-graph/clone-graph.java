/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/



class Solution {
    Node[] copyNodes = new Node[100];
    
    public Node cloneGraph(Node node) 
    {
        if (node == null) return null; 
        
        int ind = node.val-1; 
        if (copyNodes[ind] == null) 
        {
            copyNodes[ind] = new Node(node.val); 
            for (Node neighbor : node.neighbors) 
                copyNodes[ind].neighbors.add(cloneGraph(neighbor));
        }
        return copyNodes[ind]; 
    }
}