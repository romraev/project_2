package org.example;

public class View {
    protected static String askName = "Введите кличку животного: ";
    protected static String askId = "Введите id животного: ";
    protected static String askDoB = "Введите день рождения в формате дд/мм/гггг: ";
    protected static String askCommands = "Хотите добавить комманды? 1.Да/2.Нет: ";
    protected static String enterCommands = "Введите комманду: ";

    protected static String welcome = "Добро пожаловать!";
    protected static String menu = """

            Выберете пункт меню:\s
             1. Показать животных\s
             2. Отсортировать животных по...\s
             3. Добавить животное\s
             4. Добавить комманду\s
             5. Показать комманды\s
             6. Вывести количество животных по признаку...\s
             7. Сохранить\s
             8. Выйти""";
    protected static String menuMistake = "Такого нет, попробуйте еще раз.";
    protected static String inputError = "Ошибка ввода, попробуйте еще раз.";
    protected static String sortChoice = """
            
            Выберете признак:\s
            1. Id\s
            2. Возраст\s
            3. Тип""";
    protected static String petChoice = """
            
            Выберете вид животного:\s
            1. Собака\s
            2. Кошка\s
            3. Хомяк""";
    protected static String packChoice = """
            
            Выберете вид животного:\s
            1. Лошадь\s
            2. Верблюд\s
            3. Осёл""";
    protected static String groupChoice = """
            
            Выберете тип животного:\s
            1. Домашнее\s
            2. Вьючное""";
    protected static String exists = "Такой Id уже есть!";
    protected static String showChoice = """
            
            Выберете группу:\s
            1. Все\s
            2. Домашние\s
            3. Вьючные\s
            Отдельно по виду:\s
            4. Собака\s
            5. Кошка\s
            6. Хомяк\s
            7. Лошадь\s
            8. Верблюд\s
            9. Осёл""";
    protected static String showCount = "Всего животных: ";
    protected static String goodBye = "До свидания!";
    protected static String success = "Выполнено";


}
