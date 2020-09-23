package com.company;

import com.company.command.*;
import com.company.contact.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Actions {
  private final Scanner scanner = new Scanner(System.in);
  private final PhoneBook phoneBook;
  private List<Contact> searchResults;
  private Command command;

  public Actions() {
    phoneBook = new PhoneBook();
  }

  public void add() {
    System.out.print("\n[add] Enter the type (person, organization): ");
    String contactType = scanner.nextLine().toLowerCase();
    command = new AddCommand(phoneBook, contactType);
    command.execute();
  }

  public void list() {
    if (phoneBook.getSize() != 0) {
      showPhoneBook();
      System.out.print("\n[list] Enter action ([number], back): ");
      String action = scanner.nextLine();
      if (action.equals("back")) {
        return;
      }
      Contact contact = findContact(phoneBook.getPhoneBook(), action);
      if (contact != null) {
        System.out.println(contact);
        record(contact);
      }
    }
  }

  public void search() {
    searchResults = new ArrayList<>();
    command = new SearchCommand(searchResults, phoneBook.getPhoneBook());
    command.execute();
    if (searchResults.size() != 0) {
      showSearchResults();
      System.out.print("\n[search] Enter action ([number], back, again): ");
      String action = scanner.nextLine();
      switch (action) {
        case "back":
          return;
        case "again":
          search();
          break;
        default:
          Contact contact = findContact(searchResults, action);
          if (contact != null) {
            System.out.println(contact);
            record(contact);
          }
          break;
      }
    }
  }

  private void record(Contact contact) {
    while (true) {
      System.out.print("\n[record] Enter action (edit, delete, menu): ");
      String action = scanner.nextLine();
      switch (action) {
        case "edit":
          edit(contact);
          break;
        case "delete":
          delete(contact);
          return;
        case "menu":
          return;
        default:
          System.out.println("Incorrect action.");
      }
    }
  }

  private void edit(Contact contact) {
    command = new EditCommand(contact);
    command.execute();
    System.out.println("Saved");
    System.out.println(contact);
  }

  private void delete(Contact contact) {
    phoneBook.removeContact(contact);
    System.out.println("The record removed.");
  }

  public void count() {
    System.out.printf("The phone book has %s records.\n", phoneBook.getSize());
  }

  private Contact findContact(List<Contact> list, String number) {
    Contact contact = null;
    int index = isCorrectIndex(number);
    if (index == -1) {
      System.out.println("Wrong number!");
    } else {
      contact = list.get(index - 1);
    }
    return contact;
  }

  public void showPhoneBook() {
    command = new ListCommand(phoneBook.getPhoneBook());
    command.execute();
  }

  private void showSearchResults() {
    command = new ListCommand(searchResults);
    command.execute();
  }

  private int isCorrectIndex(String input) {
    int index;
    try {
      index = Integer.parseInt(input);
    } catch (Exception e) {
      index = -1;
    }
    if (index > phoneBook.getSize()) {
      index = -1;
    }
    return index;
  }
}
