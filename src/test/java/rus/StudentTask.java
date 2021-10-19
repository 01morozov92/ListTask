package rus;

import java.util.Scanner;

public class StudentTask {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String name = read.nextLine();
        int age = read.nextInt();

        Student student = new Student();
        student.name = name;

        student.setAge(age);
        System.out.println("Name: " + student.name);
        System.out.println("Age: " + student.getAge());
    }


    static class Student {

        public String name;
        private int age;

        public int getAge(){
            return age;
        }

        public void  setAge(int age){

                if (age<0){
                    System.out.println("Invalid age");
                }else{
                    this.age = age;
                }

        }
    }

}
