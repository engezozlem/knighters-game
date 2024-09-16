package app;

import models.Die;
import models.Knight;
import models.Shield;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Knight> knights;
    private final Die die;

    public Game(int numberOfKnights, int initialLife) {
        knights = new ArrayList<>();
        Shield shield = new Shield();
        for (int i = 0; i < numberOfKnights; i++) {
            knights.add(new Knight(i + 1, initialLife, shield.shield()));
        }
        die = new Die();
    }

    private void printGameState() {
        for (Knight knight : knights) {
            System.out.println("Knight " + knight.getId() + ": " + (knight.isAlive() ? "Alive, Life: " + knight.getLife() : "Dead"));
        }
        System.out.println();
    }

    private Knight getNextAliveKnight(int currentKnightIndex) {
        int index = currentKnightIndex;
        do {
            index = (index + 1) % knights.size();
        } while (!knights.get(index).isAlive());
        return knights.get(index);
    }

    public void play() {
        int currentKnightIndex = 0;


        while (knights.stream().filter(Knight::isAlive).count() > 1) {
            Knight currentKnight = knights.get(currentKnightIndex);
            if (currentKnight.isAlive()) {
                int roll = die.roll();
                Knight successorKnight = getNextAliveKnight(currentKnightIndex);
                successorKnight.reduceLife(roll);
                if (!successorKnight.isAlive()) {
                    System.out.println("Knight " + successorKnight.getId() + " has died.");
                }

                printGameState();
            }

            currentKnightIndex = (currentKnightIndex + 1) % knights.size();
        }

        knights.stream().filter(Knight::isAlive).findFirst().ifPresent(winner ->
                System.out.println("Knight " + winner.getId() + " is the winner!")
        );
    }

}
