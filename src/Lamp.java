import java.util.concurrent.ThreadLocalRandom;

public class Lamp {
    boolean lichtAan;

    public Lamp() {
        this.lichtAan = ThreadLocalRandom.current().nextBoolean();
    }
}
