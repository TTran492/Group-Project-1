
import java.util.*;
import java.lang.*;
import java.io.*;

public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final String Customer_STRING = "C";
	private String Customer_name;
	private String Customer_id;
	private String Customer_phone;
	private String Customer_address;
	//private List<Waitlist> waitlistedProducts = new LinkedList<Waitlist>();
	public Customer(String Name, String phone,  String address)
	{
		this.Customer_name    = Name;
		this.Customer_phone   = phone;
		this.Customer_address = address;

		Customer_id = Customer_STRING + (CustomerIDServer.instance()).getID();//generates id through the client id server
	}

	public String getName()
	{
		return Customer_name;
	}

	public String getAddress()
	{
		return Customer_address;
	}

	public String getPhone()
	{
		return Customer_phone;
	}


	public String getID()
	{
		return Customer_id;
	}

/*
	public boolean addProductToWaitlist(Waitlist w){
		return waitlistedProducts.add(w);
	}

	public boolean removeWaitlistedProduct(Waitlist w)
	{
		return waitlistedProducts.remove(w);
	}

	public Iterator<Waitlist> getWaitlistedProducts()
	{
		return waitlistedProducts.iterator();
	}

	public Waitlist searchWaitListOnProduct(Product p)
	{
		Iterator<Waitlist> iterator = waitlistedProducts.iterator();
		Waitlist w;
		while (iterator.hasNext())
		{
			w = iterator.next();
			if (w.getProduct() == p)
			{
				return w;
			}
		}
		return null;
	}
*/
	public String toString()
	{
		return "Customer: " + getName() + ".  Phone: " + getPhone()+ ". ID: "+ getID()+". Address: "+getAddress();
	}

}
