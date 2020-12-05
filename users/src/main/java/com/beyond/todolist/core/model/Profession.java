package com.beyond.todolist.core.model;

public class Profession {
    public int id;
    public String name;

    public Profession()
    {}

    public Profession(String n)
    {
        name = n;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
