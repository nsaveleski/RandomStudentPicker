package cis232.lab;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		File originalFile = new File("students.csv");
		Scanner inputFile = new Scanner(originalFile);
		ArrayList<Student> students = new ArrayList<>();

		Random r = new Random();

		while (inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			String[] tokens = line.split(",");
			students.add(new Student(tokens[0], Integer.parseInt(tokens[1])));
		}
		inputFile.close();
		boolean yes = true;
		while (yes) {
			System.out.println("Do you want to pick a student (y/n)");
			String input = keyboard.nextLine();

			if (input.equalsIgnoreCase("y")) {
				int n = r.nextInt(students.size());
				Student name = students.get(n);
				System.out.println("Did " + name.getName()
						+ " get it right? (y/n)");
				String input2 = keyboard.nextLine();
				if (input2.equalsIgnoreCase("y")) {
					name.addPoint();
					System.out.println("Great job! +1 point to "
							+ name.getName() + ".  " + name.getName() + " has "
							+ name.points + " point(s).");
				} else {
					System.out.println("Tough luck. Better luck next time!"
							+ name.getName() + " has " + name.points
							+ " point(s)!!");
				}
			} else if (input.equalsIgnoreCase("n")) {
				yes = false;
				System.out.println("Exits");
			} else {
				System.out.print("Invalid choice. ");
			}
		}

		PrintWriter write = new PrintWriter(originalFile);
		while (!students.isEmpty()) {
			Student each = students.remove(0);
			write.println(each.getName() + "," + each.getPoints());
		}
		write.close();
	}
}
