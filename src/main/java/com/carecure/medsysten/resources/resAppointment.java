package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "resappointment")
@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@NoArgsConstructor
public class resAppointment
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	private String speciality;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateToVisit;
	private String status;
	private String type;
	private String notes;
	private String userLoggerName;
	//@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctorCode")
	private resDoctor doctor;

	//@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patientCode")
	private resPatient patient;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "appointment")
	private resInvoice invoice;

	@Column(columnDefinition = "TEXT")
	private String doctorNote;
	//History
	@Column(columnDefinition = "TEXT")
	private String complain;
	@Column(columnDefinition = "TEXT")
	private String presentIllnessHistory;
	@Column(columnDefinition = "TEXT")
	private String pastHistory;
	@Column(columnDefinition = "TEXT")
	private String drugHistory;
	@Column(columnDefinition = "TEXT")
	private String familyHistory;
	@Column(columnDefinition = "TEXT")
	private String lumpOrUlcerHistoryDuration;
	@Column(columnDefinition = "TEXT")
	private String lumpOrUlcerHistoryFirstSymptoms;
	@Column(columnDefinition = "TEXT")
	private String lumpOrUlcerHistoryOtherSymptoms;
	@Column(columnDefinition = "TEXT")
	private String lumpOrUlcerHistoryProgression;
	@Column(columnDefinition = "TEXT")
	private String lumpOrUlcerHistoryMultiplicity;
	@Column(columnDefinition = "TEXT")
	private String lumpOrUlcerHistoryCauses;

	//Examination
	@Column(columnDefinition = "TEXT")
	private String generalCondition;
	@Column(columnDefinition = "TEXT")
	private String vitalData;
	@Column(columnDefinition = "TEXT")
	private String chestExamination;
	@Column(columnDefinition = "TEXT")
	private String abdominalExamination;
	@Column(columnDefinition = "TEXT")
	private String localExaminationForUlcerAndLumpSite;
	@Column(columnDefinition = "TEXT")
	private String localExaminationForUlcerAndLumpShape;
	@Column(columnDefinition = "TEXT")
	private String localExaminationForUlcerAndLumpSize;
	@Column(columnDefinition = "TEXT")
	private String localExaminationForUlcerAndLumpColor;
	@Column(columnDefinition = "TEXT")
	private String localExaminationForUlcerAndLumpTemperature;
	@Column(columnDefinition = "TEXT")
	private String localExaminationForUlcerAndLumpTenderness;
	@Column(columnDefinition = "TEXT")
	private String localExaminationForUlcerAndLumpSurface;
	@Column(columnDefinition = "TEXT")
	private String localExaminationForUlcerAndLumpAge;
	@Column(columnDefinition = "TEXT")
	private String localExaminationForUlcerAndLumpConsistence;
	@Column(columnDefinition = "TEXT")
	private String localExaminationForUlcerAndLumpReducability;
	@Column(columnDefinition = "TEXT")
	private String localExaminationForUlcerAndLumpRelationToSurroundStructure;
	@Column(columnDefinition = "TEXT")
	private String localExaminationForUlcerAndLumpLymphDrainage;
	@Column(columnDefinition = "TEXT")
	private String breastExaminationAbnormalFindingsDuringBreastExam;
	@Column(columnDefinition = "TEXT")
	private String breastExaminationNippleDischarge;
	@Column(columnDefinition = "TEXT")
	private String breastExaminationSkinInvolvement;
	@Column(columnDefinition = "TEXT")
	private String breastExaminationAxillaryMass;
	@Column(columnDefinition = "TEXT")
	private String breastExaminationBreastMass;
	@Column(columnDefinition = "TEXT")
	private String breastExaminationMobileRight;
	@Column(columnDefinition = "TEXT")
	private String breastExaminationSize;
	@Column(columnDefinition = "TEXT")
	private String neckExamination;

	//Investigations
	@Column(columnDefinition = "TEXT")
	private String lab;
	@Column(columnDefinition = "TEXT")
	private String radiology;
	@Column(columnDefinition = "TEXT")
	private String endoscopic;
	@Column(columnDefinition = "TEXT")
	private String biopsy;

	//Diagnoses
	@Column(columnDefinition = "TEXT")
	private String provisionalDiagnoses;
	@Column(columnDefinition = "TEXT")
	private String finalDiagnosis;
	@Column(columnDefinition = "TEXT")
	private String planOfManagement;
	@Column(columnDefinition = "TEXT")
	private String operativeDetails;
	@Column(columnDefinition = "TEXT")
	private String postOperativeComplication;

}
