package com.company.command;

import com.company.PhoneBook;
import com.company.Validator;
import com.company.contact.Organization;
import com.company.contact.Person;

import java.time.LocalDate;
import java.util.Scanner;

public class AddCommand implements Command {

  private final PhoneBook phoneBook;
  private final String contactType;
  private final Scanner scanner = new Scanner(System.in);

  public AddCommand(PhoneBook phoneBook, String contactType) {
    this.phoneBook = phoneBook;
    this.contactType = contactType;
  }

  @Override
  public void execute() {
    switch (contactType) {
      case "person":
        addPerson();
        System.out.println("The record added.");
        break;
      case "organization":
        addOrganization();
        System.out.println("The record added.");
        break;
      default:
        System.out.println("Incorrect type.");
        break;
    }
  }

  private void addPerson() {
    System.out.print("Enter the name: ");
    String name = scanner.nextLine();

    System.out.print("Enter the surname: ");
    String surname = scanner.nextLine();

    System.out.print("Enter the birth date: ");
    LocalDate birthDate = Validator.setBirthDate(scanner.nextLine());

    System.out.print("Enter the gender (M, F): ");
    String gender = Validator.setGender(scanner.nextLine());

    System.out.print("Enter the number: ");
    String number = Validator.setPhoneNumber(scanner.nextLine());

    phoneBook.addContact(new Person(
        name,
        surname,
        birthDate,
        gender,
        number)
    );
  }

  private void addOrganization() {
    System.out.print("Enter the organization name: ");
    String name = scanner.nextLine();

    System.out.print("Enter the address: ");
    String address = scanner.nextLine();

    System.out.print("Enter the number: ");
    String number = Validator.setPhoneNumber(scanner.nextLine());

    phoneBook.addContact(new Organization(name, address, number));
  }
}
