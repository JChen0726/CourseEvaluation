import javax.swing.*;
import java.util.Arrays;

public class Main{
    private boolean finish;
    Main(){
        finish = false;
    }
    private boolean continueHellLoop(){
        Object[] choose = {"end loop", "continue"};
        int notBool = JOptionPane.showOptionDialog(null,
                "Choose wisely",
                "waojfholkgfkmdslsakenruowgfn",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE,
                null,
                choose,
                choose[1]);
        return notBool == 0;
    }

    public static void main(String []args){
        Main program = new Main();
        new GUI();
        BackStage bs = new BackStage();
        FileIO fileIO = new FileIO(bs.database);
        fileIO.createFile();
        fileIO.readStorage();
        // test if things gets input into the array
        while(!program.finish){
            if(bs.check_Intention()==0){
                bs.getCourseName();
                bs.setDepartmentIDX();
                System.out.println(Arrays.toString(bs.database));
            }
            else{
                bs.init_GUI();
                bs.setDepartmentIDX();
                bs.store();
                bs.Calc_average();
                System.out.println(Arrays.toString(bs.database));
            }
            bs.displayResult();
            program.finish = program.continueHellLoop();
        }
        fileIO.updateStorage();
    }
    // file write is still wrong, average is still wrong.
}