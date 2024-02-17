package org.example;

import java.io.IOException;
import java.util.List;

public interface DataSaver {
    void saveData(List<Animal> list) throws IOException;
}
