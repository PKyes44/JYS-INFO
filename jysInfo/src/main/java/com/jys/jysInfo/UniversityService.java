package com.jys.jysInfo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {
    @Autowired
    UniversityRepository uniRepo;

    public Long saveUniversityInfo(UniversityInformation uniInfo) {
        uniRepo.save(uniInfo);
        return uniInfo.getId();
    }

    public void saveUniversityInfoList(List<UniversityInformation> uniInfoList) {
        for (UniversityInformation uniInfo : uniInfoList) {
            uniRepo.save(uniInfo);
        }
    }

    /**
     * Search University Information
     * @param baseYear
     * @param establishSeparate
     * @param schoolName
     * @param admissionMainName
     * @param admissionMediumName
     * @param admissionSmallName
     * @param pageable
     * @return
     */
    public List<UniversityInformation> searchUniversity(
            int baseYear, String establishSeparate, String schoolName, String admissionMainName,
            String admissionMediumName, String admissionSmallName, final Pageable pageable
    ) {
        return uniRepo.findList(baseYear, establishSeparate, schoolName,
                admissionMainName, admissionMediumName, admissionSmallName,
                pageable);
    }
}
