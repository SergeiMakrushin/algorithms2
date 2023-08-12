package com.example.algorithms2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArrayListR implements IntegerList {

    Integer[] arr;
    int sizeArr;


    public ArrayListR(int sizeArr) {
        this.sizeArr = sizeArr;
        this.arr = new Integer[sizeArr];

    }

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    public Integer[] grow(Integer[] arr) {
        int d = arr.length / 2;

        Integer[] temp = arr.clone();
        arr = new Integer[arr.length + d];
        System.arraycopy(temp, 0, arr, 0, temp.length);
        return arr;
//        arr = Arrays.copyOf(arr, arr.length + 1);

    }

    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new RuntimeException("Пустая Строка");
        }

        if (arr.length == 0) {
            arr = new Integer[5];
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = item;
                return arr[i];
            }
        }

        arr = grow(arr);

//        int d = arr.length / 2;
//        arr = Arrays.copyOf(arr, arr.length+d);

        for (int p = 0; p < arr.length; p++) {
            if (arr[p] == null) {
                arr[p] = item;
                break;
            }
        }

        return item;
    }

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public Integer add(int index, Integer item) {
        if (item == null) {
            throw new RuntimeException("Пустая Строка");
        }
        if (index > arr.length + 1) {
            throw new RuntimeException("Неправильный размер масива");
        }
        Integer[] arrNew = new Integer[arr.length + 1];

        System.arraycopy(arr, 0, arrNew, 0, index);
        arrNew[index] = item;
        System.arraycopy(arr, index, arrNew, index + 1, arr.length - index);
        arr = arrNew;
        return item;
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    @Override
    public Integer set(int index, Integer item) {
        if (item == null) {
            throw new RuntimeException("Пустая Строка");
        }
        if (index > arr.length) {
            throw new RuntimeException("Неправильный размер массива");
        }
        arr[index] = item;

        return item;
    }


    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public Integer remove(Integer item) {
        if (item == null) {
            throw new RuntimeException("Пустая Строка");
        }


        for (int index = 0; index < arr.length; index++) {
            if (arr[index].equals(item)) {
                Integer[] arrNew = new Integer[arr.length - 1];
                System.arraycopy(arr, 0, arrNew, 0, index);
                System.arraycopy(arr, index + 1, arrNew, index, arr.length - index - 1);
                arr = arrNew;
                break;
            } else {
                throw new RuntimeException("Нет такого элемента");
            }
        }


        return item;
    }


    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public Integer remove(int index) {
        Integer newItem;
        if (index > arr.length) {
            throw new RuntimeException("Неправильный размер массива");
        } else {
            newItem = arr[index];

            Integer[] arrNew = new Integer[arr.length - 1];
            System.arraycopy(arr, 0, arrNew, 0, index);
            System.arraycopy(arr, index + 1, arrNew, index, arr.length - index - 1);
            arr = arrNew;

        }
        return newItem;
    }


    //*************************************
    @Override
    public void swapElements(Integer[] arr, int indexA, int indexB) {

        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;

    }
//***********************************

//    private void sortSelection(Integer[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minElementIndex = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[minElementIndex]) {
//                    minElementIndex = j;
//                }
//            }
//            swapElements(arr, i, minElementIndex);
//        }
//    }

    public static void sortSelection(Integer[] sortArr, int low, int high) {
        //завершить,если массив пуст или уже нечего делить
        if (sortArr.length == 0 || low >= high) return;

        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int border = sortArr[middle];

        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (sortArr[i] < border) i++;
            while (sortArr[j] > border) j--;
            if (i <= j) {
                int swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (low < j) sortSelection(sortArr, low, j);
        if (high > i) sortSelection(sortArr, i, high);
    }
//***********************************

    private boolean contains(Integer[] arr, int element) {
        sortSelection(arr,0,arr.length-1);
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
//***********************************

    // Проверка на существование элемента.
    // Вернуть true/false;
    @Override
    public boolean contains(Integer item) {
        return contains(arr, item);


    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int indexOf(Integer item) {
        if (item == null) {
            throw new RuntimeException("Пустая Строка");
        }

        for (int index = 0; index < arr.length; index++) {
            if (Objects.equals(arr[index], item))

                return index;
        }
        return -1;

    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия
    @Override
    public int lastIndexOf(Integer item) {
        if (item == null) {
            throw new RuntimeException("Пустая Строка");
        }
        for (int index = arr.length - 1; index >= 0; index--) {
            if (Objects.equals(arr[index], item))
                return index;
        }
        return -1;
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    @Override
    public Integer get(int index) {
        return arr[index];
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    @Override
    public boolean equals(ArrayListR otherList) {
        boolean equalsArray;
        if (otherList.equals(null)) {
            throw new RuntimeException("Передан список с пустыми ячейками");
        }

        return equalsArray = Arrays.equals(arr, otherList.getArr());
    }

    // Вернуть фактическое количество элементов.
    @Override
    public int size() {
        int sizeArray;
        return sizeArray = arr.length;
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    @Override
    public boolean isEmpty() {

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != null)
                return false;
        }
        return true;
    }

    // Удалить все элементы из списка.
    @Override
    public void clear() {
        Arrays.fill(arr, null);
    }

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    @Override
    public Integer[] toArray() {
        Integer[] arrNew = new Integer[arr.length];
        for (int index = 0; index < arr.length; index++) {
            arrNew[index] = arr[index];
        }

        return arrNew;
    }
}

