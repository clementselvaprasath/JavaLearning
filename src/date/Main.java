package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Main {

	public static void main(String a[]) throws Exception {
		//System.out.println(lastUpdatedOn("2017-05-20T00:16:13.000+0000"));
		//System.out.println(lastUpdatedOn("2017-05-22T00:16:13.000+0000"));
		//dateToEpoch()
		
		System.out.println(new Date().getTime());
		//System.out.println(Calendar.getInstance(TimeZone.setDefault("UTC");).);
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println(new Date(new SimpleDateFormat("yyyy/MM/dd").format(new Date())).getTime());
		
		// Getting UTC time long value with 3 zero and converting into epoch value
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy/MM/dd");
		isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		isoFormat.format(new Date());
		long timeWithZero = isoFormat.parse(isoFormat.format(new Date())).getTime();
		System.out.println(Long.toString(timeWithZero));
		String timeWithZeroStr = Long.toString(timeWithZero);
		System.out.println(Long.parseLong(timeWithZeroStr.substring(0, timeWithZeroStr.length()-3)));
		
		//System.out.println(isoFormat.getCalendar().getTimeInMillis());
		//Date date = isoFormat.parse("2010-05-23T09:01:02");
		
		
	}
	private static String lastUpdatedOn(String dateTime) throws Exception {
		DateFormat df = new SimpleDateFormat("yyy-MM-dd'T'HH:mm");
		Date uDate = null;
		uDate = df.parse(dateTime);
		System.out.println("uDate  -- "+uDate);
		Date cDate = new Date();
		System.out.println("cDate  -- "+cDate);
		long diff = cDate.getTime() - uDate.getTime();
		long diffMinutes = diff / (60 * 1000);
		long diffHours = diff / (60 * 60 * 1000);

		if (diffMinutes < 60) {
			dateTime = diffMinutes + " minute(s) ago";
		} else if (diffHours < 24) {
			dateTime = diffHours + " hour(s) ago";
		} else {
			dateTime = (diffHours / 24) + " day(s) ago";
		}
		return dateTime;
	}
	
	public void dateToEpoch(String strDate){	
		//strDate = "04/28/2016";
		try {
		    Long millis = new SimpleDateFormat("MM/dd/yyyy").parse(strDate).getTime();
		} catch (ParseException e) {
		    e.printStackTrace();
		}
	}
}

