class Main {
    public static void main(String[] args) {
        Board board = new Board();
        GameHelper helper = new GameHelper();
        AI computer = helper.startGame();

        String winner = helper.gameLoop(board, computer);
        System.out.printf("The %s's have won!", winner);

    }
}

/* Error win state

X + X + -
+++++++++
O + O + O
+++++++++
X + O + X

~~~~~~~~~
 */