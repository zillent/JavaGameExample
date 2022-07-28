package ru.wscb.zillent.game_example;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ClickableFiguresList {
    private List<Clickable> clickableFigures = new ArrayList<>();

    public ClickableFiguresList(String[] figureTypes) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (int i = 0; i<figureTypes.length; i++) {
            clickableFigures.add((Clickable) figureFactory.getFigure(figureTypes[i], 10+60*i, 0, figureTypes[i],"Clickable"));
        }
    }

    public List<Clickable> getClickableFigures() {
        return clickableFigures;
    }

    public void setClickableFigures(List<Clickable> clickableFigures) {
        this.clickableFigures = clickableFigures;
    }
}
