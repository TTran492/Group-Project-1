import java.util.*;
import java.io.*;
public class CustomerList implements Serializable{
  private static final long serialVersionUID = 1L;
  private List<Customer> customers = new LinkedList<Customer>();
  private static CustomerList customerList;

  private CustomerList(){
  }

  public static CustomerList instance()
  {
    if (customerList == null)
    {
      return (customerList = new CustomerList());
    }
    else
    {
      return customerList;
    }
  }

  public boolean insertCustomer(Customer Customers)
  {
    customers.add(Customers);
    return true;
  }

  public Iterator<Customer> getCustomers()
  {
    return customers.iterator();
  }

  public Customer search(String customerID) {
      for (Iterator iterator = customers.iterator(); iterator.hasNext(); ) {
          Customer customer = (Customer) iterator.next();
          if (customer.getID().equals(customerID)) {
              return customer;
          }
      }
      return null;
  }

  private void writeObject(java.io.ObjectOutputStream output)
  {
    try{
      output.defaultWriteObject();
      output.writeObject(customerList);
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
  }

  private void readObject(java.io.ObjectInputStream input)
  {
    try{
      if(customerList != null)
      {
        return;
      }
      else
      {
        input.defaultReadObject();
        if(customerList == null)
        {
          customerList = (CustomerList) input.readObject();
        }
        else
        {
          input.readObject();
        }
      }
    }catch(IOException ioe){
      ioe.printStackTrace();
    }catch(ClassNotFoundException cnfe){
      cnfe.printStackTrace();
    }
  }

  public String toString()
  {
    return customers.toString();
  }

}
