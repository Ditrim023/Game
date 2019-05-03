package game;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class ReadFileInfo {
    private int SIZE_X;
    private int SIZE_Y;
    private int countIteration;
    private char[][] currentIteration = new char[SIZE_X][SIZE_Y];
    private char[][] nextIteration = new char[SIZE_X][SIZE_Y];
    char[][] tempMass;

    public void readFromFile() {
        File file = new File("src/main/resources/files/in.txt");
        List<String> stringList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringList.add(line.trim());
            }
            reader.close();
        } catch (IOException e) {
        }
        SIZE_X = Integer.parseInt(stringList.get(0));
        SIZE_Y = Integer.parseInt(stringList.get(1));
        countIteration = Integer.parseInt(stringList.get(2));
        List<String> forChar = new ArrayList<>();
        for (int i = 2; i < stringList.size(); i++) {
            forChar.add(stringList.get(i));
        }
        tempMass = new char[forChar.size()][];
        for (int i = 0; i < forChar.size(); i++) {
            tempMass[i] = forChar.get(i).toCharArray();
        }
    }
}
