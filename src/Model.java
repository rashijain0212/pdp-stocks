import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model {

  //List of the companies' data.
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
  String endingDate = "2022-10-25";

  String currentDate = startingDate;

  String data;

  HashMap<String,ArrayList<ArrayList<String>>> portfolio = new HashMap<>();

  //getter for currentDate
  String getCurrentDate(){
    return currentDate;
  }

  //getter for portfolio
  HashMap<String,ArrayList<ArrayList<String>>> getPortfolio(){
    return portfolio;
  }

  //getter for stockCompanyName
  List<String> getStockCompanyName(){
    return stockCompanyName;
  }

  //getter for the starting date variable
  String getStartingDate(){
    return startingDate;
  }

  //getter for ending Date variable
  String getEndingDate(){
    return endingDate;
  }

  //get All the stock data from the given text file and create a hashMap for each companies,
  //add the hashmap to the stockData arraylist.
  void getContentsFromFile(){
    for(int i=0;i<stockCompanies.size();i++){
      String filepath = stockCompanies.get(i);
      try {
        data = new String(Files.readAllBytes(Path.of(
                "C:\\Users\\96ras\\Desktop\\stocks\\src\\stockData\\"+filepath)));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      stockData.add(convertingStringToHashMap(data));
    }
  }

  HashMap<String,String> convertingStringToHashMap(String data){
    String fileData = data;
    HashMap<String,String> stockDateAndPrice = new HashMap<>();
    String[] breakingDownFullString = fileData.split("\r?\n|\r");
    for(int i=0;i<breakingDownFullString.length;i++){
      String[] separatingWithComa = breakingDownFullString[i].split(",");
      if(separatingWithComa.length==6){
        stockDateAndPrice.put(separatingWithComa[0],separatingWithComa[4]);
      }
    }
    return stockDateAndPrice;
  }

  boolean hasAnotherPortfolioWithSameName(String name){
    if(portfolio.containsKey(name)){
      return true;
    }
    else{
      return false;
    }
  }

  void addsFinalDataToPortfolio(List<List<String>> dataToAdd,String name,String currentDate){
    ArrayList<ArrayList<String>> finalData = new ArrayList<>();
    ArrayList<String> data;
    for(int i=0;i<dataToAdd.size();i++){
      data = new ArrayList<>();
      for(int j=0;j<dataToAdd.get(i).size();j++){
        data.add(dataToAdd.get(i).get(j));
      }
      finalData.add(data);
      data.add(currentDate);
    }
    portfolio.put(name,finalData);
  }

  boolean checkIfCompanyExists(String name){
    return stockCompanyName.contains(name.toUpperCase());
  }

  void savePortfolio(){
    //handle the case to save the portfolio
  }

  boolean isValidDate(String date){
    try{
      LocalDate newDate = LocalDate.parse(date);
      return true;
    }
    catch (DateTimeParseException e) {
      return false;
    }
  }

  //setter for currentDate
  void setCurrentDate(String currentDate){
    this.currentDate = currentDate;
  }

  double getTotalStockValue(String portfolioName,String currentDate){
    double ans = 1;
    if(portfolioName.contains(portfolioName)){
      ArrayList<ArrayList<String>> contents = portfolio.get(portfolioName);
      for(int i=0;i<contents.size();i++){
        String company = contents.get(i).get(0);
        double numbers = Double.parseDouble(contents.get(i).get(1));
        String date = currentDate;

        double price = Double.parseDouble(stockData.get(stockCompanyName.indexOf(company
                        .toUpperCase()))
                .get(date));
        ans*=(price*numbers);
      }
    }
    else{
      return -1;
    }
    return ans;
  }

  int getPortfolioSize(){
    return portfolio.size();
  }

  boolean portfolioContainsCertainKey(String name){
    return portfolio.containsKey(name);
  }

}
