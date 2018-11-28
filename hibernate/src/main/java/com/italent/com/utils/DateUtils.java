package com.italent.com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public Date parseDate(String date) throws ParseException {
		Date parsedDate = simpleDateFormat.parse(date);
		return parsedDate;
	}

	public String getFormattedDate(Date date) {
		String res = null;

		if (date != null) {
			res = simpleDateFormat.format(date);
		}
		return res;
	}
}
