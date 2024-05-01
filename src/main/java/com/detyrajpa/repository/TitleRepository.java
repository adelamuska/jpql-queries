package com.detyrajpa.repository;

import com.detyrajpa.entity.TitleEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TitleRepository {

    @PersistenceContext
    private EntityManager em;

    //Query 1
    public List<TitleEntity> getAllTitles(Integer page, Integer size,
                                          String orderByField, boolean isAscending){
        var jpql = "SELECT t FROM TitleEntity t ORDER BY t." + orderByField;
        if(!isAscending)
            jpql = jpql.concat(" DESC");

        var query = em.createQuery(jpql, TitleEntity.class);
        var first = (page * size);
        return query.setFirstResult(first).setMaxResults(size)
                .getResultList();
    }
}
