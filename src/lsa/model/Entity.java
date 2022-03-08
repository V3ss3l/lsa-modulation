package lsa.model;

public class Entity {
    private char symbol;
    private boolean isBegin;
    private int stage;
    // private boolean isEntrance;
    private int positionInArr;

    public Entity(char symbol, boolean isBegin, int stage, int positionInArr) {
        this.symbol = symbol;
        this.isBegin = isBegin;
        this.stage = stage;
        // this.isEntrance = isEntrance;
        this.positionInArr = positionInArr;
    }
}
