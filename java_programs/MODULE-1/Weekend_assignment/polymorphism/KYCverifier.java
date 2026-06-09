package polymorphism;

public class KYCverifier {

    class AadharKycVerifier extends NbfcPolymorphism {
        public void verify(){
            System.out.println("KYC done using AADHAR");
        }
    }

    class VideoKycVerifier extends NbfcPolymorphism{
        public void verify(){
            System.out.println("KYC is done using Video");
        }
    }

    class SimKycVerifier extends NbfcPolymorphism{
        public void verify(){
            System.out.println("KYC is done using sms");
        }
    }

}
