package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

   private Connection conn;
   private PreparedStatement pst;
   private ResultSet rs;
   private int cnt;
   
   // 연결기능
   public void connect() {
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String dbid = "hr";
      String dbpw = "hr";

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(url, dbid, dbpw);
         if (conn != null) {
            System.out.println("연결성공");
         } else {
            System.out.println("연결실패");
         }
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }
   
   // 회원가입
   public int joinMember(MemberDTO member) {
      
      connect();
      
      String sql = "INSERT INTO MT_USER VALUES(SEQ_USER.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
      try {
         pst = conn.prepareStatement(sql);
         pst.setString(1, member.getId());
         pst.setString(2, member.getPw());
         pst.setString(3, member.getName());
         pst.setString(4, member.getCompany_name());
         pst.setString(5, member.getDepartment_name());
         pst.setString(6, member.getPosition());
         pst.setString(7, member.getPhone());
         pst.setString(8, member.getEmail());
         pst.setString(9, member.getCompany_code());
         pst.setString(10, member.getDepartment_code());

         cnt = pst.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return cnt;
   }
   
   // 아이디 중복 체크
   public int idCheck(String id) {
      
      connect();
      
      String sql = "SELECT*FROM MT_USER WHERE ID=?";
      try {
         pst = conn.prepareStatement(sql);
         pst.setString(1, id);
         rs = pst.executeQuery();

         if(rs.next() || id.equals("")) {
            return 1;
         } else {
            return 0;
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return -1;
   }
   
   // 회사코드 인증
   public int cpCodeCheck(String companyCode) {
      
      connect();
      
      String sql = "SELECT*FROM MT_COMPANY WHERE CODE=?";
      try {
         pst = conn.prepareStatement(sql);
         pst.setString(1, companyCode);
         rs = pst.executeQuery();

         if(rs.next()) {
            return 1;
         } else {
            return 0;
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return -1;
   }
   
   // 부서코드 인증
   public int dmCodeCheck(String departmentCode) {
      
      connect();
      
      String sql = "SELECT*FROM MT_DEPARTMENT WHERE CODE=?";
      try {
         pst = conn.prepareStatement(sql);
         pst.setString(1, departmentCode);
         rs = pst.executeQuery();

         if(rs.next()) {
            return 1;
         } else {
            return 0;
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return -1;
   }
   
   // 로그인
   public MemberDTO loginMember(String id, String pw) {
      
      connect();
      
      String sql = "select id, name, company_name, department_name, position, company_code, department_code from mt_user where id=? and pw=?";
      try {
         pst = conn.prepareStatement(sql);
         pst.setString(1, id);
         pst.setString(2, pw);

         rs = pst.executeQuery();
         
         if (rs.next()) {
            return new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7));
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return null;
   }
    
   // 연결해제
   public void close() {
      try {
         if(rs != null) {
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

   






   
   
} // end class.