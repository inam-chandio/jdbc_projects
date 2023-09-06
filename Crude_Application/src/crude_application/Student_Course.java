package crude_application;
import java.sql.*;
import java.util.Scanner;

public class Student_Course {
    int st_id,course_id,marks_Obtained,z;

    public void courseData() throws SQLException, ClassNotFoundException {

        Connection con = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/student_management", "root", "9787");
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. Add Student to Course : ");
        System.out.println("2. Update Student to Course : ");
        System.out.println("3. Get StudentCourse : ");
        System.out.println("4. Get All Student Course : ");
        System.out.println("5. Delete Student  Course: ");

        Scanner sc = new Scanner(System.in);
        z = sc.nextInt();
        if (z == 1) {
            while (true) {
                System.out.println("Enter the Student ID  :");
                st_id = sc.nextInt();

                System.out.println("Enter the Course ID :");
                course_id = sc.nextInt();

                System.out.println("Enter the Obtained Marks  :");
                marks_Obtained = sc.nextInt();

                PreparedStatement ps = con.prepareStatement("insert into studentCourse values(?,?,?)");
                ps.setInt(1, st_id);
                ps.setInt(2, course_id);
                ps.setInt(3, marks_Obtained);
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
            System.out.println("1. Update Course   ID : ");
            System.out.println("2. Update Obtained Marks: ");
            z = sc.nextInt();
            switch (z) {
                case 1:
                    System.out.println("Enter the Course ID :");
                    course_id = sc.nextInt();

                    System.out.println("Enter the Student ID  :");
                    st_id = sc.nextInt();


                    PreparedStatement ps = con.prepareStatement("update course Set  course_id=? where st_id=?");
                    ps.setInt(1, st_id);
                    ps.setInt(2, course_id);
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
                    System.out.println("Enter the Student id   :");
                    st_id = sc.nextInt();
                    System.out.println("Enter the Obtained Marks   :");
                    marks_Obtained = sc.nextInt();
                    PreparedStatement ps1 = con.prepareStatement("update department Set  marks_Obtained=? where st_id=?");
                    ps1.setInt(1, st_id);
                    ps1.setInt(2, marks_Obtained);
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
            PreparedStatement ps2 = con.prepareStatement("Select * from studentCourse");
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {

                System.out.println("Student ID         : " + rs.getInt("st_id"));
                System.out.println("Course  ID         : " + rs.getString("course_id"));
                System.out.println("Obtained Marks     : " + rs.getInt("marks_Obtained"));
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
            PreparedStatement ps2 = con.prepareStatement("Select * from studentCourse");
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {

                System.out.println("Student ID         : " + rs.getInt("st_id"));
                System.out.println("Course  ID         : " + rs.getString("course_id"));
                System.out.println("Obtained Marks     : " + rs.getInt("marks_Obtained"));
                System.out.println("---------------------------------------------");
            }
        } else if (z == 5) {
            while (true) {
                PreparedStatement ps1 = con.prepareStatement("delete from studentCourse where st_id=?");
                System.out.println("Enter the Student id   :");
                st_id = sc.nextInt();
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




