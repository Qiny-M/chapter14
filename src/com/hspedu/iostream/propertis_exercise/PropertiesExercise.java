package com.hspedu.iostream.propertis_exercise;


import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

@SuppressWarnings({"all"})
public class PropertiesExercise {
    public static void main(String[] args) throws IOException {
        /*
         * 要编写一个dog.properties
         * name=tom
         * age=10
         * color=red
         *
         * 编写dog类(name,age,color)创建一个dog对象，读取dog.properties相应属性完成初始化，并输出
         *
         * 将创建的dog对象，序列化输入到dog.txt文件
         *
         * 再创建一个方法，反序列化dog对象
         *
         * */
        String propPath = "src/dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(propPath));
        String name = properties.getProperty("name") + "";//Object-->String后面加个空字符串
        int age = Integer.parseInt(properties.getProperty("age"));//Object-->int使用integer.parseInt
        String color = properties.getProperty("color") + "";//Object-->String后面加个空字符串
        Dog dog = new Dog(name, age, color);
        System.out.println(dog);

        String desPath = "/Users/meng/Downloads/dog.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(desPath));
        oos.writeObject(dog);
        oos.close();


    }

    @Test
    /*反序列化dog.txt*/
    public void m1() throws ClassNotFoundException, IOException {
        String sourPath = "/Users/meng/Downloads/dog.txt";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sourPath));
        Dog dog = (Dog) ois.readObject();
        System.out.println("反序列化后到结果为" + dog);
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}
