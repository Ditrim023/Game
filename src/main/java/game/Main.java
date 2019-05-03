package game;

/**
 * value in the input file
 * 13  //required not less than 13
 * 25 //required not less than 13
 * 8
 * XXXXXXXXX
 * XXXXXXXXX
 * XXXXXXXXX
 * XXXXXXXXX
 * XXXXXXOOO
 * XXXXXXOOO
 * XXXXXXOOO
 *
 * for correct display of information in output file field size must be not less than 13
 */

public class Main {
    public static void main(String[] args) {
        ReadFileInfo read = new ReadFileInfo();
        read.readFromFile();//read data from file
        FillArr fillArr = new FillArr();
        read.setCurrentIteration(fillArr.getArr(read.getSIZE_X(),read.getSIZE_Y(), read.getTempMass())); //fill arrays
        read.setNextIteration(fillArr.getArr(read.getSIZE_X(),read.getSIZE_Y(), read.getTempMass()));//fill arrays
        LoopGame loopGame = new LoopGame(read.getSIZE_X(),read.getSIZE_Y(),read.getCurrentIteration(),read.getNextIteration());// create game with fields
        loopGame.startGame(read.getCountIteration()); // game start
    }
}
