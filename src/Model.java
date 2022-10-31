import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public interface Model {
  /**
   *
   * @return
   */
  String getCurrentDate();

  /**
   *
   * @return
   */
  HashMap<String, List<List<String>>> getPortfolio();

  /**
   *
   * @return
   */
  List<String> getStockCompanyName();

  /**
   *
   */
  void getContentsFromFile();

  /**
   *
   * @param data
   * @return
   */
  HashMap<String,String> convertingStringToHashMap(String data);

  /**
   *
   * @param name
   * @return
   */
  boolean hasAnotherPortfolioWithSameName(String name);

  /**
   *
   * @param dataToAdd
   * @param name
   * @param currentDate
   */
  void addsFinalDataToPortfolio(List<List<String>> dataToAdd,String name,String currentDate);

  /**
   *
   * @param name
   * @return
   */
  boolean checkIfCompanyExists(String name);

  /**
   *
   * @param date
   * @return
   */
  boolean isValidDate(String date);

  /**
   *
   * @param currentDate
   */
  void setCurrentDate(String currentDate);

  /**
   *
   * @param portfolioName
   * @param currentDate
   * @return
   */
  double getTotalStockValue(String portfolioName,String currentDate);

  /**
   *
   * @return
   */
  int getPortfolioSize();

  /**
   *
   * @param name
   * @return
   */
  boolean portfolioContainsCertainKey(String name);

  /**
   *
   * @param day
   * @param month
   * @param year
   * @return
   */
  String makeStringDate(int day,int month,int year);

  /**
   *
   */
  void makeListOfDates();

  /**
   *
   * @param date
   * @return
   */
  boolean setContainsGivenDate(String date);

  /**
   *
   * @return
   */
  ArrayList<String> getPortfolioKeys();

  /**
   *
   * @param currentDate
   * @return
   */
  LocalDate localDateParser(String currentDate);

  /**
   *
   */
  void savePortfolio();

  /**
   *
   * @return
   */
  Map<String,List<List<String>>> parseJson(String data);

  /**
   *
   * @param path
   * @return
   */
  String readFromFile(String path);

  /**
   *
   * @param parsedPortfolio
   * @return
   */
  boolean checkParsedPortfolio(Map<String,List<List<String>>> parsedPortfolio);

  /**
   *
   * @param portfolio
   */
  void setPortfolio(HashMap<String, List<List<String>>> portfolio);

}
