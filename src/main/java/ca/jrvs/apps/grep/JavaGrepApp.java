package ca.jrvs.apps.grep;

import java.io.IOException;

public class JavaGrepApp {
  public static void main(String[] args) throws IOException {
    if (args.length != 3) {
      throw new IllegalArgumentException("Missing arguments.\n - USAGE: regex rootPath outFile");
    }
    JavaGrepImp javaGrepImp = new JavaGrepImp();
    javaGrepImp.setRegex(args[0]);
    javaGrepImp.setRootPath(args[1]);
    javaGrepImp.setOutFile(args[2]);
    javaGrepImp.processLambda();
  }
}
