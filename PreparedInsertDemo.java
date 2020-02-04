package com.cts.jdbc.ui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedInsertDemo {

	public static void main(String[] args) {
		try(	Scanner scan=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","welcome");){
			String regionName;
			int regionId;
			
			System.out.println("Enter Region Id:");
			regionId=scan.nextInt();
			System.out.println("Enter Region Name:");
			regionName=scan.next();
			
			String sql="Update regions set region_name=? where region_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, regionName);
			ps.setInt(2, regionId);
			ps.executeUpdate();
			
			System.out.println("Row inserted");
			
		} catch (SQLException e) {
			System.out.println("Not inserted");
			e.printStackTrace();
		}

	}

}
