package org.example;


public interface DataInput {
    String inputName();
    int inputId();
    String dOb();
    String inputCommands();
    int askCommands();
    void exists();
    String processInput(String message);
    void welcome();
    int menuChoice();
    void menuMistake();
    int sortChoice();
    int petChoice();
    int packChoice();
    int groupChoice();
    int showChoice();
    void goodbye();
    void addSuccessful();
    void inputError();
    void showCount(int count);
    void showList(String str);
    void commands(String str);


}
