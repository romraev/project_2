package org.example;

public enum Type {
    Dog ("Собака"),
    Cat ("Кошка"),
    Hamster ("Хомяк"),
    Horse ("Лошадь"),
    Donkey ("Осёл"),
    Camel ("Верблюд");
    private final String typeName;

    Type(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return this.typeName;
    }
}
