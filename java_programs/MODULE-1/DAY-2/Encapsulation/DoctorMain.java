package Encapsulation;

public class DoctorMain {
    public static void main(String[] args){
        Person doc = new Doctor();
        doc.setFname("vishnu");
        doc.setLname("balaji");
        doc.setAge(21);
        Doctor d = (Doctor) doc;
        d.setSpecialization("surgeon");
        System.out.println(doc.getFname() + doc.getLname() + " is a specialized  "+ ((Doctor)doc).getSpecialization());
    }
}
