package com.compareglobal.service.model;


public class Compare {
	private String id;
	private String locale;
	private View view;
	private Filter filter;
	
	public enum Filter {
		AIRMILES,
		CASHBACK,
		CONTACTLESS,
		DINING,
		ONLINESHOPPING,
		PREMIUM,
		BESTDEALS,
        FREE,
        DISCOUNT,
        POINTS,
		FIRSTCARD
	}

	public enum View {
		DEFAULT,
		HK,
        PT,
		ID
	}


	public String getLocale() {
		return locale;
	}


	public void setLocale(String locale) {
		this.locale = locale;
	}


	public Filter getFilter() {
		return filter;
	}


	public void setFilter(Filter filter) {
		this.filter = filter;
	}


	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	@Override
	public String toString() {
		return "Compare{" +
				"id='" + id + '\'' +
				", locale='" + locale + '\'' +
				", view=" + view +
				", filter=" + filter +
				'}';
	}
}
