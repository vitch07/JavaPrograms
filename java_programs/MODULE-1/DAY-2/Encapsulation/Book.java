package Encapsulation;

public class Book {
    private String title;
    private String author;
    private int pages;

    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setPages(int count){
        this.pages = count;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getPages(){
        return this.pages;
    }

    public void read(){
        System.out.println(this.title + "book is been written by" + this.author + "which has " + this.pages );
    }
    public void getSummary(){
            System.out.println(this.title + "has the summary at the front page");
        }
}
