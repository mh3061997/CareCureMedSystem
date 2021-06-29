package com.carecure.medsysten;

import com.carecure.medsysten.dtos.appointment.GetAppointmentSimpleDto;
import com.carecure.medsysten.dtos.patient.GetPatientSimpleDto;
import com.carecure.medsysten.resources.resAppointment;
import com.carecure.medsysten.resources.resPatient;
import com.carecure.medsysten.services.servAppointment;
import com.carecure.medsysten.services.servPatient;
import com.carecure.medsysten.utils.mappers.AppointmentMapper;
import com.carecure.medsysten.utils.mappers.PatientMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CareCureMedsystemApplicationTests {

    @Autowired
    PatientMapper patientMapper;
    @Autowired
    servPatient servPatient;

    @Autowired
    servAppointment servAppointment;
    @Autowired
    AppointmentMapper appointmentMapper;


    @Test
    void contextLoads() {
    }

    @Test
    void patientMapperSimpleDtoTest(){

        resPatient dao = servPatient.getPatientByCode(1);
        GetPatientSimpleDto simpleDto = patientMapper.mapPatientDaoToSimpleDto(dao);

        assertEquals(dao.getCode(),simpleDto.getCode());
        assertEquals(dao.getName(),simpleDto.getName());
        assertEquals(dao.getGender(),simpleDto.getGender());
        assertEquals(dao.getEmail(),simpleDto.getEmail());
        assertEquals(dao.getMobile(),simpleDto.getMobile());
        assertEquals(dao.getAge(),simpleDto.getAge());
        assertEquals(dao.getTotalDebt(),simpleDto.getTotalDebt());
        assertEquals(dao.getNotes(),simpleDto.getNotes());

    }
    @Test
    void AppointmentMapperSimpleDtoTest(){

        resAppointment dao = servAppointment.getAppointmentByCode(1);
        GetAppointmentSimpleDto simpleDto = appointmentMapper.mapAppointmentDaoToSimpleDto(dao);

        assertEquals(dao.getCode(),simpleDto.getCode());
        assertEquals(dao.getSpeciality(),simpleDto.getSpeciality());
        assertEquals(dao.getDateCreated(),simpleDto.getDateCreated());
        assertEquals(dao.getDateToVisit(),simpleDto.getDateToVisit());
        assertEquals(dao.getType(),simpleDto.getType());
        assertEquals(dao.getNotes(),simpleDto.getNotes());
        assertEquals(dao.getStatus(),simpleDto.getStatus());
        assertEquals(dao.getPatient().getCode(),simpleDto.getPatientCode());
        assertEquals(dao.getPatient().getName(),simpleDto.getPatientName());
        assertEquals(dao.getDoctor().getCode(),simpleDto.getPatientMobile());
        assertEquals(dao.getDoctor().getName(),simpleDto.getDoctorName());
        assertEquals(dao.getUserLoggerName(),simpleDto.getUserLoggerName());

    }
}
