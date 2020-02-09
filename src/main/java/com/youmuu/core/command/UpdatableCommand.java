package com.youmuu.core.command;

public interface UpdatableCommand<T> {
    void updateData(T data);
}
