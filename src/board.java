class Board {
    final private Cell[][] board;

    public Board() {
        Cell cellA1 = new Cell();
        Cell cellA2 = new Cell();
        Cell cellA3 = new Cell();
        Cell cellB1 = new Cell();
        Cell cellB2 = new Cell();
        Cell cellB3 = new Cell();
        Cell cellC1 = new Cell();
        Cell cellC2 = new Cell();
        Cell cellC3 = new Cell();

        Cell[] rowA = {cellA1, cellA2, cellA3};
        Cell[] rowB = {cellB1, cellB2, cellB3};
        Cell[] rowC = {cellC1, cellC2, cellC3};

        this.board = new Cell[][]{rowA, rowB, rowC};
    }

    public void displayBoard() {
        System.out.printf(
                "%s + %s + %s \n+++++++++\n%s + %s + %s\n+++++++++\n%s + %s + %s\n\n~~~~~~~~~\n%n"
                , board[0][0].getValue()
                , board[0][1].getValue()
                , board[0][2].getValue()
                , board[1][0].getValue()
                , board[1][1].getValue()
                , board[1][2].getValue()
                , board[2][0].getValue()
                , board[2][1].getValue()
                , board[2][2].getValue());
    }

    public Cell getCell(int row, int column) {
        return board[row][column];
    }

    // Checks all winning lanes of the board
    // Returns: winning piece (either X or O)
    public String checkWin() {
        int checkSum;
        String winner;

        // Check rows for a win
        for (int i = 0; i < 3; i++) {
            checkSum = 0;

            // Individual row check
            for (int j = 0; j < 3; j++) {
                checkSum += board[i][j].getValue().charAt(0);
            }
            winner = checkWinner(checkSum);
            if (!winner.isBlank()) {
                return winner;
            }
        }

        // Check columns for a win
        for (int i = 0; i < 3; i++) {
            checkSum = 0;

            // Individual column check
            for (int j = 0; j < 3; j++) {
                checkSum += board[j][i].getValue().charAt(0);
            }
            winner = checkWinner(checkSum);
            if (!winner.isBlank()) {
                return winner;
            }
        }
        // Reset checkSum before checking diagonals
        checkSum = 0;

        // Check both diagonals for a win
        for (int i = 0; i < 3; i++) {
            checkSum += board[i][i].getValue().charAt(0);
        }
        winner = checkWinner(checkSum);
        if (!winner.isBlank()) {
            return winner;
        }

        for (int i = 2; i >= 0; i--) {
            checkSum += board[i][i].getValue().charAt(0);
        }
        winner = checkWinner(checkSum);
        if (!winner.isBlank()) {
            return winner;
        }
        return winner;
    }

    private String checkWinner(int checkSum) {
        final int asciiX = 88;
        final int asciiO = 79;

        if(checkSum % asciiX == 0) {
            return "X";
        } else if (checkSum % asciiO == 0) {
            return "O";
        } else {
            return "";
        }
    }
}
