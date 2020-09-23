package com.company.command;

import com.company.Validator;
import com.company.contact.Contact;
import com.company.contact.Organization;
import com.company.contact.Person;

import java.util.Scanner;

public class EditCommand implements Command {
  private final Contact contact;
  private final Scanner scanner;

  public EditCommand(Contact contact) {
    this.contact = contact;
    scanner = new Scanner(System.in);
  }

  @Override
  public void execute() {
    switch (contact.getClass().getSimpleName()) {
      case "com.company.contact.Person":
        editPerson();
        break;
      case "com.company.contact.Organization":
        editOrganization();
        break;
    }
  }

  private void editPerson() {
    Person person = (Person) contact;
    System.out.print("Select a field (name, surname, birth, gender, number): ");
    String field = scanner.nextLine().toLowerCase();
    switch (field) {
      case "name":
        System.out.print("Enter name: ");
        person.setName(scanner.nextLine());
        break;
      case "surname":
        System.out.print("Enter surname: ");
        person.setSurname(scanner.nextLine());
        break;
      case "birth":
        System.out.print("Enter birth date: ");
        person.setBirthDate(Validator.setBirthDate(scanner.nextLine()));
        break;
      case "gender":
        System.out.print("Enter gender: ");
        person.setGender(Validator.setGender(scanner.nextLine()));
        break;
      case "number":
        System.out.print("Enter number: ");
        person.setPhoneNumber(Validator.setPhoneNumber(scanner.nextLine()));
        break;
      default:
        System.out.println("Incorrect field.");
    }
  }

  private void editOrganization() {
    Organization organization = (Organization) contact;
    System.out.print("Select a field (name, address, number): ");
    String field = scanner.nextLine().toLowerCase();
    switch (field) {
      case "name":
        System.out.print("Enter name: ");
        organization.setName(scanner.nextLine());
        break;
      case "address":
        System.out.print("Enter address: ");
        organization.setAddress(scanner.nextLine());
        break;
      case "number":
        System.out.print("Enter number: ");
        organization.setPhoneNumber(Validator.setPhoneNumber(scanner.nextLine()));
        break;
      default:
        System.out.println("Incorrect field.");
    }
  }
}
