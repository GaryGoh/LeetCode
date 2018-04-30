package LeetCode;

import LeetCode.util.UndirectedGraphNode;

import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * <p>
 * <p>
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * <p>
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * <p>
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * <p>
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 */

public class CloneGraph {

    // BFS with HashMap
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        HashSet<UndirectedGraphNode> vist = new HashSet();
        Queue<UndirectedGraphNode> queue = new LinkedList();

        // create the reflecting table.
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            if (vist.contains(cur)) {
                continue;
            }
            vist.add(cur);
            map.put(cur, new UndirectedGraphNode(cur.label));
            for (UndirectedGraphNode child : cur.neighbors) {
                queue.add(child);
            }
        }

        // build up the neighbors.
        queue.add(node);
        vist.clear();
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            if (vist.contains(cur)) {
                continue;
            }
            vist.add(cur);
            UndirectedGraphNode res = map.get(cur);
            for (UndirectedGraphNode child : cur.neighbors) {
                res.neighbors.add(map.get(child));
                queue.add(child);
            }
        }

        return map.get(node);
    }


    // DFS with HashMap
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        return dfsClone(node, map);
    }

    private UndirectedGraphNode dfsClone(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        map.put(node, res);

        for (UndirectedGraphNode child : node.neighbors) {
            res.neighbors.add(dfsClone(child, map));
        }

        return res;
    }

    public static void main(String[] args) {
        UndirectedGraphNode n1 = new UndirectedGraphNode(0);
//        UndirectedGraphNode n2 = new UndirectedGraphNode(1);
//        UndirectedGraphNode n3 = new UndirectedGraphNode(2);
//
//        n1.neighbors.add(n2);
//        n1.neighbors.add(n3);
//        n2.neighbors.add(n3);
//        n3.neighbors.add(n3);
//
//        CloneGraph c = new CloneGraph();
//        UndirectedGraphNode res = c.cloneGraph(n1);
        System.out.println("a".hashCode());
        System.out.println("b".hashCode());
        System.out.println("a".hashCode() ^ "b".hashCode());
    }
}
