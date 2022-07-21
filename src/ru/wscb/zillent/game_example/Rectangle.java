package ru.wscb.zillent.game_example;

import java.awt.*;

public class Rectangle extends Figure implements GameFigure{
  public int width;
  public int height;

    public Rectangle(String name, int x, int y) {
        super(name, x, y);
        this.width = 40;
        this.height = 20;
    }

    public Rectangle(String name, int x, int y, int width, int height) {
        super(name, x, y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Rectangle name:%s, x:%s, y:%s, width:%s, height:%s", name, x, y, width, height);
    }

    @Override
    public void plot(Graphics g) {
        g.fillRect(x, y, width, height);
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
        if (x>this.x + this.width) return false;
        if (y>this.y + this.height) return false;
        return true;
    }
}
