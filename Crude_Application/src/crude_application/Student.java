package crude_application;
import java.sql.*;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    Scanner sc = new Scanner(System.in);
    int z;
    void addRecord() throws ClassNotFoundException, SQLException {

        System.out.println("\t\t\tWelcome");
        System.out.println();
        System.out.println("1. Add STUDENT : ");
        System.out.println("2. Update Student : ");
        System.out.println("3. Get Student ");
        System.out.println("4. GET aa STUDENT: ");
        System.out.println("5.Delete STUDENT");
        z=sc.nextInt();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "9787");
        Class.forName("com.mysql.cj.jdbc.Driver");
        if(z==1) {

            while (true) {
                System.out.println("Enter the id of Student :");
                int st_id = sc.nextInt();

                System.out.println("Enter the RollNumber of Student :");
                String st_rollNumber = sc.next();

                System.out.println("Enter the Name of Student :");
                String st_name = sc.next();

                System.out.println("Enter the FatherName of Student :");
                String st_fatherName = sc.next();

                System.out.println("Enter the Age of Student :");
                int st_age = sc.nextInt();

                System.out.println("Enter the email of Student :");
                String st_email = sc.next();

                System.out.println("Enter the MobileNumber of Student :");
                String st_mobile_Number = sc.next();

                System.out.println("Enter the DepartmentID of Student :");
                int dep_ID = sc.nextInt();

                PreparedStatement ps = con.prepareStatement("insert into students values(?,?,?,?,?,?,?,?)");
                ps.setInt(1, st_id);
                ps.setString(2, st_rollNumber);
                ps.setString(3, st_name);
                ps.setString(4, st_fatherName);
                ps.setInt(5, st_age);
                ps.setString(6, st_email);
                ps.setString(7, st_mobile_Number);
                ps.setInt(8, dep_ID);

                ps.execute();
                System.out.println("Do you want continoue");
                System.out.println("1.      Yes");
                System.out.println("2.      No");
                z = sc.nextInt();
                if (z == 1) {

                } else {
                    break;
                }
//                if (i < 0) System.out.println("data is not added");
//                else {
//                    System.out.println("Data is added successfully");
//                }
//            }




                }
    } else if (z==2) {
                while (true){

                             System.out.println("Enter the id of Student :");
                             int st_id = sc.nextInt();
                             System.out.println("Enter the New Name of Student :");
                             String st_name = sc.next();
                             PreparedStatement ps = con.prepareStatement("update students Set  st_name=? where st_id=?");
                             ps.setInt(1, st_id);
                             ps.setString(2, st_name);
                             int i = ps.executeUpdate();
                             System.out.println("Do you want continoue");
                             System.out.println("1.      Yes");
                             System.out.println("2.      No");

                             z = sc.nextInt();
                                        if (z == 1) {
                                                 } else {
                                              break;
                                        }
                             if (i < 0) {
                                 System.out.println("data is not added");
                             }else {
                                 System.out.println();
                                     }
                }
    }
        else if (z==3) {
            PreparedStatement ps2 = con.prepareStatement("Select * from students");
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                System.out.println("Student ID            : " + rs.getInt("st_id"));
                System.out.println("Student RollNumber    : " + rs.getString("st_rollNumber"));
                System.out.println("Student Name          : " + rs.getString("st_name"));
                System.out.println("Student FatherName    : " + rs.getString("st_fatherName"));
                System.out.println("Student Age           : " + rs.getInt("st_age"));
                System.out.println("Student Email         : " + rs.getString("st_email"));
                System.out.println("Student MobileNumber  : " + rs.getInt("st_mobile_Number"));
                System.out.println("Department ID         : " + rs.getInt("dep_ID"));
                System.out.println("---------------------------------------------");
                System.out.println("Do you  want another record :");
                System.out.println("1. Yes                  \n2.  No  ");
                z = sc.nextInt();
                if (z == 1) {
                    continue;
                } else {
                    break;
                }
        }
        } else if (z==4) {
            PreparedStatement ps2 = con.prepareStatement("Select * from students");
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {

                System.out.println("Student ID            : " + rs.getInt("st_id"));
                System.out.println("Student RollNumber    : " + rs.getString("st_rollNumber"));
                System.out.println("Student Name          : " + rs.getString("st_name"));
                System.out.println("Student FatherName    : " + rs.getString("st_fatherName"));
                System.out.println("Student Age           : " + rs.getInt("st_age"));
                System.out.println("Student Email         : " + rs.getString("st_email"));
                System.out.println("Student MobileNumber  : " + rs.getInt("st_mobile_Number"));
                System.out.println("Department ID         : " + rs.getInt("dep_ID"));
                System.out.println("---------------------------------------------");
        }
    } else if (z==5){

            while (true) {
                PreparedStatement ps1 = con.prepareStatement("delete from students where st_id=?");
                System.out.println("Enter the Student ID   :");
                int st_id = sc.nextInt();
                ps1.setInt(1, st_id);
                int i1 = ps1.executeUpdate();
                System.out.println("Data is Deleted successfully");
                System.out.println("Do you want continoue to Delete anOther Recoord :   ");
                System.out.println("1.      Yes");
                System.out.println("2.      No");
                z = sc.nextInt();
                if (z == 1) {

                } else {
                    break;
                }
                if (i1 < 0) {
                    System.out.println("data is not Deleted");
                }
                else {
                    System.out.println();
                }
            }
        }

    }


}
