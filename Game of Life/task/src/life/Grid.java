package life;

import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {

    private static final int width = 5;
    private static final int height = 5;
    private int N;
    private Symbol[][] matrix;


    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (matrix[r][c] == Symbol.ALIVE) {
                    g2.fillRect(c * width,r * height, width, height);
                } else {
                    g2.drawRect(c * width,r * height, width, height);
                }
            }
        }

    }

    public void setUniverse(Universe u) {
        setN(u.getDimension());
        setMatrix(u.getMatrix());
    }

    public void setN(int n) {
        this.N = n;
    }

    public void setMatrix(Symbol[][] matrix) {
        this.matrix = matrix;
    }
}
