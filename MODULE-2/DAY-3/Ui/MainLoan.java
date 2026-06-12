package Ui;

import DaoPattern.LoanDao;
import DaoPattern.LoanDaoImpl;
import entity.Loan.Loan;

import java.util.Comparator;

public class MainLoan {
    public static void main(String[] args){
        LoanDao loanDao = new LoanDaoImpl();
        loanDao.save(new Loan(123,"VehicleLoan",500000,24,2,"Ongoing"));
        loanDao.save(new Loan(133,"VehicleLoan",200000,18,2,"Ongoing"));
        loanDao.save(new Loan(143,"BusinessLoan",100000,24,5,"Closed"));
        loanDao.save(new Loan(153,"HealthLoan",50000,36,1,"Closed"));
        loanDao.save(new Loan(163,"BusinessLoan",500000,12,5,"Ongoing"));

        System.out.println(loanDao.findAll().stream()
                .max(new Comparator<Loan>(){
                    public int compare(Loan o1, Loan o2) {
                        return o1.getAmount() - o2.getAmount();

                    }
                }).get()
        );

        loanDao.findAll().stream().forEach(System.out::println);

    }
}
