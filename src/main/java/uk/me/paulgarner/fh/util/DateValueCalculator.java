package uk.me.paulgarner.fh.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValueCalculator {

	public static Integer getDateValue(String dateString) 
	{
		Integer adjustment = 0;
		Integer result = 99999999;
		
		String months = "JANFEBMARAPRMAYJUNJULAUGSEPOCTNOVDEC";

		int dashPos = dateString.indexOf("-");
		if (dashPos > -1) {
			dateString = dateString.substring(0, dashPos-1);
		}
		
		if (dateString.substring(0, 3).equalsIgnoreCase("bef")) {
			dateString = dateString.substring(4);
			adjustment = -1;
		}

		if (dateString.substring(0, 3).equalsIgnoreCase("aft")) {
			dateString = dateString.substring(4);
			adjustment = 1;
		}

		Pattern pattern = Pattern.compile("^[0-9]{4}");
		Matcher matcher = pattern.matcher(dateString);
		if (matcher.find()) {
			result = Integer.parseInt(dateString.substring(0,4));
		}

		pattern = Pattern.compile("^Q[0-9]{1} ([0-9]{4})$");
		matcher = pattern.matcher(dateString);
		if (matcher.find()) {
			Integer value = Integer.parseInt(dateString.substring(3,7));
			result = (value * 10000) + 100;
			
			value = Integer.parseInt(dateString.substring(1, 1));
			result = result + ((value - 1) * 300);
		}
		
		pattern = Pattern.compile("^[0-9]{2} [a-zA-Z]{3} ([0-9]{4})$");
		matcher = pattern.matcher(dateString);
		if (matcher.find()) {
			Integer value = Integer.parseInt(dateString.substring(7,11));
			result = (value * 10000);

			value = Integer.parseInt(dateString.substring(0,2));
			result = result + value;

			value = months.indexOf("21 Jan 1900".substring(3, 6));
			result = result + ((value/3)+1)*100;
		}
		
		pattern = Pattern.compile("^[a-zA-Z]{3} ([0-9]{4})");
		matcher = pattern.matcher(dateString);
		if (matcher.find()) {
			Integer value = Integer.parseInt(dateString.substring(4,8));
			result = (value * 10000);
			
			value = months.indexOf("21 Jan 1900".substring(0, 3));
			result = result + ((value/3)+1)*100;
		}

		result = result + adjustment;
		
		return result;
	}
}
