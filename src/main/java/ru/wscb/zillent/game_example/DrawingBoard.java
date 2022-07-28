package ru.wscb.zillent.game_example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

class DrawingBoard extends JPanel {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private List<Moveable> figures;
    private int figureIndex = 0;
    private int triesCount = 0;
    private int guessedCount = 0;

    public void setFigures(List<Moveable> figures) {
        this.figures = figures;
    }

    public DrawingBoard () {
        setOpaque ( true );
    }

    public void changeCounts(int triesCount, int guessedCount) {
        this.triesCount = triesCount;
        this.guessedCount = guessedCount;
        repaint(300,10,400,70);
    }

    public void tick(int figureIndex) {
        this.figureIndex = figureIndex;
        Moveable figure = (Moveable) figures.get(figureIndex);
        figure.moveBy(0, 10);
        repaint(200,10,40,250);
    }

    private void drawFigure(GameFigure figure, Graphics g) {
        figure.plot(g);
    }
    @Override
    public Dimension getPreferredSize () {
        return new Dimension ( WIDTH, HEIGHT );
    }

    @Override
    protected void paintComponent ( Graphics g ) {
        super.paintComponent ( g );
        g.setColor(Color.BLUE);
        g.drawString("TRIES: "+this.triesCount, 300,20);
        g.drawString("GUESSED: "+this.guessedCount, 300,40);
        g.setColor ( Color.RED );
        if (figures == null) return;
        GameFigure figure = (GameFigure) figures.get(figureIndex);
        drawFigure( figure, g);
    }
}
