package ru.andrey.kvstorage.console.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;


public class UpdateKeyCommand implements DatabaseCommand {
    private final ExecutionEnvironment environment;

    private final String databaseName, tableName;
    private final String key, value;

    public UpdateKeyCommand(ExecutionEnvironment environment, String databaseName, String tableName, String key, String value) {
        this.environment = environment;
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.key = key;
        this.value = value;
    }

    @Override
    public DatabaseCommandResult execute() {
        Optional<Database> database = environment.getDatabase(databaseName);
        try {
            database.get().write(tableName, key, value);
            return DatabaseCommandResult.success("Update successful");
        } catch (NullPointerException e) {
            return DatabaseCommandResult.error("There is no such database");
        } catch (DatabaseException e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
