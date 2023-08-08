package Models;

import lombok.Builder;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Builder
public class Board {
    Player[][] cells;
    int dimensions;

    public Board(int dimensions) {
        this.dimensions = dimensions;
        Player[][] cells1 = new Player[dimensions][dimensions];
        for(int i=0;i<dimensions;i++)
            for(int j=0;j<dimensions;j++)
                cells1[i][j]=new Player();

        this.cells = cells1;
    }

    public Player[][] getCells() {
        return cells;
    }

    public void setCells(Player[][] cells) {
        this.cells = cells;
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }
}
