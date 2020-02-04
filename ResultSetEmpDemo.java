package com.cts.jdbc.ui;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ResultSetEmpDemo {

	public static void main(String[] args) {
		try(	Scanner scan=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","welcome");){
			
			String sql="Select * from employees where salary>? order by first_name";
			CallableStatement cs=con.prepareCall(sql);
			cs.setInt(1, 15000);
			cs.executeQuery();
			ResultSet rs=cs.getResultSet();
			while(rs.next()) {
				System.out.printf("%-6s%-8s%-10s%-15s%s\n", rs.getString("employee_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("salary"), rs.getString("job_id"));
			}
			System.out.println("Executed");
			
		} catch (SQLException e) {
			System.out.println("Not Executed");
			e.printStackTrace();
		}

	}

}
