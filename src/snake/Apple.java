package snake;

// класс который будет есть Snake
public class Apple {
    Point coord;
    int weight;

    public Apple() {
        this.coord = new Point(0,0);
        this.weight = 1;
    }
}
