package backtrack;

import java.util.ArrayList;

/**
 * Created by Rastko on 12-Dec-16.
 */
public class MainBacktrack {

    private final static int WALL = -11;
    private final static int EXIT = -99;
    private final static int HOLE = -1;

    private final static Road road = new Road();
    private final static ArrayList<Road> roads = new ArrayList<>();

    private static boolean findRoad(final Field[][] map, final int x, final int y) {
        final int height = map.length;
        final int width = map[0].length;

        if(x < 0 || x > width - 1 || y < 0 || y > height - 1)
            return false;

        if(map[y][x].getValue() == EXIT) {
            System.out.println("Found a road!");
            roads.add(road.cloneRoad());
            return true;
        }

        if(map[y][x].getValue() == WALL)
            return false;

        if(map[y][x].isVisited())
            return false;

        map[y][x].setVisited(true);
        road.add(map[y][x]);

        if(findRoad(map, x + 1, y))
            return true;

        if(findRoad(map, x, y + 1))
            return true;

        if(findRoad(map, x - 1, y))
            return true;

        if(findRoad(map, x, y - 1))
            return true;

        map[y][x].setVisited(false);
        road.remove(map[y][x]);

        return false;
    }

    private static int holeCounter = 0;

    private static void findAllRoads(final Field[][] map, final int x, final int y) {
        final int height = map.length;
        final int width = map[0].length;

        // check if we're still in map
        if(x < 0 || x > width - 1 || y < 0 || y > height - 1)
            return;

        // check if we found exit
        if(map[y][x].getValue() == EXIT) {
            roads.add(road.cloneRoad());
            return;
        }

        // check if we hit a wall
        if(map[y][x].getValue() == WALL)
            return;

        // check if we found a hole
        if(map[y][x].getValue() == HOLE) {
            // found a hole, we increase the counter but continue
            holeCounter++;

            if(holeCounter > 1) {
                holeCounter = 0;
                return;
            }
        }

        // check if we visited this already
        if(map[y][x].isVisited())
            return;

        map[y][x].setVisited(true);
        road.add(map[y][x]);

        findAllRoads(map, x + 1, y);

        findAllRoads(map, x, y + 1);

        findAllRoads(map, x - 1, y);

        findAllRoads(map, x, y - 1);

        map[y][x].setVisited(false);
        road.remove(map[y][x]);

        // if it was a hole, decrement hole count
        if(map[y][x].getValue() == HOLE)
            holeCounter--;
    }

    private static void shortestRoad(final Map map) {

        final CompareRoadsByLength cmp = new CompareRoadsByLength();
        Road min = roads.get(0);

        for(final Road r : roads)
            if(cmp.compare(r, min) < 0)
                min = r;

        min.applyRoad(Map.cloneMap(map.getMap()));
    }

    public static void main(String[] args) {
        final Map map = new Map("lav-rupe.txt");
        Map.printMap(map.getMap());

        findAllRoads(Map.cloneMap(map.getMap()), 0, 0);

        for(final Road r : roads) {
            System.out.println("Found a road!");
            r.applyRoad(Map.cloneMap(map.getMap()));
        }

        System.out.println("Shortest road: ");
        shortestRoad(map);
    }

}
