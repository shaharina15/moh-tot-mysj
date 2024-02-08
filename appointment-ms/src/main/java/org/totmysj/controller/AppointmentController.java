package org.totmysj.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.totmysj.dto.AppointmentDto;
import org.totmysj.service.AppointmentService;
@lombok.RequiredArgsConstructor
@RestController

class AppointmentController
{
    private final AppointmentService appointmentService;

    @PostMapping("/appointment")
    void createAppointment(@RequestBody AppointmentDto appointment)
    {
        appointmentService.createAppointment(appointment);
    }
}