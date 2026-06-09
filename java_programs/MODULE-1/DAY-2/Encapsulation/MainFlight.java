package Encapsulation;

class Flight {
    private String airline;
    private int flightNumber;
    private String source;
    private String destination;

    Flight(){}
    public Flight(String airline,int flightNumber,String source,String destination){
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
    }

    public void setAirline(String name){
        this.airline = name;
    }
    public void setFlightNumber(int number){
        this.flightNumber = number;
    }
    public String getAirline(){
        return this.airline;
    }
    public int getFlightNumber(){
        return this.flightNumber;
    }
    public void setSource(String source){
        this.source = source;
    }
    public void setDestination(String destination){
        this.destination = destination;
    }

}
public class MainFlight {
    public static void main(String args[]) {
        Flight flight = new Flight("airIndia",56767,"Bangalore","chennai");
        System.out.println(flight.getAirline() + " " + flight.getFlightNumber());

    }
}