package ru.andrey.kvstorage.logic;

import ru.andrey.kvstorage.exception.DatabaseException;

import java.util.Map;
import java.util.Optional;

public interface Table {

    String getName();

    void write(String objectKey, String objectValue) throws DatabaseException;

    String read(String objectKey) throws DatabaseException;
}
