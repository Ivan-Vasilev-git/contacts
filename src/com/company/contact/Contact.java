package com.company.contact;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Contact implements Serializable {
  private final LocalDateTime timeCreated;
  private String name;
  private String phoneNumber;
  private LocalDateTime lastEdit;

  public Contact(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    timeCreated = LocalDateTime.now().withSecond(0).withNano(0);
    lastEdit = timeCreated;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    setLastEdit(LocalDateTime.now());
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    setLastEdit(LocalDateTime.now());
  }

  public LocalDateTime getTimeCreated() {
    return timeCreated;
  }

  public LocalDateTime getLastEdit() {
    return lastEdit;
  }

  public void setLastEdit(LocalDateTime lastEdit) {
    this.lastEdit = lastEdit.withSecond(0).withNano(0);
  }

  public String getForSearch() {
    return getFullName() + " " + phoneNumber;
  }

  public abstract String toString();

  public abstract String getFullName();
}
