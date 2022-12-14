package customer;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Customer
{
	private String email = "abc@gmail.com";
	
	public int complaining()	// customer complaining
	{
		Event e = new Event();
		EventManager em = new EventManager();
		e.complaint();
		return e.complaint();
	}
	
	public int query()		// customer query
	{
		Event e = new Event();
		EventManager em = new EventManager();
		e.getEventId();
		em.manageQuery();
		return em.manageQuery();
	}
	
	public String getEmail()	// get email which is already inputed by customer
	{	return email;	}
	
	public String feedback(String e)		// customer gives feedback
	{
		System.out.print("Email is sent to ");
		System.out.println(e);
		Scanner in = new Scanner(System.in);
		System.out.print("Please give feedback: ");
		String feedback = in.next();
		return feedback;		
	}
	
	public void cancelOrder()		// customer cancels order
	{
		Booking b = new Booking();
		b.getBookingId();
		b.getBill();
		b.bookingDate();
		b.calcReturn();
	}
	
	public int requestChange() 		// customer requests change
	{	return 1;	}
	
	public static void main(String[] args)
	{
		Customer c1 = new Customer();
		EventManager em = new EventManager();
		FinanceManager fm = new FinanceManager();
		int c = c1.complaining();
		int q = c1.query();
		if (c==1)	{System.out.println("Complaint Solved");}
		if (q==1)	{System.out.println("Query Sent");}
		String feedback = em.askFeedback();
		System.out.print("Feedback from Customer: ");
		System.out.println(feedback);
		c1.cancelOrder();
		if(c1.requestChange() == 1)
		{
			fm.reviseCostPlan();
			fm.updatePackagePrice();
		}
	}
}

class Event
{
	private EventManager em1 = new EventManager();
	public int complaint() 			// complaint for a particular event
	{
		int comStatus = em1.manageComplaint();	// status of complaint (handled/ not handled)
		return comStatus;
	}
	public int getEventId()			// event id
	{
		int eventId = 123;
		return eventId;
	}
	
}

class EventManager
{
	private Customer c2 = new Customer();

	
	public int manageComplaint()		// event manager handles complaint
	{	return 1;	}
	
	public int manageQuery()		// event manager handles query
	{	return 1;	}
	
	public String askFeedback()		// event manager asks customer for feedback
	{
		String email = c2.getEmail();	// get customer email first
		String fb = c2.feedback(email);	// ask for customer feedback by sending email
		return fb;
	}
	
	public float sendBill()			// send bill to finance manager
	{
		float bill = 906;
		return bill;
	}
	
	public float getAllocatedMoney()		// get allocated money from finance manager for event
	{	FinanceManager fm = new FinanceManager();	
		return fm.emAllocateMoney();	}
	
	public float getSalary()		// get salary
	{	FinanceManager fm = new FinanceManager();
		return fm.setSalary();	}

}
class Booking
{
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	int bid = 12345;
	float totalBill = 3500;		// final bill paid by customer
	String bookedDate = "08/10/2022";
	String todayDate = "09/10/2022";
	
	public int getBookingId()
	{		return bid;		}
	
	public float getBill()
	{		return totalBill;	}
	
	public String bookingDate()
	{		return bookedDate;	}

	public void calcReturn()	// calculate if cancelled within 2 days and refund
	{
		try {
			Date d1 = format.parse(bookedDate);
			Date d2 = format.parse(todayDate);
			long dateDifference = (d2.getTime()-d1.getTime())/(1000 * 60 * 60 * 24);	// calculate number of days difference	
			if(dateDifference<=2) {			// if cancelled within 2 days
				float refund = totalBill*95/100;		// 95% of total amount refunded
				System.out.print("Booking cancelled! Refund amount: $");
				System.out.println(refund);
			}
			else {							// if cancelled not within 2 days
				System.out.println("Booking cancelled!");		// not refunded and notify unsuccessful
			}
		} 
		catch (ParseException e){
			e.printStackTrace();
		}
	}
}

class FinanceManager
{
	EventManager em = new EventManager();
	LogisticsManager lm = new LogisticsManager();
	Caterer ca = new Caterer();
	Booking b = new Booking();
	Customer c = new Customer();
	
	float emBill = em.sendBill();		// get bill from event manager
	float lmBill = lm.sendBill();		// get bill from logistics manager
	float caBill = ca.sendBill();		// get bill from caterer
	
	public float makeCostPlan()
	{
		float totalBill = (emBill + lmBill + caBill);		// calculate actual bill
		float finalBill = b.getBill();			// bill paid by customer
		float profit = finalBill - totalBill;
		return profit;
	}
	
	public int reviseCostPlan()			// revise cost plan	
	{	return 1;	}				// status 1 -> cost plan revise successful
	
	public int updatePackagePrice()
	{	return 1;	}			// status 1 -> update package price successful
	
	public float emAllocateMoney()		// allocate money to Event manager
	{	return emBill;	}
	public float lmAllocateMoney()		// allocate money to Logistics manager
	{	return lmBill;	}
	public float caAllocateMoney()		// allocate money to Caterer
	{	return caBill;	}
	
	public float setSalary()
	{		return this.makeCostPlan()/5;	}	//**profit divided into 5 portions	
	
	public float getSalary()			// get salary
	{	return this.setSalary();	}
	
}

class LogisticsManager
{
	
	public float sendBill()			// send bill to finance manager
	{
		float bill = 500;
		return bill;
	}
	
	public float getAllocatedMoney() 		// get allocated money from finance manager for event
	{		
		FinanceManager fm = new FinanceManager();
		return fm.lmAllocateMoney();	
	}
	
	public float getSalary()			// get salary from finance manager
	{	
		FinanceManager fm = new FinanceManager();
		return fm.setSalary();	}
}

class Caterer
{
	public float sendBill()			// send bill to finance manager
	{
		float bill = 708;
		return bill;
	}
	
	public float getAllocatedMoney()		// get allocated money from finance manager for event
	{	FinanceManager fm = new FinanceManager();
		return fm.caAllocateMoney();	}
	
	public float getSalary()		// get salary from finance manager
	{	FinanceManager fm = new FinanceManager();
		return fm.setSalary();	}
}
