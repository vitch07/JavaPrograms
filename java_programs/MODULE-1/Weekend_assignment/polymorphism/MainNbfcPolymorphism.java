package polymorphism;

public class MainNbfcPolymorphism {
    public static void main(String[] args){
        KYCverifier kyc = new KYCverifier();
        NbfcPolymorphism nbfc = kyc.new AadharKycVerifier();
        nbfc.verify();
        NbfcPolymorphism nbfc1 = kyc.new VideoKycVerifier();
        nbfc1.verify();


    }
}
