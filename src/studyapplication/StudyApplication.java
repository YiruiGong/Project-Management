/*
Yirui Gong, Thimithy Timias Tanderson The III, Sahadad Ewaz (The BOMBer)
May 15, 2025

*/
package studyapplication;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class StudyApplication {

    public static int checkInput(String msg) {
        boolean goodInput = false;
        int num = -1;
        while (!goodInput) {
            String input = JOptionPane.showInputDialog(msg);
            try {
                num = Integer.parseInt(input);
                goodInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error", "ERROR", JOptionPane.ERROR_MESSAGE);
                goodInput = false;
            }
        }
        return num;
    }
    
    public static ArrayList<Quiz> readQuizFile(String filePath) {
        ArrayList<Quiz> quiz = new ArrayList<Quiz>();
        try {
            File f = new File(filePath);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                quiz.add(new Quiz(s.nextLine(), s.nextLine(), Integer.parseInt(s.nextLine())));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
        return quiz;
    }
    
    public static ArrayList<Notes> readNotesFile(String filePath) {
        ArrayList<Notes> notes = new ArrayList<Notes>();
        try {
            File f = new File(filePath);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                notes.add(new Notes(s.nextLine(), s.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
        return notes;
    }
    
    public static void main(String[] args) {
        boolean done = false;
        int option;
        ArrayList<Quiz> quiz = readQuizFile("src/studyapplication/quiz1.txt");
        ArrayList<Notes> notes = readNotesFile("src/studyapplication/notes.txt");
        while (!done) {
            
        }
    }
    
}
