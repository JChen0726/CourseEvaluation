import javax.swing.*;

public class GUI{
    private final Object[] buttons1;
    public final Object[] courseCat;
    private final Object [] ratings ;
    int evalorRusults;
    GUI(){
        buttons1 = new String[]{"Results", "Evaluation"};
        courseCat = new String[]{"Math", "English", "History", "Science", "Language"};
        ratings = new Integer[] {1, 2, 3, 4, 5};
    }
    //  Int - input output buttons
    // String - department (classname) coursecat
    // int difficulty workload pacing avalabilityteacher courseenvironment , with ratings
    // changed from string to integer to see if it will facilitate/ or also check if it will correctly output in GUI.
    public Integer check_Intention(){                                       // evaluation or results // return 0,1
        return  evalorRusults = JOptionPane.showOptionDialog(
                null,
                "Do you want to see results or add an evaluation?",
                "Class Evaluation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, this.buttons1, this.buttons1[0]);
    }
    public String getDepartment(){ // this code does choose between classes.
        return (String) JOptionPane.showInputDialog(
                null,
                "Enter Class Name",
                "Class Evaluation", JOptionPane.PLAIN_MESSAGE,
                null, this.courseCat, this.courseCat[0]);
    }
    public Integer getDifficulty(){
        return   (Integer) JOptionPane.showInputDialog(
                null,
                "How difficult would you rate the course?",
                "Class Evaluation", JOptionPane.PLAIN_MESSAGE,
                null, this.ratings, this.ratings[0]);
    }
    public Integer getWorkLoad(){
        return (Integer) JOptionPane.showInputDialog(
                null,
                "How is the work load??",
                "Class Evaluation", JOptionPane.PLAIN_MESSAGE,
                null, this.ratings, this.ratings[0]);
    }
    public Integer getPacing(){
        return (Integer) JOptionPane.showInputDialog(
                null,
                "How is the pacing of the course?",
                "Class Evaluation", JOptionPane.PLAIN_MESSAGE,
                null, this.ratings, this.ratings[0]);
    }
    public Integer getTeacherAvailability(){
        return (Integer) JOptionPane.showInputDialog(
                null,
                "How often is the teacher available?",
                "Class Evaluation", JOptionPane.PLAIN_MESSAGE,
                null, ratings, ratings[0]);
    }
    public Integer getCourseEnvironment (){
        return (Integer) JOptionPane.showInputDialog(
                null,
                "How is the course environment?",
                "Class Evaluation", JOptionPane.PLAIN_MESSAGE,
                null, ratings, ratings[0]);
    }
}
