package org.example;

import java.rmi.AlreadyBoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shelter<T extends Animal> {
    private List<T> shelter;

    public List<T> getShelter() {
        return shelter;
    }

    public Shelter() {
        this.shelter = new ArrayList<>();
    }
    public void addAnimal(T animal) throws AlreadyBoundException {
        if (this.shelter.stream().noneMatch(x -> x.getId()==animal.getId())){this.shelter.add(animal);}
        else throw new AlreadyBoundException();
    }
    public void addCommand(int id, List<String> list){
        for (Animal animal:this.shelter){
            if(animal.getId()==id){
                animal.addCommands(list);
            }
        }
    }
    public List<String> showCommand(int id) throws IndexOutOfBoundsException {
        List<String> list = Collections.emptyList();
        if (this.shelter.stream().anyMatch(x -> x.getId()==id)){
            for (Animal animal:this.shelter){
                if(animal.getId()==id){
                    list = animal.getCommands();
                }
            }
            return list;
        }
        else throw new IndexOutOfBoundsException();
    }
    public int getAnimalCount(){
        return this.shelter.size();
    }
    public int getGroupCount(Object o){
        int count = 0;
        for(T animal : this.shelter){
             if(animal.getClass().equals(o)){
                 count++;
             }
        }
        return count;
    }
    public int getTypeCount(Type o){
        int count = 0;
        for(T animal : this.shelter){
            if(animal.getType().equals(o)){
                count++;
            }
        }
        return count;
    }

    public String getShelterPets() {
        StringBuilder str = new StringBuilder();
        for(T animal : this.shelter){
            if(animal.getClass().equals(Pet.class)){
                str.append(animal);
            }
        }
        return str.toString();
    }
    public String getShelterPackAnimals() {
        StringBuilder str = new StringBuilder();
        for(T animal : this.shelter){
            if(animal.getClass().equals(PackAnimal.class)){
                str.append(animal);
            }
        }
        return str.toString();
    }
    public String getShelterType(Type type) {
        StringBuilder str = new StringBuilder();
        for(T animal : this.shelter){
            if(animal.getType().equals(type)){
                str.append(animal);
            }
        }
        return str.toString();
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(T animal : this.shelter){
            str.append(animal);
        }
        return str.toString();
    }
    public void sortById(){
        this.shelter.sort(Animal::compareTo);
    }
    public void sortByAge(){
        this.shelter.sort(Animal::compareAge);
    }
    public void sortByType(){
        this.shelter.sort(Animal::compareType);
    }
}
