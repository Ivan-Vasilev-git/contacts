package com.company.command;


import com.company.contact.Contact;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SearchCommand implements Command {
  private final List<Contact> phoneBook;
  private final List<Contact> searchResults;
  private final Scanner scanner;

  public SearchCommand(List<Contact> searchResults, List<Contact> phoneBook) {
    this.searchResults = searchResults;
    this.phoneBook = Collections.unmodifiableList(phoneBook);
    scanner = new Scanner(System.in);
  }

  @Override
  public void execute() {
    System.out.print("Enter search query: ");
    String query = scanner.nextLine().toLowerCase();
    for (Contact c : phoneBook) {
      if (c.getForSearch().toLowerCase().contains(query)) {
        searchResults.add(c);
      }
    }
  }
}
