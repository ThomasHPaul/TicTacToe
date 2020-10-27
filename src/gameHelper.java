import java.util.Scanner;

class GameHelper {
    boolean isPlayerTurn;
    int turnCount;
    String playerPiece;
    Scanner input = new Scanner(System.in);

    public GameHelper() {
        this.isPlayerTurn = true;
        this.turnCount = 0;
    }

    public AI startGame() {

        System.out.println("Let's play TicTacToe!\n");
        System.out.println("X's or O's");
        playerPiece = input.next().toUpperCase();

        if(playerPiece.equals("O")) {
            AI computer = new AI("X");
            return computer;
        }
        else {
            AI computer = new AI("O");
            return computer;
        }
    }

    public void pickPiece() {
        String playerPiece = null;

        while(
                (playerPiece == null || playerPiece.isEmpty())
                        && !playerPiece.equals("O")
                        && !playerPiece.equals("X") ) {
            System.out.println("X's or O's ?");
            playerPiece = input.next();
        }

    }

    public String gameLoop(Board board, AI ai) {
        while(true) {
            while(turnCount < 2) {
                playerTurn(board);
                board.displayBoard();
                ai.pickCell(board);
                board.displayBoard();
                turnCount++;
            }
            playerTurn(board);
            board.displayBoard();

            String winner = board.checkWin();
            if(!winner.isBlank()) {
                return winner;
            }
            ai.pickCell(board);
            board.displayBoard();
            winner = board.checkWin();
            if(!winner.isBlank()) {
                return winner;
            }
        }
    }

    private void playerTurn(Board board) {

        int row;
        int column;

        inputValidation: while(true) {
            System.out.println("Please choose your spot\tex. A2 is row A column 2");

            String chosenCell = input.next().toUpperCase();
            column = Integer.parseInt(chosenCell.substring(1)) - 1;

            switch (chosenCell.charAt(0)) {
                case 'A':
                    row = 0;
                    break inputValidation;

                case 'B':
                    row = 1;
                    break inputValidation;

                case 'C':
                    row = 2;
                    break inputValidation;

                default:
                    System.out.println("Please pick either A, B, or C and a number for your selection\n\n");
                    continue;
            }
        }

        Cell potentialCell = board.getCell(row, column);
        while(true) {
            if (potentialCell.getValue().equals("-")) {
                potentialCell.setValue(playerPiece);
                break;
            } else {
                System.out.println("That space has already been chosen\nPlease pick another");
                continue;
            }
        }
    }


}