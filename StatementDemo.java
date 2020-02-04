package com.cts.jdbc.ui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StatementDemo {

	public static void main(String[] args) {
		try(	Scanner scan=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","welcome");) {
			String regionName;
			int regionId;
			
			System.out.println("Enter Region Id:");
			regionId=scan.nextInt();
			System.out.println("Enter Region Name:");
			regionName=scan.next();
			
			String sql="insert into regions values("+regionId+","+"'"+regionName+"'"+")";
			Statement st=con.createStatement();
			
			st.executeUpdate(sql);
			System.out.println("Row inserted");
		} catch (SQLException e) {
			System.err.println("no data inserted");
			e.printStackTrace();
		}

	}

}
