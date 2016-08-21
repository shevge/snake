package shevge;

import com.sun.prism.Graphics;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Drawer {
    private Canvas canvas;
    private int center = 250;

    public Drawer() {
        canvas = new Canvas(center * 2, center * 2);
    }

    // Рисуем координатную сетку
    public void drawCoordinateLines() {
        for (int i = -250; i <= 250; i+= 25) {
            drawLine((new Point(-250, i)), new Point(250, i));
            drawLine((new Point(i, -250)), new Point(i, 250));
        }
    }

    // Рисуем змею
    public void drawSnake(Snake snake) {
        // Рисуем  динамическое тело
        for (int i = 0; i < snake.getSize();i++) {
            // Окрашиваем голову змеи в черный цвет, тело змеи - шоколадный цвет
            if (i == 0)
                changeBrush(Color.BLACK);
            else
                changeBrush(Color.CHOCOLATE);

            drawSquare(snake.getBodyPart(i));
        }
    }

    // Рисуем яблоко
    public void drawApple(Apple apple) {
        // Меняем кисть в зависимости от веса
        switch(apple.weight) {
            case 0:
                changeBrush(Color.GREEN);
                break;
            case 1:
                changeBrush(Color.YELLOW);
                break;
            case 2:
                changeBrush(Color.RED);
                break;
            default:
                System.out.println();
        }

        // Заполняем овал
        drawOval(apple.coord);

        // Меняем кисть обратно
        changeBrush(Color.BLACK);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void clearCanvas() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 500, 500);
    }

    // Рисуем линию
    private void drawLine(Point start, Point finish) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.strokeLine(center + start.x, center + start.y, center + finish.x, center + finish.y);
    }
    // Рисуем круг
    private void drawOval(Point p) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.fillOval(center + p.x, center + p.y, 25, 25);
    }
    // Рисуем квадрат
    private void drawSquare(Point p) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.fillRect(center + p.x * 25, center + p.y * 25, 25, 25);
    }
    // Меняем кисть (цвет)
    private void changeBrush(Color c) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(c);
    }

}
