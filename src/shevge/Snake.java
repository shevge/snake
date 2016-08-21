package shevge;

import java.util.ArrayList;

// класс охотника за яблоками
public class Snake {
    public ArrayList<Point> bodyParts;

    public Snake() {
        // Инициализируем части тела пустым массивом
        bodyParts = new ArrayList<>();

        // Добавили голову первой, по умолчанию (добавляем рост в конец)
        bodyParts.add(new Point(2, 2));

        // Добавляем тело змеи
        bodyParts.add(new Point(3, 2));
        bodyParts.add(new Point(3, 3));
        bodyParts.add(new Point(3, 4));
   }

   public int getSize() {
       return bodyParts.size();
   }

   // Возвращает координаты и'той части тела
   public Point getBodyPart(int i) {
       return bodyParts.get(i);
   }
}