package com.carecure.medsysten.resources.Utils;

public class resContactUsData
{

	String name;
	String email;
	String mobile;
	String Message;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getMessage()
	{
		return Message;
	}

	public void setMessage(String message)
	{
		Message = message;
	}

	public resContactUsData(String name, String email, String mobile, String message)
	{
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		Message = message;
	}
}
