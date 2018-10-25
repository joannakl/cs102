

package project1_jk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class questionA {
    public static void main (String args[]) {
      ColorList cl = new ColorList();
      cl.add(new Color("#ffffff"));
      cl.add(new Color("#000000"));
      cl.add(new Color("#00ff00"));
      System.out.println(cl);
    }
}
