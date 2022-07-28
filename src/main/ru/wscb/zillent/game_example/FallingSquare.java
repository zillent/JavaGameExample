package ru.wscb.zillent.game_example;

public class FallingSquare extends Square implements Moveable{
    public FallingSquare(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void moveBy(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }
}
