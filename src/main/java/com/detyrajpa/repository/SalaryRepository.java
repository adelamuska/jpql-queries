package com.detyrajpa.repository;

import com.detyrajpa.dto.AvgSalary;
import com.detyrajpa.dto.LastSalary;
import com.detyrajpa.entity.SalaryEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalaryRepository {

    @PersistenceContext
    private EntityManager em;

    //Query 1
    public List<SalaryEntity> getAllSalaries(Integer page, Integer size,
                                             String orderByField, boolean isAscending){
        var jpql = "SELECT s FROM SalaryEntity s ORDER BY s." + orderByField;
        if(!isAscending)
            jpql = jpql.concat(" DESC");

        var query = em.createQuery(jpql, SalaryEntity.class);
        var first = (page * size);

        return query.setFirstResult(first).setMaxResults(size)
                .getResultList();

    }

    //Query 5
    public List<LastSalary> getLastSalaryForEachEmployee(Integer page, Integer size,
                                                         String orderByField, boolean isAscending){
        var jpql = "SELECT NEW com.detyrajpa.dto.LastSalary(s.id.empNo, s.salary, MAX(s.id.fromDate)) " +
                "FROM SalaryEntity s " +
                "GROUP BY s.id.empNo, s.salary " +
                "ORDER BY s." + orderByField;
        if(!isAscending)
            jpql = jpql.concat(" DESC");

        var query = em.createQuery(jpql);
        var first = (page * size);
        return query.setFirstResult(first).setMaxResults(size)
                .getResultList();
    }


    //Query 6
    public List<AvgSalary> getAverageSalaryForEachDepartment(Integer page, Integer size,
                                                             String orderByField, boolean isAscending){
        var jpql = "SELECT NEW com.detyrajpa.dto.AvgSalary(de.id.deptNo, d.deptName, AVG(s.salary)) " +
                "FROM DeptEmpEntity de " +
                "INNER JOIN de.department d " +
                "INNER JOIN de.employee e " +
                "INNER JOIN e.salary s " +
                "GROUP BY de.id.deptNo, d.deptName " +
                "ORDER BY d." + orderByField;
        if(!isAscending)
            jpql = jpql.concat(" DESC");

        var query = em.createQuery(jpql);
        var first = (page * size);
        return query.setFirstResult(first).setMaxResults(size)
                .getResultList();
    }


}
