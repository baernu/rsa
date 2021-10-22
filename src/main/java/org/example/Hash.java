package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hash {
    private String string;
    private int key;
    private int hashCode;

    public Hash(String string, int key) {
        this.string = string;
        this.key = key;
        this.hashCode = hashCode();
    }

    public String getString() {
        return string;
    }

    public int getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hash hash = (Hash) o;
        return key == hash.key && Objects.equals(string, hash.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string, key);
    }
}
