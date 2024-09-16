package models;

public class Knight {
    private int life;
    private final int id;

    private boolean shield;

    public Knight(int id, int life, boolean shield) {
        this.id = id;
        this.life = life;
        this.shield = shield;
    }

    public int getId() {
        return id;
    }

    public int getLife() {
        return life;
    }

    public boolean isShield() {
        return shield;
    }

    public boolean isAlive() {
        return life > 0;
    }

    public void reduceLife(int roll) {
        if (this.isShield()) {
            this.life = life - roll - 1;
            System.out.println(this.getId() + " has shield.");
        } else {
            this.life = life - roll;
            System.out.println(this.getId() + " has no shield.");
        }
    }
}
