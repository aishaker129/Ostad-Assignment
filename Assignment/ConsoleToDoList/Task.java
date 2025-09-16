public class Task {

    private static long idCounter = 100;
    private long id;
    private String message;
    private String date;

    public Task(String message, String date) {
        this.id = idCounter++;
        this.message = message;
        this.date = date;
    }
    public long getId() {
        return id;
    }
    public String getMessage() {
        return message;
    }
    public String getDate() {
        return date;    
    }
    @Override
    public String toString() {
        return "----------------------\n" +
           "Task ID: " + id + "\n" +
           "Message: " + message + "\n" +
           "Date   : " + date + "\n" +
           "----------------------";
    }

}