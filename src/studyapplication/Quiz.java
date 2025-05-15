/*

*/
package studyapplication;

public class Quiz {
    private String question;
    private String options;
    private int answer;
    
    public Quiz(String question, String options, int answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }
    
    public boolean checkAnswer(int userAnswer) {
        if (userAnswer == answer) {
            return true;
        } else {
            return false;
        }
    }
    
    public String getQuestion() {
        return question;
    }
    
    public String getOptions() {
        return options;
    }
    
    public String toString() {
        return question + "?\n" + options;
    }

}
