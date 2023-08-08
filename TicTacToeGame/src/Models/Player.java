package Models;

import java.util.Scanner;

public class Player {
    int Id;
    String Name;
    char Symbol;
    PlayerType playerType;

    public Player(int id, String name, char symbol,PlayerType playerType) {
        Id = id;
        Name = name;
        Symbol = symbol;
        this.playerType = playerType;
    }

    public Player() {
        this.Id = -1;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public void makeMove(Board board) {
        Player[][] cells = board.getCells();
        int dim = cells.length;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter move for player:-"+this.getName());

        System.out.println("Please enter row details");
        int row = sc.nextInt();

        System.out.println("Please enter column details");
        int col = sc.nextInt();

        if(row>=dim || col>=dim)
        {
            System.out.println("Invalid move. Please re-enter");
            makeMove(board);
            return;
        }

        if(cells[row][col].getPlayerType()==null)
        cells[row][col] = this;
        else
        {
            System.out.println("Cell provided by "+this.getName()+" is already filled. Please re-input details");
            makeMove(board);
            return;
        }
    }
}
