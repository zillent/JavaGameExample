package ru.wscb.zillent.game_example;

import java.awt.*;

public interface GameFigure {
    public void plot(Graphics g);
    public void moveBy(int x, int y);
    public void rotate(int speed);
    public boolean isCoordsIn(int x, int y);
}
