public class Smoothie extends Beverage
{
	private int numOfFruits;
	private boolean addProtein;
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	public int getNumOfFruits()
	{
		return numOfFruits;
	}
	public boolean getAddProtein()
	{
		return addProtein;
	}
	public String toString()
	{
		return super.toString() + "\nNumber of Fruits Added: " + numOfFruits + "\nProtein Added: " + addProtein;
	}
	public double calcPrice()
	{
		double smoothiePrice = getBasePrice();
		smoothiePrice += addSizePrice();
		smoothiePrice = smoothiePrice + (numOfFruits * 0.50);
		if(addProtein == true)
		{
			smoothiePrice += 1.50;
		}
		return smoothiePrice;
	}
	public boolean equals(Smoothie anotherBev)
	{
		if(super.equals(anotherBev) && this.numOfFruits == anotherBev.numOfFruits && this.addProtein == anotherBev.addProtein)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	 
}