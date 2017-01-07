package backtrack;

import java.util.ArrayList;

public class Road {

    private final ArrayList<Field> road = new ArrayList();

    private int length;
    private int value;

    public Road() {
        length = 0;
        value = 0;
    }

    public void add(final Field f) {
        road.add(f);

        // update length
        length++;

        // update value
        if(f.getValue() > 0)
            value += f.getValue();
    }

    public void remove(final Field f) {
        if(road.isEmpty())
            return;

        road.remove(f);

        // update length
        length--;

        // update value
        if(f.getValue() > 0)
            value -= f.getValue();
    }

    public Road cloneRoad() {
        final Road tempRoad = new Road();

        for(final Field f : road)
            tempRoad.add(new Field(f.getX(), f.getY(), f.getValue()));

        return tempRoad;
    }

    public void applyRoad(final Field[][] map) {
        final Field[][] tempMap = Map.cloneMap(map);

        for(final Field f : road)
            tempMap[f.getY()][f.getX()].setValue(88);

        Map.printMap(tempMap);

    }

    public int getValue() { return this.value; }
    public int getLength() { return this.length; }
}
