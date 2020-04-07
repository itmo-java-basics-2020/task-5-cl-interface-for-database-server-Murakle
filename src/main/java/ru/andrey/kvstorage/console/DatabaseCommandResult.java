package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    Optional<String> getErrorMessage();

    static DatabaseCommandResult success(String result) {
        return new SimpleDatabaseCommandResult(Optional.of(result), Optional.empty(), DatabaseCommandStatus.SUCCESS);
    }

    static DatabaseCommandResult error(String errorMessage) {
        return new SimpleDatabaseCommandResult(Optional.empty(), Optional.of(errorMessage), DatabaseCommandStatus.FAILED);
    }

    enum DatabaseCommandStatus {
        SUCCESS(true),
        FAILED(false);

        private boolean status;

        private DatabaseCommandStatus(boolean status) {
            this.status = status;
        }

        public boolean isSuccess() {
            return status;
        }
    }

    public class SimpleDatabaseCommandResult implements DatabaseCommandResult {

        private Optional<String> errorMessage;
        private Optional<String> result;
        private DatabaseCommandStatus status;

        private SimpleDatabaseCommandResult(Optional<String> result, Optional<String> errorMessage, DatabaseCommandStatus status) {
            this.result = result;
            this.errorMessage = errorMessage;
            this.status = status;
        }


        @Override
        public Optional<String> getResult() {
            return result;
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            return status;
        }

        @Override
        public boolean isSuccess() {
            return false;
        }

        @Override
        public Optional<String> getErrorMessage() {
            return errorMessage;
        }
    }
}