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

    public UniversityInformation getUniversityInfo(long id) {
        return uniRepo.findOne(id);
    }
    public List<UniversityInformation> getSearchUniversity(String searchText, final Pageable pageable
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
