package com.cts.jdbc.ui;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ResultSetEmployDemo {

	public static void main(String[] args) {
		try(	Scanner scan=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","welcome");){
			
			String sql="select job_id, department_id, count(*) from employees group by department_id";
			CallableStatement cs=con.prepareCall(sql);
			//cs.setString(1, "no_of_employees");
			cs.executeQuery();
			ResultSet rs=cs.getResultSet();
			while(rs.next()) {
				System.out.printf("%-15s%-9s%d\n", rs.getString("job_id"), rs.getString("department_id"), rs.getInt("count(*)"));
			}
			System.out.println("Executed");
			
		} catch (SQLException e) {
			System.out.println("Not Executed");
			e.printStackTrace();
		}


	}

}
