
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
    
    public void calculateFinalGrade()
    {
        finalMark = module1.getMark() + module2.getMark() + module3.getMark() + module4.getMark();
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
