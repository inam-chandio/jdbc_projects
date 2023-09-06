package crude_application;
import java.sql.*;
import java.util.Scanner;
public class Depatment {
    Scanner sc = new Scanner(System.in);
    int z, dep_ID;
    String dep_name, dep_code;

    public void departmentData() throws ClassNotFoundException, SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/student_management", "root", "9787");
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. Add Department : ");
        System.out.println("2. Update Department : ");
        System.out.println("3. Get Department : ");
        System.out.println("4. Get all Departments : ");
        System.out.println("5. Delete Department : ");


        z = sc.nextInt();
        if (z == 1) {
            while (true) {
                System.out.println("Enter the Department id  :");
                int dep_ID = sc.nextInt();

                System.out.println("Enter the Name of Department :");
                String dep_name = sc.next();

                System.out.println("Enter the Department Code  :");
                String dep_code = sc.next();

                PreparedStatement ps = con.prepareStatement("insert into department values(?,?,?)");
                ps.setInt(1, dep_ID);
                ps.setString(2, dep_name);
                ps.setString(3, dep_code);
                int i = ps.executeUpdate();
                System.out.println("Data is added successfully");
                System.out.println("---------------------------------");
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

                } else {
                    System.out.println("---------------------------------");
                }
            }
        } else if (z == 2) {
            System.out.println("1. Update Name of Department: ");
            System.out.println("2. Update Code of Department: ");
            z = sc.nextInt();

            switch (z) {
                case 1:
                    System.out.println("Enter the Department id  :");
                    dep_ID = sc.nextInt();

                    System.out.println("Enter the Department Name :");
                    dep_name = sc.next();

                    PreparedStatement ps = con.prepareStatement("update department Set  dep_name=? where dep_ID=?");
                    ps.setInt(1, dep_ID);
                    ps.setString(2, dep_name);
                    ps.execute();
                    System.out.println("Data is Update successfully");
                    System.out.println("Do you want continoue to update anOther Recoord :   ");
                    System.out.println("1.      Yes");
                    System.out.println("2.      No");
                    z = sc.nextInt();
                    if (z == 1) {

                    } else {
                        break;
                    }
//                    if (i < 0) {
//                        System.out.println("data is not Update");
//                    } else {
//                        System.out.println();
//                    }
                case 2:
                    System.out.println("Enter the Department id   :");
                    dep_ID = sc.nextInt();
                    System.out.println("Enter the Department Code   :");
                    dep_code = sc.next();
                    PreparedStatement ps1 = con.prepareStatement("update department Set  dep_code=? where dep_ID=?");
                    ps1.setInt(1, dep_ID);
                    ps1.setString(2, dep_code);
                    int i1 = ps1.executeUpdate();
                    System.out.println("Data is Update successfully");
                    System.out.println("------------------------------------------------");
                    System.out.println("Do you want continoue to update anOther Recoord :   ");
                    System.out.println("1.      Yes");
                    System.out.println("2.      No");
                    z = sc.nextInt();
                    if (z == 1) {

                    } else {
                        break;
                    }
                    if (i1 < 0) System.out.println("data is not Update");
                    else {
                        System.out.println();
                    }

            }
        } else if (z == 3) {
            PreparedStatement ps2 = con.prepareStatement("Select * from department");
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {

                System.out.println("Department ID    : " + rs.getInt("dep_ID"));
                System.out.println("Department Name    : " + rs.getString("dep_name"));
                System.out.println("Department Code    : " + rs.getInt("dep_code"));
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
        } else if (z == 4) {
            PreparedStatement ps2 = con.prepareStatement("Select * from department");
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                System.out.println("Department ID      : " + rs.getInt("dep_ID"));
                System.out.println("Department Name    : " + rs.getString("dep_name"));
                System.out.println("Department Code    : " + rs.getInt("dep_code"));
                System.out.println();
                System.out.println("----------------------------------------------");
            }
        } else if (z == 5) {
            while (true) {
                PreparedStatement ps1 = con.prepareStatement("delete from department where dep_ID=?");
                System.out.println("Enter the Department id   :");
                dep_ID = sc.nextInt();
                ps1.setInt(1, dep_ID);
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
