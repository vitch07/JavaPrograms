package Encapsulation;
import java.time.LocalDate;
public class MovieMain {
    public static void main(String[] args){
        Movie movie = new Movie("24","Shankar",LocalDate.now());
        movie.play();
        movie.setDate(LocalDate.of(2027,6,3));
        LocalDate new_date = movie.getDate();
        System.out.println("the dates have changed " + new_date);
    }
}
