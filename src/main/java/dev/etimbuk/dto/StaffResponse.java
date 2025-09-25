package dev.etimbuk.dto;

import lombok.Builder;

@Builder
public record StaffResponse(String firstName, String lastName) {
}
