import java.util.ArrayList;
import java.util.List;

import br.com.instead.smartpush.Smartpush;
import br.com.instead.smartpush.model.Notification;
import br.com.instead.smartpush.model.SmartpushResponse;
import br.com.instead.smartpush.util.FilterBuilder;


public class Test {

	public static void main(String[] args) {
		List<Notification> notifications = new ArrayList<Notification>();
		Notification notification = new Notification();
		notification.setAppId("31231");
		notification.setPlatform("ANDROID");
		notification.addMsgParam("test", "valueTest");
		notifications.add(notification);
		
		FilterBuilder filters = new FilterBuilder();
		filters.in("BUSCAPE_ID", "1000", "9874", "1025", "3265", "1254", "1524");
		filters.in("BUSCAPE_ID", "1000", "9874", "1025", "3265", "1254", "1524");
		
		String devId = "123";
		
		SmartpushResponse response = Smartpush.withDeveloperId(devId).push(notifications).filteredBy(filters).now();
		System.out.println(response);
		
	}
	
}
