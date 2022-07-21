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
    public int figureIndex = 0;
    private List<GameFigure> figures = new ArrayList<>();

    private static final int GAP = 5;
    private String[] figureTypes = {"Square", "Rectangle", "Circle"};
    private int triesCount = 0;
    private int guessedCount = 0;
    private DrawingBoard board = null;
    private boolean isGuessed = false;

    private GameFigure figureFactory(String name, int x, int y, String figureType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("ru.wscb.zillent.game_example." + figureType);
        Class[] parsClasses = {String.class, int.class, int.class};
        return (GameFigure) c.getConstructor(parsClasses).newInstance(name, x, y);
    }

    //FIXME: Single Responsibility
    private void displayGUI () throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        JFrame frame = new JFrame ( "" );
        frame.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );
        JPanel contentPane = new JPanel ();
        contentPane.setLayout ( new BorderLayout ( GAP, GAP ) );
        drawingBoard = new DrawingBoard ();
        contentPane.add ( drawingBoard, BorderLayout.CENTER );

// FIXME: Dependency Inversion
        JPanel figuresContentPane = new FiguresPane();

        figuresContentPane.addMouseListener(new MouseAdapter() {
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
//                                                                    figure.moveBy(0, -10);
                                                                    figuresContentPane.repaint(0,0,200,50);
                                                                }
                                                            });
                                                    if (board != null) board.changeCounts(triesCount, guessedCount);
                                                }
                                            });

        JPanel buttonContentPane = new JPanel ();
        buttonContentPane.add ( figuresContentPane, BorderLayout.NORTH );
        button = new JButton ( "Start" );
        button.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent ae ) {
                board = ( DrawingBoard ) drawingBoard;
                button.setEnabled(false);
                figureIndex = 0;
                triesCount = 0;
                guessedCount = 0;
                try {
                    for (int i=0; i<10; i++) {
                        String figureType = figureTypes[(int) Math.round(Math.random()*(figureTypes.length-1))];
                        figures.add(figureFactory(figureType, 200, 10, figureType));
                    }
                } catch (Exception e) {e.printStackTrace();};
                board.setFigures(figures);

                Timer timer = new Timer(1000/20,
                        new ActionListener() {
                            @Override
                            public void actionPerformed ( ActionEvent e ) {
                                board.setState (figureIndex);
                                if (((Figure)figures.get(figureIndex)).getY()>250) {
                                    figureIndex++;
                                    isGuessed = false;
                                }
                                if (figureIndex >= figures.size()) {
                                    ((Timer) e.getSource()).stop();
                                    button.setEnabled(true);
                                }
                            }
                        });
                timer.start();
            }
        } );
        buttonContentPane.add ( button, BorderLayout.SOUTH );

        contentPane.add(buttonContentPane, BorderLayout.PAGE_END);
        frame.setContentPane ( contentPane );
        frame.pack ();
        frame.setLocationByPlatform ( true );
        frame.setVisible ( true );

    }

    public static void main ( String [] args ) {
        Runnable runnable = new Runnable () {
            @Override
            public void run () {
                try {
                    new GameExample().displayGUI ();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        };
        EventQueue.invokeLater ( runnable );
    }
}

