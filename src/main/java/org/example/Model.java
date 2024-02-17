package org.example;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class Model {
    private final DataSaver saver;
    private final DataInput input;
    private final DateFormat df = new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH);

    public Model(DataSaver saver, DataInput input) {
        this.saver = saver;
        this.input = input;
    }

    private Shelter<Animal> shelter = new Shelter<>();
    public void showAnimals(){
        try{
            int ch = input.showChoice();
            switch(ch){
                case 1 -> input.showList(this.shelter.toString());
                case 2 -> input.showList(this.shelter.getShelterPets());
                case 3 -> input.showList(this.shelter.getShelterPackAnimals());
                case 4 -> input.showList(this.shelter.getShelterType(Type.Dog));
                case 5 -> input.showList(this.shelter.getShelterType(Type.Cat));
                case 6 -> input.showList(this.shelter.getShelterType(Type.Hamster));
                case 7 -> input.showList(this.shelter.getShelterType(Type.Horse));
                case 8 -> input.showList(this.shelter.getShelterType(Type.Camel));
                case 9 -> input.showList(this.shelter.getShelterType(Type.Donkey));
                default -> throw new RuntimeException();
            }
        } catch(RuntimeException e){
            input.menuMistake();
        }

    }
    public List<String> createCommand(){
        List<String> list = new ArrayList<>();
        while (true){
            try{
                int ch = input.askCommands();
                switch(ch){
                    case 1 -> list.add(input.inputCommands());
                    case 2 -> throw new RuntimeException();
                    default -> throw new IOException();
                }
            }catch(NumberFormatException e){
                input.inputError();
            }catch(RuntimeException e){
                break;
            } catch (IOException e) {
                input.menuMistake();
            }
        }
        return list;
    }
    public Calendar getCal() throws ParseException {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(df.parse(input.dOb()));
        return cal;
    }
    public void addAnimal(){
        try{
            int ch1 = input.groupChoice();
            switch(ch1){
                case 1 -> {
                    int ch2 = input.petChoice();
                    switch(ch2){
                        case 1 -> this.shelter.addAnimal(
                                new Pet(input.inputId(), input.inputName(), getCal(), Type.Dog, createCommand())
                        );
                        case 2 -> this.shelter.addAnimal(
                                new Pet(input.inputId(), input.inputName(), getCal(), Type.Cat, createCommand())
                        );
                        case 3 -> this.shelter.addAnimal(
                                new Pet(input.inputId(), input.inputName(), getCal(), Type.Hamster, createCommand())
                        );
                        default -> throw new IOException();
                    }
                    input.addSuccessful();
                }
                case 2 -> {
                    int ch2 = input.packChoice();
                    switch(ch2){
                        case 1 -> this.shelter.addAnimal(
                                new PackAnimal(input.inputId(), input.inputName(), getCal(), Type.Horse, createCommand())
                        );
                        case 2 -> this.shelter.addAnimal(
                                new PackAnimal(input.inputId(), input.inputName(), getCal(), Type.Camel, createCommand())
                        );
                        case 3 -> this.shelter.addAnimal(
                                new PackAnimal(input.inputId(), input.inputName(), getCal(), Type.Donkey, createCommand())
                        );
                        default -> throw new IOException();
                    }
                    input.addSuccessful();
                }
                default -> throw new IOException();
            }
        } catch (ParseException | NumberFormatException e) {
            input.inputError();
        } catch (IOException e) {
            input.menuMistake();
        } catch (AlreadyBoundException e) {
            input.exists();
        }
    }

    public void sort(){
        try{
            int ch = input.sortChoice();
            switch(ch){
                case 1 -> this.shelter.sortById();
                case 2 -> this.shelter.sortByAge();
                case 3 -> this.shelter.sortByType();
                default -> throw new IOException();
            }
        } catch (IOException e) {
            input.menuMistake();
        } catch (NumberFormatException e){
            input.inputError();
        }
    }
    public int menu() throws IOException {
        try{
            return input.menuChoice();
        }catch(NumberFormatException e){
            input.inputError();
            throw new IOException();
        }
    }
    public void absent(){
        input.menuMistake();
    }
    public void welcome() {
        input.welcome();
    }
    public void goodbye() {
        input.goodbye();
    }

    public void addCommand() {
        try {
            this.shelter.addCommand(input.inputId(), createCommand());
        } catch (NumberFormatException e) {
            input.menuMistake();
        }
    }
    public void showCommands(){
        try{
            input.commands(this.shelter.showCommand(input.inputId()).toString());
        }catch(NumberFormatException e){
            input.inputError();
        }catch(IndexOutOfBoundsException e){
            input.menuMistake();
        }
    }

    public void count(){
        try{
            int ch = input.showChoice();
            switch(ch){
                case 1 -> input.showCount(this.shelter.getAnimalCount());
                case 2 -> input.showCount(this.shelter.getGroupCount(Pet.class));
                case 3 -> input.showCount(this.shelter.getGroupCount(PackAnimal.class));
                case 4 -> input.showCount(this.shelter.getTypeCount(Type.Dog));
                case 5 -> input.showCount(this.shelter.getTypeCount(Type.Cat));
                case 6 -> input.showCount(this.shelter.getTypeCount(Type.Hamster));
                case 7 -> input.showCount(this.shelter.getTypeCount(Type.Horse));
                case 8 -> input.showCount(this.shelter.getTypeCount(Type.Camel));
                case 9 -> input.showCount(this.shelter.getTypeCount(Type.Donkey));
                default -> throw new IOException();
            }
        } catch(IOException e){
            input.menuMistake();
        } catch(NumberFormatException e){
            input.inputError();
        }
    }
    public void save(){
        try{
            saver.saveData(this.shelter.getShelter());
            input.addSuccessful();
        } catch (IOException e) {
            input.inputError();
        }
    }
}
