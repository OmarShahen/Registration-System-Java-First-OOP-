/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.util.ArrayList;

public class Collage {
    
    private String collageName = "CCIT";
    private int collageID = 1;
    private static int numberOfCourses = 0;
    private static int numberOfStudents = 0;
    private static int numberOfLecturers = 0;
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Lecturer> lecturerList = new ArrayList<Lecturer>();
    
    private static Collage collage_instance = null;
    private Collage()
    {
    }
    public static Collage getInstance()
    {
        if(collage_instance == null)
        {
            collage_instance = new Collage();
        }
        return collage_instance;
    }
    public String getCollageName()
    {
        return collageName;
    }
    public int getCollageID()
    {
        return collageID;
    }
  public void addCourse(String courseName,int courseID,int lecturerID)
  {
      for(int i=0;i<lecturerList.size();i++)
      {
          if(lecturerID == lecturerList.get(i).getLecturerID())
          {
              Course courseObject = new Course(courseName,courseID);
              courseObject.setLectuerer(lecturerList.get(i));
              courseList.add(courseObject);
              lecturerList.get(i).addCourseToLecturer(courseObject);
              numberOfCourses++;
              
          }
      }
     
  }
  public void displayCourses()
  {
      for(int i=0;i<courseList.size();i++)
      {
          System.out.println(courseList.get(i));
          System.out.println("*****************************************************");
      }
  }
  public void addStudent(String studentName,int studentID)
  {
      Student studentObject = new Student(studentName,studentID);
      studentList.add(studentObject);
      numberOfStudents++;
  }
  public void dispalyStudents()
  {
      for(int i=0;i<studentList.size();i++)
      {
          System.out.println(studentList.get(i));
          System.out.println("*****************************************************");
   
      }
  }
  public void addLecturer(String lecturerName,int lecturerID)
  {
      Lecturer lecturerObject = new Lecturer(lecturerName,lecturerID);
      lecturerList.add(lecturerObject);
      numberOfLecturers++;
  }
  public void displayLecturers()
  {
      for(int i=0;i<lecturerList.size();i++)
      {
          System.out.println(lecturerList.get(i));
           System.out.println("*****************************************************");
      }
  }
 
  public String toString()
  {
      return String.format("Collage Name:%s\nCollage ID:%d\nNumber of Courses:%d\nNumber of Students:%d\nNumber of Lecturers:%d\n",collageName,collageID,numberOfCourses,numberOfStudents,numberOfLecturers);
  }


    
public void registerCourseForStudent(int studentID,int courseID)
{
    for(int i=0;i<studentList.size();i++)
    {
        if(studentID == studentList.get(i).getStudentID())
        {
            for(int j=0;j<courseList.size();j++)
            {
                if(courseID == courseList.get(j).getCourseID())
                {
                    studentList.get(i).addCourseToStudent(courseList.get(j));
                    courseList.get(j).setNumberOfRegisteredStudents();
                   
                
                }
            
            }
        }
    
    }

}
public void displayCourseForParticularStudent(int studentID)
{
    
    for(int i=0;i<studentList.size();i++)
    {
        if(studentID == studentList.get(i).getStudentID())
        {
            System.out.println("Student Name: "+studentList.get(i).getStudentName());
            studentList.get(i).displayStudentCourseList();
        }
        
    }

}
public void registerCourseForLecturer(int lecturerID,int courseID)
{
    for(int i=0;i<lecturerList.size();i++)
    {
        if(lecturerList.get(i).getLecturerID() == lecturerID)
        {
            for(int j=0;j<courseList.size();j++)
            {
                if(courseList.get(j).getCourseID() == courseID)
                {
                    lecturerList.get(i).addCourseToLecturer(courseList.get(j));
                }
                
            }
        }
    }
}
public void displayCoursesForLecturer(int lecturerID)
{
    for(int i=0;i<lecturerList.size();i++)
    {
        if(lecturerList.get(i).getLecturerID() == lecturerID)
        {
            System.out.println("Lecturer Name: "+lecturerList.get(i).getLecturerName());
            lecturerList.get(i).displayCoursesOfLecturer();
        }
    }
}
public void deleteCourse(int courseID)
{
    for(int i=0;i<courseList.size();i++)
    {
        if(courseList.get(i).getCourseID() == courseID)
        {
            courseList.remove(i);
            numberOfCourses--;

            for(int y=0;y<studentList.size();y++)
            {
                studentList.get(y).deleteCourseForStudent(courseID);
            }
            for(int t=0;t<lecturerList.size();t++)
            {
                lecturerList.get(t).deleteCourseForLecturer(courseID);
            }
        }
    }

}
public void deleteStudent(int studentID)
{
    for(int i=0;i<studentList.size();i++)
    {
        if(studentList.get(i).getStudentID() == studentID)
        {
            studentList.remove(i);
            numberOfStudents--;
        }
    }
}
public void deleteLecturer(int lecturerID)
{
    for(int i=0;i<lecturerList.size();i++)
    {
        if(lecturerList.get(i).getLecturerID() == lecturerID)
        {
            lecturerList.remove(i);
            numberOfLecturers--;
        }
    }
}
//***********************************************************************************************Checking Validity Methods*******************************************
 
  public boolean checkStudentID(int id)
  {
      for(int i=0;i<studentList.size();i++)
      {
          if(id == studentList.get(i).getStudentID())
          {
              return true;
              
          }
      }
      return false;
  }
  public boolean checkStudentName(String name)
  {
      for(int i=0;i<studentList.size();i++)
      {
          if(studentList.get(i).getStudentName().equals(name))
          {
              return false;
          }
      }
      return true;
  }
   public boolean checkCourseID(int id)
  {
      for(int i=0;i<courseList.size();i++)
      {
          if(id == courseList.get(i).getCourseID())
          {
              return true;
              
          }
      }
      return false;
  }
   public boolean CheckCourseName(String courseName)
   {
       for(int i=0;i<courseList.size();i++)
       {
           if(courseList.get(i).getCourseName().equals(courseName))
           {
               return false;
         }
       }
       return true;
   }
   
   public boolean checkLecturerID(int id)
   {
       for(int i=0;i<lecturerList.size();i++)
       {
           if(id == lecturerList.get(i).getLecturerID())
           {
               return true;
           }
       
       }
       return false; 
   }
   public boolean checkLecturerName(String name)
   {
       for(int i=0;i<lecturerList.size();i++)
       {
           if(lecturerList.get(i).getLecturerName().equals(name))
           {
               return false;
           }
       }
   return true;
   }
   public boolean checkCourseAdditionForStudent(int studentID,int courseID)
   {
       for(int i=0;i<studentList.size();i++)
       {
           if(studentList.get(i).getStudentID() == studentID)
           {
               for(int j=0;j<courseList.size();j++)
               {
                   if(courseList.get(j).getCourseID() == courseID)
                   {
                       boolean checkStudent = studentList.get(i).checkCourseForStudent(courseID);
                       if(checkStudent == true)
                       {
                           return true;
                       }
                       
                   }
               }
           }
       }
            return false;
   }
   public boolean checkUserInputValidityForStrings(String word)
   {
        String test = "`~1234567890!@#$%^&*()_+=]}[{;:?/>.<,";     
           if(word.equals(test))
           {
               return false;
           }
 
       return true;
   }
   /*public void setGradesOfStudents(int courseID,int studentID,int lecturerID,String grade){

       for(int i=0;i<studentList.size();i++)
       {
           if(studentList.get(i).getStudentID() == studentID)
           {
               for(int j=0;j<courseList.size();j++)
               {
                   if(courseList.get(j).getCourseID() == courseID)
                   {
                       studentList.get(i).setCourseGrade(courseID, grade);
                   }
               }
           }
       }
       
}*/
   public void addStudentToLecturer(int lecturerID,int studentID)
   {
       for(int i=0;i<lecturerList.size();i++)
       {
           if(lecturerList.get(i).getLecturerID() == lecturerID)
           {
               for(int j=0;j<studentList.size();j++)
               {
                   if(studentList.get(j).getStudentID() == studentID)
                   {
                       lecturerList.get(i).addStudentToLecturer(studentList.get(j));
                   }
               }
           }
       }
   }
   public void displayStudentsOfLecturer(int lecturerID)
   {
       for(int i=0;i<lecturerList.size();i++)
       {
           if(lecturerList.get(i).getLecturerID() == lecturerID)
           {
              lecturerList.get(i).displayStudentsTaughtByLecturer();
           }
       }
   }
   public void setGradesByLecturer(int lectuererID,int studentID,int courseID,String grade)
   {
       for(int i=0;i<lecturerList.size();i++)
       {
           if(lecturerList.get(i).getLecturerID() == lectuererID)
           {
               for(int j=0;j<studentList.size();j++)
               {
                   if(studentList.get(j).getStudentID() == studentID)
                   {
                       for(int u = 0;u<courseList.size();u++)
                       {
                           if(courseList.get(u).getCourseID() == courseID)
                           {
                               lecturerList.get(i).setGradesOfStudents(studentID, grade, courseID);
                           }
                       }
                   }
               }
           }
       }
   }
}
