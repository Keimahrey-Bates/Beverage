import java.util.ArrayList;
public class Order extends Object implements OrderInterface, Comparable<Order>
{
	private int orderNumber;
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverageList = new ArrayList<Beverage>();
	public Order(int orderTime, Day orderDay, Customer cust)
	{
		orderNumber = generateOrder();
		this.orderTime = orderTime;
		this.orderDay = orderDay;
	}
	public int generateOrder()
	{
		final int min = 10000;
		final int max = 90000;
		int randNum = (int) (Math.random() * (max - min + 1) + min);
		return randNum;
	}
	public int getOrderNo()
	{
		return orderNumber;
	}
	public int getOrderTime()
	{
		return orderTime;
	}
	public Day getOrderDay()
	{
		return orderDay;
	}
	public Customer getCustomer()
	{
		return customer;
	}

	public boolean isWeekend()
	{
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public Beverage getBeverage(int itemNo)
	{
		return beverageList.get(itemNo);
	}
	public int getTotalItems()
	{
		return beverageList.size();
	}
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		beverageList.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}
	public void addNewBeverage(String bevName, Size size)
	{
		beverageList.add(new Alcohol(bevName, size, isWeekend()));
	}
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		beverageList.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}
	public double calcOrderTotal()
	{
		double orderTotal = 0.0;
		for(Beverage b: beverageList)
		{
			orderTotal += b.calcPrice();
		}
		return orderTotal;
	}
	public int findNumOfBeveType(Type type)
	{
		int num = 0;
		for (Beverage b: beverageList)
		{
			if(b.getType() == type)
			{
				num++;
			}
		}
		return num;
	}
	public String toString()
	{
		String order;
		order = "Order Number: " + orderNumber + "\nOrder Time: " + orderTime + "\nOrder Day" + orderDay + "Customer: " + customer.toString();
		for(Beverage b: beverageList)
		{
			order += b.toString();
		}
		return order;
	}
	public int compareTo(Order anotherOrder)
	{
		int compare = 0;
		if(orderNumber > anotherOrder.getOrderNo())
		{
			compare = 1;
		}
		else if(orderNumber < anotherOrder.getOrderNo())
		{
			compare = -1;
		}
		return compare;
	}

}