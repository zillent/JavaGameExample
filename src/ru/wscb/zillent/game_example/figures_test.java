package ru.wscb.zillent.game_example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class figures_test {
    public static Figure figureFactory(String name, int x, int y, String figureType) {
        if (figureType == "Rectangle") return new Rectangle(name, x, y);
        if (figureType == "Square") return  new Square(name, x, y);
        return null;
    }
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<Figure>();
        figures.add(new Rectangle("Rectangle 1", 10, 10, 35, 40));
        figures.add(new Square("Square 1", 10, 10, 50));

        Square square = new Square("Square 2", 10,10,40);

        figures.add(square);

        figures.add(figureFactory("rect 1", 10,10, "Rectangle"));
        figures.add(figureFactory("sq 1", 10,10, "Square"));
        System.out.println();
        figures.forEach(System.out::println);
    }
}
