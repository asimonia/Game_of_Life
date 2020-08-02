package life;

import java.util.Random;

import static life.Symbol.*;

public class Universe {

    private Symbol[][] matrix;
    private final int N;

    public Universe(int N) {
        this.N = N;
        createUniverse();
    }

    private void createUniverse() {
        Random random = new Random();
        matrix = new Symbol[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = random.nextBoolean() ? ALIVE : DEAD;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(matrix[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getDimension() {
        return N;
    }

    public Symbol getCell(int r, int c) {
        if (r < 0) {
            r = N - 1;
        } else if (r == N) {
            r = 0;
        }
        if (c < 0) {
            c = N - 1;
        } else if (c == N) {
            c = 0;
        }
        return matrix[r][c];
    }

    public void setDead(int r, int c) {
        matrix[r][c] = DEAD;
    }

    public void setAlive(int r, int c) {
        matrix[r][c] = ALIVE;
    }

    public int countAlive() {
        int alive = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == ALIVE)
                    alive++;
            }
        }
        return alive;
    }

    public Symbol[][] getMatrix() {
        return matrix;
    }
}
