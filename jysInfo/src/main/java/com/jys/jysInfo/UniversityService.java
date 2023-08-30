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
     * search University Admission Data
     * @param searchText
     * @param pageable
     * @return
     */
    public List<UniversityInformation> searchUniversity(String searchText, final Pageable pageable
    ) {
        return uniRepo.findList(searchText, pageable);
    }

    public List<CountDAO> getDataCount() {
        return uniRepo.CountById();
    }
    public List<CountDAO> getSearchCount(String searchText) {
        return uniRepo.CountBySearch(searchText);
    }
}
