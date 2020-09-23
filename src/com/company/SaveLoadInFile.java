package com.company;

import java.io.*;

public class SaveLoadInFile {

  public static void save(Object object, String fileName) {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream(fileName))) {
      out.writeObject(object);
    } catch (IOException e) {
      System.out.println("Save failed! " + e.getMessage());
    }
  }

  public static Object load(String fileName) {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
      System.out.println("open " + fileName);
      return in.readObject();
    } catch (FileNotFoundException e) {
      System.out.println("File not found.");
    } catch (IOException e) {
      System.out.println("Load failed.");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }
}
