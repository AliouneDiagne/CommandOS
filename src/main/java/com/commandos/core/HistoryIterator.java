package com.commandos.core;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Iterator per la cronologia dei comandi eseguiti.
 * Pattern: Iterator.
 */
public class HistoryIterator implements Iterator<Command> {
    private final List<Command> history;
    private int current = 0;

    public HistoryIterator(List<Command> history) {
        this.history = history != null ? List.copyOf(history) : List.of();
    }

    @Override
    public boolean hasNext() {
        return current < history.size();
    }

    @Override
    public Command next() {
        if (!hasNext()) throw new NoSuchElementException();
        return history.get(current++);
    }
}
