package ru.wscb.zillent.game_example;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class FiguresPaneTest {
    private FiguresPane figuresPane;
    private ClickableSquare clickableSquare = Mockito.mock(ClickableSquare.class);
    private ClickableRectangle clickableRectangle = Mockito.mock(ClickableRectangle.class);
    private ClickableCircle clickableCircle = Mockito.mock(ClickableCircle.class);

    @BeforeEach
    void setUp() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Clickable> clickableFigures = new ArrayList<Clickable>();
        clickableFigures.add(clickableSquare);
        clickableFigures.add(clickableRectangle);
        clickableFigures.add(clickableCircle);
        figuresPane = new FiguresPane(clickableFigures);
    }

    @Test
    void paintComponent() throws InterruptedException {
        JFrame frame = new JFrame ( "Test Game Example" );
        frame.setContentPane(figuresPane);
        frame.pack ();
        frame.setVisible ( true );
        Thread.sleep(100);
        Mockito.verify(clickableRectangle, atLeast(1)).plot(Mockito.any());
        Mockito.verify(clickableCircle, atLeast(1)).plot(Mockito.any());
        Mockito.verify(clickableSquare, atLeast(1)).plot(Mockito.any());
    }

    @Test
    void getPreferredSize() {
        Dimension dimension = figuresPane.getPreferredSize();
        assertThat(dimension.getHeight(), CoreMatchers.is(50.0));
        assertThat(dimension.getWidth(), CoreMatchers.is(400.0));
    }
}