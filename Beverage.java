public abstract class Beverage extends Object
{

	private String bevName;
	private Type type;
	private Size size;
	public final double basePrice = 2.0;
	public final double sizePrice = 1.0;
	public Beverage(String bevName, Type type, Size size)
	{
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	public double getBasePrice()
	{
		return basePrice;
	}
	public Type getType()
	{
		return type;
	}
	public String getBevName()
	{
		return bevName;
	}
	public Size getSize()
	{
		return size;
	}
	public double addSizePrice()
	{
		double totalSizePrice = 0.0;
		if(this.size == Size.SMALL)
		{
			totalSizePrice = basePrice;
		}
		else if(this.size == Size.MEDIUM)
		{
			totalSizePrice = basePrice + sizePrice;
		}
		else if(this.size == Size.LARGE)
		{
			totalSizePrice = basePrice + (sizePrice + 1);
		}
		return totalSizePrice;
	}
	public String toString()
	{
		return "Beverage Name: " + bevName + "\nBeverage Size: " + size;
	}
	public boolean equals(Beverage anotherBev)
	{ 
		if(this.bevName.equals(anotherBev.getBevName()) && this.type == anotherBev.getType() && this.size == anotherBev.getSize())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public abstract double calcPrice();
}