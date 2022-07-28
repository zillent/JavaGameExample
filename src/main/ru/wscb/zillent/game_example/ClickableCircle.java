package ru.wscb.zillent.game_example;

public class ClickableCircle extends Circle implements Clickable{
    public ClickableCircle(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public boolean isCoordsIn(int x, int y) {
        if (x<this.x) return false;
        if (y<this.y) return false;
        if (x>this.x + 2*this.radius) return false;
        if (y>this.y + 2*this.radius) return false;
        return true;
    }
}
