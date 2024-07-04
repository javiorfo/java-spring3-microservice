package com.javi.common.response;

public record PaginationResponse(int pageNumber, int pageSize, long total){}
