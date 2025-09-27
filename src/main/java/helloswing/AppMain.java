package helloswing;

import helloswing.shared.GreetingDTO;
import helloswing.user.internal.UserDAO;
import helloswing.user.internal.UserService;
import helloswing.user.internal.impl.UserDAOMockImpl;

public class AppMain {

    public static void main(String[] args) {
	UserDAO impl = new UserDAOMockImpl();
	UserService service = new UserService(impl);

	GreetingDTO marcosGreeting = service.greetUser("Marcos");
	marcosGreeting = service.greetUser("Marcos");
	marcosGreeting = service.greetUser("Marcos");
	marcosGreeting = service.greetUser("Marcos");
	System.out.println(
	    "Marcos - visit count: " + marcosGreeting.getVisitCount());
    }

}
