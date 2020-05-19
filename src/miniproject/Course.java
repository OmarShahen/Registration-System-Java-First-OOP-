/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.util.ArrayList;


public class Course {
    private String courseName;
    private int courseID;
    private int numberOfRegisteredStudents = 0;
    private static int numberOfCourses = 0;
    private Lecturer lecturer;
    private String grade;

    
   
    public Course()
    {
    }
    public Course(String name,int id)
    {
        courseName = name;
        courseID = id;
    }
    public void setLectuerer(Lecturer lecturer)
    {
        this.lecturer = lecturer;
    }
    public Lecturer getLecturer()
    {
        return lecturer;
    }
    public void setCourseName(String name)
    {
        this.courseName = name;
    }
    public String getCourseName()
    {
        return courseName;
    }
  
    public void setCourseID(int id)
    {
        this.courseID = id;
    }
    public int getCourseID()
    {
        return courseID;
    }
    public void setNumberOfRegisteredStudents()
    {
        numberOfRegisteredStudents++;
    }
    public int getNumberOfRegisteredStudents()
    {
        return numberOfRegisteredStudents;
    }
    public int getNumberOfCourses()
    {
        return numberOfCourses;
    }
        public void setCourseGrade(String grade)
    {
      this.grade = grade;  
    }
    public String getGrade()
    {
        return grade;
    }
    public String toString()
    {
        return String.format("Course Name:%s\nCourse ID:%d\nLecturer Name:%s\nNumber Of Registered Students:%d\n",courseName,courseID,lecturer.getLecturerName(),numberOfRegisteredStudents);
    }
    
    
    
    
    
    
    
    
    
    

    
    
}