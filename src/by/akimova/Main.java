package by.akimova;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Integer array[] = new Integer[]{1, 4, 2, 8, 6, 2, 0, 3, 5, 7};

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                for (int left = 0; left < array.length; left++) {
                    // Вытаскиваем значение элемента
                    int value = array[left];
                    // Перемещаемся по элементам, которые перед вытащенным элементом
                    int i = left - 1;
                    for (; i >= 0; i--) {
                        // Если вытащили значение меньшее — передвигаем больший элемент дальше
                        if (value < array[i]) {
                            array[i + 1] = array[i];
                        } else {
                            // Если вытащенный элемент больше — останавливаемся
                            break;
                        }
                    }
                    // В освободившееся место вставляем вытащенное значение
                    array[i + 1] = value;
                }
                return integer.compareTo(t1);
            }
        };

        Arrays.sort(array, comparator);
        System.out.println(Arrays.toString(array));

    }
}
