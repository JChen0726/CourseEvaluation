import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileIO extends BackStage{ // a class that handles the input output of files

    FileIO(ArrayList<Double>[] database){
        this.database = database;
    }
    public void createFile () {
        try {
            File storeInfo = new File("evaluation.txt");
            if (storeInfo.createNewFile()) {
                System.out.println("File created: " + storeInfo.getName());
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    // generates a new file called evaluation.txt   it should be done in the start of this program.
    public void updateStorage( ) { // very end at the main loop
        try {
            FileWriter clearFile = new FileWriter("evaluation.txt");
            PrintWriter clearingFile = new PrintWriter(clearFile,false);
            clearingFile.flush();
            clearingFile.close();
            clearFile.close();
            // clear file
            FileWriter myWriter = new FileWriter("evaluation.txt");
            for (int i=0;i<super.database.length;i++) {
                for (int j =0;j<super.database[i].size();j++) {
                    myWriter.write(super.database[i].get(j) + " ");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
    public void readStorage(){  //this code go in the middle? Scan and input
        try {
            Scanner fileIn = new Scanner(new FileInputStream("evaluation.txt"));
            for(int i = 0; i < super.database.length; i++) {
                for (int j = 0; j < super.database[i].size(); j++) {
                    if(fileIn.hasNextDouble()){
                    super.database[i].set(j,fileIn.nextDouble());
                    }
                }
            }
            fileIn.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

}
