package org.example.weeklyassignment3.controller;

import org.example.weeklyassignment3.entity.Expenditure;
import org.example.weeklyassignment3.service.ExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expenditures")
public class ExpenditureController {

    @Autowired
    private ExpenditureService service;

    @PostMapping("/load")
    public ResponseEntity<String> loadExpenses(
            @RequestBody List<String> records) {

        service.loadExpenses(records);
        return ResponseEntity.ok("Expenses Loaded");
    }

    @GetMapping("/top-expenses")
    public ResponseEntity<List<Expenditure>> topExpenses(
            @RequestParam int n) {

        return ResponseEntity.ok(service.topExpenses(n));
    }

    @GetMapping("/average-by-type")
    public ResponseEntity<Map<String, Double>> averageByType() {

        return ResponseEntity.ok(service.averageExpenseByType());
    }

    @GetMapping("/department-wise")
    public ResponseEntity<Map<String, List<Expenditure>>> departmentWise() {

        return ResponseEntity.ok(service.departmentWiseExpenses());
    }

    @GetMapping("/suspicious")
    public ResponseEntity<List<String>> suspicious() {

        return ResponseEntity.ok(service.suspiciousExpenses());
    }
}