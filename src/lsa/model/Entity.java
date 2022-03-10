package lsa.model;

public class Entity {
    private char symbol;
    private boolean isBegin;
    private int stage;

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isBegin() {
        return isBegin;
    }

    public void setBegin(boolean begin) {
        isBegin = begin;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }


    public Entity(char symbol, boolean isBegin, int stage) {
        this.symbol = symbol;
        this.isBegin = isBegin;
        this.stage = stage;
    }
}
