package com.company;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

  private final static Pattern phoneNumberPattern = Pattern.compile(
      "\\+?((\\([0-9A-Za-z]+\\)|[0-9A-Za-z]+)|" +
          "([0-9A-Za-z]+[ -]\\([0-9A-Za-z]{2,}\\))|" +
          "[0-9A-Za-z]+[ -][0-9A-Za-z]{2,})([ -][0-9A-Za-z]{2,}[ -]?)*"
  );

  public static LocalDate setBirthDate(String birthDate) {
    if (!isValidBirthDate(birthDate)) {
      System.out.println("Bad birth date!");
    }
    return isValidBirthDate(birthDate) ? LocalDate.parse(birthDate) : null;
  }

  public static String setGender(String gender) {
    if (!isValidGender(gender)) {
      System.out.println("Bad gender!");
    }
    return isValidGender(gender) ? gender : "[no data]";
  }

  public static String setPhoneNumber(String number) {
    if (!isValidPhoneNumber(number)) {
      System.out.println("Wrong number format!");
    }
    return isValidPhoneNumber(number) ? number : "[no data]";
  }

  private static boolean isValidPhoneNumber(String number) {
    Matcher matcher = phoneNumberPattern.matcher(number);
    return matcher.matches();
  }

  private static boolean isValidBirthDate(String birthDate) {
    try {
      LocalDate.parse(birthDate);
    } catch (DateTimeException e) {
      return false;
    }
    return true;
  }

  private static boolean isValidGender(String gender) {
    return gender.equals("M") || gender.equals("F");
  }

}
