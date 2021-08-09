package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MeetingDAO {
	// �����ͺ��̽� ���� �ʵ庯��
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private int cnt;

	// ������
	public void connect() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String dbid = "hr";
		String dbpw = "hr";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, dbid, dbpw);

			if (conn == null) {
				System.out.println("���� ����");
			} else {
				System.out.println("���� ����");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ��������
	public void close() {
		// �����ͺ��̽� ����� �ڿ� ����
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ȸ�Ƿ� DB�� �����ϱ�
	public int saveMinute(MeetingDTO meeting) {

		connect();

		String sql = "INSERT INTO MT_MINUTES VALUES(SEQ_MINUTES.NEXTVAL,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, meeting.getCode());
			pst.setString(2, meeting.getCompany_code());
			pst.setString(3, meeting.getDepartment_code());
			pst.setString(4, meeting.getWriter_name());
			pst.setString(5, meeting.getMeeting_place());
			pst.setString(6, meeting.getMeeting_date());
			pst.setString(7, meeting.getJoiner());
			pst.setString(8, meeting.getJoiner_department());
			pst.setString(9, meeting.getMeeting_title());		
			pst.setString(10, meeting.getMeeting_summary());
			pst.setString(11, meeting.getMeeting_final());
			pst.setString(12, meeting.getWordcloud());
			pst.setString(13, meeting.getEtc1_title());
			pst.setString(14, meeting.getEtc1());
			pst.setString(15, meeting.getEtc2_title());
			pst.setString(16, meeting.getEtc2());
			pst.setString(17, meeting.getMeeting_name());

			cnt = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// ȸ�Ƿ� �����ڵ� ��ġ�°� �ִ��� Ȯ��
	public boolean findSameCode(String code) {
		connect();
		String sql = "select code from MT_MINUTES where code = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, code);

			rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}
	
	// ȸ�Ƿ� ��� �ҷ�����
	public ArrayList<MeetingDTO> selectMinutes(String company_code, String department_code) {
		ArrayList<MeetingDTO> minutes = new ArrayList<MeetingDTO>();
		connect();
		String sql = "select meeting_name, meeting_date, writer_name, write_date from mt_minutes where company_code = ? and department_code = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, company_code);
			pst.setString(2, department_code);

			rs = pst.executeQuery();

			while(rs.next()) {
				minutes.add(new MeetingDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return minutes;
	}
	
	// ��ȸ �� �˻� �� �ش� ȸ�Ƿ� ���� ��������
	public MeetingDTO showMinutes(String meeting_name) {
		connect();
		String sql = "select * from mt_minutes where meeting_name = ?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, meeting_name);

			rs = pst.executeQuery();

			while (rs.next()) {
				return new MeetingDTO(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}
}
