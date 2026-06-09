package BasicComposition;

public class AadhaarComposition {
    private long aadharNumber;
    private String aadharName;
    private String aadharAddress;

    AadhaarComposition(long aadharNumber, String aadharName, String aadharAddress){
        this.aadharAddress = aadharAddress;
        this.aadharName = aadharName;
        this.aadharNumber = aadharNumber;
    }

    public long getAadharNumber(){
        return this.aadharNumber;
    }
    public String getDetails(){
        return "the details are: " + aadharNumber + " " + aadharName + " " + aadharAddress;
    }
}
