package org.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Pet extends Animal{
    private final Type type;

    public Pet(int id, String name, Calendar dob, Type type, List<String> commands) {
        super(id, name, dob, commands);
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public int compareType(Animal animal) {
        if (animal.getType().equals(this.getType())) return 0;
        else return 1;
    }


    @Override
    public int compareTo(Animal o) {
        if (o != null) {
            return Integer.compare(this.getId(), o.getId());
        }
        else throw new RuntimeException();
    }

    @Override
    public int compareAge(Animal animal) {
        if (this.getDoB().equals(animal.getDoB())) return 0;
        else if (this.getDoB().after(animal.getDoB())) return 1;
        else return -1;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("d/MM/yyyy");
        return String.format("%d. \t%s \t%s \t%s \t%s \tPet\n",
                this.getId(), this.getName(), df.format(this.getDoB().getTime()), this.getType(), this.getCommands());
    }
}
