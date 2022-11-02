import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MockModelForAddPortfolioData implements Model{
  List<String> stockCompanies = List.of("AAPL.txt","AMZN.txt","ATVI.txt","BCS.txt",
          "CAJ.txt","CSCO.txt","DIS.txt","JPM.txt","MCD.txt","MSFT.txt","ORCL.txt","SBUX.txt"
          ,"WFC.txt");

  List<String> stockCompanyName = List.of("APPLE","AMAZON","ACTIVISION","BARCLAYS"
          ,"CANON INC","CISCO SYSTEMS","DISNEY","JP MORGAN","MCDONALD","MICROSOFT"
          ,"ORACLE","STARBUCKS","WELLS FARGO");


  //ArrayList of HashMap containing StockData of companies with date as key and stock value on
  //that date as value.
  ArrayList<HashMap<String,String>> stockData = new ArrayList<>();
  String startingDate = "2001-02-02";
  //String endingDate = "2022-10-25";

  String currentDate = startingDate;

  Set<String> listOfDates = new HashSet<>();
  String data;

  Map<String, List<List<String>>> portfolio = new HashMap<>();

  private StringBuilder log;

  public MockModelForAddPortfolioData(){
    this.log = new StringBuilder();
  }

  public String logGetter(){
    return log.toString();
  }
  @Override
  public String getCurrentDate() {
    return null;
  }

  @Override
  public Map<String, List<List<String>>> getPortfolio() {
    return null;
  }

  @Override
  public List<String> getStockCompanyName() {
    return null;
  }

  @Override
  public void getContentsFromFile(){
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
  public HashMap<String,String> convertingStringToHashMap(String data){
    HashMap<String,String> stockDateAndPrice = new HashMap<>();
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
    return false;
  }

  @Override
  public void addsFinalDataToPortfolio(List<List<String>> dataToAdd, String name, String currentDate) {
    log.append(name);
    for(int i=0;i<dataToAdd.size();i++){
      for(int j=0;j<dataToAdd.get(i).size();j++){
        log.append(" "+dataToAdd.get(i).get(j));
      }
    }
  }

  @Override
  public boolean checkIfCompanyExists(String name) {
    return stockCompanyName.contains(name.toUpperCase());
  }

  @Override
  public boolean isValidDate(String date) {
    return false;
  }

  @Override
  public void setCurrentDate(String currentDate) {

  }

  @Override
  public double getTotalStockValue(String portfolioName, String currentDate) {
    return 0;
  }

  @Override
  public int getPortfolioSize() {
    return 0;
  }

  @Override
  public boolean portfolioContainsCertainKey(String name) {
    return false;
  }

  @Override
  public String makeStringDate(int day, int month, int year) {
    return null;
  }

  @Override
  public void makeListOfDates() {

  }

  @Override
  public boolean setContainsGivenDate(String date) {
    return false;
  }

  @Override
  public ArrayList<String> getPortfolioKeys() {
    return null;
  }

  @Override
  public LocalDate localDateParser(String currentDate) {
    return null;
  }

  @Override
  public void savePortfolio() {

  }

  @Override
  public Map<String, List<List<String>>> parseJson(String data) {
    return null;
  }

  @Override
  public String readFromFile(String path) {
    return null;
  }

  @Override
  public boolean checkParsedPortfolio(Map<String, List<List<String>>> parsedPortfolio) {
    return false;
  }

  @Override
  public void setPortfolio(Map<String, List<List<String>>> portfolio) {

  }

  @Override
  public String[] getListOfPortfolio() {
    return new String[0];
  }
}
