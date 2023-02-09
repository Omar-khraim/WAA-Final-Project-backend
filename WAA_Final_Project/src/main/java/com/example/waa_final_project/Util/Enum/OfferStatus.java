package com.example.waa_final_project.Util.Enum;

public enum OfferStatus {
    Approved(1),
    Rejected(2),
    Deleted(3),
    Waiting(4),
    Contingent(5),
    Done(6);


    private final int value;

    OfferStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
