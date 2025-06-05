package org.example.lesson2_5;

public class ArrayInstrumental {
    public static void checkSize4x4(String[][] array) throws MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException("Размер массива по строкам должен быть 4, текущий: " + array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Размер массива по столбцам в строке " + i + " должен быть 4, текущий: " + array[i].length);
            }
        }

    }

    public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        checkSize4x4(array);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                String element = array[i][j];
                try {
                    int value = Integer.parseInt(element);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Некорректные данные в ячейке [" + i + "][" + j + "]: '" + element + "'"
                    );
                }
            }
        }
        return sum;
    }
}
