package ru.wscb.zillent.game_example;

import org.hamcrest.CoreMatchers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClickableFiguresListTest {
    @org.junit.jupiter.api.Test
    void getClickableFigures() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ClickableFiguresList clickableFiguresList = new ClickableFiguresList(new FiguresTypes());
        List<Clickable> clickableFigures = clickableFiguresList.getClickableFigures();
        assertThat(clickableFigures.size(), CoreMatchers.is(3));
        int i = 0;
        assertThat(clickableFigures.get(i).toString(),
                CoreMatchers.is("Square name:Square, x:"+(10+60*i)+", y:0, size:40"));
        i++;
        assertThat(clickableFigures.get(i).toString(),
                CoreMatchers.is("Rectangle name:Rectangle, x:"+(10+60*i)+", y:0, width:40, height:20"));
        i++;
        assertThat(clickableFigures.get(i).toString(),
                CoreMatchers.is("Circle name:Circle, x:"+(10+60*i)+", y:0, radius:20"));
        i++;
    }
}