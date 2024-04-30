package com.orfosys.common.response;

public record PaginationResponse(int pageNumber, int pageSize, long total){}
