package ru.wscb.zillent.game_example;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

class MoveableFiguresListTest {

    @Test
    void getMoveableFigures() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        MoveableFiguresList moveableFiguresList = new MoveableFiguresList(new FiguresTypes());
        moveableFiguresList.regenerate();
        List<Moveable> moveableFigures = moveableFiguresList.getMoveableFigures();
        int figuresCount = moveableFigures.size();
        assertThat(figuresCount, CoreMatchers.is(10));
        for (int i=0; i<figuresCount; i++) {
            assertThat(moveableFigures.get(0).toString(), CoreMatchers.anyOf(
                    CoreMatchers.containsString("Circle"),
                    CoreMatchers.containsString("Rectangle"),
                    CoreMatchers.containsString("Square")
            ));
        }
    }
}