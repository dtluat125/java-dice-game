import java.util.ArrayList;

public class Referee {
    private ArrayList<Player> players = new ArrayList<>();
    private Player nextPlayer = null;
    private final int MAX_PLAYERS = 4;
    private boolean hasWinner = false;

    public Referee(Player... newPlayers) {
        int numVirtualPlay = MAX_PLAYERS - newPlayers.length;
        for (Player i : newPlayers) {
            players.add(i);
        }
        for (int i = 0; i < numVirtualPlay; i++) {
            Player virtualPlayer = new Player("virtual " + i, 0, "What a bad luck", true);
            players.add(virtualPlayer);
        }
    }

    public boolean isHasWinner() {
        return hasWinner;
    }

    public Player appointNextPlayer(int playerIndex) {
        if (players.size() < MAX_PLAYERS) {
            System.out.println("Not enough players, add some!");
            return null;
        }
        if (playerIndex > MAX_PLAYERS) {
            System.out.println("Invalid Player Index, should be less than 4");
            return null;
        }
        nextPlayer = players.get(playerIndex);
        int randomInt = (int) Math.round(Math.random() * (4 - 1 + 1) + 1);
        Dice nextDice = new Dice(randomInt);
        int dicePoints = nextDice.rollTheDice();
        int newPoints = calculatePoints(dicePoints);
        nextPlayer.setPoints(newPoints);
        System.out.println("Next player is: " + nextPlayer.getName());
        System.out.println("Player's Current Points: " + nextPlayer.getPoints());
        System.out.println("Dice Points: " + dicePoints);
        System.out.println("Player's New Points: " + newPoints);
        if (newPoints == 21) {
            annouceWinner(nextPlayer);
            this.hasWinner = true;
            System.out.println("Game Over!!!");
        }
        System.out.println("*****************************");
        return nextPlayer;
    }

    private int calculatePoints(int points) {
        if (nextPlayer == null) {
            System.out.println("Appoint a player first");
            return 0;
        }
        int tempPoints = nextPlayer.getPoints() + points;
        if (tempPoints > 21)
            return 0;
        return tempPoints;
    }

    private void annouceWinner(Player winner) {
        System.out.println("The winner is: " + winner.getName());
        for (Player p : players) {
            if (!p.equals(winner) && p.isVirtual())
                System.out.println(p.getName() + ": " + p.getEmotion());
        }
    }
}
