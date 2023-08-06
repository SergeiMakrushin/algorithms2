package com.example.algorithms2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayListRTest {

    private ArrayListR arrayListR;
    private ArrayListR arrayListR1;
    Integer one = 1;
    Integer two = 2;
    Integer three = 3;
    Integer four = 4;
    Integer five = 5;
    Integer six = 6;
    Integer seven = 7;

    @BeforeEach
    public void setUp() {
        arrayListR = new ArrayListR(0);
        arrayListR.add(one);
        arrayListR.add(two);
        arrayListR.add(three);
        arrayListR.add(four);

    }

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Test
    public void addTest() {


        Integer actual = arrayListR.add(five);
        Integer expected = five;
        assertEquals(expected, actual);

        int expected1 = 5;
        int actual1 = arrayListR.getArr().length;

        assertEquals(expected1, actual1);

    }

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Test
    public void addIndexTest() {

        Integer actual = arrayListR.add(0, six);
        System.out.println("actual = " + actual);
        Integer expected = six;
        System.out.println("six = " + six);
        assertEquals(expected, actual);

        Integer[] newArray = {six, one, two, three, four};
        assertArrayEquals(arrayListR.getArr(), newArray);

    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    @Test
    public void set() {

        Integer actual = arrayListR.set(0, five);
        Integer expected = five;
        assertEquals(expected, actual);


        Integer[] newArray = {five, two, three, four};
        assertArrayEquals(arrayListR.getArr(), newArray);

    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Test
    public void remove() {

        Integer actual = arrayListR.remove(one);
        Integer expected = one;
        assertEquals(expected, actual);


        Integer[] newArray = {two, three, four};
        assertArrayEquals(arrayListR.getArr(), newArray);

    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Test
    public void removeIndex() {

        Integer actual = arrayListR.remove(1);
        Integer expected = two;
        assertEquals(expected, actual);


        Integer[] newArray = {one, three, four};
        assertArrayEquals(arrayListR.getArr(), newArray);
    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    @Test
    public void contains() {
        boolean actual = arrayListR.contains(three);
        assertTrue(actual);

    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Test
    public void indexOf() {

        int expected = 2;
        int actual = arrayListR.indexOf(three);
        assertEquals(expected, actual);

        int expected1 = -1;
        int actual1 = arrayListR.indexOf(five);
        assertEquals(expected1, actual1);
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Test
    public void lastIndexOf() {

        int expected = 2;
        int actual = arrayListR.lastIndexOf(three);
        assertEquals(expected, actual);

        int expected1 = -1;
        int actual1 = arrayListR.lastIndexOf(five);
        assertEquals(expected1, actual1);

    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    @Test
    public void get() {

        Integer actual = arrayListR.get(1);
        Integer expected = two;
        assertEquals(expected, actual);

    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    @Test
    public void equals() {
        arrayListR1 = new ArrayListR(0);
        arrayListR1.add(one);
        arrayListR1.add(two);
        arrayListR1.add(three);
        arrayListR1.add(four);

        assertArrayEquals(arrayListR1.getArr(), arrayListR.getArr());

    }

    // Вернуть фактическое количество элементов.
    @Test
    public void size() {
        int actual = arrayListR.size();
        int expected = 4;
        assertEquals(expected, actual);
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    @Test
    public void isEmpty() {
        boolean actual = arrayListR.isEmpty();
        assertFalse(actual);

        arrayListR.clear();
        boolean actual1 = arrayListR.isEmpty();
        assertTrue(actual1);
    }

    // Удалить все элементы из списка.
    @Test
    public void clear() {
        arrayListR.clear();
        boolean actual = arrayListR.isEmpty();
        assertTrue(actual);
    }

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    @Test
    public void toArray() {
        Integer[] newArr = {one, two, three, four};
        assertArrayEquals(newArr, arrayListR.toArray());
    }

}
