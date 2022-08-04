package com.fuelorderservice.common;

public enum FuelType {
    OCTANE92("Octane-92"),
    OCTANE95("Octane-95"),
    SUPER_DIESEL("Super-Diesel"),
    DIESEL("Diesel");

    public final String value;

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    FuelType(String value) {
        this.value = value;
    }

    public static FuelType getEnum(String value) {
        for (FuelType f : values())
            if (f.getValue().equalsIgnoreCase(value)) return f;
        throw new IllegalArgumentException(String.format("No Fuel Type Found For: %s", value));
    }
}
