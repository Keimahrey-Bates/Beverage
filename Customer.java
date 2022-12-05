public class Customer extends Object
{
	public int age;
	public String name;
	Customer(Customer c)
	{
		name = c.name;
		age = c.age;
	}
	Customer(String name, int age)
	{
		this.setName(name);
		this.setAge(age);
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return age;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public String toString()
	{
		return "Name: " + name + "\nAge: " + age;
	}
}