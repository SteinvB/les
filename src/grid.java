public class grid {
    String plane = "";
    public grid(int size_x, int size_y) {
        for (int y=1; y<=size_y; y++) {
            String line = "";
            for (int x=0; x<size_x; x++) {
                String coordinate = "(" + x + "," + (size_y-y) + ")";
                line = line.concat(coordinate);
            }
            line = line + "\n";
            this.plane = this.plane.concat(line);
        }
    }
    public void print() {
        System.out.println(this.plane);
    }
}
