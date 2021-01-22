package com.carecure.medsysten.repositories;

import com.carecure.medsysten.resources.resMedImage;
import com.carecure.medsysten.resources.resNoteAppointment;
import org.springframework.data.repository.CrudRepository;

public interface repoNoteAppointment extends CrudRepository<resNoteAppointment,Long> {
}
