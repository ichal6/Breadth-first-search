public class Main {
    public static void main(String[] args) {
        BFS breadthFirstSearch = new BFS();
        breadthFirstSearch.addEdge(1, 2);
        breadthFirstSearch.addEdge(2,4);
        boolean hasPathBFS = breadthFirstSearch.hasPathBFS(1, 4);
        System.out.println(hasPathBFS);
    }
}
