import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Library {

    //Arraylist to store Book class objects
    ArrayList<Book> b_list = new ArrayList<>();

    public ArrayList<Book> getB_list() {
        return b_list;
    }

    public Library() {
        getBookDetails();
    }

    //Method to read the CSV file
    public List<String> getFile() {
        List<String> data = new ArrayList<>();
        try {
            BufferedReader br1 = new BufferedReader(new FileReader("src/main/resources/Books.csv"));
            data = br1.lines().collect(Collectors.toList());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return data; //return list of strings where ech element is a row of csv file
    }

    //Method to get index of each column in csv file
    public Map<String, Integer> getHeader() {
        List<String> data = getFile();
        Map<String, Integer> headers = new HashMap<>();//Hashmap with column name as key and index as value
        String[] l1 = data.get(0).split(";");
        int i = 0;
        for (String s : l1) {
            headers.put(s, i);
            i++;
        }
        return headers;
    }

    //Method to store book data from csv to object array
    public void getBookDetails() {

        List<String> data = getFile(); //getting data from file
        Map<String, Integer> headers = getHeader(); //getting headers

        //using headers hashmap to get index of required columns
        int title_index = (headers.get("original_title"));
        int auth_index = (headers.get("authors"));
        int year_index = (headers.get("original_publication_year"));
        int rating_index = (headers.get("average_rating"));
        data.remove(0); //first element contains headers of columns

        for (String l : data) {

            String[] l2 = l.split(";");
            String[] auth_row = l2[auth_index].split(",");

            for (String s : auth_row) {

                //creating Book object for each row of csv and adding that object to object arraylist
                Book b = new Book(l2[title_index], new Author(s.trim()), Float.parseFloat(l2[rating_index]), (int) Float.parseFloat(l2[year_index]));
                b_list.add(b);

            }
        }
    }

    //Method for sorting object arraylist by the title of book
    public void NameWiseSort(String author) {

        b_list.sort(Comparator.comparing(Book::getTitle));
        for (Book b : b_list) {
            if (b.getAuthors().getName().replaceAll("\\s", "").equalsIgnoreCase(author.replaceAll("\\s", "")))
                System.out.println(b.getTitle());
        }

    }

    //Method for sorting object arraylist by the year
    public void YearWiseSort(String author) {

        b_list.sort(Comparator.comparing(Book::getYear));
        for (Book b : b_list) {
            if (b.getAuthors().getName().replaceAll("\\s", "").equalsIgnoreCase(author.replaceAll("\\s", "")))
                System.out.println(b.getTitle() + " " + b.getYear());
        }
    }

    //Method for sorting object arraylist by the ratings of book
    public void RatingWiseSort(String author) {
        b_list.sort(Comparator.comparing(Book::getRatings));
        for (Book b : b_list) {
            if (b.getAuthors().getName().replaceAll("\\s", "").equalsIgnoreCase(author.replaceAll("\\s", "")))
                System.out.println(b.getTitle() + " " + b.getRatings());
        }

    }

    //Method to display all the authors of the given book
    public void getAllAuthors(String title) {
        for (Book b : b_list) {
            if (b.getTitle().replaceAll("\\s", "").equalsIgnoreCase(title.replaceAll("\\s", ""))) {
                System.out.println(b.getAuthors().getName());
            }
        }
    }

    //Method to display all the books published in the given year
    public void getBooksInYear(int year) {
        ArrayList<String> book_list = new ArrayList<>();
        for (Book b : b_list) {
            if (b.getYear() == year && !book_list.contains(b.getTitle())) book_list.add(b.getTitle());
        }
        for (String s : book_list) {
            System.out.println(s);
        }
    }

    //Method to get count of books published by the given author
    public int getBookCount(String author) {
        int a = 0;
        for (Book b : b_list) {
            if (b.getAuthors().getName().replaceAll("\\s", "").equalsIgnoreCase(author.replaceAll("\\s", ""))) a++;
        }
        return a;
    }

    //Method to get prolific author from the given data
    public void ProlificAuthor() {
        ArrayList<String> proAuth = new ArrayList<>();
        int max = getBookCount(b_list.get(0).getAuthors().getName());
        for (Book b : b_list) {
            if (getBookCount(b.getAuthors().getName()) >= max)
                max = getBookCount(b.getAuthors().getName());
        }
        for (Book b : b_list) {
            if (getBookCount(b.getAuthors().getName()) == max && !proAuth.contains(b.getAuthors().getName()))
                proAuth.add(b.getAuthors().getName());
        }
        System.out.println(proAuth + ": Number of books published by author/s: " + max);
    }


    //Main function
    public static void main(String[] args) {
        String author;
        String title;
        int year;
        Library l = new Library();

        boolean flag = true;
        while (flag) {
            System.out.println("\n");
            System.out.println("1.Books by an author (sorted by name)\n" +
                    "2.Books by an author (sorted by year)\n" +
                    "3.Books by an author (sorted by rating)\n" +
                    "4.Authors of a book\n" +
                    "5.Number of books published by an author\n" +
                    "6.Books published in a year\n" +
                    "7.Prolific author\n" +
                    "8.End\n");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the name of author:");
                        author = sc.nextLine();
                        System.out.println("Books published by '" + author + "' are: ");
                        l.NameWiseSort(author);
                        break;
                    case 2:
                        System.out.println("Enter the name of author:");
                        author = sc.nextLine();
                        System.out.println("Books written by '" + author + "' are: ");
                        l.YearWiseSort(author);
                        break;
                    case 3:
                        System.out.println("Enter the name of author:");
                        author = sc.nextLine();
                        System.out.println("Books written by '" + author + "' are: ");
                        l.RatingWiseSort(author);
                        break;
                    case 4:
                        System.out.println("Enter the name of the book:");
                        title = sc.nextLine();
                        System.out.println("Authors of '" + title + "' are: ");
                        l.getAllAuthors(title);
                        break;
                    case 5:
                        System.out.println("Enter the name of author:");
                        author = sc.nextLine();
                        System.out.println(l.getBookCount(author));
                        break;
                    case 6:
                        System.out.println("Enter the year:");
                        year = sc.nextInt();
                        sc.nextLine();
                        l.getBooksInYear(year);
                        break;
                    case 7:
                        l.ProlificAuthor();
                        break;
                    default:
                        flag = false;
                        break;
                }
            } else System.out.println("Wrong input");
        }
    }
}











