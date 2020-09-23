package com.company.command;

import com.company.contact.Contact;

import java.util.List;

public class ListCommand implements Command {

  private final List<Contact> contacts;

  public ListCommand(List<Contact> contacts) {
    this.contacts = contacts;
  }

  @Override
  public void execute() {
    int index = 0;
    for (Contact contact : contacts) {
      System.out.printf("%d. %s\n", ++index, contact.getFullName());
    }
  }
}
