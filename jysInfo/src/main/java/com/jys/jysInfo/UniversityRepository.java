package com.jys.jysInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UniversityRepository {
    @PersistenceContext
    EntityManager em;

    public Long save(UniversityInformation uniInfo) {
        em.persist(uniInfo);
        return uniInfo.getId();
    }

    public UniversityInformation findOne(Long id) {
        return em.find(UniversityInformation.class, id);
    }

    public String findList(
            int baseYear, String establishSeparate, String schoolName, String admissionMainName,
            String admissionMediumName, String admissionSmallName, final Pageable pageable
    ) {
        String jpQuery = "select u from UniversityInformation u";

        String whereSql = " where ";
        List<String> whereCondition = new ArrayList<>();
        // 기준년도
        if (baseYear != 0) {
            whereCondition.add("u.baseYear = :baseYear");
        }
        // 설립구분명 (공립/사립)
        if (StringUtils.hasText(establishSeparate)) {
            whereCondition.add("u.establishSeparate = :establishSeparate");
        }
        // 학교명
        if (StringUtils.hasText(schoolName)) {
            whereCondition.add("u.schoolName like concat('%',:schoolName,'%')");
        }
        // 전형대분류명
        if (StringUtils.hasText(admissionMainName)) {
            whereCondition.add("u.admissionMainName like concat('%',:admissionMainName,'%')");
        }
        // 전형중분류명
        if (StringUtils.hasText(admissionMediumName)) {
            whereCondition.add("u.admissionMediumName like concat('%',:admissionMediumName,'%')");
        }
        // 전형소분류명
        if (StringUtils.hasText(admissionSmallName)) {
            whereCondition.add("u.admissionSmallName like concat('%',:admissionSmallName,'%')");
        }

        if (!whereCondition.isEmpty()) {
            jpQuery += whereSql;
            jpQuery += String.join(" or ", whereCondition);
        }

        // 조건에 따라서 각각의 where문에 parameter 설정
        TypedQuery<UniversityInformation> query = em.createQuery(jpQuery, UniversityInformation.class);
        // 기준년도
        if (baseYear != 0) {
            query.setParameter("baseYear", baseYear);
        }
        // 설립구분명 (공립/사립)
        if (StringUtils.hasText(establishSeparate)) {
            query.setParameter("establishSeparate", establishSeparate);
        }
        // 학교명
        if (StringUtils.hasText(schoolName)) {
            query.setParameter("schoolName", schoolName);
        }
        // 전형대분류명
        if (StringUtils.hasText(admissionMainName)) {
            query.setParameter("admissionMainName", admissionMainName);
        }
        // 전형중분류명
        if (StringUtils.hasText(admissionMediumName)) {
            query.setParameter("admissionMediumName", admissionMainName);
        }
        // 전형소분류명
        if (StringUtils.hasText(admissionSmallName)) {
            query.setParameter("admissionSmallName", admissionSmallName);
        }

        List<UniversityInformation> uniInfoList = query
                // 몇 페이지인지 설정
                .setFirstResult(pageable.getOffset())
                // 페이지당 몇 개 가져올지 설정
                .setMaxResults(pageable.getPageSize() + 1)
                .getResultList();

        return uniInfoList.toString();
    }


//    public List<UniversityInformation> findBy
}
