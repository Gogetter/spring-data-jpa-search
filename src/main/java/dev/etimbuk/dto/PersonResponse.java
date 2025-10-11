package dev.etimbuk.dto;

import lombok.Builder;

@Builder
public record PersonResponse(String firstName, String lastName) {
}
