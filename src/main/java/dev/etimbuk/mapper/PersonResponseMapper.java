package dev.etimbuk.mapper;

import dev.etimbuk.dto.PersonResponse;
import dev.etimbuk.models.Patient;
import dev.etimbuk.models.Staff;
import org.mapstruct.Mapper;

@Mapper
public interface PersonResponseMapper {
    PersonResponse to(Staff staff);
    PersonResponse to(Patient patient);
}
