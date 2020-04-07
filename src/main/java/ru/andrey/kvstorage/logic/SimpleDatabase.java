package ru.andrey.kvstorage.logic;

import ru.andrey.kvstorage.exception.DatabaseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SimpleDatabase implements Database {

    private final String name;
    private ArrayList<Table> tables;

    public SimpleDatabase(String name) {
        this.name = name;
        tables = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void createTableIfNotExists(String tableName) {
        if (findTable(tableName).isEmpty()) {
            tables.add(new SimpleTable(tableName));
        }
    }

    @Override
    public void createTableIfNotExists(String tableName, int segmentSizeInBytes) {
        //todo
    }

    @Override
    public void write(String tableName, String objectKey, String objectValue) throws DatabaseException {
        Optional<Table> t = findTable(tableName);
        if (t.isEmpty()) {
            throw new DatabaseException("No such table");
        } else {
            t.get().write(objectKey, objectValue);
        }
    }

    @Override
    public String read(String tableName, String objectKey) throws DatabaseException {
        Optional<Table> t = findTable(tableName);
        if (t.isEmpty()) {
            throw new DatabaseException("No such table");
        } else {
            return t.get().read(objectKey);
        }
    }


    private Optional<Table> findTable(String Name) {
        for (Table t :
                tables) {
            if (t.getName().equals(Name)) return Optional.of(t);
        }
        return Optional.empty();
    }

    private class SimpleTable implements Table {
        private final String name;
        private Map<String, String> data;

        private SimpleTable(String name) {
            this.name = name;
            data = new HashMap<>();
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void write(String objectKey, String objectValue) {
            data.put(objectKey, objectValue);
        }

        @Override
        public String read(String objectKey) {
            return data.get(objectKey);
        }
    }
}
