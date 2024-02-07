package org.totmysj.service;

import org.test.models.SmsMessage;
import org.totmysj.dto.AppointmentDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@lombok.extern.slf4j.Slf4j
@lombok.RequiredArgsConstructor
@Service

class AppointmentServiceImpl implements AppointmentService
{
    private final PatientService patientService;
    private final KafkaTemplate<String, SmsMessage> kafkaTemplate;
    @Override
    public void createAppointment(AppointmentDto appointment)
    {
        var patient = patientService.searchPatientByPatientId(appointment.getPatientId());
        var message = String.format("Appointment Time: %s, Appointment Date: %s, Location: %s",
                appointment.getTime(), appointment.getDate(), appointment.getLocation());
        var smsMessage = new SmsMessage(patient.getContactNo(), message);

        kafkaTemplate.send("sms",smsMessage);
    }
}
