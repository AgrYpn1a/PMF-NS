package backtrack;

public class Field {

    private final int x;
    private final int y;
    private int value;

    private boolean visited = false;

    public Field(final int x, final int y, final int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    // getters
    public int getX() { return this.x; }
    public int getY() { return this.y ; }
    public int getValue() { return this.value; }

    public boolean isVisited() { return this.visited; }

    // setters
    public void setVisited(final boolean visited) {
        this.visited = visited;
    }

    public void setValue(final int value) {
        this.value = value;
    }

}
