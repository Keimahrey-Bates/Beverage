public class Coffee extends Beverage
{
	private boolean extraShot;
	private boolean extraSyrup;
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	public boolean getExtraShot()
	{
		return extraShot;
	}
	public boolean getExtraSyrup()
	{
		return extraSyrup;
	}
	public double calcPrice()
	{
		double totalCost = getBasePrice();
		totalCost += addSizePrice();
		if(extraShot == true)
		{
			totalCost += 0.5;
		}
		if(extraSyrup == true)
		{
			totalCost += 0.5;
		}
		return totalCost;
	}
	public String toString()
	{
		return super.toString() + "\nExtra Shot: " + extraShot + "\nExtra Syrup: " + extraSyrup;
	}
	public boolean equals(Coffee anotherBev)
	{
		if(super.equals(anotherBev) && this.extraShot == anotherBev.extraShot && this.extraSyrup == anotherBev.extraSyrup)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}