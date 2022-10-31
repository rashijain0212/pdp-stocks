import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
   * Sets current date
   * @param currentDate date entered by user
   */
  void setCurrentDate(String currentDate);

  /**
   * Get the user's portfolio.
   *
   * @return user's portfolio as a HashMap of String and array list.
   */
  HashMap<String, List<List<String>>> getPortfolio();

  /**
   * Sets the portfolio.
   * @param portfolio
   */
  void setPortfolio(HashMap<String, List<List<String>>> portfolio);

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
   *
   * @param dataToAdd   stocks data to be purchased
   * @param name        name of the stock
   * @param currentDate date of purchase
   */
  void addsFinalDataToPortfolio(List<List<String>> dataToAdd, String name, String currentDate);

  /**
   * Checks if the company entered by user exists.
   *
   * @param name name of the company to be checked
   * @return true or false if the company exists.
   */
  boolean checkIfCompanyExists(String name);

  /**
   * Check if the date is valid.
   *
   * @param date date inputted by the user
   * @return true or false after checking the date
   */
  boolean isValidDate(String date);

  /**
   * Gets the total stock value by calculating the price and number of stocks.
   *
   * @param portfolioName name of the portfolio
   * @param currentDate   date of portfolio creation
   * @return Total value of stock
   */
  double getTotalStockValue(String portfolioName, String currentDate);

  /**
   * Gets the size of portfolio.
   *
   * @return the size of portfolio
   */
  int getPortfolioSize();

  /**
   * Checks if the portfolio already exists
   * @param name name of portfolio to be checked
   * @return boolean value after matching
   */
  boolean portfolioContainsCertainKey(String name);

  /**
   * Convert Date to string form
   *
   * @param day   day entered by user
   * @param month month entered by user
   * @param year  year entered by user
   * @return date in string form
   */
  String makeStringDate(int day, int month, int year);

  /**
   * Creates a hashmap of dates.
   */
  void makeListOfDates();

  /**
   * Checks of the data contains the given date.
   * @param date date to be checked
   * @return boolean value if the date exists
   */
  boolean setContainsGivenDate(String date);

  /**
   * Gets keys for the portfolio.
   *
   * @return Array list of string as keys
   */
  ArrayList<String> getPortfolioKeys();

  /**
   *
   * @param currentDate
   * @return
   */
  LocalDate localDateParser(String currentDate);

  /**
   * Saves the current portfolio.
   */
  void savePortfolio();

  /**
   * Parses the json.
   * @return the file
   */
  Map<String, List<List<String>>> parseJson(String data);

  /**
   * Reads the given file
   * @param path path of the file
   * @return File in string form
   */
  String readFromFile(String path);

  /**
   * @param parsedPortfolio
   * @return
   */
  boolean checkParsedPortfolio(Map<String, List<List<String>>> parsedPortfolio);

}