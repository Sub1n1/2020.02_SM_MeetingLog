package com.model;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String company_name;
	private String department_name;
	private String position;
	private String phone;
	private String email;
	private String company_code;
	private String department_code;

	// All
	public MemberDTO(String id, String pw, String name, String company_name, String department_name, String position,
			String phone, String email, String company_code, String department_code) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.company_name = company_name;
		this.department_name = department_name;
		this.position = position;
		this.phone = phone;
		this.email = email;
		this.company_code = company_code;
		this.department_code = department_code;
	}

	// pw, phone, email Á¦¿Ü
	public MemberDTO(String id, String name, String company_name, String department_name, String position,
			String company_code, String department_code) {
		super();
		this.id = id;
		this.name = name;
		this.company_name = company_name;
		this.department_name = department_name;
		this.position = position;
		this.company_code = company_code;
		this.department_code = department_code;
	}



	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public String getPosition() {
		return position;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getCompany_code() {
		return company_code;
	}

	public String getDepartment_code() {
		return department_code;
	}

}
