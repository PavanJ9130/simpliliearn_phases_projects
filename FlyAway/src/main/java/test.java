import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.FlyAway.layers.dto.Admin;
import com.FlyAway.layers.dto.Airlines;
import com.FlyAway.layers.dto.Flights;
import com.FlyAway.layers.dto.User;
import com.FlyAway.layers.util.ConnectionManagerImpl;

public class test {

	public static void main(String[] args) {
		SessionFactory factory=new ConnectionManagerImpl().getConnection();
		System.out.println(factory);
		
	Set<Flights> flights=new LinkedHashSet<Flights>();
	Airlines airline1=new Airlines("Air India");
	
	flights.add(new Flights("2022-07-01","T08:30", "mumbai", "pune", 1150.00, 100,airline1));
	flights.add(new Flights("2022-07-01","T13:30", "mumbai", "Hyderabad", 2150.00, 100,airline1));
	flights.add(new Flights("2022-07-01","T19:30", "Bengaluru", "mumbai", 2200.00, 100,airline1));
	flights.add(new Flights("2022-07-01","T09:30", "Kolkata", "mumbai", 3250.00, 100,airline1));
	flights.add(new Flights("2022-07-01","T11:30", "Kolkata", "chennai", 4220.00, 100,airline1));
	flights.add(new Flights("2022-07-01","T13:00", "pune", "chennai", 5050.00, 100,airline1));
	flights.add(new Flights("2022-07-01","T15:30", "chennai", "delhi", 6000.00, 100,airline1));
	flights.add(new Flights("2022-07-01","T16:00", "delhi", "mumbai", 4700.00, 100,airline1));
	flights.add(new Flights("2022-07-01","T18:30", "goa", "mumbai", 4550.00, 100,airline1));
	flights.add(new Flights("2022-07-01","T20:30", "goa", "delhi", 8200.00, 100,airline1));
	flights.add(new Flights("2022-07-02","T08:30", "pune", "mumbai", 2100.00, 100,airline1));
	flights.add(new Flights("2022-07-02","T13:30", "Hyderabad", "mumbai", 2200.00, 100,airline1));
	flights.add(new Flights("2022-07-02","T19:30", "Bengaluru", "mumbai", 2200.00, 100,airline1));
	flights.add(new Flights("2022-07-02","T09:30", "Kolkata", "mumbai", 3100.00, 100,airline1));
	flights.add(new Flights("2022-07-02","T11:30", "Kolkata", "chennai", 3200.00, 100,airline1));
	flights.add(new Flights("2022-07-02","T13:00", "pune", "chennai", 4600.00, 100,airline1));
	flights.add(new Flights("2022-07-02","T15:30", "chennai", "delhi", 6100.00, 100,airline1));
	flights.add(new Flights("2022-07-02","T16:00", "delhi", "mumbai", 6500.00, 100,airline1));
	flights.add(new Flights("2022-07-02","T18:30", "goa", "mumbai", 4300.00, 100,airline1));
	flights.add(new Flights("2022-07-03","T20:30", "goa", "delhi", 8500.00, 100,airline1));
	flights.add(new Flights("2022-07-03","T08:30", "pune", "mumbai", 900.00, 100,airline1));
	flights.add(new Flights("2022-07-03","T13:30", "Hyderabad", "mumbai", 1200.00, 100,airline1));
	flights.add(new Flights("2022-07-03","T19:30", "Bengaluru", "mumbai", 2600.00, 100,airline1));
	flights.add(new Flights("2022-07-03","T09:30", "Kolkata", "mumbai", 3210.00, 100,airline1));
	flights.add(new Flights("2022-07-03","T11:30", "Kolkata", "chennai", 3100.00, 100,airline1));
	flights.add(new Flights("2022-07-03","T13:00", "pune", "chennai", 5050.00, 100,airline1));
	flights.add(new Flights("2022-07-03","T15:30", "chennai", "delhi", 6050.00, 100,airline1));
	flights.add(new Flights("2022-07-03","T16:00", "delhi", "mumbai", 5500.00, 100,airline1));
	flights.add(new Flights("2022-07-03","T18:30", "goa", "mumbai", 4230.00, 100,airline1));
	flights.add(new Flights("2022-07-03","T20:30", "goa", "delhi", 7000.00, 100,airline1));
	flights.add(new Flights("2022-07-04","T08:30", "pune", "mumbai", 1000.00, 100,airline1));
	flights.add(new Flights("2022-07-04","T13:30", "Hyderabad", "mumbai", 2220.00, 100,airline1));
	flights.add(new Flights("2022-07-04","T19:30", "Bengaluru", "mumbai", 2520.00, 100,airline1));
	flights.add(new Flights("2022-07-04","T09:30", "Kolkata", "mumbai", 3010.00, 100,airline1));
	flights.add(new Flights("2022-07-04","T11:30", "Kolkata", "chennai", 3200.00, 100,airline1));
	flights.add(new Flights("2022-07-04","T13:00", "pune", "chennai", 5000.00, 100,airline1));
	flights.add(new Flights("2022-07-04","T15:30", "chennai", "delhi", 6300.00, 100,airline1));
	flights.add(new Flights("2022-07-04","T16:00", "delhi", "mumbai", 5500.00, 100,airline1));
	flights.add(new Flights("2022-07-04","T18:30", "goa", "mumbai", 4200.00, 100,airline1));
	flights.add(new Flights("2022-07-04","T20:30", "goa", "delhi", 8500.00, 100,airline1));
		
	airline1.setFlights(flights);
	Session session=factory.openSession();
	Transaction transaction=  session.beginTransaction();
	
	session.save(airline1);

	transaction.commit();
	
	session.close();
	factory.close();
	

	}

}
