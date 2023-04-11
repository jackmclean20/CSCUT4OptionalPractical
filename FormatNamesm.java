import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.io.FileWriter;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FormatNamesm {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter input file location and name: ");
		String inputFileName = input.nextLine();
		System.out.print("Enter output file location and name: ");
		String outputFileName = input.nextLine();
		System.out.print("Convert names to uppercase? (Y/N): ");
		boolean isUpperCase = input.nextLine().equalsIgnoreCase("Y");

		File inputFile = new File(inputFileName);
		Scanner scanner;
		try {
			scanner = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}

		File outputFile = new File(outputFileName);
		PrintWriter writer;
		try {
			writer = new PrintWriter(outputFile);
		} catch (FileNotFoundException e) {
			System.err.println("Error: " + e.getMessage());
			return;
		}

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();

			String[] parts = line.split(" ");
			String firstName = toTitleCase(parts[0]);
			String middleName = "";
			String lastName = toTitleCase(parts[parts.length-1]);
			String dateOfBirth = parts[2];
			String formattedDate = formatDate(dateOfBirth);
			
			if (parts.length == 4) {
				middleName = middleName(parts[1]);
			}
			
			if (isUpperCase) {
				firstName = firstName.toUpperCase();
                lastName = lastName.toUpperCase();
			}

			writer.printf("%-20s %-20s %s%n", firstName, middleName, lastName, formattedDate);
		}
		if (isUpperCase) 

		scanner.close();
		writer.close();
		input.close();
	}

	private static String toTitleCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}
	
	private static String middleName(String str) {
		if (str != null) {
			return str.toUpperCase();
		}
		else {
			return "";
		}
	}

	private static String formatDate(String str) {
		return str.substring(0, 2) + "/" + str.substring(2, 4) + "/" + str.substring(4);
	}

} // FilesInOut