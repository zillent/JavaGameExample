package ru.wscb.zillent.game_example;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MoveableFiguresList {
    String[] figureTypes;
    private List<Moveable> moveableFigures;

    public MoveableFiguresList(FiguresTypes figuresTypesObj) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        figureTypes = figuresTypesObj.getFigureTypes();
//        regenerate();
    }

    public void regenerate() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        moveableFigures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String figureType = figureTypes[(int) Math.round(Math.random() * (figureTypes.length - 1))];
            moveableFigures.add((Moveable) figureFactory.getFigure(figureType, 200, 10, figureType, "Falling"));
        }
    }

    public List<Moveable> getMoveableFigures() {
        return moveableFigures;
    }

    public void setMoveableFigures(List<Moveable> moveableFigures) {
        this.moveableFigures = moveableFigures;
    }
}
