package com.company;

import java.util.Scanner;

public class Menu {
  private final Actions actions;
  private final Scanner scanner = new Scanner(System.in);

  public Menu() {
    actions = new Actions();
  }

  public void startMenu() {
    while (true) {
      System.out.print("\n[menu] Enter action (add, list, search, count, exit): ");
      String action = scanner.nextLine();
      switch (action) {
        case "add":
          actions.add();
          break;
        case "list":
          actions.list();
          break;
        case "search":
          actions.search();
          break;
        case "count":
          actions.count();
          break;
        case "exit":
          scanner.close();
          return;
        default:
          System.out.println("Incorrect action.");
      }
    }
  }
}
