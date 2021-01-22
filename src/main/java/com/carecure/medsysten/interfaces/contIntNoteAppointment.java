package com.carecure.medsysten.interfaces;

        import com.carecure.medsysten.resources.resNoteAppointment;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

        import java.util.List;

@RequestMapping("/noteAppointment")
public interface contIntNoteAppointment {

    @RequestMapping
    List<resNoteAppointment> getNoteAppointmentAll();

    @RequestMapping("/{noteAppointmentCode}")
    resNoteAppointment getNoteAppointmentById(@PathVariable("noteAppointmentCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    void addNoteAppointment(@RequestBody resNoteAppointment newNoteAppointment);

    @RequestMapping(method = RequestMethod.PUT,value="/{noteAppointmentCode}")
    void updateNoteAppointment(@PathVariable("noteAppointmentCode") long code, @RequestBody resNoteAppointment updatedNoteAppointment);

    @RequestMapping(method= RequestMethod.DELETE,value="/{noteAppointmentCode}")
    void deleteNoteAppointment(@PathVariable("noteAppointmentCode") long code);
}
