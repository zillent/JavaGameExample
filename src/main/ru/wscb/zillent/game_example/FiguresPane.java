package ru.wscb.zillent.game_example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class FiguresPane extends JPanel {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 50;
    public List<Clickable> clickableFigures;

    // FIXME: Dependency Injection Constructor
    FiguresPane(List<Clickable> clickableFigures) {
        this.clickableFigures = clickableFigures;
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
