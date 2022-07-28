package ru.wscb.zillent.game_example;

import org.hamcrest.CoreMatchers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClickableFiguresListTest {
    @org.junit.jupiter.api.Test
    void getClickableFigures() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ClickableFiguresList clickableFiguresList = new ClickableFiguresList(new String[]{"Rectangle", "Square", "Circle"});
        List<Clickable> clickableFigures = clickableFiguresList.getClickableFigures();
        assertThat(clickableFigures.size(), CoreMatchers.is(3));
        assertThat(clickableFigures.get(0).toString(), CoreMatchers.is("Rectangle name:Rectangle, x:10, y:0, width:40, height:20"));
        assertThat(clickableFigures.get(1).toString(), CoreMatchers.is("Square name:Square, x:70, y:0, size:40"));
        assertThat(clickableFigures.get(2).toString(), CoreMatchers.is("Circle name:Circle, x:130, y:0, radius:20"));
    }
}