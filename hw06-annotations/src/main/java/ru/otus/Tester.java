package ru.otus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Tester {

    private final IntCalc intCalc = new IntCalc();

    Logger log = LoggerFactory.getLogger("ru.otus.Tester");

    @After
    public void printSeparator() {
        System.out.println("After ---------------------");
    }

    @Before
    public void setUp() {
        log.info("Before Подготовка к тестированию");
    }

    @After
    public void tearDown() {
        log.info("After избавляемся от тестовых артефактов");
    }

    @Test
    public void sumTest() {
        assertThat(intCalc.sum(1, 5)).isEqualTo(6);
    }

    @Test("Сумма")
    public void sumTestNamed() {
        assertThat(intCalc.sum(1, 3)).isEqualTo(4);
    }

    @Test("Сумма c аннотацией @Before")
    public void sumTestNamedWithBefore() {
        log.info("Before отработает, а тест с данной");
    }

    @Test("Тест который должен упасть")
    public void sumFailTestNamed() {
        assertThat(intCalc.sum(1, 3)).isEqualTo(5);
    }
}
