package com.example.bsm.common;

import lombok.Data;

@Data
public class Pagination {
    private int totalCnt;
    private int perCnt = 15;
    private int startNum;
    private int pageIndex;
    private int startIndex;
    private int lastIndex;
}
