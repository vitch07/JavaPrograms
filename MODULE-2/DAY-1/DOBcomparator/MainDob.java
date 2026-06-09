package DOBcomparator;

import java.util.Arrays;
import java.util.Comparator;

public class MainDob {
    public static void main(String[] args){
        DOBChild[] c = {new DOBChild("vishnu","balaji","07-11-2004"),
                        new DOBChild("Jane","princess","03-02-2004"),
                        new DOBChild("nikash","sundar","03-02-2005"),
                        new DOBChild("kalyan","smith","13-02-2005")};
//        custom comparator to use the dob as the comparator and to use the anonymus comparator

        Arrays.sort(c,new Comparator<DOBChild>(){
            public int compare(DOBChild c1, DOBChild c2){
                String[] captured = c1.getDob().split("-");
                int day = Integer.parseInt(captured[0]);
                int month = Integer.parseInt(captured[1]);
                int year = Integer.parseInt(captured[2]);

                String[] captured2 = c2.getDob().split("-");
                int day2 = Integer.parseInt(captured2[0]);
                int month2 = Integer.parseInt(captured2[1]);
                int year2 = Integer.parseInt(captured2[2]);

                if (year != year2){
                    return Integer.compare(year,year2);
                }
                else if (month != month2){
                    return Integer.compare(month,month2);
                }
                else{
                    return Integer.compare(day,day2);
                }
            }
        });
        System.out.println(Arrays.toString(c));
    }
}
