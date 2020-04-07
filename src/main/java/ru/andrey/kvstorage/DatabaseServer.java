package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.DatabaseCommands;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {
        this.env = env;
    }

    public static void main(String[] args) {

    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        try {
            DatabaseCommands commandCreator = DatabaseCommands.valueOf(commandText.split(" ")[0]);
            DatabaseCommand command = commandCreator.getCommand(env, commandText.split(" "));
            return command.execute();
        } catch (IllegalArgumentException e) {
            return DatabaseCommandResult.error("Not correct command (first word)");
        } catch (DatabaseException e) {
            return DatabaseCommandResult.error("Not correct amount of arguments");
        } catch (NullPointerException e) {
            return DatabaseCommandResult.error("null command was given");
        }
    }
}
