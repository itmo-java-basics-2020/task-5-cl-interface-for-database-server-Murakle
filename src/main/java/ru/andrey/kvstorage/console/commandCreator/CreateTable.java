package ru.andrey.kvstorage.console.commandCreator;

import ru.andrey.kvstorage.console.AbstractDatabaseCommandCreator;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.console.commands.CreateTableCommand;
import ru.andrey.kvstorage.exception.DatabaseException;

public class CreateTable implements AbstractDatabaseCommandCreator {

    @Override
    public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) throws DatabaseException {
        if (args.length != 3) throw new DatabaseException("Not correct command(wrong arguments");
        return new CreateTableCommand(env, args[INDEX_OF_DATABASE_NAME], args[INDEX_OF_TABLE_NAME]);
    }
}
