package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.console.commandCreator.CreateDatabase;
import ru.andrey.kvstorage.console.commandCreator.CreateTable;
import ru.andrey.kvstorage.console.commandCreator.ReadKey;
import ru.andrey.kvstorage.console.commandCreator.UpdateKey;
import ru.andrey.kvstorage.exception.DatabaseException;

public enum DatabaseCommands {
    CREATE_DATABASE(new CreateDatabase()),
    CREATE_TABLE(new CreateTable()),
    UPDATE_KEY(new UpdateKey()),
    READ_KEY(new ReadKey());

    AbstractDatabaseCommandCreator creator;

    DatabaseCommands(AbstractDatabaseCommandCreator creator) {
        this.creator = creator;
    }

    public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) throws DatabaseException {
        return creator.getCommand(env, args);
    }

}
