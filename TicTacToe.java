import java.util.Scanner;

public class TicTacToe extends Board {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    Board game = new Board();

    game.displayBoard();

    int turnsPlayed = 0;
    boolean gameOver = false;
    boolean player1Turn = true;

    while (turnsPlayed < 9 && !gameOver) {
      while (!gameOver && player1Turn) {
        System.out.println("Player 1, make your move");
        int move1 = input.nextInt();

        if (game.getPlayer1().contains(move1) || game.getPlayer2().contains(move1)) {
          game.displayBoard();
          System.out.println("That spot has already been played!");
        } else {
          game.setBoard(move1, 1);
          gameOver = game.hasRow(game.getPlayer1());
          game.displayBoard();
          player1Turn = false;
        }
      }

      while (!gameOver && !player1Turn) {
        System.out.println("Player 2, make your move");
        int move2 = input.nextInt();
        if (game.getPlayer1().contains(move2) || game.getPlayer2().contains(move2)) {
          System.out.println("That spot has already been played!");
          game.displayBoard();
        } else {
          game.setBoard(move2, 2);
          gameOver = game.hasRow(game.getPlayer2());
          game.displayBoard();
          player1Turn = true;
        }
      }
    }

    if (gameOver) {
      if (game.hasRow(game.getPlayer1()))
        System.out.println("Player 1 has won!");
      else
        System.out.println("Player 2 has won!");
    } else
      System.out.println("It is a CAT game!");

    input.close();
  }
}
