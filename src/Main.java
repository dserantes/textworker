import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{

       /*
        *  Setting output for a result file.
        *  This file will be created in the "individualtask" folder
        *  after its execution.
        *
        *  Every sb.append() saves the buffer into the result file.
        */

        StringBuilder sb = new StringBuilder();
        File file = new File("result.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        TextWorker tw = new TextWorker();

        //Saving the start time of execution
        tw.setTimeStart(tw.timing());

        int op=0;
        String f;
        String w;

        //Do-while loop to receive all the data from the user
        do{
            try {

                tw.menu();
                sb.append(tw.getMb());

                Scanner scanner = new Scanner(System.in);
                op = scanner.nextInt();
                sb.append(op).append("\n");

            }catch(InputMismatchException im){
                System.err.println("You must enter a number");
                sb.append("You must enter a number").append("\n");
            }
        }while ((op < 1) || (op > 2));

        /*
        *  Name of the file that we will work with.
        *  The filename (t.txt) MUSN'T be changed and must remain always in
        *  the same folder.
        */
        tw.setFileName("t.txt");

        switch(op){
            case 1:

                System.out.println("Enter the word to search");
                sb.append("Enter the word to search").append("\n");

                Scanner scanner3 = new Scanner(System.in);
                w = scanner3.nextLine();

                try{

                    tw.find(tw.getFileName(),w);
                    sb.append(tw.getFb());

                }catch(IOException ioe){
                    ioe.printStackTrace();
                }
            break;
            case 2:


                try {
                    tw.copy(tw.getFileName());
                    sb.append(tw.getFb());
                }catch(IOException e3){
                    e3.printStackTrace();
                }
                break;
        }

        //Calcutating endtime of the execution
        tw.setTimeEnd(tw.timing());
        long timePassed = tw.getTimeEnd()-tw.getTimeStart();

        System.out.println("Execution time = "+ timePassed + "ms = "+ timePassed/1000 + "sec");
        sb.append("Execution time = "+ timePassed + "ms = "+ timePassed/1000 + "sec").append("\n");

        //Outputting results to the file & closing it
        writer.write(sb.toString());
        writer.close();

    }

}
