package ru.otus;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestHandler {

    private HashMap<String, Method> beforeMethods = new HashMap<>();
    private HashMap<String, Method> afterMethods = new HashMap<>();
    private HashMap<String, Method> testMethods = new HashMap<>();


    public void classHandler(String className) throws Exception {

        Class classInst = Class.forName(className);

        Constructor constructor = classInst.getConstructor();

        for (Method cl : classInst.getDeclaredMethods()) {

            if (cl.isAnnotationPresent(Before.class)) {
                beforeMethods.put(cl.getName(), cl);
                continue;
            }

            if (cl.isAnnotationPresent(After.class)) {
                afterMethods.put(cl.getName(), cl);
                continue;
            }

            if (cl.isAnnotationPresent(Test.class)) {
                testMethods.put(cl.getName(), cl);
            }
        }

        if (testMethods.isEmpty()) {

            return;
        }

        for (Map.Entry<String, Method> entries : testMethods.entrySet()) {

            var classInstance = constructor.newInstance().getClass();

            try {

                for (Map.Entry<String, Method> beforeEntries : beforeMethods.entrySet()) {
                    classInstance.getDeclaredMethod(beforeEntries.getKey()).invoke(classInstance);
                }

                classInstance.getDeclaredMethod(entries.getKey()).invoke(classInstance);

                for (Map.Entry<String, Method> afterEntries : afterMethods.entrySet()) {
                    classInstance.getDeclaredMethod(afterEntries.getKey()).invoke(classInstance);
                }

            } catch (Exception e) {

            }
        }
    }

}
