package ru.wscb.zillent.game_example;

import org.springframework.stereotype.Component;

@Component
public class FiguresTypes {
    private final String[] figureTypes = {"Square", "Rectangle", "Circle"};

    public String[] getFigureTypes() {
        return figureTypes;
    }
}
