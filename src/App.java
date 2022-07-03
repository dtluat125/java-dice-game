import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Player player1 = new Player("John", 0);
        Player player2 = new Player("Jenna", 0);
        Referee newRefree = new Referee(player1, player2);
        Scanner sc = new Scanner(System.in);
        while (!newRefree.isHasWinner()) {
            System.out.println("Appoint next Player by index: ");
            String nextLine = sc.nextLine();
            if (nextLine.length() == 0)
                nextLine = "0";
            int index = Integer.parseInt(nextLine);
            newRefree.appointNextPlayer(index);
        }
    }
}
