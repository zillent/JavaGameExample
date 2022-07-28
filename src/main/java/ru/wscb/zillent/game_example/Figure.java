package ru.wscb.zillent.game_example;

public abstract class Figure {
    public int x;
    public int y;
    public String name;

    public Figure(String name, int x, int y) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}

