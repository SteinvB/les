public class klad {
    public static void main(String[] args) {
        Lamp lamp0 = new Lamp(true);
        lamp0.set(true);
        System.out.println(lamp0.lichtAan);
        lamp0.switchState();
        System.out.println(lamp0.lichtAan);
        lamp0.roulette();
        System.out.println(lamp0.lichtAan);
        for (int i=0; i<10; i++) {
            lamp0.switchState();
        }
    }
}
