package ru.wscb.zillent.game_example;


import java.awt.*;

public class Square extends Figure implements GameFigure{
    int size;

    public Square(String name, int x, int y) {
        super(name, x, y);
        this.size = 40;
    }

    public Square(String name, int x, int y, int size) {
        super(name, x, y);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Square name:%s, x:%s, y:%s, size:%s", name, x, y, size);
    }

    @Override
    public void plot(Graphics g) {
        g.fillRect(x, y, size, size);
    }

    @Override
    public void moveBy(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    @Override
    public void rotate(int speed) {

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
