import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModelImpl implements Model {

  //List of the companies' data.
  List<String> stockCompanies = List.of("AAPL.txt", "AMZN.txt", "ATVI.txt", "BCS.txt", "CAJ.txt", "CSCO.txt", "DIS.txt", "JPM.txt", "MCD.txt", "MSFT.txt", "ORCL.txt", "SBUX.txt", "WFC.txt");

  List<String> stockCompanyName = List.of("APPLE", "AMAZON", "ACTIVISION", "BARCLAYS", "CANON INC", "CISCO SYSTEMS", "DISNEY", "JP MORGAN", "MCDONALD", "MICROSOFT", "ORACLE", "STARBUCKS", "WELLS FARGO");


  //ArrayList of HashMap containing StockData of companies with date as key and stock value on
  //that date as value.
  ArrayList<HashMap<String, String>> stockData = new ArrayList<>();
  String startingDate = "2001-02-02";
  //String endingDate = "2022-10-25";

  String currentDate = startingDate;

  Set<String> listOfDates = new HashSet<>();
  String data;

  HashMap<String, ArrayList<ArrayList<String>>> portfolio = new HashMap<>();

  //getter for currentDate
  @Override
  public String getCurrentDate() {
    return currentDate;
  }

  //setter for currentDate
  @Override
  public void setCurrentDate(String currentDate) {
    this.currentDate = currentDate;
  }

  //getter for portfolio
  @Override
  public HashMap<String, ArrayList<ArrayList<String>>> getPortfolio() {
    return portfolio;
  }

  //getter for stockCompanyName
  @Override
  public List<String> getStockCompanyName() {
    return stockCompanyName;
  }

  //get All the stock data from the given text file and create a hashMap for each company,
  //add the hashmap to the stockData arraylist.
  @Override
  public void getContentsFromFile() {
    for (String filepath : stockCompanies) {
      try {
        data = new String(Files.readAllBytes(Path.of("src\\stockData\\" + filepath)));
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
    return portfolio.containsKey(name);
  }

  @Override
  public void addsFinalDataToPortfolio(List<List<String>> dataToAdd, String name, String currentDate) {
    ArrayList<ArrayList<String>> finalData = new ArrayList<>();
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
    return stockCompanyName.contains(name.toUpperCase());
  }

  public void savePortfolio() {
    //handle the case to save the portfolio
  }

  @Override
  public boolean isValidDate(String date) {
    try {
      LocalDate.parse(date);
      return true;
    } catch (DateTimeParseException e) {
      return false;
    }
  }

  //if there is no stock data on certain date, we add 0.
  @Override
  public double getTotalStockValue(String portfolioName, String currentDate) {
    double ans = 1;

    ArrayList<ArrayList<String>> contents = portfolio.get(portfolioName);
    for (ArrayList<String> content : contents) {
      String company = content.get(0);
      double numbers = Double.parseDouble(content.get(1));

      double price;
      try {
        price = Double.parseDouble(stockData.get(stockCompanyName.indexOf(company.toUpperCase())).get(currentDate));
        ans *= (price * numbers);
      } catch (NullPointerException e) {
        //caught
      }
    }
    return ans;
  }

  @Override
  public int getPortfolioSize() {
    return portfolio.size();
  }

  @Override
  public boolean portfolioContainsCertainKey(String name) {
    return portfolio.containsKey(name);
  }

  @Override
  public String makeStringDate(int day, int month, int year) {
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

    return year + "-" + monthVal + "-" + dateVal;
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
    return listOfDates.contains(date);
  }

  @Override
  public ArrayList<String> getPortfolioKeys() {
    return new ArrayList<>(portfolio.keySet());
  }

  @Override
  public LocalDate localDateParser(String currentDate) {
    return LocalDate.parse(currentDate);
  }

}
