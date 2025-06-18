package com.sonatel.recouvrement.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TypeEvenement {
    RESTRICTION,
    RESILIATION,
    SUSPENSION,
    RETABLISSEMENT;

    @JsonCreator
    public static TypeEvenement fromString(String key) {
        return key == null ? null : TypeEvenement.valueOf(key.toUpperCase());
    }
}

