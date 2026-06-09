package Encapsulation;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class Movie {
    private String Title;
    private String Director;
    private LocalDate date;

    Movie(){}
    Movie(String Title, String Director, LocalDate date){
        this.Title = Title;
        this.Director = Director;
        this.date = date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalDate getDate(){
        return date;
    }

    void play(){
        System.out.println(Title + " is going to release on " + date);
    }


    }

