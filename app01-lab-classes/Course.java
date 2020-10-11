
/**
 * Write a description of class Course here.
 *
 * @author (Luke Limkee)
 * @version (11,10,2020)
 */
public class Course
{
    // instance variables - replace the example below with your own
    private String codeNumber;
    private String title;

    /**
     * Constructor for objects of class Course
     */
    public Course()
    {
        // initialise instance variables
        codeNumber = "unknown";
        title = "unknown";
    }

    /**
     * Set the code number for this course
     */
    public void setcodeNumber(String code)
    {
        codeNumber = code;
    }
    
    /**
     * Set the title for this course
     */
    public void settitle(String courseTitle)
    {
        title = courseTitle;
    }
}
