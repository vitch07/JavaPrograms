package BasicComposition;

class KYCApplicant{
    private String employeeId;
    private AadhaarComposition aadhaar;

    KYCApplicant(long aadharNumber, String aadharName,String aadharAddress,String employeeId){
        this.employeeId = employeeId;
        this.aadhaar = new AadhaarComposition(aadharNumber,aadharName,aadharAddress);
    }
    public String getEmployeeId(){
        return employeeId;
    }
    public String toString(){
        return aadhaar.getDetails() + " " + employeeId;
    }
}
public class KYCcomposition{
public static void main(String[] args){
     KYCApplicant kyc = new KYCApplicant(966213422,"VishnuBalaji","Rajajji st","12343");
    System.out.println(kyc);

}}
