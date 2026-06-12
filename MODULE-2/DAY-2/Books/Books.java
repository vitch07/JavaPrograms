package Books;

public class Books {
    private int id;
    private String name;
    private int pages;
    private String author;

    Books(int id,String name,int pages,String author){
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.author = author;
    }

    public int getId(){return this.id;}
    public int getPages(){return this.pages;}
    public String getName(){return this.name;}
    public String getAuthor(){return this.author;}

    public void setName(String name){
        this.name = name;
    }
    public void setAuthor(String author){
        this.author = author;
    }

}
