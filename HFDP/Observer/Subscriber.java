package Observer;

public class Subscriber implements Observer {

    // attributes
    private String currentArticle; 
    public String Client; 

    // reference to the subject
    public NewsAgency subject;

    // constructor 
    public Subscriber(String name) {
        this.currentArticle = "NONE"; 
        this.Client = name; 
        this.subject = null; 
    }

    // methods 
    @Override
    public void update(Object newData) {
        System.out.println("Recieved new data");
        this.currentArticle = (String) newData; 
    }

    // all observers should be able to manually query out information from the subjects
    public void query() {
        if (this.subject != null) {
            var headline = subject.getHeadline(); 
            this.currentArticle = headline; 
        }
    }

    public void printNews() {
        System.out.println(this.currentArticle); 
    }
}
