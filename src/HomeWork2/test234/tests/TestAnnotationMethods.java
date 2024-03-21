package HomeWork2.test234.tests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TestAnnotationMethods {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException{
        Object o = new Tests();
        Object b = new AnnotatedMethods();

        Method[] method = o.getClass().getDeclaredMethods();

        Method beforeAll = b.getClass().getDeclaredMethod("beforeAll");
        Method beforeEach = b.getClass().getDeclaredMethod("beforeEach");
        Method afterAll = b.getClass().getDeclaredMethod("afterAll");
        Method afterEach = b.getClass().getDeclaredMethod("afterEach");


        for (int i = 0; i < method.length; i++) {
                if(i == 0){
                    beforeAll.invoke(b);
                    beforeEach.invoke(b);
                    method[i].invoke(o);
                    afterEach.invoke(b);
                    System.out.println("-------------------");
                } else if (i == method.length-1) {
                    beforeEach.invoke(b);
                    method[i].invoke(o);
                    afterEach.invoke(b);
                    afterAll.invoke(b);
                }else {
                    beforeEach.invoke(b);
                    method[i].invoke(o);
                    afterEach.invoke(b);
                    System.out.println("-------------------");
                }
        }

    }
}
