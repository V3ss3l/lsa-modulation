package lsa.model;

public class Entity {
    private final char symbol;
    private final boolean isBegin;
    private final int stage;

    public char getSymbol() {
        return symbol;
    }

    public boolean isBegin() {
        return isBegin;
    }

    public int getStage() {
        return stage;
    }

    public Entity(char symbol, boolean isBegin, int stage) {
        this.symbol = symbol;
        this.isBegin = isBegin;
        this.stage = stage;
    }
}
