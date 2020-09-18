import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BFS {
    private HashMap<Integer, Node> nodeLookup = new HashMap<>();

    public static class Node{
        private int id;
        LinkedList<Node> adjacent =new LinkedList<>();
        private Node(int id){
            this.id = id;
        }
    }

    private Node getNode(int id){
        if(nodeLookup.containsKey(id)){
            return nodeLookup.get(id);
        } else{
            nodeLookup.put(id, new Node(id));
            return nodeLookup.get(id);
        }
    }

    public void addEdge(int source, int destination){
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathBFS(int source, int destination){
        return hasPathBFS(getNode(source), getNode(destination));
    }

    private boolean hasPathBFS(Node source, Node destination){
        LinkedList<Node> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(source);
        while(!nextToVisit.isEmpty()){
            Node node = nextToVisit.remove();
            if(node == destination){
                return true;
            }

            if(visited.contains(node.id)){
                continue;
            }

            visited.add(node.id);
            for(Node child: node.adjacent){
                nextToVisit.add(child);
            }
        }
        return false;
    }
}
