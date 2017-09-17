package com.dengshaolin.api.model;

public class PageQueryParams {

	protected int limit;
	protected int page;
	protected boolean total;

	public PageQueryParams() {
		// TODO Auto-generated constructor stub
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public boolean isTotal() {
		return total;
	}

	public void setTotal(boolean total) {
		this.total = total;
	}

	public String toString() {
		return String.format("limit=%d, page=%s", limit,page);
	}
}
