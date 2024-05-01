package com.detyrajpa.repository;

import com.detyrajpa.entity.DepartmentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager em;

    //Query 1
    public List<DepartmentEntity> getAllDepartments(Integer page, Integer size,
                                                    String orderByField, boolean isAscending){
        var jpql = "SELECT d FROM DepartmentEntity d ORDER BY d." + orderByField;
        if(!isAscending)
            jpql = jpql.concat(" DESC");

        var query = em.createQuery(jpql, DepartmentEntity.class);
        var first = (page * size);
        return query
                .setFirstResult(first)
                .setMaxResults(size)
                .getResultList();
    }
}
