package ru.job4j.list;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConvertList {
    /**
     * Конвертирует список массивов в один большой список
     * @param list список массивов
     * @return объедененный список
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] i: list) {
            for (int j: i) {
                result.add(j);
            }
        }
        return result;
    }
}
