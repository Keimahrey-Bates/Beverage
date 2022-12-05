public class Alcohol extends Beverage
{
	private boolean isWeekend;
	public Alcohol(String bevName, Size size, boolean isWeekend)
	{
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	public boolean isWeekend()
	{
		return isWeekend;
	}
	public double calcPrice()
	{
		double alcoholPrice = getBasePrice() + addSizePrice();
		if(isWeekend == true)
		{
			alcoholPrice += 0.60;
		}
		return alcoholPrice;
	}
	public String toString()
	{
		return super.toString() + "\nIs Weekend: " + isWeekend;
	}
	public boolean equals(Alcohol anotherBev)
	{
		if(super.equals(anotherBev) && this.isWeekend == anotherBev.isWeekend)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}