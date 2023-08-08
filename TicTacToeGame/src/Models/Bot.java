package Models;
import java.util.Random;
public class Bot extends Player{

    public Bot(int id, String name, char symbol,PlayerType playerType) {
        super(id, name, symbol,playerType);
    }

    public void makeMove(Board board) {
        Player[][] cells = board.getCells();
        int dim = cells.length;

        Random random = new Random();

        int row = random.nextInt(dim);
        int col = random.nextInt(dim);

        System.out.println(row+"-"+col);

        if(cells[row][col].getPlayerType()==null)
            cells[row][col] = this;
        else
            makeMove(board);
    }
}
