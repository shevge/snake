package shevge;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Random;

public class Game extends Application {
    private Snake snake;
    private Apple apple;
    private Drawer ann;

    // public static void main() в javaFX
    @Override
    public void start(Stage window) {
        ann = new Drawer();
        snake = new Snake();
        apple = null;

        // Меняем заголовок окна
        window.setTitle("SnakeFx");

        // Повесили канвас на корневой элемент
        Group root = new Group();
        root.getChildren().add(ann.getCanvas());
        // Повесили корневой элемент на окно
        window.setScene(new Scene(root));

        // Эта конструкция для тебя пока что непонятна
        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {

            // ------------------------- Главный цикл игры ------------------------- //
            public void handle(long currentNanoTime) {
                // ----- Считывание нажатых клавиш -----

                // ----- Обновление объектов -----
                Random rnd = new Random();
                if (rnd.nextInt() % 135 == 0) {
                    // Инициализация рандомного (случайного) яблока
                    Point p = new Point((rnd.nextInt() % 10) * 25, (rnd.nextInt() % 10) * 25);
                    int weight = Math.abs(rnd.nextInt() % 3);
                    apple = new Apple(p, weight);
                }

                // ----- Отрисовка объекоов -----
                ann.clearCanvas();
                ann.drawCoordinateLines();
                ann.drawSnake(snake);
                if (apple != null)
                    ann.drawApple(apple);
            }
            // ------------------------- Главный цикл игры ------------------------- //
        }.start();

        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

