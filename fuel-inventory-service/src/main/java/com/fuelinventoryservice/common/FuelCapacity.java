package com.fuelinventoryservice.common;

public enum FuelCapacity {
    CAPACITY_13200("CAPACITY_13200", 13200L),
    CAPACITY_6600("CAPACITY_6600", 6600L),
    CAPACITY_3300("CAPACITY_3300", 3300L);


    public final String capValue;
    public final Long capacity;

    public String getcapValue() {
        return this.capValue;
    }

    public Long getCapacity() {
        return this.capacity;
    }

    @Override
    public String toString() {
        return this.getcapValue();
    }

    FuelCapacity(String value, Long capacity) {
        this.capValue = value;
        this.capacity = capacity;
    }

    public static FuelCapacity getEnum(String capValue) {
        for (FuelCapacity c : values())
            if (c.getcapValue().equalsIgnoreCase(capValue)) return c;
        throw new IllegalArgumentException(String.format("No Fuel Capacity Found For: %s", capValue));
    }
}
