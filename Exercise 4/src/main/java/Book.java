public class Book {
    private String title;
    private Author authors;
    private float ratings;
    private int year;

    public Book(){
    }

    //Parameterised Constructor
    public Book(String title, Author authors, float ratings, int year) {
        this.title = title;
        this.authors = authors;
        this.ratings = ratings;
        this.year = year;
    }

    //Getter Methods
    public String getTitle() {
        return title;
    }
    public Author getAuthors() {
        return authors;
    }
    public float getRatings() {
        return ratings;
    }
    public int getYear() {
        return year;
    }






}
