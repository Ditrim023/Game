package game;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Nikita Krutoguz
 */
@Getter
@Setter
class LoopGame {
    private int SIZE_X;
    private int SIZE_Y;
    private char[][] currentIteration;
    private char[][] nextIteration;

    LoopGame(int SIZE_X, int SIZE_Y, char[][] currentIteration, char[][] nextIteration) {
        this.SIZE_X = SIZE_X;
        this.SIZE_Y = SIZE_Y;
        this.currentIteration = currentIteration;
        this.nextIteration = nextIteration;
    }

    void startGame(int countIteration) {
        File file = new File("src/main/resources/files/out.txt");
        FileWriter writer;
        for (int iteration = 0; iteration < countIteration; iteration++) {
            for (int x = 0; x < SIZE_X; x++) {
                for (int y = 0; y < SIZE_Y; y++) {
                    int count = countNeighbors(x, y);
                    if (count == 3) {
                        this.nextIteration[x][y] = 'O';
                    } else if ((count < 2) || (count > 3)) {
                        this.nextIteration[x][y] = 'X';
                    } else {
                        this.nextIteration[x][y] = currentIteration[x][y];
                    }

                }
            }

            for (int i = 0; i < SIZE_X; i++) {
                System.arraycopy(this.nextIteration[i], 0, currentIteration[i], 0, SIZE_Y);
            }
        }

        try {
            writer = new FileWriter(file);
            for (int i = 0; i < currentIteration.length; i++) {
                for (int j = 0; j < currentIteration[i].length; j++) {
                    writer.write(currentIteration[i][j]);

                }
                writer.write("\r\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int countNeighbors(int x, int y) {
        int count = 0;
        for (int dx = -1; dx < 2; dx++) {
            for (int dy = -1; dy < 2; dy++) {
                int nX = x + dx;
                int nY = y + dy;
                if (nX < 0 || nX > SIZE_X - 1) {
                    nX = x;
                }
                if (nY < 0 || nY > SIZE_Y - 1) {
                    nY = y;
                }
                if (currentIteration[nX][nY] == 'O') {
                    count += 1;
                }
            }
        }
        if (currentIteration[x][y] == 'O') {
            count--;
        }
        return count;
    }
}
