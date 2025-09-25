package dev.etimbuk.mapper;

import dev.etimbuk.dto.StaffResponse;
import dev.etimbuk.models.Staff;
import org.mapstruct.Mapper;

@Mapper
public interface StaffResponseMapper {
    StaffResponse to(Staff staff);
}
