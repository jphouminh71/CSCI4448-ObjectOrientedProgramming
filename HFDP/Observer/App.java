package Observer;

public class App {
    
    public static void main(String[] args) {
        System.out.println();

        var ABC = new Subscriber("ABC"); 
        var NBC = new Subscriber("NBC"); 

        var Agency = new NewsAgency(); 
        Agency.addObserver(ABC);
        Agency.addObserver(NBC);
        Agency.printObservers();
        System.out.println();
        System.out.println("Setting new news");

        var newNews = "RE8"; 
        Agency.setNews(newNews);                

        System.out.println();
    }
}
