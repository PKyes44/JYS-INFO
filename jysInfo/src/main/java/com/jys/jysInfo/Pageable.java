package com.jys.jysInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pageable {
    private int offset;
    private int pageSize;

    @Builder
    public Pageable(int offset, int pageSize) {
        this.offset = offset;
        this.pageSize = pageSize;
    }
}
