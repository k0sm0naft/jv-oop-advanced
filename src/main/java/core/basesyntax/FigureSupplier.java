package core.basesyntax;

import java.util.Random;

public class FigureSupplier {
    private static final int FIGURE_COUNT = 5;
    private final Random random = new Random();

    public Figure getRandomFigure() {
        ColorSupplier cs = new ColorSupplier();
        return switch (random.nextInt(FIGURE_COUNT + 1)) {
            case 1 -> new Square(cs.getRandomColor(), getRandomDouble());
            case 2 -> new Rectangle(cs.getRandomColor(), getRandomDouble(), getRandomDouble());
            case 3 -> new RightTriangle(cs.getRandomColor(), getRandomDouble(), getRandomDouble());
            case 4 -> new Circle(cs.getRandomColor(), getRandomDouble());
            case 5 -> new IsoscelesTrapezoid(
                    cs.getRandomColor(), getRandomDouble(), getRandomDouble(), getRandomDouble());
            default -> getDefaultFigure();
        };
    }

    private double getRandomDouble() {
        return Math.round(random.nextDouble() * 100);
    }

    public Figure getDefaultFigure() {
        return new Circle(Color.WHITE, 10);
    }
}
