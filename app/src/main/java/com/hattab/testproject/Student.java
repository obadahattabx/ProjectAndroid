package com.hattab.testproject;

public class Student {
    private int ID;
    private String name;
    private Double age;

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getAge() {
        return age;
    }
    public void setAge(Double age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student{" +
                "\nID= " + ID +
                "\nname= " + name +
                "\nage= " + age +
                +'\n'+'}'+'\n';
    }
}