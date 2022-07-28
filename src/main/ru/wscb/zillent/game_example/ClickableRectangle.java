package ru.wscb.zillent.game_example;

public class ClickableRectangle extends Rectangle implements Clickable {
    public ClickableRectangle(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public boolean isCoordsIn(int x, int y) {
        if (x<this.x) return false;
        if (y<this.y) return false;
        if (x>this.x + this.width) return false;
        if (y>this.y + this.height) return false;
        return true;
    }
}
