package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class JsonSaver implements DataSaver {
    @Override
    public void saveData(List<Animal> list) throws IOException {
            String fileName = "Shelter.json";
            DateFormat df = new SimpleDateFormat("d/MM/yyyy");
            try (FileWriter writer = new FileWriter(fileName, false)) {
                writer.write("[\n");
                for (int i = 0; i < list.size(); i++) {
                    writer.write("\t{\n");
                    writer.write(String.format("\t\t\"Id\":\"%d\",\n", list.get(i).getId()));
                    writer.write(String.format("\t\t\"Имя\":\"%s\",\n", list.get(i).getName()));
                    writer.write(String.format("\t\t\"Дата рождения\":\"%s\",\n", df.format(list.get(i).getDoB().getTime())));
                    writer.write(String.format("\t\t\"Вид\":\"%s\",\n", list.get(i).getType()));
                    writer.write(String.format("\t\t\"Комманды\":\"%s\"\n", list.get(i).getCommands()));
                    writer.write("\t}");
                    if (i < list.size() - 1) {
                        writer.write(",\n");
                    }
                }
                writer.write("\n]");
                writer.flush();
            } catch (IOException e) {
                throw new IOException();
            }
        }
}
