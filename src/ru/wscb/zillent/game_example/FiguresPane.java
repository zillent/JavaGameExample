package ru.wscb.zillent.game_example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class FiguresPane extends JPanel {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 50;
    public List<GameFigure> clickableFigures = new ArrayList<>();

    // FIXME: Dependency Injection Constructor
    FiguresPane() {
        Circle circle = new Circle("Circle", 10, 0, 20);
        this.clickableFigures.add(circle);
        Rectangle rectangle = new Rectangle("Rectangle", 70, 10, 40, 20);
        this.clickableFigures.add(rectangle);
        Square square = new Square("Square", 130, 0, 40);
        this.clickableFigures.add(square);
    }
    @Override
    public Dimension getPreferredSize () {
        return new Dimension ( WIDTH, HEIGHT );
    }

    @Override
    protected void paintComponent ( Graphics g ) {
        super.paintComponent ( g );
        g.setColor ( Color.GREEN);
        clickableFigures.forEach( figure -> ((GameFigure) figure).plot(g));
    }
}
