package org.example;

import java.util.Calendar;
import java.util.List;

public abstract class Animal {
    private final int id;
    private final String name;
    private final Calendar dob;
    private List<String> commands;

    public Animal(int id, String name, Calendar dob, List<String> commands) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Calendar getDoB() {
        return dob;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommands(List<String> command) {
        this.commands.addAll(command);
    }
    public abstract Type getType();
    public abstract int compareType(Animal animal);

    public abstract int compareTo(Animal animal);

    public abstract int compareAge(Animal animal);
    public abstract String toString();
}
