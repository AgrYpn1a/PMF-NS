package backtrack;

/**
 * Created by Rastko on 12-Dec-16.
 */
public class CompareRoadsByLength extends CompareRoads {
    @Override
    public int compare(Road r1, Road r2) {
        return r1.getLength() - r2.getLength();
    }
}
