package backtrack;

/**
 * Created by Rastko on 12-Dec-16.
 */
public class CompareRoadsByValue extends CompareRoads {
    @Override
    public int compare(Road r1, Road r2) {
        return r1.getValue() - r2.getValue();
    }
}
