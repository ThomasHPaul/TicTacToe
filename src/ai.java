import java.util.Random;
import java.util.ArrayList;

class AI {
    String piece;
    Random rand = new Random();

    public AI(String piece) {
        this.piece = piece;
    }

    public void pickCell(Board board) {

        ArrayList<Cell> availableCells = board.getEmptyCells();
        int numEmptyCells = availableCells.size();
        int randCell = rand.nextInt(numEmptyCells) - 1;

        availableCells.get(randCell).setValue(piece);
    }
}