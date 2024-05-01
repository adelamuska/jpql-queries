package com.detyrajpa.repository;

import com.detyrajpa.dto.NumberEmployees;
import com.detyrajpa.entity.EmployeeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager em;

    //Query 1
    public List<EmployeeEntity> getAllEmployees(Integer page, Integer size,
                                                String orderByField, boolean isAscending){
        var jpql = "SELECT e FROM EmployeeEntity e ORDER BY e." + orderByField;
        if(!isAscending)
            jpql =jpql.concat(" DESC");

        var query = em.createQuery(jpql, EmployeeEntity.class);;
        var first = (page * size);
        return  query.setFirstResult(first).setMaxResults(size).getResultList();
    }

    //Query 2
    public List<EmployeeEntity> getEmployeesAfterDate(LocalDate hireDate, Integer page, Integer size,
                                                      String orderByField, boolean isAscending){
        var jpql = "SELECT e FROM EmployeeEntity e WHERE e.hireDate > :hireDate ORDER BY e." + orderByField;
        if(!isAscending)
            jpql = jpql.concat(" DESC");

        var query = em.createQuery(jpql, EmployeeEntity.class);
        var first = (page * size);
        return query.setParameter("hireDate",hireDate).setFirstResult(first).setMaxResults(size)
                .getResultList();
    }

    //Query 3
    public List<EmployeeEntity> getEmployeesWithSalaryGreaterThan(Integer salary, Integer page, Integer size,
                                                                  String orderByField, boolean isAscending) {
        var jpql = "SELECT s.employee FROM SalaryEntity s WHERE s.salary > :salary ORDER BY s." + orderByField;
        if(!isAscending)
            jpql = jpql.concat(" DESC");

        var query = em.createQuery(jpql, EmployeeEntity.class);
        var first = (page * size);
        return query.setParameter("salary", salary).setFirstResult(first).setMaxResults(size)
                .getResultList();
    }



    //Query 4
    public List<EmployeeEntity> getEmployeesByTitle(String title, Integer page, Integer size,
                                                    String orderByField, boolean isAscending) {
        var jpql = "SELECT e FROM EmployeeEntity e INNER JOIN e.titles t WHERE t.titleId.title = :title ORDER BY e." + orderByField;
        if(!isAscending)
            jpql = jpql.concat(" DESC");

        var query = em.createQuery(jpql, EmployeeEntity.class);
        var first = (page * size);
        return query.setParameter("title", title).setFirstResult(first).setMaxResults(size)
                .getResultList();
    }

    //Query 7
    public List<NumberEmployees> getNumberOfEmployeesForEachDepartment(Integer page, Integer size,
                                                                       String orderByField, boolean isAscending){
        var jpql = "SELECT NEW com.detyrajpa.dto.NumberEmployees(de.id.deptNo, d.deptName, COUNT(de)) " +
                "FROM DeptEmpEntity de " +
                "INNER JOIN de.department d " +
                "GROUP BY de.id.deptNo" +
                " ORDER BY d." + orderByField;
        if(!isAscending)
            jpql = jpql.concat(" DESC");

        var query = em.createQuery(jpql);
        var first = (page * size);
        return query.setFirstResult(first).setMaxResults(size)
                .getResultList();
    }




}
