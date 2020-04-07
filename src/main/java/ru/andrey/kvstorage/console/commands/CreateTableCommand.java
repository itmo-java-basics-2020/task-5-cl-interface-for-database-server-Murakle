package ru.andrey.kvstorage.console.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;
import ru.andrey.kvstorage.logic.SimpleDatabase;

import java.util.Optional;

public class CreateTableCommand implements DatabaseCommand {
    private ExecutionEnvironment environment;
    private String databaseName;
    private String tableName;

    public CreateTableCommand(ExecutionEnvironment environment, String databaseName, String tableName) {
        this.environment = environment;
        this.databaseName = databaseName;
        this.tableName = tableName;
    }

    @Override
    public DatabaseCommandResult execute() {
        Optional<Database> database = environment.getDatabase(databaseName);
        DatabaseCommandResult result;
        try {
            database.get().createTableIfNotExists(tableName);
            return DatabaseCommandResult.success("Created table");
        } catch (NullPointerException e) {
            return DatabaseCommandResult.error("There is no such database");
        } catch (DatabaseException e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
