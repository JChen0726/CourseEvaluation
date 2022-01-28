import javax.swing.*;
import java.util.*;

public class BackStage extends GUI{
    String courseSelect;
    int CourseIndex;
    int n= 5;
    public ArrayList<Double>[] database; // the place to store 0-4 index for the integer evaluations
    Map<Integer, Integer> myMap;
    // 01234 ratings, 56789 avg ratings 10attempts
    //supposstoree to set a integer that records times it evaluate
    BackStage(){

        myMap = new HashMap<>();
        database = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            database[i] = new ArrayList<>();
            for (int j = 0; j < 11; j++) {
                database[i].add(0.0);
            }
        }

    }
    public void getCourseName(){
        courseSelect= getDepartment();
    }
    public void init_GUI(){
        courseSelect= getDepartment();
        myMap.put(0,getDifficulty());
        myMap.put(1, getWorkLoad());
        myMap.put(2,getPacing());
        myMap.put(3, getTeacherAvailability());
        myMap.put(4, getCourseEnvironment());
    }
    public void setDepartmentIDX() {
        switch (courseSelect) {
            case "Math" -> CourseIndex = 0;
            case "English" -> CourseIndex = 1;
            case "History" -> CourseIndex = 2;
            case "Science" -> CourseIndex = 3;
            case "Language" -> CourseIndex = 4;
        }
    }
    public void store (){
        for (int i = 0; i <5; i++) {
            double cur = database[CourseIndex].get(i);
            database[CourseIndex].set(i,cur+myMap.get(i));// this assigns all the integer values to the arraylist
            //                                           at index 01234
        }
        double attempt = database[CourseIndex].get(10)+1;
        database[CourseIndex].set(10,attempt);
    }
    public void Calc_average(){
        for (int i = 5; i < 10; i++) {
            database[CourseIndex].set(i, (database[CourseIndex].get(i-5) / database[CourseIndex].get(10)));
        }
    }
    public void displayResult(){
        JOptionPane.showMessageDialog(null,
                "Difficulty: "+ database[CourseIndex].get(5)+
                        "\n Work Load: " + database[CourseIndex].get(6)+
                        "\n Pacing: " + database[CourseIndex].get(7)+
                        "\n Availability: " + database[CourseIndex].get(8)+
                        "\n Class Environment: " + database[CourseIndex].get(9)
                ,courseSelect+ "Average Score",
                JOptionPane.PLAIN_MESSAGE);
    }
}
