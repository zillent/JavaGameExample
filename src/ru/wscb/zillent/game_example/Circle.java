package ru.wscb.zillent.game_example;

import java.awt.*;

public class Circle extends Figure implements GameFigure {

    int radius;

    public Circle(String name, int x, int y) {
        super(name, x, y);
        this.radius = 20;
    }

    public Circle(String name, int x, int y, int radius) {
        super(name, x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("Circle name:%s, x:%s, y:%s, radius:%s", name, x, y, radius);
    }

    @Override
    public void plot(Graphics g) {
        g.fillOval(x, y, 2*radius, 2*radius);
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
        if (x>this.x + 2*this.radius) return false;
        if (y>this.y + 2*this.radius) return false;
        return true;
    }
}

