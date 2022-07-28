package ru.wscb.zillent.game_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClickableFiguresList {
    private List<Clickable> clickableFigures = new ArrayList<>();

    public ClickableFiguresList(FiguresTypes figuresTypesObj) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] figureTypes = figuresTypesObj.getFigureTypes();
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
