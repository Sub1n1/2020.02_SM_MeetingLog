package com.model;

public class MeetingDTO {
	private String code;
	private String company_code;
	private String department_code;
	private String writer_name;
	private String write_date;
	private String meeting_place;
	private String meeting_date;
	private String joiner;
	private String joiner_department;
	private String meeting_title;
	private String meeting_summary;
	private String meeting_final;
	private String wordcloud;
	private String etc1_title;
	private String etc1;
	private String etc2_title;
	private String etc2;
	private String meeting_name;

	// All
	public MeetingDTO(String code, String company_code, String department_code, String writer_name, String write_date,
			String meeting_place, String meeting_date, String joiner, String joiner_department, String meeting_title,
			String meeting_summary, String meeting_final, String wordcloud, String etc1_title, String etc1,
			String etc2_title, String etc2, String meeting_name) {
		this.code = code;
		this.company_code = company_code;
		this.department_code = department_code;
		this.writer_name = writer_name;
		this.write_date = write_date;
		this.meeting_place = meeting_place;
		this.meeting_date = meeting_date;
		this.joiner = joiner;
		this.joiner_department = joiner_department;
		this.meeting_title = meeting_title;
		this.meeting_summary = meeting_summary;
		this.meeting_final = meeting_final;
		this.wordcloud = wordcloud;
		this.etc1_title = etc1_title;
		this.etc1 = etc1;
		this.etc2_title = etc2_title;
		this.etc2 = etc2;
		this.meeting_name = meeting_name;
	}


	// write_date Á¦¿Ü
	public MeetingDTO(String code, String company_code, String department_code, String writer_name, String meeting_place,
			String meeting_date, String joiner, String joiner_department, String meeting_title, String meeting_summary,
			String meeting_final, String wordcloud, String etc1_title, String etc1, String etc2_title, String etc2,
			String meeting_name) {
		this.code = code;
		this.company_code = company_code;
		this.department_code = department_code;
		this.writer_name = writer_name;
		this.meeting_place = meeting_place;
		this.meeting_date = meeting_date;
		this.joiner = joiner;
		this.joiner_department = joiner_department;
		this.meeting_title = meeting_title;
		this.meeting_summary = meeting_summary;
		this.meeting_final = meeting_final;
		this.wordcloud = wordcloud;
		this.etc1_title = etc1_title;
		this.etc1 = etc1;
		this.etc2_title = etc2_title;
		this.etc2 = etc2;
		this.meeting_name = meeting_name;
	}


	public MeetingDTO(String meeting_name, String meeting_date, String writer_name, String write_date) {
		this.meeting_name = meeting_name;
		this.meeting_date = meeting_date;
		this.writer_name = writer_name;
		this.write_date = write_date;
	}

	

	public String getCode() {
		return code;
	}

	public String getCompany_code() {
		return company_code;
	}

	public String getDepartment_code() {
		return department_code;
	}

	public String getWriter_name() {
		return writer_name;
	}

	public String getWrite_date() {
		return write_date;
	}

	public String getMeeting_place() {
		return meeting_place;
	}

	public String getMeeting_date() {
		return meeting_date;
	}

	public String getJoiner() {
		return joiner;
	}

	public String getJoiner_department() {
		return joiner_department;
	}

	public String getMeeting_title() {
		return meeting_title;
	}

	public String getWordcloud() {
		return wordcloud;
	}

	public String getMeeting_summary() {
		return meeting_summary;
	}

	public String getMeeting_final() {
		return meeting_final;
	}

	public String getEtc1_title() {
		return etc1_title;
	}

	public String getEtc1() {
		return etc1;
	}

	public String getEtc2_title() {
		return etc2_title;
	}

	public String getEtc2() {
		return etc2;
	}

	public String getMeeting_name() {
		return meeting_name;
	}
}
