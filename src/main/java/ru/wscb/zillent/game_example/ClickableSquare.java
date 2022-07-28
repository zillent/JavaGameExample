package ru.wscb.zillent.game_example;

public class ClickableSquare extends Square implements Clickable{
    public ClickableSquare(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public boolean isCoordsIn(int x, int y) {
        if (x<this.x) return false;
        if (y<this.y) return false;
        if (x>this.x + this.size) return false;
        if (y>this.y + this.size) return false;
        return true;
    }
}
