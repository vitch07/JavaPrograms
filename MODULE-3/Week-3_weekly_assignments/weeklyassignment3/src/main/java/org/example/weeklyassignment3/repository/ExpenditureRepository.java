package org.example.weeklyassignment3.repository;


import org.example.weeklyassignment3.entity.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenditureRepository
        extends JpaRepository<Expenditure,String> {
}
