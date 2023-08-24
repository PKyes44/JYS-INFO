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
    private int baseYear;               // 기준년도
    private String schoolType;          // 학교종류명
    private String establishSeparate;   // 설립구분명
    private String schoolName;          // 학교명
    private String capacitySeparate;    // 정원구분명
    private String admissionMainName;   // 전형유형명
    private String admissionBigName;    // 전형대분류
    private String admissionMediumName; // 전형중분류
    private String admissionSmallName;  // 전형소분류
    private int earlyDecisionRecruit;   // 수시모집인원수(명)
    private String earlyDecisionSignCnt;// 수시등록인원수(명)
    private String earlyDecisionSignPercent;
    private String regularDecisionRecruit;
    private String regularDecisionSignCnt;
    private String regularDecisionSignPercent;
    private String addRecruit;
    private String addSignCnt;
    private String addSignPercent;
    private String finalRecruit;
    private String finalSignCnt;
    private String finalSignPercent;



}
