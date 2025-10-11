package dev.etimbuk.service;

import dev.etimbuk.dto.PersonResponse;
import dev.etimbuk.mapper.PersonResponseMapper;
import dev.etimbuk.models.Patient;
import dev.etimbuk.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final PersonResponseMapper patientResponseMapper;

    public List<PersonResponse> findAllPatientsByFirstName(final String firstName) {
        if (!StringUtils.hasText(firstName)) {
            return List.of();
        }

        final var exampleMatcher = ExampleMatcher.matching()
            .withIgnoreCase()
            .withIgnoreNullValues()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        final var patientProbe = new Patient();
        patientProbe.setFirstName(firstName);

        return patientRepository.findAll(Example.of(patientProbe, exampleMatcher)).stream().map(patientResponseMapper::to).toList();
    }

    public List<PersonResponse> findAllPatientsByEmailAddress(final String emailAddress) {
        if (!StringUtils.hasText(emailAddress)) {
            return List.of();
        }

        final var patientProbe = new Patient();
        patientProbe.setEmail(emailAddress);

        return findAllPatients(patientProbe, exactCaseInsensitiveMatchExampleMatcher());
    }

    public List<PersonResponse> findAllPatients(final String searchCriteria) {
        if (!StringUtils.hasText(searchCriteria)) {
            return List.of();
        }

        final var patientProbe = new Patient();
        patientProbe.setEmail(searchCriteria);
        patientProbe.setFirstName(searchCriteria);
        patientProbe.setLastName(searchCriteria);

        return findAllPatients(patientProbe, customCaseInsensitiveMatchExampleMatcher(StringMatcher.CONTAINING));
    }

    private List<PersonResponse> findAllPatients(final Patient probe, final ExampleMatcher matcher) {
        return patientRepository.findAll(Example.of(probe, matcher)).stream().map(patientResponseMapper::to).toList();
    }

    private ExampleMatcher exactCaseInsensitiveMatchExampleMatcher() {
        return ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase();
    }

    private ExampleMatcher customCaseInsensitiveMatchExampleMatcher(final StringMatcher stringMatcher) {
        return ExampleMatcher.matchingAny().withIgnoreNullValues().withIgnoreCase().withStringMatcher(stringMatcher);
    }
}
