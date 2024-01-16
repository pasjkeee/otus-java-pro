package ru.otus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntCalc {

    Logger log = LoggerFactory.getLogger("ru.otus.IntCalc");
    public int sum(int i, int j) {
        log.info("Пытаюсь считать");
        return i + j;
    }
}
