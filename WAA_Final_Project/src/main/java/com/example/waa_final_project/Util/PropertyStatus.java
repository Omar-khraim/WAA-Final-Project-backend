package com.example.waa_final_project.Util;

public enum PropertyStatus {
    Available(1),
    Pending(2),
    Contingent(3);

    private final int value;

    PropertyStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
