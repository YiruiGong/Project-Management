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
import java.text.DecimalFormat;

public class StudyApplication {

    public static int checkInputInt(String msg) {
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
    
    public static int checkInput(String msg, int lowRange, int highRange) {
        boolean goodInput = false;
        int userInput = 0;
        while (!goodInput) {
            userInput = checkInputInt(msg);
            if (userInput >= lowRange && userInput <= highRange) {
                goodInput = true;
            } else {
                JOptionPane.showMessageDialog(null, "", "INVALID INPUT", JOptionPane.ERROR_MESSAGE);
            }
        }
        return userInput;
    }
    
    public static ArrayList<Quiz> readQuizFile(String filePath) {
        ArrayList<Quiz> quiz = new ArrayList<Quiz>();
        try {
            File f = new File(filePath);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String question = s.nextLine();
                String options = s.nextLine() + "\n" + s.nextLine() + "\n" + s.nextLine() + "\n" + s.nextLine();
                int answer = Integer.parseInt(s.nextLine());
                quiz.add(new Quiz(question, options, answer));
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
    
    public static void showQuiz(ArrayList<Quiz> quiz) {
        DecimalFormat percentage = new DecimalFormat("##.0%");
        int userAnswer = 0;
        int acheivedPoints = 0;
        for (int i = 0; i < quiz.size(); i ++) {
            userAnswer = checkInput(quiz.get(i).toString(), 1, 4);
            boolean correct = quiz.get(i).checkAnswer(userAnswer);
            if (correct) {
                acheivedPoints ++;
            }
        }
        double grade = ((double) acheivedPoints) / quiz.size();
        String results = "Your Score: " + acheivedPoints + " / " + quiz.size() + "\nPercentage Grade: " + percentage.format(grade);
        JOptionPane.showMessageDialog(null, results);
    }
    
    public static void showNotes(ArrayList<Notes> notes) {
        boolean done = false;
        while (!done) {
            String topics = "Choose a Topic:";
            int userTopic = 0;
            for (int i = 0; i < notes.size(); i ++) {
                topics += "\n" + (i + 1) + ". " + notes.get(i).getTopic();
            }
            topics += "\n" + (notes.size() + 2) + ". " + "Exit";
            userTopic = checkInput(topics, 1, notes.size() + 2);
            if (userTopic == notes.size() + 2) {
                done = true;
            } else {
                JOptionPane.showMessageDialog(null, notes.get(userTopic - 1).toString());
            }
        }
    }
    
    public static void main(String[] args) {
        boolean done = false;
        int option;
        ArrayList<Quiz> quiz = readQuizFile("src/studyapplication/quiz1.txt");
        ArrayList<Notes> notes = readNotesFile("src/studyapplication/notes.txt");
        while (!done) {
            option = checkInput("Project Management Project\n1. Notes\n2. Quiz\n 3. Exit", 1, 3); 
            if (option == 1) {
                showQuiz(quiz);
            } else if (option == 2) {
                showNotes(notes);
            } else {
                done = true;
            }
        }
    }
    
}
