package com.example;

/**
 * @Author: guo wei
 * 2020-07-09
 */
public  class Student extends Thread{
    int a = 0;
    class  aa{
        void  dada(){
       synchronized (Student.class){

       }
        }
    }
    public static void main(String[] args) {

    }
    private int age;

    public Student(int age) {

        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private  void doSomething(){
        System.out.println(123);
    }

}
