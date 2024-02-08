package org.totmysj.service;

import org.springframework.http.HttpStatusCode;
import org.totmysj.dto.PatientDto;
import org.totmysj.models.SmsMessage;
import org.totmysj.dto.AppointmentDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@lombok.extern.slf4j.Slf4j
@lombok.RequiredArgsConstructor
@Service

class AppointmentServiceImpl implements AppointmentService
{
    private final KafkaTemplate<String, SmsMessage> kafkaTemplate;
    private final RestClient patientRestClient = RestClient.builder()
            .baseUrl("http://localhost:8080")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
    @Override
    public void createAppointment(AppointmentDto appointment)
    {
        var patient = patientRestClient.get()
                .uri("/patient",
                        uriBuilder -> uriBuilder.queryParam("patientId", appointment.getPatientId()).build())
                .retrieve()
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) ->
                {
                    throw new RuntimeException("Error connection to patient-ms");
                })
                .onStatus(HttpStatusCode::is4xxClientError,(request, response) ->
                {
                    throw new IllegalArgumentException("Invalid patient Id provided");
                })
                .body(PatientDto.class);
        var message = String.format("Appointment Time: %s, Appointment Date: %s, Location: %s",
                appointment.getTime(), appointment.getDate(), appointment.getLocation());
        var smsMessage = new SmsMessage(patient.getContactNo(), message);

        kafkaTemplate.send("sms",smsMessage);
    }
}