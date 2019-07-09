package ca.jrvs.apps.grep;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JavaGrepImp implements JavaGrep {
  private String rootPath;
  private String regex;
  private String outFile;

  public void processLambda() throws IOException {
    File fOut = new File(this.outFile);
    FileOutputStream fos = new FileOutputStream(fOut);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
    for (File file : listFilesLambda(this.rootPath)) {
      readWriteLinesLambda(file, bw);
    }
    bw.close();
  }

  public List<File> listFilesLambda(String rootPath) throws IOException {
    return Files.walk(Paths.get(rootPath))
        .filter(Files::isRegularFile)
        .map(Path::toFile)
        .collect(Collectors.toList());
  }

  public void readWriteLinesLambda(File inputFile, BufferedWriter bw) {
    try {
      Stream<String> lines = (Stream<String>) Files.lines(Paths.get(inputFile.getPath()));
      lines
          .filter(l -> containsPattern(l))
          .forEach(
              l -> {
                try {
                  bw.write(l + "\n");
                } catch (Exception e) {
                  System.out.println("Error writing line '" + l + "' to file");
                }
              });
    } catch (Exception e) {
      System.out.println("Unrecognized file format: " + inputFile);
    }
  }

  @Override
  public void process() throws IOException {
    List<String> lines = new ArrayList<>();
    for (File file : listFilesLambda(this.rootPath)) {
      for (String line : readLines(file)) {
        if (containsPattern(line)) {
          lines.add(line);
        }
      }
    }
    writeToFile(lines);
  }

  @Override
  public List<File> listFiles(String rootDir) {
    File aDirectory = new File(rootDir);
    List<File> files = new ArrayList<>();
    for (File file : aDirectory.listFiles()) {
      if (file.isDirectory()) {
        files.addAll(listFiles(file.getPath()));
      } else {
        files.add(file);
      }
    }
    return files;
  }

  @Override
  public List<String> readLines(File inputFile) {
    String line;
    List<String> lines = new ArrayList<>();
    try {
      BufferedReader br = new BufferedReader(new FileReader(inputFile));
      while ((line = br.readLine()) != null) {

        lines.add(line);
      }
    } catch (Exception e) {
    }
    return lines;
  }

  @Override
  public boolean containsPattern(String line) {
    return line.toLowerCase().matches(this.regex);
  }

  @Override
  public void writeToFile(List<String> lines) throws IOException {
    File fOut = new File(this.outFile);
    FileOutputStream fos = new FileOutputStream(fOut);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
    for (String line : lines) {
      bw.write(line);
      bw.newLine();
    }
    bw.close();
  }

  @Override
  public String getRootPath() {
    return this.rootPath;
  }

  @Override
  public void setRootPath(String rootPath) {
    this.rootPath = rootPath;
  }

  @Override
  public String getRegex() {
    return this.regex;
  }

  @Override
  public void setRegex(String regex) {
    this.regex = regex;
  }

  @Override
  public String getOutFile() {
    return this.outFile;
  }

  @Override
  public void setOutFile(String outFile) {
    this.outFile = outFile;
  }
}
