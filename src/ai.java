import java.util.Random;

class AI {
    String piece;
    Random rand = new Random();

    public AI(String piece) {
        this.piece = piece;
    }

    public void pickCell(Board board) {
        // TO DO - fix infinite loop
        // create board state variable
        // use variable and only pick random from the possible strategies
        while(true) {
            int row = rand.nextInt(3);
            int column = rand.nextInt(3);

            Cell cellToFill = board.getCell(row, column);
            if(cellToFill.getValue().equals("-")) {
                cellToFill.setValue(piece);
                break;
            }
        }
    }
}