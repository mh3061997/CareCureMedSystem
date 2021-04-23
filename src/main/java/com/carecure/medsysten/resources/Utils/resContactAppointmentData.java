package com.carecure.medsysten.resources.Utils;

public class resContactAppointmentData

{
	String name;
	String mobile;
	String speciality;
	String doctorName;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getSpeciality()
	{
		return speciality;
	}

	public void setSpeciality(String speciality)
	{
		this.speciality = speciality;
	}

	public String getDoctorName()
	{
		return doctorName;
	}

	public void setDoctorName(String doctorName)
	{
		this.doctorName = doctorName;
	}

	public resContactAppointmentData(String name, String mobile, String speciality, String doctorName)
	{
		this.name = name;
		this.mobile = mobile;
		this.speciality = speciality;
		this.doctorName = doctorName;
	}
}
