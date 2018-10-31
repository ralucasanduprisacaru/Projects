package com.example.raluc.okhttppoc;

public class Person {

    private String name, favouriteAnimal;
    private int age;

    public Person(String name, String favouriteAnimal, int age) {
        this.name = name;
        this.favouriteAnimal = favouriteAnimal;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavouriteAnimal() {
        return favouriteAnimal;
    }

    public void setFavouriteAnimal(String favouriteAnimal) {
        this.favouriteAnimal = favouriteAnimal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
