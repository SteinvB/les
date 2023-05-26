import java.util.LinkedList;

public class TravelingSalesman {
    static LinkedList<Node> nodeList = new LinkedList<>();
    public static void main(String[] args) {
        createNode("Leeuwarden",53.201390,5.808590);
        createNode("Utrecht", 52.090830,5.122220);
        createNode("Groningen",53.219170,6.566670);
        createNode("Arnhem", 51.980000,5.911110);
        createNode("Maastricht", 50.848330,5.688890);
        createNode("Assen",52.996670,6.562500);
        createNode("Lelystad", 52.508330,5.475000);
        createNode("Amsterdam", 52.374030,4.889690);
        createNode("Den Haag", 52.076670,4.298610);
        createNode("Middelburg", 51.500000,3.613890);
        createNode("'s Hertogenbos", 51.699170,5.304170);
        LinkedList<Node> optimal = solve();
        System.out.println("optimal path (distance: " + getPathDistance(optimal) + "):");
        printList(optimal);
    }
    public static void createNode(String name, double x, double y) {
        Node temp = new Node(name, x, y);
        nodeList.add(temp);
    }

    public static double getDistance(Node start, Node end) {
        double square1 = Math.pow(start.X - end.X, 2);
        double square2 = Math.pow(start.Y - end.Y, 2);
        return Math.sqrt(square1 + square2);
    }

    public static int getClosestIndex(Node start, LinkedList<Node> excludeList) {
        int mIndex = 0;
        int i = 0;
        double min = -1;
        for (Node current : nodeList) {
            if (excludeList.contains(current)) {
                i++;
                continue;
            }
            double distance = getDistance(start, current);
            if (min == -1 || distance < min) {
                min = distance;
                mIndex = i;
            }
            i++;
        }
        return mIndex;
    }

    public static void printList(LinkedList<Node> list) {
        for (Node item : list) {
            System.out.println(item.toString());
        }
    }

    public static double getPathDistance(LinkedList<Node> list) {
        double sum = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            sum += getDistance(list.get(i), list.get(i + 1));
        }
        return sum;
    }

    public static LinkedList<Node> solve() {
        double min = -1;
        LinkedList<Node> optimalPath = new LinkedList<>();
        for (int i = 0; i < nodeList.size(); i++) {
            double sum = 0;
            LinkedList<Node> currentPath = solveForStart(i);
            for (int j = 0; j < currentPath.size() - 1; j++) {
                sum += getDistance(currentPath.get(j), currentPath.get(j + 1));
            }
            if (min == -1 || sum < min) {
                min = sum;
                optimalPath = currentPath;
            }
        }
        return optimalPath;
    }

    public static LinkedList<Node> solveForStart(int startIndex) {
        LinkedList<Node> resultingPath = new LinkedList<>();
        Node start = nodeList.get(startIndex);
        resultingPath.add(start);
        while (resultingPath.size() < nodeList.size()) {
            int mIndex = getClosestIndex(start, resultingPath);
            start = nodeList.get(mIndex);
            resultingPath.add(start);
        }
        return resultingPath;
    }
}
