package dev.etimbuk;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SQLSelect {
    public static final String JPQL_GET_STAFF_BY_APPOINTMENT_DATE =
              """
                SELECT
                    new dev.etimbuk.dto.StaffAppointmentResponse(
                     s.firstName,
                     s.lastName,
                     s.position,
                     appts.status,
                     appts.appointmentReason,
                     appts.appointmentDate
                    )
                 FROM staff s
                 JOIN s.appointments appts
                 WHERE appts.appointmentDate = :appointmentDate
              """;

    public static final String JPQL_VARIANT_GET_STAFF_BY_APPOINTMENT_DATE =
        """
          SELECT
                  s.firstName,
                  s.lastName,
                  s.position,
                  appts.status,
                  appts.appointmentReason,
                  appts.appointmentDate
              FROM staff s
              JOIN appointments appts ON appts.staffAppointment.id = s.id
              WHERE appts.appointmentDate = :appointmentDate
        """;
}
