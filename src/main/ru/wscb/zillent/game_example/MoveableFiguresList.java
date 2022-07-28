package ru.wscb.zillent.game_example;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MoveableFiguresList {
    private List<Moveable> moveableFigures = new ArrayList<>();

    public MoveableFiguresList(String[] figureTypes) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
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
