package com.sonatel.recouvrement.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatutEvenement {
    ACTIF,
    INACTIF;

    @JsonCreator
    public static StatutEvenement fromString(String key) {
        return key == null ? null : StatutEvenement.valueOf(key.toUpperCase());
    }
}

