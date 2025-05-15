/*

*/
package studyapplication;

public class Notes {
    private String topic;
    private String notes;
    
    public Notes(String topic, String notes) {
        this.topic = topic;
        this.notes = notes;
    }
    
    public String getTopic() {
        return topic;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public String toString() {
        return topic + ":\n" + notes;
    }
}
