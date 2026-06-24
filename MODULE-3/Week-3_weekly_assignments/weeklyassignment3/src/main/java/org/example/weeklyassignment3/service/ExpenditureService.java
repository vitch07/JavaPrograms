package org.example.weeklyassignment3.service;



import org.example.weeklyassignment3.entity.Expenditure;

import java.util.List;
import java.util.Map;

public interface ExpenditureService {

    void loadExpenses(List<String> records);

    List<Expenditure> topExpenses(int n);

    Map<String, Double> averageExpenseByType();

    Map<String, List<Expenditure>> departmentWiseExpenses();

    List<String> suspiciousExpenses();
}
