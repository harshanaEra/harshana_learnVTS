package com.fuelscheduleservice.common;

public enum FuelCapacity {
    CAPACITY_13200("CAPACITY_13200"),
    CAPACITY_6600("CAPACITY_6600"),
    CAPACITY_3300("CAPACITY_3300");


    public final String capValue;

    public String getcapValue() {
        return this.capValue;
    }

    @Override
    public String toString(){
        return this.getcapValue();
    }

    FuelCapacity(String value){
        this.capValue = value;
    }

    public static FuelCapacity getEnum(String capValue){
        for (FuelCapacity c : values())
            if (c.getcapValue().equalsIgnoreCase(capValue)) return c;
        throw new IllegalArgumentException(String.format("No Fuel Capacity Found For: %s",capValue));
    }
}
