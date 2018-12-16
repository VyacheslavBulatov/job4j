package ru.job4j.loop;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Построение пирамиды с заданной высотой из символов "^" и пробелов
     * @param h высота пирамиды
     * @return пирамида
     */
    public String piramid(int h) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h + i; j++) {
                if (j < (h - i - 1)) {
                    screen.append(" ");
                } else {
                    screen.append("^");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
