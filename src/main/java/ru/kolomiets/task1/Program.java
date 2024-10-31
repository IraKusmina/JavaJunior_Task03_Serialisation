package ru.kolomiets.task1;

import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        //Задание. Разработайте класс Student с полями String name, int age, transient GPA (средний бал).
        //Обеспечьте поддержку сериализации для этого класса. Создайте обхект класса Student
        //и инициализируйте его данными. Сериализуйте этот объект в файл.
        //Десериализуйте объект обратно из файла. Выведите все поля объекта, включая GPA,
        //и обсудите почему значение GPA не было () -> сохранено / восстановлено.
        //Выполните задачу выше используя другие типы сериализаторов. (в xml, json документы).
        Student student = new Student("Irina", 30, 4.7);

        FileOutputStream fileOutputStream = new FileOutputStream("students.bin");

        try (ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
            try {
                oos.writeObject(student);
                System.out.println("Объект Student сериализован");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("students.bin");
        Student student2;
        try (ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream)) {
            try {
                student2 = (Student) objInputStream.readObject();
                System.out.println("Объект Student десериализован");

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        fileInputStream.close();

        System.out.println("Name: " + student2.getName());
        System.out.println("Age: " + student2.getAge());
        System.out.println("GPA(ожидается null): " + student2.getGpa());
    }
}
