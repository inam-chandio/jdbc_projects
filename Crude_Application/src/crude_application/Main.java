package crude_application;

import java.sql.*;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    
      public static void main(String[] args) throws SQLException,ClassNotFoundException
      
      {
            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("1. Student Record  \n2.  Department    \n3.  Course    \n4.  StudentCourse    ");
                int s = sc.nextInt();
                if (s == 1) 
                {
                    Student st = new Student();
                    st.addRecord();
                } else if (s == 2) {
                    Depatment d = new Depatment();
                    d.departmentData();
                } else if (s == 3) {
                    Course c = new Course();
                    c.courseData();
                } else if (s == 4) {
                    Student_Course co = new Student_Course();
                    co.courseData();
                }

                else {
                    System.out.println("Sorry");
                }

            }
        }


    }


 

