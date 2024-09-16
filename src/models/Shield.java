package models;

import java.util.Random;

public class Shield {
    private final Random random;

    public Shield() {
        this.random = new Random();
    }

    public boolean shield() {
        return random.nextBoolean();
    }
}
