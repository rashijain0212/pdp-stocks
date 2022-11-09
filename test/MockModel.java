import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * This class implements Model, but it is not a real class used for operations. This class is
 * mainly used to log the operations results, data received from controller, which are used for
 * testing actual model and controller.
 */
public class MockModel implements Model {
  private final StringBuilder logForAddPortfolioData = new StringBuilder();
  private final StringBuilder logForCheckingIfCompanyNameExist = new StringBuilder();
  private final StringBuilder logForIsValidDate = new StringBuilder();
  private final StringBuilder logForMakeStringDate = new StringBuilder();
  private final StringBuilder logForReadFromFile = new StringBuilder();
  private final StringBuilder logForParseJson = new StringBuilder();
  private final StringBuilder logForCheckParsedPortfolio = new StringBuilder();
  private final StringBuilder logForSetPortfolio = new StringBuilder();
  private final StringBuilder logForGetPortfolio = new StringBuilder();
  private final StringBuilder logForGetPortfolioKeys = new StringBuilder();
  private final StringBuilder LogForGetPortfolioSize = new StringBuilder();
  private final StringBuilder logForHelper = new StringBuilder();
  private final StringBuilder logForCheckingHelperWorksCorrectly = new StringBuilder();
  private final StringBuilder logForSetCurrentDate = new StringBuilder();
  private final StringBuilder logForPortfolioContainsCertainKey = new StringBuilder();
  private final StringBuilder logForHasAnotherPortfolioWithSameName = new StringBuilder();
  private final StringBuilder logForTotalStockValue = new StringBuilder();
  private final StringBuilder logForSetContainsGivenDate = new StringBuilder();
  private final StringBuilder logForSavePortfolio = new StringBuilder();
  private final StringBuilder logForModelSavePortfolio = new StringBuilder();
  List<String> stockCompanies = List.of("AAPL.txt", "AMZN.txt", "ATVI.txt", "BCS.txt",
          "CAJ.txt", "CSCO.txt", "DIS.txt", "JPM.txt", "MCD.txt", "MSFT.txt", "ORCL.txt", "SBUX.txt"
          , "WFC.txt");
  List<String> stockCompanyName = List.of("APPLE", "AMAZON", "ACTIVISION", "BARCLAYS"
          , "CANON INC", "CISCO SYSTEMS", "DISNEY", "JP MORGAN", "MCDONALD", "MICROSOFT"
          , "ORACLE", "STARBUCKS", "WELLS FARGO");
  List<HashMap<String, String>> stockData = new ArrayList<>();
  String startingDate = "2001-02-02";
  String endingDate = "2022-10-25";
  String currentDate = startingDate;
  Set<String> listOfDates = new HashSet<>();
  String data;
  Map<String, List<List<String>>> portfolio = new HashMap<>();

  /**
   * Getter method for logForCheckingHelperWorksCorrectly.
   *
   * @return String containing the contents of logForCheckingHelperWorksCorrectly.
   */
  public String getLogForCheckingHelper() {
    return logForCheckingHelperWorksCorrectly.toString();
  }

  /**
   * Getter for logForHelper.
   *
   * @return String containing the contents of logForHelper.
   */
  public String getLogForHelper() {
    return logForHelper.toString();
  }

  /**
   * Getter for LogForGetPortfolioSize.
   *
   * @return String containing the contents of LogForGetPortfolioSize.
   */
  public String getLogForGetPortfolioSize() {
    return LogForGetPortfolioSize.toString();
  }

  /**
   * Getter for logForGetPortfolioKeys.
   *
   * @return String containing the contents of logForGetPortfolioKeys.
   */
  public String getLogForPortfolioKeys() {
    return logForGetPortfolioKeys.toString();
  }

  /**
   * Getter for logForGetPortfolio.
   *
   * @return String containing the contents of logForGetPortfolio.
   */
  public String getLogForGetPortfolio() {
    return logForGetPortfolio.toString();
  }

  /**
   * Getter for logForReadFromFile.
   *
   * @return String containing the contents of logForReadFromFile.
   */
  public String getLogForReadFromFile() {
    return logForReadFromFile.toString();
  }

  /**
   * Getter for logForParseJson.
   *
   * @return String containing the contents of logForParseJson.
   */
  public String getLogForParseJson() {
    return logForParseJson.toString();
  }

  /**
   * Getter for logForCheckParsedPortfolio.
   *
   * @return String containing the contents of logForCheckParsedPortfolio.
   */
  public String getLogForCheckParsedPortfolio() {
    return logForCheckParsedPortfolio.toString();
  }

  /**
   * Getter for logForSetPortfolio.
   *
   * @return String containing the contents of logForSetPortfolio.
   */
  public String getLogForSetPortfolio() {
    return logForSetPortfolio.toString();
  }

  /**
   * Getter for logForMakeStringDate.
   *
   * @return String containing the contents of logForMakeStringDate.
   */
  public String getLogForMakeString() {
    return logForMakeStringDate.toString();
  }

  /**
   * Getter for logForIsValidDate.
   *
   * @return String containing the contents of logForIsValidDate.
   */
  public String getLogForIsValidDate() {
    return logForIsValidDate.toString();
  }

  /**
   * Getter for logForAddPortfolioData.
   *
   * @return String containing the contents of logForAddPortfolioData.
   */
  public String getLogForAddPortfolioData() {
    return logForAddPortfolioData.toString();
  }

  /**
   * Getter for logForCheckingIfCompanyNameExist.
   *
   * @return String containing the contents of logForCheckingIfCompanyNameExist.
   */
  public String getLogForCheckingCompanyNameExist() {
    return logForCheckingIfCompanyNameExist.toString();
  }

  /**
   * Getter for logForSavePortfolio.
   *
   * @return String containing the contents of logForSavePortfolio.
   */
  public String getLogForSavePortfolio() {
    return logForSavePortfolio.toString();
  }

  /**
   * Getter for logForSetCurrentDate.
   *
   * @return String containing the contents of logForSetCurrentDate.
   */
  public String getLogForSetCurrentDate() {
    return logForSetCurrentDate.toString();
  }

  /**
   * Getter for logForPortfolioContainsCertainKey.
   *
   * @return String containing the contents of logForPortfolioContainsCertainKey.
   */
  public String getLogForPortfolioContainsCertainKey() {
    return logForPortfolioContainsCertainKey.toString();
  }

  /**
   * Getter for logForHasAnotherPortfolioWithSameName.
   *
   * @return String containing the contents of logForHasAnotherPortfolioWithSameName.
   */
  public String getLogForHasAnotherPortfolioWithSameName() {
    return logForHasAnotherPortfolioWithSameName.toString();
  }

  /**
   * Getter for logForTotalStockValue.
   *
   * @return String containing the contents of logForTotalStockValue.
   */
  public String getLogForTotalStockValue() {
    return logForTotalStockValue.toString();
  }

  /**
   * Getter for logForSetContainsGivenDate.
   *
   * @return String containing the contents of logForSetContainsGivenDate.
   */
  public String getSetContainsGivenDate() {
    return logForSetContainsGivenDate.toString();
  }

  /**
   * Getter for logForModelSavePortfolio.
   *
   * @return String containing the contents of logForModelSavePortfolio.
   */
  public String getLogForModelSavePortfolio() {
    return logForModelSavePortfolio.toString();
  }

  @Override
  public String getCurrentDate() {
    return currentDate;
  }

  @Override
  public void setCurrentDate(String currentDate) {
    //System.out.println(currentDate);
    logForSetCurrentDate.append(currentDate);
    this.currentDate = currentDate;
  }

  @Override
  public Map<String, List<List<String>>> getPortfolio() {
    List<String> keys = new ArrayList<>(portfolio.keySet());
    List<List<String>> contents1;
    List<String> insideContents1;
    for (String s : keys) {
      logForGetPortfolio.append(s);
      contents1 = portfolio.get(s);
      for (List<String> contents : contents1) {
        insideContents1 = new ArrayList<>(contents);
        logForGetPortfolio.append(insideContents1.get(0));
        logForGetPortfolio.append(insideContents1.get(1));
        logForGetPortfolio.append(insideContents1.get(2));
      }
    }
    return this.portfolio;
  }

  @Override
  public void setPortfolio(Map<String, List<List<String>>> portfolio) {
    List<String> keys = new ArrayList<>(portfolio.keySet());
    List<List<String>> contents1;
    List<String> insideContents1;
    for (String s : keys) {
      logForSetPortfolio.append(s);
      contents1 = portfolio.get(s);
      for (List<String> contents : contents1) {
        insideContents1 = new ArrayList<>(contents);
        logForSetPortfolio.append(insideContents1.get(0));
        logForSetPortfolio.append(insideContents1.get(1));
        logForSetPortfolio.append(insideContents1.get(2));
      }
    }
    this.portfolio = portfolio;

  }

  @Override
  public List<String> getStockCompanyName() {
    return stockCompanyName;
  }

  @Override
  public void getContentsFromFile() {
    for (String filepath : stockCompanies) {
      try {
        data = new String(Files.readAllBytes(Path.of(
                "src\\stockData\\" + filepath)));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      stockData.add(convertingStringToHashMap(data));
    }
  }

  @Override
  public HashMap<String, String> convertingStringToHashMap(String data) {
    HashMap<String, String> stockDateAndPrice = new HashMap<>();
    String[] breakingDownFullString = data.split("\r?\n|\r");
    for (String s : breakingDownFullString) {
      String[] separatingWithComa = s.split(",");
      if (separatingWithComa.length == 6) {
        stockDateAndPrice.put(separatingWithComa[0], separatingWithComa[4]);
      }
    }
    return stockDateAndPrice;
  }

  @Override
  public boolean hasAnotherPortfolioWithSameName(String name) {
    logForHasAnotherPortfolioWithSameName.append(name);
    return portfolio.containsKey(name);
  }

  @Override
  public void addsFinalDataToPortfolio(List<List<String>> dataToAdd, String name,
                                       String currentDate) {
    logForAddPortfolioData.append(name);
    for (List<String> stringList : dataToAdd) {
      for (String s : stringList) {
        logForAddPortfolioData.append(" " + s);
      }
    }

    ArrayList<List<String>> finalData = new ArrayList<>();
    ArrayList<String> data;
    for (List<String> strings : dataToAdd) {
      data = new ArrayList<>(strings);
      finalData.add(data);
      data.add(currentDate);
    }
    portfolio.put(name, finalData);

  }

  @Override
  public boolean checkIfCompanyExists(String name) {
    logForCheckingIfCompanyNameExist.append("Received:" + name);
    //System.out.println(stockCompanyName.size());
    return stockCompanyName.contains(name.toUpperCase());
  }

  @Override
  public boolean isValidDate(String date) {
    logForIsValidDate.append("Received:" + date);
    try {
      LocalDate.parse(date);
      return true;
    } catch (DateTimeParseException e) {
      return false;
    }
  }

  @Override
  public double getTotalStockValue(String portfolioName, String currentDate) {

    logForTotalStockValue.append(portfolioName);
    logForTotalStockValue.append(currentDate);
    double ans = 1;

    List<List<String>> contents = portfolio.get(portfolioName);
    for (List<String> content : contents) {
      String company = content.get(0);
      double numbers = Double.parseDouble(content.get(1));

      double price;
      try {
        price = Double.parseDouble(stockData.get(stockCompanyName.indexOf(company
                        .toUpperCase()))
                .get(currentDate));
        ans *= (price * numbers);
      } catch (NullPointerException e) {
        //caught
      }
    }
    logForModelSavePortfolio.append(ans);
    return ans;
  }

  @Override
  public int getPortfolioSize() {
    LogForGetPortfolioSize.append(this.portfolio.size());
    return this.portfolio.size();
  }

  @Override
  public boolean portfolioContainsCertainKey(String name) {
    logForPortfolioContainsCertainKey.append(name);

    return portfolio.containsKey(name);
  }

  @Override
  public String makeStringDate(int day, int month, int year) {
    logForMakeStringDate.append("Day:" + day + "Month:" + month + "Year:" + year);
    String dateVal;
    String monthVal;
    if (day <= 9) {
      dateVal = "0" + day;
    } else {
      dateVal = String.valueOf(day);
    }
    if (month <= 9) {
      monthVal = "0" + month;
    } else {
      monthVal = String.valueOf(month);
    }

    return year + "-" + monthVal + "-"
            + dateVal;

  }

  @Override
  public void makeListOfDates() {
    Map<String, String> container;
    for (HashMap<String, String> stockDatum : stockData) {
      container = stockDatum;
      container.forEach((key, value) -> listOfDates.add(key));
    }
  }

  @Override
  public boolean setContainsGivenDate(String date) {
    logForSetContainsGivenDate.append(date);
    return listOfDates.contains(date);
  }

  @Override
  public ArrayList<String> getPortfolioKeys() {
    List<String> keys = new ArrayList<>(portfolio.keySet());
    for (String key : keys) {
      logForGetPortfolioKeys.append(key);
    }

    return new ArrayList<>(portfolio.keySet());
  }

  @Override
  public LocalDate localDateParser(String currentDate) {
    return LocalDate.parse(currentDate);
  }

  @Override
  public void savePortfolio() {
    List<String> names = new ArrayList<>();
    portfolio.forEach((key, value) -> names.add(key));
    Json json = new Json(this.portfolio, names);

    List<String> jsonPortfolios = json.jsonFormatFromHashMap();

    String path = "src\\portfolios\\";

    for (int i = 0; i < jsonPortfolios.size(); i++) {
      String newPath = path;
      newPath += names.get(i);
      newPath += ".txt";
      try {
        File myObj = new File(newPath);
        Files.writeString(Path.of(newPath), jsonPortfolios.get(i));
        myObj.setReadOnly();
      } catch (FileNotFoundException e) {
        //handled
      } catch (IOException e) {
        //
      }
    }
  }

  @Override
  public Map<String, List<List<String>>> parseJson(String data) {
    logForParseJson.append(data);
    Json json = new Json();
    return json.jsonParser(data);
  }

  @Override
  public String readFromFile(String path) {
    logForReadFromFile.append("Received:" + path);
    StringBuilder output = new StringBuilder();
    try {
      FileReader filereader = new FileReader(path);
      int c = 0;
      while ((c = filereader.read()) != -1) {
        char character = (char) c;
        if (character == '"') {
          output.append("\"");
        } else {
          output.append(character);
        }
      }
    } catch (IOException e) {
      return "Failure";
      //throw new RuntimeException(e);
    }

    logForSavePortfolio.append(output);
    return output.toString();

  }

  @Override
  public boolean checkParsedPortfolio(Map<String, List<List<String>>> parsedPortfolio) {
    List<String> keys = new ArrayList<>(parsedPortfolio.keySet());
    List<List<String>> contents1;
    List<String> insideContents1;
    for (String s : keys) {
      logForCheckParsedPortfolio.append(s);
      contents1 = parsedPortfolio.get(s);
      for (List<String> contents : contents1) {
        insideContents1 = new ArrayList<>(contents);
        logForCheckParsedPortfolio.append(insideContents1.get(0));
        logForCheckParsedPortfolio.append(insideContents1.get(1));
        logForCheckParsedPortfolio.append(insideContents1.get(2));
      }
    }

    List<String> keyset = new ArrayList<>(parsedPortfolio.keySet());
    List<List<String>> contents;
    List<String> insideContents;
    for (String s : keyset) {
      contents = parsedPortfolio.get(s);
      for (List<String> content : contents) {
        insideContents = new ArrayList<>(content);
        if (insideContents.size() != 3) {
          return false;
        }
        try {
          Double.parseDouble(insideContents.get(1));
        } catch (NumberFormatException e) {
          return false;
        }
        try {
          LocalDate.parse(insideContents.get(2));
        } catch (DateTimeParseException e) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public List<String> getListOfPortfolio() {
    URI uri = null;
    try {
      uri = this.getClass().getResource("/portfolios").toURI();
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
    Path myPath;
    if (uri.getScheme().equals("jar")) {
      FileSystem fileSystem = null;
      try {
        fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      myPath = fileSystem.getPath("/portfolios");
    } else {
      myPath = Paths.get(uri);
    }
    Stream<Path> walk = null;
    try {
      walk = Files.walk(myPath, 1);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    List<String> values = new ArrayList<>();
    for (Iterator<Path> it = walk.iterator(); it.hasNext(); ) {
      values.add(String.valueOf(it.next()));
    }
    return values;
  }

  @Override
  public Double helper(Double val) {
    logForHelper.append("Received:" + val);
    logForCheckingHelperWorksCorrectly.append(Double.valueOf(Math.round(val)));
    return Double.valueOf(Math.round(val));
  }

  @Override
  public void createADirectory() {
    //do nothing
  }
}
