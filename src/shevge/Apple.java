package shevge;

// класс который будет есть Snake
public class Apple {
    public Point coord;
    public int weight;

    public Apple(Point p, int weight) {
        this.coord = p;
        this.weight = weight;
    }
}
