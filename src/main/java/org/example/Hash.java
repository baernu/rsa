package org.example;

public class Hash<T> {

    private T value;

    public Hash(T value) {
        this.value = value;
    }

    public Hash() {
    }

    public T getValue() {
        return this.value;
    }
}
