package ru.wscb.zillent.game_example;

public class FallingCircle extends Circle implements Moveable{
    public FallingCircle(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void moveBy(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }
}
