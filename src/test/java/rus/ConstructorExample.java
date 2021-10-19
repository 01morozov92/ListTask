package rus;

import java.util.Scanner;

public class ConstructorExample {

    public static void main(String[] args) {


        Student student2 = new Student("Ruslan", -29);
    }


    static class Student {
        public String name;
        private int age;

        public Student(String name, int age) {
            this.setName(name);
            this.setAge(age);
        }

        public Student() {

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
            if (age < 0) {
                System.out.println("Пашёл нахуй! Возраст должен быть положительным числом!");
            } else {
                this.age = age;
            }
        }
    }
}
