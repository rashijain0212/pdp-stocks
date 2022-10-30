import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is an interface for stock model.
 * Contains all the data-related logic that the user requires.
 */
public interface Model {
  /**
   * Gets the current date.
   *
   * @return the current date as string.
   */
  String getCurrentDate();

  /**
   * @param currentDate
   */
  void setCurrentDate(String currentDate);

  /**
   * Get the user's portfolio.
   *
   * @return user's portfolio as a HashMap of String and array list.
   */
  HashMap<String, ArrayList<ArrayList<String>>> getPortfolio();

  /**
   * Gets the name of companies whose stocks are listed.
   *
   * @return a list of companies as List of strings.
   */
  List<String> getStockCompanyName();

  /**
   * Retrieve data from text file.
   */
  void getContentsFromFile();

  /**
   * Converts String to HashMap.
   *
   * @param data string data to be converted.
   * @return Hashmap of string data.
   */
  HashMap<String, String> convertingStringToHashMap(String data);

  /**
   * Checks if the name of portfolio already exists.
   *
   * @param name name of portfolio to checked.
   * @return true or false if the name exists or not.
   */
  boolean hasAnotherPortfolioWithSameName(String name);

  /**
   * Adds the final data to the portfolio.
   * @param dataToAdd stocks data to be purchased
   * @param name  name of the stock
   * @param currentDate date of purchase
   */
  void addsFinalDataToPortfolio(List<List<String>> dataToAdd, String name, String currentDate);

  /**
   * Checks if the company entered by user exists.
   * @param name name of the company to be checked
   * @return true or false if the company exists.
   */
  boolean checkIfCompanyExists(String name);

  /** Check if the date is valid.
   * @param date date inputted by the user
   * @return true or false after checking the date
   */
  boolean isValidDate(String date);

  /**
   * Gets the total stock value by calculating the price and number of stocks.
   * @param portfolioName name of the portfolio
   * @param currentDate date of portfolio creation
   * @return Total value of stock
   */
  double getTotalStockValue(String portfolioName, String currentDate);

  /**
   * Gets the size of portfolio.
   * @return the size of portfolio
   */
  int getPortfolioSize();

  /**
   * @param name
   * @return
   */
  boolean portfolioContainsCertainKey(String name);

  /**
   * Convert Date to string form
   * @param day day entered by user
   * @param month month entered by user
   * @param year year entered by user
   * @return date in string form
   */
  String makeStringDate(int day, int month, int year);

  /**
   *
   */
  void makeListOfDates();

  /**
   * @param date
   * @return
   */
  boolean setContainsGivenDate(String date);

  /**
   * Gets keys for the portfolio.
   * @return Array list of string as keys
   */
  ArrayList<String> getPortfolioKeys();

  /**
   * @param currentDate
   * @return
   */
  LocalDate localDateParser(String currentDate);
}
