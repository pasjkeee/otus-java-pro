package ru.otus;

import com.google.common.collect.Lists;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HelloOtus {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        List<String> names = Lists.newArrayList("John", "Adam", "Jane");

        List<String> reversed = Lists.reverse(names);

        System.out.printf(reversed.toString());
    }
}