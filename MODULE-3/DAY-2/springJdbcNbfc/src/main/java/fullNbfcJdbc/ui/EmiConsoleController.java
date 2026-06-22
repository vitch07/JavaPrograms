package fullNbfcJdbc.ui;

import fullNbfcJdbc.EmiDao.EmiDao;
import fullNbfcJdbc.entity.Emi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Scanner;
@Component
public class EmiConsoleController {
    @Autowired
    Scanner sc;
    @Autowired
    EmiDao emiDao;
    public void welcomeMessage(){
        System.out.println("Welcome to the Emi DB..");
    }
    public void show(){
        while(true){
            System.out.println("Enter the options " +
                    "1: add" +
                    "2: Delete" +
                    "3: Update" +
                    "4:getall" +
                    "5:mark as paid " +
                    "6:GetById" +
                    "7: Pending EMis");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    getall();
                    break;
                case 5:
                    System.out.println("Enter the id to be replaced");
                    int id = sc.nextInt();
                    System.out.println("Enter paid or not paid");
                    String res = sc.nextLine();
                    Boolean value;
                        if(res.toLowerCase().equalsIgnoreCase("paid")) value = true;
                        else value = false;
                    emiDao.markAsPaid(id,value);
                    break;
                case 6:
                    System.out.println("Enter id to get the details:");
                    int member = sc.nextInt();
                    emiDao.findById(member);
                    break;
                case 7:
                    System.out.println("printing pending emis");
                    emiDao.findPendingsEmis();
                    break;
                default:
                    System.out.println("entered invalid choice ...");
                    return;
            }
        }
    }

public void add(){
    System.out.println("Enter the emi_id: ");
    int id = sc.nextInt();
    System.out.println("Enter the Loan_id ");
    int loan_id = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter the due_date: ");
    String input = sc.nextLine();
    Date date = Date.valueOf(input);
    System.out.println("entet the amount: ");
    double amount = sc.nextDouble();
    System.out.println("Enter the status of the amount paid: ");
    Boolean paid = sc.nextBoolean();
    Emi new_emi = new Emi(id, loan_id, date, amount, paid);
    emiDao.save(new_emi);
}

public void update(){
    System.out.println("Enter the emi_id: ");
    int id = sc.nextInt();
    System.out.println("Enter the Loan_id ");
    int loan_id = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter the due_date: ");
    String input = sc.nextLine();
    Date date = Date.valueOf(input);
    System.out.println("entet the amount: ");
    double amount = sc.nextDouble();
    System.out.println("Enter the status of the amount paid: ");
    Boolean paid = sc.nextBoolean();
    emiDao.update(new Emi(id,loan_id,date,amount,paid));
}

public void delete(){
    System.out.println("Enter the id: ");
    int id = sc.nextInt();
    emiDao.deleteById(id);
}

public void getall(){
    System.out.println("Printing all the entries of emi's");
    emiDao.findall().stream().forEach(System.out::println);
}


}
