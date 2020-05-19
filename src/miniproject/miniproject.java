/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

  import java.util.Scanner;
import javax.swing.JOptionPane;

 


public class miniproject {

    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Collage collageObject = Collage.getInstance();
        Student studentObject = new Student();
        Lecturer lecturerObject = new Lecturer();
        while(true){
            
           String GUIInput = JOptionPane.showInputDialog(null,"1.Add Course.\n2.Add Student.\n3.Add Lecturer.\n4.Register a course for a Student.\n"
                    + "5.Register a course for a Lecturer.\n6.Display Collage Information.\n7.Display the complete list of Courses.\n"
                    + "8.Display the complete list of students.\n9.Display the complete list of Lecturers.\n"
                    + "10.Display list of courses currently taken by a particular student.\n11.Display list of courses currently taken by a particular Lecturer.\n"
                    + "12.Delete Course.\n13.Delete Student.\n14.Delete Lecturer.\n16.Add student to Lecturer.\n17.Set grades of students.\n18.QUIT.\nEnter the Number of Option:");
           int choose = Integer.parseInt(GUIInput); 
        if(choose == 1)
        {
            for(int i=0;i<1;i++){
            System.out.print("Enter the ID of the Lecturer:");
            int lecturerID = input.nextInt();
            boolean lecturerValid = collageObject.checkLecturerID(lecturerID);
            if(lecturerValid == false)
            {
                System.out.println("The Lecturer doesnot exist.");
                break;
            }
            
            System.out.print("Enter the Name of the Course:");
            String courseName = input.next();
           boolean userInput = collageObject.checkUserInputValidityForStrings(courseName);
            if(userInput == false)
            {
                System.out.println("Enter The Name correctly without numbers or special signs.");
                break;
            }
            boolean courseNameValid = collageObject.CheckCourseName(courseName);
            if(courseNameValid == false)
            {
                System.out.println("There is a Course already with that name.");
                break;
            }
            System.out.print("Enter the ID of the Course:");
            int courseID = input.nextInt();
            boolean courseIDValid = collageObject.checkCourseID(courseID);
            if(courseIDValid == true)
            {
                System.out.println("There is a Course already with that ID.");
                break;
            }
            collageObject.addCourse(courseName, courseID,lecturerID);
            }
            
            }
        
        if(choose == 2)
        {
            for(int i=0;i<1;i++){
            System.out.print("Enter the Name of the Student:");
            String studentName = input.next();
            System.out.print("Enter the ID of the Student:");
            int studentID = input.nextInt();
            boolean IDValid = collageObject.checkLecturerID(studentID);
           if(IDValid == true)
           {
               System.out.println("There is a Student with that ID.");
           }
            collageObject.addStudent(studentName, studentID);
            }
        
        }
        if(choose == 3)
        {
            System.out.print("Enter the Name of the Lecturer:");
            String lecturerName = input.next();
            System.out.print("Enter the ID of the Lecturer:");
            int lecturerID = input.nextInt();
            collageObject.addLecturer(lecturerName,lecturerID);
        }
        if(choose == 4)
        {
            for(int i=0;i<1;i++){
            System.out.print("Enter The id of the Student:");
            int studentID = input.nextInt();
            boolean studentValid = collageObject.checkStudentID(studentID);
            if(studentValid == false)
            {
                System.out.println("The Student is not here.");
                break;
            }
            System.out.print("Enter The id of the Course:");
            int courseID = input.nextInt();
            boolean courseValid = collageObject.checkCourseID(courseID);
            if(courseValid == false)
            {
                System.out.println("The Course is not here.");
                break;
            }
            boolean doubleCourseCheck = collageObject.checkCourseAdditionForStudent(studentID, courseID);
            if(doubleCourseCheck == true)
            {
                System.out.println("This Student already registered this Course.");
                break;
            }
            collageObject.registerCourseForStudent(studentID, courseID);
            
            }
        }
        if(choose == 5)
        {
            for(int i=0;i<1;i++)
            {
                System.out.print("Enter the Lecturer ID:");
                int lecturerID = input.nextInt();
                boolean lecturerValid = collageObject.checkLecturerID(lecturerID);
                if(lecturerValid == false)
                {
                    System.out.println("The Lecturer is not here.");
                    break;
                }
                System.out.print("Enter the Course ID:");
                int courseID = input.nextInt();
                boolean courseValid = collageObject.checkCourseID(courseID);
                if(courseValid == false)
                {
                    System.out.println("The Course is not here.");
                    break;
                }
                collageObject.registerCourseForLecturer(lecturerID, courseID);
            }
        
        }     
        if(choose == 6)               
        {

            System.out.println(collageObject);
        }
        if(choose == 7)
        {
            collageObject.displayCourses();
        
        }
        if(choose == 8)
        {
            collageObject.dispalyStudents();
        }
        if(choose == 9)
        {
            collageObject.displayLecturers();
        }
        if(choose == 10)
        {
            for(int i=0;i<1;i++)
            {
                System.out.print("Enter The Student ID:");
                int studentID = input.nextInt();
                boolean validStudent = collageObject.checkStudentID(studentID);
                if(validStudent == false)
                {
                    System.out.println("The Student is not here.");
                    break;
                }
                collageObject.displayCourseForParticularStudent(studentID);

            }
                
        
        }
        if(choose == 11)
        {
            for(int i=0;i<1;i++)
            {
                System.out.print("Enter The Lecturer ID:");
                int lecturerID = input.nextInt();
                boolean validLecturer = collageObject.checkLecturerID(lecturerID);
                if(validLecturer == false)
                {
                    System.out.println("The Lecturer is not here.");
                    break;
                }
                collageObject.displayCoursesForLecturer(lecturerID);
            }
        }
        if(choose == 12)
        {
            System.out.print("Enter Course ID:");
            int courseID = input.nextInt();
            collageObject.deleteCourse(courseID);
        }
        if(choose == 13)
        {
            System.out.print("Enter Student ID:");
            int studentID = input.nextInt();
            collageObject.deleteStudent(studentID);
        }
        if(choose == 14)
        {
            System.out.print("Enter Lecturer ID:");
            int lecturerID = input.nextInt();
            collageObject.deleteLecturer(lecturerID);
        }
        if(choose == 15)
        {
            System.out.print("Enter Lecturer ID:");
            int lecturerID = input.nextInt();
            System.out.print("Enter Student ID:");
            int studentID = input.nextInt();
            System.out.print("Enter Course ID:");
            int courseID = input.nextInt();
            System.out.print("Enter Course Grade:");
            String courseGrade = input.next();
        }
        if(choose == 16)
        {
            System.out.print("Enter Lecturer ID:");
            int lecturerID = input.nextInt();
            System.out.print("Enter Student ID:");
            int studentID = input.nextInt();
            collageObject.addStudentToLecturer(lecturerID, studentID);
        }
        if(choose == 17)
        {
            System.out.print("Enter Lecturer ID:");
            int lecturerID = input.nextInt();
            System.out.print("Enter StudentID:");
            int studentID = input.nextInt();
            System.out.print("Enter Course ID:");
            int courseID = input.nextInt();
            System.out.print("Enter Course Grade:");
            String grade = input.next();
            collageObject.setGradesByLecturer(lecturerID, studentID, courseID, grade);
        }
        if(choose == 18)
        {
            break;
        }
        }
        
       }

}
    
    

