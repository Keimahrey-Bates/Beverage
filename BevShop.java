import java.util.ArrayList;
public class BevShop extends Object implements BevShopInterface
{
	private Order currentOrder;
	private int numOfAlcohol;
	private ArrayList<Order> listOfOrders = new ArrayList<Order>(); 
	public BevShop()
	{
		listOfOrders = new ArrayList<Order>();
		numOfAlcohol = 0;
		
	}
	public boolean isValidTime(int time)
	{
		if(time < MIN_TIME || time > MAX_TIME)
		{
			return false;
		}
		return true;
	}
	public int getMaxNumOfFruits()
	{
		return MAX_FRUIT;
	}
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE_FOR_ALCOHOL;
	}
	public boolean isMaxFruit(int numOfFruits)
	{
		if(numOfFruits > MAX_FRUIT)
		{
			return false;
		}
		return true;
	}
	public int getMaxOrderForAlcohol()
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}
	public boolean isEligibleForMore()
	{
		int num;
		num = currentOrder.findNumOfBeveType(Type.ALCOHOL);
		if(num > MAX_ORDER_FOR_ALCOHOL)
		{
			return false;
		}
		return true;
	}
	public int getNumOfAlcoholDrink()
	{
		return numOfAlcohol;
	}
	public boolean isValidAge(int age)
	{
		if(age < MIN_AGE_FOR_ALCOHOL)
		{
			return false;
		}
		return true;
	}
	public void startNewOrder(int time, Day day, String customerName, int customerAge)
	{
		currentOrder = new Order(time, day, new Customer(customerName, customerAge));
	}
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	public void processAlcoholOrder(String bevName, Size size)
	{
		currentOrder.addNewBeverage(bevName, size);
	}
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	public int findOrder(int orderNo)
	{
		int index = 0;
		int location = -1;
		for(Order i: listOfOrders)
		{
			if(i.getOrderNo() == orderNo)
			{
				location = index;
			}
			index++;
			
		}
		return location;
	}
	public double totalOrderPrice(int orderNo)
	{
		double totalOrder = 0.0;
		for(Order i: listOfOrders)
		{
			if(i.getOrderNo() == orderNo)
			{
				totalOrder = i.calcOrderTotal();
			}
		}
		return totalOrder;
	}
	public double totalMonthlySale()
	{
		double totalMonthSale = 0.0;
		for(Order i: listOfOrders)
		{
			totalMonthSale += i.calcOrderTotal();
		}
		return totalMonthSale;
	}
	public int totalNumOfMonthlyOrders()
	{
		return listOfOrders.size();
	}
	public Order getCurrentOrder()
	{
		return currentOrder;
	}
	public Order getOrderAtIndex(int index)
	{
		int j = 0;
		Order found;
		for(Order i: listOfOrders)
		{
			if(index == j)
			{
				found = i;
				return found;
			}
			j++;
		}
		return null;
	}
	public void sortOrders()
	{
		int orderLength = listOfOrders.size();
		for(int i =0; i < orderLength - 1; i++)
		{
			int minIndex = i;
			for(int j = i + 1; j < orderLength; j++)
			{
				if(listOfOrders.get(j).compareTo(listOfOrders.get(minIndex)) < 0)
				{
					minIndex = j;
				}
				Order other = listOfOrders.get(minIndex);
				listOfOrders.set(minIndex, listOfOrders.get(i));
				listOfOrders.set(i, other);
				
			}
		}
	}
	public String toString()
	{
		String allOrders = "";
		allOrders = "Number Of Alcoholic Beverages: " + numOfAlcohol + "\nCurrent Order: " + currentOrder;
		for(Order i: listOfOrders)
		{
			allOrders += "\n" + i.toString();
		}
		allOrders += "\n" + totalMonthlySale();
		return allOrders;
	}
	
	
}