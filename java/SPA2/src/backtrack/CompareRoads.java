package backtrack;

import java.util.Comparator;

/**
 * Created by Rastko on 12-Dec-16.
 */
public abstract class CompareRoads implements Comparator<Road> {

    public abstract int compare(final Road r1, final Road r2);

}
