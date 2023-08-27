package com.jys.jysInfo;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(name = "universityInformation")
@Entity
public class UniversityInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String baseYear;                           // 기준년도
    private String schoolType;                      // 학교종류명
    private String establishSeparate;               // 설립구분명
    private String schoolName;                      // 학교명
    private String capacitySeparate;                // 정원구분명
    private String admissionType;                   // 전형유형명
    private String admissionMainName;                // 전형대분류
    private String admissionMediumName;             // 전형중분류
    private String admissionSmallName;              // 전형소분류
    private String earlyDecisionRecruit;               // 수시모집인원수(명)
    private String  earlyDecisionSignCnt;               // 수시등록인원수(명)
    private String  earlyDecisionSignPercent;         // 수시등록률(%)
    private String  regularDecisionRecruit;             // 정시모집인원수(명)
    private String  regularDecisionSignCnt;             // 정시등록인원수(명)
    private String  regularDecisionSignPercent;       // 정시등록률(%)
    private String  addRecruit;                         // 추가모집인원수(명)
    private String addSignCnt;                         // 추가등록인원수(명)
    private String  addSignPercent;                   // 추가등록률(%)
    private String  finalRecruit;                       // 최종모집인원수(명)
    private String  finalSignCnt;                       // 최종등록인원수(명)
    private String  finalSignPercent;                 // 최종등록률(%)

    @Builder
    public UniversityInformation(
        String  baseYear, String schoolType, String establishSeparate, String schoolName, String capacitySeparate,
        String admissionType, String admissionMainName, String admissionMediumName, String admissionSmallName,
        String  earlyDecisionRecruit, String  earlyDecisionSignCnt, String  earlyDecisionSignPercent,
        String  regularDecisionRecruit, String  regularDecisionSignCnt, String  regularDecisionSignPercent,
        String  addRecruit, String  addSignCnt, String  addSignPercent,
        String  finalRecruit, String  finalSignCnt, String  finalSignPercent
    ) {
        this.baseYear = baseYear;
        this.schoolType = schoolType;
        this.establishSeparate = establishSeparate;
        this.schoolName = schoolName;
        this.capacitySeparate = capacitySeparate;
        this.admissionType = admissionType;
        this.admissionMainName = admissionMainName;
        this.admissionMediumName = admissionMediumName;
        this.admissionSmallName = admissionSmallName;
        this.earlyDecisionRecruit = earlyDecisionRecruit;
        this.earlyDecisionSignCnt = earlyDecisionSignCnt;
        this.earlyDecisionSignPercent = earlyDecisionSignPercent;
        this.regularDecisionRecruit = regularDecisionRecruit;
        this.regularDecisionSignCnt = regularDecisionSignCnt;
        this.regularDecisionSignPercent = regularDecisionSignPercent;
        this.addRecruit = addRecruit;
        this.addSignCnt = addSignCnt;
        this.addSignPercent = addSignPercent;
        this.finalRecruit = finalRecruit;
        this.finalSignCnt = finalSignCnt;
        this.finalSignPercent = finalSignPercent;
    }
}
