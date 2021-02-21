package com.ironhack.account.repository;

import com.ironhack.account.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT AVG(a.employeeCount) FROM Account a")
    public Object[] findMeanEmployeeCount();

    @Query(value = "SELECT CAST(employee_count AS DOUBLE) FROM account ORDER BY employee_count", nativeQuery = true)
    public List<Object[]> orderEmployeeCount();

    @Query("SELECT MIN(a.employeeCount) FROM Account a")
    public Object[] findMinEmployeeCount();

    @Query("SELECT MAX(a.employeeCount) FROM Account a")
    public Object[] findMaxEmployeeCount();
}
