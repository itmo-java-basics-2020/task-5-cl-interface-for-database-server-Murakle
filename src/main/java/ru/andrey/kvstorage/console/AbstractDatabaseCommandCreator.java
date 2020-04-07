package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;

public interface AbstractDatabaseCommandCreator {
    static final int INDEX_OF_DATABASE_NAME = 1;
    static final int INDEX_OF_TABLE_NAME = 2;
    static final int INDEX_OF_KEY = 3;
    static final int INDEX_OF_VALUE = 4;

    DatabaseCommand getCommand(ExecutionEnvironment env, String... args) throws DatabaseException;
}
