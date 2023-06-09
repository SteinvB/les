public class Node {
    final String NAME;
    final double X;
    final double Y;

    public Node(String name, double x, double y) {
        this.NAME = name;
        this.X = x;
        this.Y = y;
    }

    @Override
    public String toString() {
        return (this.NAME + " (" + this.X + ", " + this.Y + ")");
    }
}
