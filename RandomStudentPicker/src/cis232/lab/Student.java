package cis232.lab;

public class Student {
	String name;
	int points;
	
	public Student(String name, int points)
	{
		
		this.name = name;
		this.points = points;
	}
	
	public void addPoint()
	{
		points++;
	}
	public String getName()
	{
		return this.name;
	}
	public String getPoints()
	{
		return Integer.toString(points);
	}
}
