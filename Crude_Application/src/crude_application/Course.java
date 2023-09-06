package crude_application;
import java.sql.*;
import java.util.Scanner;
public class Course {
public void courseData() throws SQLException, ClassNotFoundException {
    int course_id,course_marks,z;
    String course_name;
    Connection con = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/student_management", "root", "9787");
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("1. Add Course : ");
    System.out.println("2. Update Course : ");
    System.out.println("3. Get Course : ");
    System.out.println("4. Get all Course : ");
    System.out.println("5. Delete Course : ");

    Scanner sc = new Scanner(System.in);
    z = sc.nextInt();
    if (z == 1) {
        while (true) {
            System.out.println("Enter the Course id  :");
             course_id = sc.nextInt();

            System.out.println("Enter the Name of Course :");
             course_name = sc.next();

            System.out.println("Enter the Course Marks  :");
             course_marks = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("insert into course values(?,?,?)");
            ps.setInt(1, course_id);
            ps.setString(2, course_name);
            ps.setInt(3, course_marks);
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
        System.out.println("1. Update Name of Course: ");
        System.out.println("2. Update Course Marks: ");
        z = sc.nextInt();
        switch (z) {
            case 1:
                System.out.println("Enter the Course id  :");
                course_id = sc.nextInt();

                System.out.println("Enter the Department Name :");
                course_name = sc.next();

                PreparedStatement ps = con.prepareStatement("update course Set  course_name=? where course_id=?");
                ps.setInt(1, course_id);
                ps.setString(2, course_name);
                int i = ps.executeUpdate();
                System.out.println("Data is Update successfully");
                System.out.println("Do you want continoue to update anOther Recoord :   ");
                System.out.println("1.      Yes");
                System.out.println("2.      No");
                z = sc.nextInt();
                if (z == 1) {

                } else {
                    break;
                }
                if (i < 0) {
                    System.out.println("data is not Update");
                } else {
                    System.out.println();
                }
            case 2:
                System.out.println("Enter the Department id   :");
                course_id = sc.nextInt();
                System.out.println("Enter the Department Code   :");
               course_marks = sc.nextInt();
                PreparedStatement ps1 = con.prepareStatement("update department Set  dep_code=? where dep_ID=?");
                ps1.setInt(1, course_id);
                ps1.setInt(2, course_marks);
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
        PreparedStatement ps2 = con.prepareStatement("Select * from course");
        ResultSet rs = ps2.executeQuery();
        while (rs.next()) {

            System.out.println("Course ID      : " + rs.getInt("course_id"));
            System.out.println("Course Name    : " + rs.getString("course_name"));
            System.out.println("Course Code    : " + rs.getInt("course_marks"));
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
        PreparedStatement ps2 = con.prepareStatement("Select * from course");
        ResultSet rs = ps2.executeQuery();
        while (rs.next()) {
            System.out.println("Course ID      : " + rs.getInt("course_id"));
            System.out.println("Course Name    : " + rs.getString("course_name"));
            System.out.println("Course Code    : " + rs.getInt("course_marks"));
            System.out.println("---------------------------------------------");
        }
    } else if (z == 5) {
        while (true) {
            PreparedStatement ps1 = con.prepareStatement("delete from course where course_id=?");
            System.out.println("Enter the Department id   :");
            course_id = sc.nextInt();
            ps1.setInt(1, course_id);
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