package org.example;

import java.io.IOException;

public class Controller {
        public static void start(){
            DataInput input = new ConsoleInput();
            DataSaver saver = new JsonSaver();
            Model model = new Model(saver, input);
            model.welcome();
            while(true){
                try{
                    switch(model.menu()){
                        case 1 -> model.showAnimals();
                        case 2 -> model.sort();
                        case 3 -> model.addAnimal();
                        case 4 -> model.addCommand();
                        case 5 -> model.showCommands();
                        case 6 -> model.count();
                        case 7 -> model.save();
                        case 8 -> throw new RuntimeException();
                        default -> throw new IOException();
                    }
                }catch(RuntimeException e){
                    model.goodbye();
                    break;
                }catch (IOException e){
                    model.absent();
                }
            }
        }
}
