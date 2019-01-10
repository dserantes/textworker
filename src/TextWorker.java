import java.io.*;
import java.util.Scanner;

class TextWorker {

    private Integer line;
    private String fileName;
    private long timeStart;
    private long timeEnd;
    private File result;
    private StringBuilder mb;
    private StringBuilder fb;


    //Object that will manage everything in the file
    TextWorker() {
        this.line = 0;
        mb = new StringBuilder();
        fb = new StringBuilder();
    }

    //The method 'find' will try to find the desired word in a selected file
    void find(String f, String searchString) throws FileNotFoundException, IOException {
        boolean result = false;
        Scanner in = null;

        try {
            this.setFileName(f);
            in = new Scanner(new FileReader(f));
            while(in.hasNextLine() && !result) {
                this.setLine(this.getLine()+1);
                result = in.nextLine().contains(searchString);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                assert in != null;
                in.close() ; } catch(Exception e) { /* ignore */ }
        }
        if (result){
            System.out.println("The word '"+ searchString +"' has been found in line "+ this.getLine() + ".");
            fb.append("The word '"+ searchString +"' has been found in line "+ this.getLine() + ".").append("\n");
        }else{
            System.out.println("The word '"+ searchString +"' is not in the file.");
            fb.append("The word '"+ searchString +"' is not in the file.").append("\n");
        }

    }

    //The method 'copy' will copy the file by dropping spaces between words.
        void copy(String f)  throws FileNotFoundException {

        String read;
        this.setFileName(f);
        FileReader f2 = new FileReader(f);
        BufferedReader b = new BufferedReader(f2);
        try {
            while((read=b.readLine())!=null)
            {
                read=read.replaceAll("\\s","").replaceAll("//n", "").replaceAll("//r","");
                System.out.printf(read);
                fb.append(read.toString());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            b.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
            System.out.println(" ");
            fb.append(" ").append("\n");
    }

    //The method 'timing' will return the time of a system in a exact moment.
    long timing(){

        return System.currentTimeMillis();
    }

    //The method 'menu' will display all the options for the user.
    void menu() {


        System.out.println("Choose one option");
        mb.append("Choose one option").append("\n");

        System.out.println("-----------------");
        mb.append("-----------------").append("\n");

        System.out.println("1) Search a word in the data file and display the line where the word is found.");
        mb.append("1) Search a word in the data file and display the line where the word is found.").append("\n");

        System.out.println("2) Copy the data file by dropping the space between the words.");
        mb.append("2) Copy the data file by dropping the space between the words.").append("\n");

    }
    long getTimeStart() {
        return timeStart;
    }

    long getTimeEnd() {
        return timeEnd;
    }

    String getFileName() {
        return fileName;
    }

    Integer getLine() {
        return line;
    }

    StringBuilder getMb() {
        return mb;
    }


    StringBuilder getFb() {
        return fb;
    }
    void setLine(Integer line) {
        this.line = line;
    }

    void setTimeStart(long timeStart) {
        this.timeStart = timeStart;
    }

    void setTimeEnd(long timeEnd) {
        this.timeEnd = timeEnd;
    }

    void setFileName(String fileName) {
        this.fileName = fileName;
    }
}