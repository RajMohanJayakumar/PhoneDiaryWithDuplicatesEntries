package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Logic {
	public static Map<String, String> contactsMap = new HashMap<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name");
		String name = scanner.nextLine();
		System.out.println("Enter the Phonenumber");
		String phoneNumber = scanner.nextLine();
		boolean isContactExists = false;

		File file = new File("src//contacts.txt");
		if (file.length() == 0) {
			System.out.println("File is empty !!! creating new file...");
			try {
				file.createNewFile();
				saveContact(file, name, phoneNumber);
			} catch (IOException e) {
				System.out.println("Exception is caught" + e);
			}
		} else {
			try {
				FileInputStream inputFile = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(inputFile);
				contactsMap = (Map<String, String>) in.readObject();
				for (Map.Entry<String, String> localMap : contactsMap.entrySet()) {
					if (localMap.getValue().equalsIgnoreCase(phoneNumber)) {
						isContactExists = true;
						System.out.println("contact number already exists in the database" + phoneNumber);
						break;
					}
				}
				if (!isContactExists) {
					saveContact(file, name, phoneNumber);
				}
				in.close();
				inputFile.close();
			} catch (Exception ex) {
				System.out.println("Exception is caught" + ex);
			}
		}
	}

	private static void saveContact(File file, String name, String phoneNumber) {
		try {
			FileOutputStream outputFile = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(outputFile);
			// Method for serialization of object
			contactsMap.put(name, phoneNumber);
			out.writeObject(contactsMap);
			System.out.println("Details successfully saved and has been serialized");
			out.flush();
			out.close();
			outputFile.close();
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}
}
