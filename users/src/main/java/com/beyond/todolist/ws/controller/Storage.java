package com.beyond.todolist.ws.controller;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String,Object> container = new HashMap<>();

    public static void set(String name, Object value)
    {
        container.put(name, value);
    }

    public static Object get(String name, Object def)
    {
        return container.getOrDefault(name, def);
    }

    public static void delete(String name)
    {
        container.remove(name);
    }
}
