/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.util.ArrayList;


public class Student {
    private ArrayList<Course> studentCourseList = new ArrayList<Course>();
    private String studentName;
    private int studentID;
    private  int numberOfTakenCourses =0;
    private Collage collage;
    public Student()
    {
    }
    public Student(String name,int id)
    {
        this.studentName = name;
        this.studentID = id;
    
    }
    public void setStudentName(String name)
    {
        this.studentName = name;
    }
    public String getStudentName()
    {
        return studentName;
    }
    public void setStudentID(int id)
    {
        this.studentID = studentID;
    }
    public int getStudentID()
    {
        return studentID;
    }
    public void addCourseToStudent(Course courseObject)
    {
        studentCourseList.add(courseObject);
        numberOfTakenCourses++;
        
    }
    public void displayStudentCourseList()
    {
        for(int i=0;i<studentCourseList.size();i++)
        {
            System.out.println((i+1)+"-"+studentCourseList.get(i).getCourseName());
            System.out.println("Course Grade: "+studentCourseList.get(i).getGrade());
        }
        
    }
    public void deleteCourseForStudent(int courseID)
    {
        for(int i=0;i<studentCourseList.size();i++)
        {
            if(studentCourseList.get(i).getCourseID() == courseID)
            {
                studentCourseList.remove(i);
                numberOfTakenCourses--;
            }
        }
    
    }
    public boolean checkCourseForStudent(int courseID)
    {
        for(int i=0;i<studentCourseList.size();i++)
        {
            if(courseID == studentCourseList.get(i).getCourseID())
            {
                return true;
            }
        }    
        return false;      
    }
    public void setGrade(String grade,int courseID)
    {
        for(int i=0;i<studentCourseList.size();i++)
        {
            if(studentCourseList.get(i).getCourseID() == courseID)
            {
                studentCourseList.get(i).setCourseGrade(grade);
            }
        }
    }
  
    public String toString()
    {
        return String.format("Student Name:%s\nStudent ID:%d\nNumber of taken Courses:%d\n",studentName,studentID,numberOfTakenCourses);
    }
}
 
    
   
  
