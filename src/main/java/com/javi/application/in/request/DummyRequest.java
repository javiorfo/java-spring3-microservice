package com.javi.application.in.request;

import jakarta.validation.constraints.NotBlank;

public record DummyRequest(@NotBlank(message = "Info is mandatory") String info) {}
