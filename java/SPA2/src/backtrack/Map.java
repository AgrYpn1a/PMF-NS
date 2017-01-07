package backtrack;

import org.svetovid.Svetovid;

/**
 * Created by Rastko on 12-Dec-16.
 */
public class Map {

    private final Field[][] map;

    public Map(final String fileName) {
        map = scanMap(fileName);
    }

    public static void printMap(final Field[][] map) {
        for(int y=0; y<map.length; y++) {
            for(int x=0; x<map[0].length; x++) {
                System.out.printf("%1$5d", map[y][x].getValue());
            }
            System.out.println();
        }
    }

    public static Field[][] cloneMap(final Field[][] map) {
        final int height = map.length;
        final int width = map[0].length;

        final Field[][] tempMap = new Field[height][width];

        for(int y=0; y<height; y++) {
            for(int x=0; x<width; x++) {
                tempMap[y][x] = new Field(map[y][x].getX(), map[y][x].getY(), map[y][x].getValue());
            }
        }

        return tempMap;
    }

    private Field[][] scanMap(final String fileName) {
        if(!Svetovid.testIn(fileName))
            throw new RuntimeException("Something wrong with the file");

        final int width = Svetovid.in(fileName).readInt();
        final int height = Svetovid.in(fileName).readInt();

        final Field[][] tempMap = new Field[height][width];

        for(int y=0; y<height; y++) {
            for(int x=0; x<width; x++) {
                tempMap[y][x] = new Field(x, y, Svetovid.in(fileName).readInt());
            }
        }

        return tempMap;
    }

    public Field[][] getMap() {
        return map;
    }

}
