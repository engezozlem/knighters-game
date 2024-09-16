import app.Game;

public class Main {
    public static void main(String[] args) {
        int numberOfKnights = 5;
        int initialLife = 10;

        Game game = new Game(numberOfKnights, initialLife);
        game.play();
    }
}