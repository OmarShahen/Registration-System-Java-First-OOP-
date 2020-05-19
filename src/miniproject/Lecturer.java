/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;


import java.util.ArrayList;
import java.util.Scanner;

public class Lecturer {
    
    Scanner input = new Scanner(System.in);
    
  private String lecturerName;
  private int lecturerID;
  private int NumberOfTaughtCourses = 0;
  private ArrayList<Course> lecturerCoursesList = new ArrayList<Course>();
  private ArrayList<Student> studentTaughtList = new ArrayList<Student>();
  public Lecturer()
  {
  }
  
  public Lecturer(String name,int id)
  {
      this.lecturerName = name;
      this.lecturerID = id;
  }
  public void setLecturerName(String name)
  {
      this.lecturerName = name;
  }
  public String getLecturerName()
  {
      return lecturerName;
  }
  public void setLecturerID(int id)
  {
      this.lecturerID = id;
  }
  public int getLecturerID()
  {
      return lecturerID;
  }

  public void addCourseToLecturer(Course courseObject)
  {
      lecturerCoursesList.add(courseObject);
      NumberOfTaughtCourses++;
  }
  public void addStudentToLecturer(Student studentObject)
  {
      studentTaughtList.add(studentObject);
  }
  public void setGradesOfStudents(int studentID,String grade,int courseID)
  {
      for(int i=0;i<studentTaughtList.size();i++)
      {
          if(studentTaughtList.get(i).getStudentID() == studentID)
          {
              studentTaughtList.get(i).setGrade(grade,courseID);
          }
      }
  }
  public void displayStudentsTaughtByLecturer()
  {
      for(int i=0;i<studentTaughtList.size();i++)
      {
          System.out.println(studentTaughtList.get(i));
      }
  }
  public void displayCoursesOfLecturer()
  {
      for(int i=0;i<lecturerCoursesList.size();i++)
      {
          System.out.println((i+1)+"-"+lecturerCoursesList.get(i).getCourseName());
      }
  }
  public void deleteCourseForLecturer(int courseID)
  {
      for(int i=0;i<lecturerCoursesList.size();i++)
      {
          if(lecturerCoursesList.get(i).getCourseID() == courseID)
          {
              lecturerCoursesList.remove(i);
              NumberOfTaughtCourses--;
          }
      }
  }
 
  public String toString()
  {
      return String.format("Lecturer Name:%s\nLecturer ID:%d\nNumber of Taught Courses:%d\n",lecturerName,lecturerID,NumberOfTaughtCourses);
  }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
}
