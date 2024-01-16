package ru.otus;

import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class IntCalcTest {

    private final IntCalc intCalc = new IntCalc();

    @Before
    @After
    public void printSeparator() {
        System.out.println("---------------------");
    }

    @Before
    public void setUp() {
        log.info("Подготовка к тестированию");
    }

    @After
    public void tearDown() {
        log.info("Избавляемся от тестовых артефактов");
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
