package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String a[]) throws Exception {
		System.out.println(lastUpdatedOn("2017-05-20T00:16:13.000+0000"));
		System.out.println(lastUpdatedOn("2017-05-22T00:16:13.000+0000"));
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
	
}

