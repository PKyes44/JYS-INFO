package com.jys.jysInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pageable {
    private int offset;         // 시작번호
    private int pageSize;       // 한 페이지당 개수

    @Builder
    public Pageable(int offset, int pageSize) {
        this.offset = offset;
        this.pageSize = pageSize;
    }
}
