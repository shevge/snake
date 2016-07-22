package snake;

// класс оперирующий процессом игры
public  class Game {
    Snake snake;
    Apple apple;
    Field field;

    public Game() {
        snake = new Snake();
        apple = new Apple();
        field = new Field();
    }

    public void start() {
        // основная логика игры
    }
}
