package com.chaosystema.domain.model;

import java.util.Objects;

public record Dummy(String info) {
    public Dummy {
        info = Objects.requireNonNull(info);
    }
}
