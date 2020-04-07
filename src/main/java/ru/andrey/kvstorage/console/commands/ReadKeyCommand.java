package ru.andrey.kvstorage.console.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ReadKeyCommand implements DatabaseCommand {

    private ExecutionEnvironment environment;
    private String databaseName;
    private String tableName;
    private String key;

    public ReadKeyCommand(ExecutionEnvironment environment, String databaseName, String tableName, String key) {
        this.environment = environment;
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.key = key;
    }

    @Override
    public DatabaseCommandResult execute() {
        Optional<Database> database = environment.getDatabase(databaseName);
        try {
            return DatabaseCommandResult.success(database.get().read(tableName, key));
        } catch (NoSuchElementException e) {
            return DatabaseCommandResult.error("There is no such database");
        } catch (DatabaseException e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
