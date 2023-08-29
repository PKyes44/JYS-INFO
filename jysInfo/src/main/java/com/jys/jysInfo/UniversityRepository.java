package com.jys.jysInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UniversityRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public Long save(UniversityInformation uniInfo) {
        em.persist(uniInfo);
        return uniInfo.getId();
    }

    public UniversityInformation findOne(Long id) {
        return em.find(UniversityInformation.class, id);
    }

    public List<UniversityInformation> findList(String searchText, final Pageable pageable) {
        String jpQuery = "select u from UniversityInformation u";

        String whereSql = " where ";
        List<String> whereCondition = new ArrayList<>();
        // 기준년도
        whereCondition.add("u.baseYear like concat('%',:searchText,'%')");
        // 설립구분명 (공립/사립)
        whereCondition.add("u.establishSeparate = :searchText");
        // 학교명
        whereCondition.add("u.schoolName like concat('%',:searchText,'%')");
        // 전형대분류명
        whereCondition.add("u.admissionMainName like concat('%',:searchText,'%')");
        // 전형중분류명
        whereCondition.add("u.admissionMediumName like concat('%',:searchText,'%')");
        // 전형소분류명
        whereCondition.add("u.admissionSmallName like concat('%',:searchText,'%')");

        jpQuery += whereSql;
        jpQuery += String.join(" or ", whereCondition);

        // 조건에 따라서 각각의 where문에 parameter 설정
        TypedQuery<UniversityInformation> query = em.createQuery(jpQuery, UniversityInformation.class);

        query.setParameter("searchText", searchText);

        List<UniversityInformation> uniInfoList = query
                // 몇 페이지인지 설정
                .setFirstResult(pageable.getOffset())
                // 페이지당 몇 개 가져올지 설정
                .setMaxResults(pageable.getPageSize() + 1)
                .getResultList();

        return uniInfoList;
    }

    public List<CountDAO> CountById() {
        List<CountDAO> uniCount = em.createQuery("select count(u.id) as `count` from UniversityInformation u", CountDAO.class)
                .getResultList();
        System.out.println(uniCount);
        return uniCount;
    }

}
