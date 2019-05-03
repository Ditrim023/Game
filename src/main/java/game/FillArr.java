package game;


public class FillArr {

    public char[][] getArr(int x, int y, char[][] tem) {
        char[][] result = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                result[i][j] = 'X';
            }
        }
        for (int i = 0; i < tem.length; i++) {
            System.arraycopy(tem[i], 0, result[i], 0, tem[i].length);
        }

        return result;
    }
}
