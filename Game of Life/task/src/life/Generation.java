package life;


import static life.Symbol.ALIVE;
import static life.Symbol.DEAD;

public class Generation {

    public static Universe next(Universe board) {
        Universe emptyBoard = new Universe(board.getDimension());

        int N = board.getDimension();
        int aliveNeighbors = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board.getCell(r - 1, c - 1) == ALIVE) {
                    aliveNeighbors++;
                }
                if (board.getCell(r - 1, c) == ALIVE) {
                    aliveNeighbors++;
                }
                if (board.getCell(r - 1, c + 1) == ALIVE) {
                    aliveNeighbors++;
                }
                if (board.getCell(r, c - 1) == ALIVE) {
                    aliveNeighbors++;
                }
                if (board.getCell(r, c + 1) == ALIVE) {
                    aliveNeighbors++;
                }
                if (board.getCell(r + 1, c - 1) == ALIVE) {
                    aliveNeighbors++;
                }
                if (board.getCell(r + 1, c) == ALIVE) {
                    aliveNeighbors++;
                }
                if (board.getCell(r + 1, c + 1) == ALIVE) {
                    aliveNeighbors++;
                }

                if (board.getCell(r,c) == ALIVE) {
                    if (aliveNeighbors == 2 || aliveNeighbors == 3) {
                        emptyBoard.setAlive(r,c);
                    } else {
                        emptyBoard.setDead(r,c);
                    }
                } else if (board.getCell(r,c) == DEAD) {
                    if (aliveNeighbors == 3) {
                        emptyBoard.setAlive(r,c);
                    } else {
                        emptyBoard.setDead(r,c);
                    }
                }

                aliveNeighbors = 0;

            }
        }

        return emptyBoard;
    }

    public static void sleep() throws InterruptedException {
        Thread.sleep(100);
    }
}
