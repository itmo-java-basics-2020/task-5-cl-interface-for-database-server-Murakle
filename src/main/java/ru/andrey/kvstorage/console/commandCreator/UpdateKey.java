package ru.andrey.kvstorage.console.commandCreator;

import ru.andrey.kvstorage.console.AbstractDatabaseCommandCreator;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.console.commands.UpdateKeyCommand;
import ru.andrey.kvstorage.exception.DatabaseException;

public class UpdateKey implements AbstractDatabaseCommandCreator {

    @Override
    public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) throws DatabaseException {
        if (args.length != 5) throw new DatabaseException("Not correct command(wrong arguments");
        return new UpdateKeyCommand(env, args[INDEX_OF_DATABASE_NAME], args[INDEX_OF_TABLE_NAME],
                args[INDEX_OF_KEY], args[INDEX_OF_VALUE]);
    }
}
