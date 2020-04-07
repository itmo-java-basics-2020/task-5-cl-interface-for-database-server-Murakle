package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.logic.Database;
import ru.andrey.kvstorage.logic.SimpleDatabase;

import java.util.ArrayList;
import java.util.Optional;

public class SimpleExecutionEnvironment implements ExecutionEnvironment {
    ArrayList<Database> databases;

    public SimpleExecutionEnvironment() {
        databases = new ArrayList<>();
    }

    @Override
    public Optional<Database> getDatabase(String name) {
        for (Database d :
                databases) {
            if (d.getName().equals(name)) {
                return Optional.of(d);
            }
        }
        return Optional.empty();
    }

    @Override
    public void addDatabase(Database db) {
        databases.add(db);
    }
}
