import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Tic tac toe game");
        System.out.println("Please enter no of players");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Please provide dimension for a Board");
        int boardDimension = sc.nextInt();

        System.out.println("Do you want to play with Bot");
        String botRequired = sc.next();

        n =(botRequired.equals("y") || botRequired.equals("Y"))? n-1:n;

        List<Player> playerList = new ArrayList<Player>();

        for(int i=0;i<n;i++)
        {
            System.out.println("Please enter details for a player "+i);
            System.out.println("Please enter player name");
            String name = sc.next();

            System.out.println("Please enter player symbol");
            String symbol = sc.next();

            playerList.add(new Player(i,name,symbol.charAt(0), PlayerType.Human));
        }

        if(botRequired.equals("y") || botRequired.equals("Y"))
        {
            System.out.println("Please enter details for a Bot");
            System.out.println("Please enter Bot name");
            String name = sc.next();

            System.out.println("Please enter Bot symbol");
            String symbol = sc.next();

            playerList.add(new Bot(n-1,name,symbol.charAt(0),PlayerType.Bot));
        }

        Board board = new Board(boardDimension);
        Game gameObj = new Game(board, playerList, 0);

        while(gameObj.getGameStatus().equals(GameStatus.Running))
        {
            int currentPlayerIndex = gameObj.getCurrentPlayerIndex();
            Player currentPlayer = gameObj.getPlayerList().get(currentPlayerIndex);

            currentPlayer.makeMove(gameObj.getBoard());

            gameObj.DisplayBoard();

            gameObj.checkWinner();

            if(gameObj.getGameStatus().equals(GameStatus.Won))
            {
                System.out.println("Congratulation player:-"+currentPlayer.getName()+" for winning game");
                break;
            }
            else if(gameObj.getGameStatus().equals(GameStatus.Tie))
            {
                System.out.println("Unfortunately game has been tie. Please play again");
                break;
            }

            gameObj.nextMove();
        }
    }
}