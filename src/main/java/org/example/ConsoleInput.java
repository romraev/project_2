package org.example;

import java.util.*;

public class ConsoleInput implements DataInput {
    Scanner scanner = new Scanner(System.in);
    @Override
    public String inputName() {
        return processInput(View.askName);
    }

    @Override
    public int inputId() throws NumberFormatException{
        try {
            return Integer.parseInt(processInput(View.askId));
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    @Override
    public String dOb() { return processInput(View.askDoB);
    }

    @Override
    public String inputCommands() {return processInput(View.enterCommands);}

    @Override
    public int askCommands() throws NumberFormatException{
        try {
            return Integer.parseInt(processInput(View.askCommands));
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    @Override
    public void exists() {
        System.out.println(View.exists);
    }

    @Override
    public String processInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public void welcome() {
        System.out.println(View.welcome);
    }

    @Override
    public int menuChoice() throws NumberFormatException{
        try {
            return Integer.parseInt(processInput(View.menu));
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    @Override
    public void menuMistake() {
        System.out.println(View.menuMistake);
    }

    @Override
    public int sortChoice() throws NumberFormatException{
        try {
            return Integer.parseInt(processInput(View.sortChoice));
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    @Override
    public int petChoice() throws NumberFormatException{
        try {
            return Integer.parseInt(processInput(View.petChoice));
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    @Override
    public int packChoice() throws NumberFormatException{
        try {
            return Integer.parseInt(processInput(View.packChoice));
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    @Override
    public int groupChoice() throws NumberFormatException{
        try {
            return Integer.parseInt(processInput(View.groupChoice));
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    @Override
    public int showChoice() throws NumberFormatException{
        try {
            return Integer.parseInt(processInput(View.showChoice));
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    @Override
    public void goodbye() {
        System.out.println(View.goodBye);
    }

    @Override
    public void addSuccessful() {
        System.out.println(View.success);
    }


    @Override
    public void inputError() {
        System.out.println(View.inputError);
    }

    @Override
    public void showCount(int count) {
        System.out.printf("\n%s %d\n", View.showCount, count);
    }

    @Override
    public void showList(String str) {
        System.out.println("Id \tИмя \tДата рождения \tВид \tКомманды \tГруппа");
        System.out.println(str);
    }

    @Override
    public void commands(String str) {
        System.out.println("Доступные комманды: " + str);
    }


}
