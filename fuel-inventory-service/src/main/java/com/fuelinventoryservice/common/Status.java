package com.fuelinventoryservice.common;

public enum Status {
    ALLOCATED("Allocated"),
    NOT_ALLOCATED("Not_allocated");

    public final String value;

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    Status(String value) {
        this.value = value;
    }

    public static Status getEnum(String value) {
        for (Status s : values())
            if (s.getValue().equalsIgnoreCase(value)) return s;
        throw new IllegalArgumentException(String.format("Error in status For: %s", value));
    }
}