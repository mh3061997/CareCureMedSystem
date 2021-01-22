package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntNoteAppointment;
import com.carecure.medsysten.resources.resNoteAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
public class implNoteAppointment implements contIntNoteAppointment {

    @Autowired
    private com.carecure.medsysten.services.servNoteAppointment servNoteAppointment;

    @CrossOrigin
    @Override
    public List<resNoteAppointment> getNoteAppointmentAll() {
        return servNoteAppointment.getNoteAppointmentAll();
    }

    @Override
    public resNoteAppointment getNoteAppointmentById(long code) {
        return servNoteAppointment.getNoteAppointmentByCode(code);
    }

    @Override
    public void addNoteAppointment(resNoteAppointment newNoteAppointment) {
        servNoteAppointment.addNoteAppointment(newNoteAppointment);
    }

    @Override
    public void updateNoteAppointment(long code, resNoteAppointment updatedNoteAppointment) {
        servNoteAppointment.updateNoteAppointment(code,updatedNoteAppointment);
    }

    @Override
    public void deleteNoteAppointment(long code) {
        servNoteAppointment.deleteNoteAppointment(code);
    }
}
