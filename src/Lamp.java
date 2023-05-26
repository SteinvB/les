import java.util.concurrent.ThreadLocalRandom;

public class Lamp {
    boolean lichtAan;
    int lampLife = 10;

    public Lamp() {
        this.lichtAan = ThreadLocalRandom.current().nextBoolean();
    }

    public Lamp(boolean lichtAan) {
        this.lichtAan = lichtAan;
    }

    public void set(boolean lichtAan) {
        if (this.lampLife < 1) {
            System.out.println("lamp is broken. contact your nearest SteinStore tm for a replacement ($44,99)");
            this.lichtAan = false;
            return;
        }
        if (this.lichtAan != lichtAan) {
            this.lichtAan = lichtAan;
            this.lampLife--;
        }
    }

    public void switchState() {
        this.set(!this.lichtAan);
    }

    public void roulette() {
        this.set(ThreadLocalRandom.current().nextBoolean());
    }
}
