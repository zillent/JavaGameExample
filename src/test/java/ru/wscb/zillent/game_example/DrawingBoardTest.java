package ru.wscb.zillent.game_example;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.atLeast;

class DrawingBoardTest {
    private DrawingBoard drawingBoard;
    private FallingSquare fallingSquare = Mockito.mock(FallingSquare.class);
    private FallingRectangle fallingRectangle = Mockito.mock(FallingRectangle.class);
    private FallingCircle fallingCircle = Mockito.mock(FallingCircle.class);

    @BeforeEach
    void setUp() {
        List<Moveable> fallingFigures = new ArrayList<Moveable>();
        fallingFigures.add(fallingSquare);
        fallingFigures.add(fallingRectangle);
        fallingFigures.add(fallingCircle);
        drawingBoard = new DrawingBoard();
        drawingBoard.setFigures(fallingFigures);
    }

    @Test
    void paintComponent() throws InterruptedException {
        JFrame frame = new JFrame ( "Test Game Example" );
        frame.setContentPane(drawingBoard);
        frame.pack ();
        frame.setVisible ( true );
        drawingBoard.tick(0);
        Thread.sleep(10);
        Mockito.verify(fallingSquare, atLeast(1)).plot(Mockito.any());
        drawingBoard.tick(1);
        Thread.sleep(10);
        Mockito.verify(fallingRectangle, atLeast(1)).plot(Mockito.any());
        drawingBoard.tick(2);
        Thread.sleep(10);
        Mockito.verify(fallingCircle, atLeast(1)).plot(Mockito.any());
    }

    @Test
    void getPreferredSize() {
        Dimension dimension = drawingBoard.getPreferredSize();
        assertThat(dimension.getHeight(), CoreMatchers.is(300.0));
        assertThat(dimension.getWidth(), CoreMatchers.is(400.0));
    }
}