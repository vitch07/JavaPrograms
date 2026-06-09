package association;


public class Passport {
    private String passport;
    private String country;
    private String issueDate;
    private String expiryDate;
    private Person person;

    Passport(String passport, String country, String issueDate, String expiryDate){
        this.passport = passport;
        this.country = country;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public void setPerson(Person person){
        this.person = person;
    }

    public String toString(){
        return passport + " "+ country + " " +  issueDate + " " + expiryDate +" "+ "Person : " + person.toString();
    }
}
