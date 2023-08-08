package Models;

import java.util.List;

public class Game {
    Board board;
    List<Player> playerList;
    GameStatus gameStatus;
    int currentPlayerIndex;

    public Game(Board board, List<Player> playerList, int currentPlayerIndex) {
        this.board = board;
        this.playerList = playerList;
        this.gameStatus = GameStatus.Running;
        this.currentPlayerIndex = currentPlayerIndex;
    }
    
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public void checkWinner() {

        Player[][] cells = this.board.getCells();
        int dim = cells.length;
        Player currentPlayer = this.getPlayerList().get(currentPlayerIndex);

        for(int i=0;i<dim;i++)
        {
            int cnt = 0;
            for (int j=0; j<dim; j++)
            {
                if(cells[i][j].equals(currentPlayer))
                {
                    cnt++;
                }
            }
            if(cnt==dim)
            {
                this.setGameStatus(GameStatus.Won);
                return;
            }
        }

        for(int i=0;i<dim;i++)
        {
            int cnt = 0;
            for (int j=0; j<dim; j++)
            {
                if(cells[j][i].equals(currentPlayer))
                {
                    cnt++;
                }
            }
            if(cnt==dim)
            {
                this.setGameStatus(GameStatus.Won);
                return;
            }
        }

        int cnt = 0;
        for (int j=0; j<dim; j++)
        {
            if(cells[j][j].equals(currentPlayer))
            {
                cnt++;
            }
        }
        if(cnt==dim)
        {
            this.setGameStatus(GameStatus.Won);
            return;
        }

        cnt = 0;
        for (int i=0,j=dim-1; j>=0; i++,j--)
        {
            if(cells[j][i].equals(currentPlayer))
            {
                cnt++;
            }
        }
        if(cnt==dim)
        {
            this.setGameStatus(GameStatus.Won);
            return;
        }


        boolean isEmpty = false;
        for(int i=0;i<dim;i++)
        {
            for (int j=0; j<dim; j++)
            {
                if(cells[i][j].getPlayerType()==null)
                {
                    isEmpty = true;
                }
            }
        }

        if(!isEmpty)
        {
            this.setGameStatus(GameStatus.Tie);
            return;
        }
    }

    public void DisplayBoard() {

        Player[][] cells = this.board.getCells();
        int dim = cells.length;
        Player currentPlayer = this.getPlayerList().get(currentPlayerIndex);
        System.out.println("Following board after move by:-"+currentPlayer.getName());
        for(int i=0;i<dim;i++)
        {
            for (int j=0; j<dim; j++)
            {
                if(cells[i][j].getPlayerType()==null)
                System.out.print("|-|");
                else
                System.out.print("|"+cells[i][j].getSymbol()+"|");
            }
            System.out.println();
        }
    }

    public void nextMove() {
        int playersCnt = this.playerList.size();
        this.currentPlayerIndex = (this.currentPlayerIndex+1)%playersCnt;
    }
}
