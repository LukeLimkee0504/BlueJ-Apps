
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Derek Peacock
 * @version 0.1 11/Sep/2020
 */
public class Course
{
    // instance variables - replace the example below with your own
    private String codeNo;
    private String title;

    private Module module1;
    private Module module2;
    private Module module3;
    private Module module4;
    
    private int finalMark;
        
    private Grades finalGrade;
        
    /**
     * Constructor for objects of class Course
     */
    public Course(String codeNo, String title)
    {
        // initialise instance variables
        this.codeNo = codeNo;
        this.title = title;
        
        module1 = new Module("Programming Concepts", "CO452");
        module2 = new Module("Game Design", "CO459");
        module3 = new Module("Networking", "CO451");
        module4 = new Module("Computer Architectures", "CO450");
    }
    
    public void replaceModule(Module newModule, int moduleNo)
    {
      if(moduleNo == 1)
        {
            module1 = newModule;
        }
        if(moduleNo == 2)
        {
            module2 = newModule;
        }
        if(moduleNo == 3)
        {
            module3 = newModule;
        }
        if(moduleNo == 4)
        {
            module4 = newModule;
        }  
    }

    
   public int getModuleMark(int moduleNo)
    {
        if(moduleNo == 1)
        {
            return module1.getMark();
        }
        if(moduleNo == 2)
        {
            return module2.getMark();
        }
        if(moduleNo == 3)
        {
            return module3.getMark();
        }
        if(moduleNo == 4)
        {
            return module4.getMark();
        }
        return 0;
    }
    
    public String getModuleTitle(int moduleNo)
    {
        if(moduleNo == 1)
        {
            return "" + module1.getTitle();
        }
        if(moduleNo == 2)
        {
            return "" + module2.getTitle();
        }
        if(moduleNo == 3)
        {
            return "" + module3.getTitle();
        }
        if(moduleNo == 4)
        {
            return "" + module4.getTitle();
        }
        
        return "Please enter a valid module number (1-4)";
    }
    
    public void addMark(int mark, int moduleNo)
    {
        if(moduleNo == 1)
        {
            module1.awardMark(mark);
        }
        if(moduleNo == 2)
        {
            module2.awardMark(mark);
        }
        if(moduleNo == 3)
        {
            module3.awardMark(mark);
        }
        if(moduleNo == 4)
        {
            module4.awardMark(mark);
        }
    }
    
    public int getFinalMark()
    {
        finalMark = module1.getMark() + module2.getMark() + module3.getMark() + module4.getMark();
        return finalMark;
    }
    
    /**
     * Prints out the details of a course
     */
    public void printCourseDetails()
    {
        // put your code here
        System.out.println("Course " + codeNo + " - " + title);
    }
        
    public Grades convertToGrade()
    {
        if((finalMark>= 0) && (finalMark < 40))
        {
            return Grades.F;
        }
        if((finalMark >= 0) && (finalMark >= 40) && (finalMark < 50))
        {
            return Grades.D;
        }
        if((finalMark >= 0) && (finalMark >= 50) && (finalMark < 60))
        {
            return Grades.C;
        }
        if((finalMark >= 0) && (finalMark >= 60) && (finalMark < 70))
        {
            return Grades.B;
        }
        if((finalMark >= 0) && (finalMark >= 70))
        {
            return Grades.A;
        }
        
        return Grades.X;
    }
}
