package com.carecure.medsysten.services;

import com.carecure.medsysten.resources.resNoteAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class servNoteAppointment {

    @Autowired
    com.carecure.medsysten.repositories.repoNoteAppointment repoNoteAppointment;

    //return all noteAppointments in db
    public List<resNoteAppointment> getNoteAppointmentAll(){
        List<resNoteAppointment> NoteAppointmentList = new ArrayList<>();
        repoNoteAppointment.findAll().forEach(NoteAppointmentList::add);
        return NoteAppointmentList;
    }

    //return app by id
    public resNoteAppointment getNoteAppointmentByCode(long code){
        Optional<resNoteAppointment> noteAppointment = repoNoteAppointment.findById(code);
        if(noteAppointment.isPresent())
            return noteAppointment.get();
        else
            //throw exception
            return null;
    }

    public void  addNoteAppointment(resNoteAppointment newNoteAppointment){
        System.out.println(newNoteAppointment.getNote());
        repoNoteAppointment.save(newNoteAppointment);
    }

    public void updateNoteAppointment(long noteAppointmentCode, resNoteAppointment updatedNoteAppointment){
        Optional<resNoteAppointment> noteAppointment = repoNoteAppointment.findById(noteAppointmentCode);
        if(noteAppointment.isPresent()){
            updatedNoteAppointment.setCode(noteAppointmentCode);
            repoNoteAppointment.save(updatedNoteAppointment);
        }
    }

    public void deleteNoteAppointment(long code){

        Optional<resNoteAppointment> noteAppointment = repoNoteAppointment.findById(code);
        if(noteAppointment.isPresent())
            repoNoteAppointment.deleteById(code);
        else
            //throw exception
            return;
    }

}