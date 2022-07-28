package ru.wscb.zillent.game_example;

import java.lang.reflect.InvocationTargetException;

public class figureFactory {
    public static GameFigure getFigure(String name, int x, int y, String figureType, String figureInterface) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("ru.wscb.zillent.game_example."+ figureInterface + figureType);
        Class[] parsClasses = {String.class, int.class, int.class};
        return (GameFigure) c.getConstructor(parsClasses).newInstance(name, x, y);
    }


}
