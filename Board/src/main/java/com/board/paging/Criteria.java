package com.board.paging;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class Criteria {
	private int currentPageNo;
	private int recordsPerPage;
	private int pageSize;
	private String searchKeyWord;
	private String searchType;
	
	public Criteria() {
		this.currentPageNo = 1;
		this.recordsPerPage = 10;
		this.pageSize = 10;
	}
	
	public String makeQueryString(int pageNo) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("currentPageNo", pageNo)
				.queryParam("recordsPerPage", recordsPerPage)
				.queryParam("pageSize", pageSize)
				.queryParam("searchType", searchType)
				.queryParam("searchKeyWord", searchKeyWord)
				.build()
				.encode();
		
		return uriComponents.toUriString();
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchKeyWord() {
		return searchKeyWord;
	}

	public void setSearchKeyWord(String searchKeyWord) {
		this.searchKeyWord = searchKeyWord;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	@Override
	public String toString() {
		return "Criteria [currentPageNo=" + currentPageNo + ", recordsPerPage=" + recordsPerPage + ", pageSize="
				+ pageSize + ", searchKeyWord=" + searchKeyWord + ", searchType=" + searchType + "]";
	}
	
	

}
