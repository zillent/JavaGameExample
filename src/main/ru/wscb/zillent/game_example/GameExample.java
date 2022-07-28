package ru.wscb.zillent.game_example;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class GameExample {

    private JPanel drawingBoard;
    private JButton button;
    private int figureIndex = 0;
    private List<Moveable> figures = new ArrayList<>();
    private static final int GAP = 5;
    private final String[] figureTypes = {"Square", "Rectangle", "Circle"};
    private int triesCount = 0;
    private int guessedCount = 0;
    private DrawingBoard board = null;
    private boolean isGuessed = false;
    private JPanel figuresContentPane;

    private MouseAdapter getMouseAdapter() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                triesCount++;
                ((FiguresPane) figuresContentPane).clickableFigures.forEach(
                        figure -> {
                            if (figures.size()<=figureIndex) return;
                            if (!figure.isCoordsIn(e.getX(), e.getY())) return;
                            if (((Figure)figures.get(figureIndex)).name == ((Figure)figure).name && !isGuessed) {
                                guessedCount++;
                                isGuessed = true;
// FIXME: ISP Bad example
// FIXED: Cannot compile this
//figure.moveBy(0, -10);
                                figuresContentPane.repaint(0,0,200,50);
                            }
                        });
                if (board != null) board.changeCounts(triesCount, guessedCount);
            }
        };
    }

    private ActionListener getTimerListener() {
        return e -> {
            board.tick(figureIndex);
            if (((Figure)figures.get(figureIndex)).getY()>250) {
                figureIndex++;
                isGuessed = false;
            }
            if (figureIndex >= figures.size()) {
                ((Timer) e.getSource()).stop();
                button.setEnabled(true);
            }
        };
    }

    private ActionListener getBtnListener() {
        return ae -> {
            board = ( DrawingBoard ) drawingBoard;
            button.setEnabled(false);
            figureIndex = 0;
            triesCount = 0;
            guessedCount = 0;
            try {
                figures = new MoveableFiguresList(figureTypes).getMoveableFigures();
                board.setFigures(figures);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Timer timer = new Timer(1000/20, getTimerListener());
            timer.start();
        };
    }

    //FIXME: Single Responsibility
    private void displayGUI () throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        JFrame frame = new JFrame ( "Game Example" );
        frame.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );
        JPanel contentPane = new JPanel ();
        contentPane.setLayout ( new BorderLayout ( GAP, GAP ) );
        drawingBoard = new DrawingBoard ();
        contentPane.add ( drawingBoard, BorderLayout.CENTER );
// FIXME: Dependency Inversion
        figuresContentPane = new FiguresPane(new ClickableFiguresList(figureTypes).getClickableFigures());
        figuresContentPane.addMouseListener(getMouseAdapter());
        JPanel buttonContentPane = new JPanel ();
        buttonContentPane.add ( figuresContentPane, BorderLayout.NORTH );
        button = new JButton ( "Start" );
        button.addActionListener (getBtnListener());
        buttonContentPane.add ( button, BorderLayout.SOUTH );
        contentPane.add(buttonContentPane, BorderLayout.PAGE_END);
        frame.setContentPane ( contentPane );
        frame.pack ();
        frame.setLocationByPlatform ( true );
        frame.setVisible ( true );
    }

    public static void main ( String [] args ) {
        Runnable runnable = () -> {
            try {
                new GameExample().displayGUI ();
            } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        };
        EventQueue.invokeLater ( runnable );
    }
}

