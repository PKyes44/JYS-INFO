package com.jys.jysInfo;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "universityInformation")
@Entity
public class UniversityInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int baseYear;                           // 기준년도
    private String schoolType;                      // 학교종류명
    private String establishSeparate;               // 설립구분명
    private String schoolName;                      // 학교명
    private String capacitySeparate;                // 정원구분명
    private String admissionType;                   // 전형유형명
    private String admissionMainName;                // 전형대분류
    private String admissionMediumName;             // 전형중분류
    private String admissionSmallName;              // 전형소분류
    private int earlyDecisionRecruit;               // 수시모집인원수(명)
    private int earlyDecisionSignCnt;               // 수시등록인원수(명)
    private float earlyDecisionSignPercent;         // 수시등록률(%)
    private int regularDecisionRecruit;             // 정시모집인원수(명)
    private int regularDecisionSignCnt;             // 정시등록인원수(명)
    private float regularDecisionSignPercent;       // 정시등록률(%)
    private int addRecruit;                         // 추가모집인원수(명)
    private int addSignCnt;                         // 추가등록인원수(명)
    private float addSignPercent;                   // 추가등록률(%)
    private int finalRecruit;                       // 최종모집인원수(명)
    private int finalSignCnt;                       // 최종등록인원수(명)
    private float finalSignPercent;                 // 최종등록률(%)
}
