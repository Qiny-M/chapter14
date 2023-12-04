package com.hspedu.reflection.reflection_exercise;

import java.lang.reflect.Constructor;

/**
 * @author mqy
 * @version 1.0
 * @date 2023/12/4 23:30
 */

public class ReflectionExercise {
    public static void main(String[] args) throws Exception {
        /*通过反射机制创建实例
         * */

        //1.先获取到User对象到Class对象
        Class<?> a = Class.forName("com.hspedu.reflection.reflection_exercise.User");
        Object user1 = a.newInstance();
        System.out.println(user1);

        //2.通过Public的无参构造器创建实例
        Constructor<?> constructor1 = a.getConstructor();
        Object user2 = constructor1.newInstance();
        System.out.println(user2);

        //3.通过Public的有参构造器创建实例
        Constructor<?> constructor2 = a.getConstructor(String.class);
        Object user3 = constructor2.newInstance("MQY");
        System.out.println(user3);

        //4.通过非Public的有参构造器创建实例
        Constructor<?> declaredConstructor = a.getDeclaredConstructor(int.class, String.class);
        declaredConstructor.setAccessible(true);//暴破后，用反射可以访问private构造器或方法等
        Object user4 = declaredConstructor.newInstance(25, "MQY_mqy");
        System.out.println(user4);
    }
}

class User {
    private int age = 24;
    private String name = "mqy";

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}