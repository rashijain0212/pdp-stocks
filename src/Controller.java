import java.util.List;

/**
 * This is an interface for controller for stock.
 * It controls the data flow into model object and updates the view whenever data changes.
 * It keeps view and model separate.
 */
public interface Controller {
  /**
   * This method views all the initial options to the user at start of program.
   */
  void start();

  /**
   * This method handles the portfolio creations.
   * It shows further options for new portfolio.
   */

  void handlePortfolioCreation();

  /**
   * This method handles the composition of portfolio.
   * It shows further options for already created portfolio.
   */
  void handlePortfolioComposition();

  /**
   * This method shows the futuristic prices of the stocks.
   */
  void handleFastForwardTime();

  /**
   * Displays the total value of a particular portfolio.
   */

  void handleTotalStockValueDisplay();

  /**
   * Displays all the companies stocks listed.
   */
  void handleShowCompanies();

  /**
   * This function adds a company stock to the user's portfolio.
   *
   * @return ArrayList<String> The list of name of company with number of stocks.
   */
  List<String> handleAddACompanyStock();

  /**
   * Get the name of the portfolio
   *
   * @return The name of the portfolio.
   */
  String handleGetPortfolioName();

  /**
   * This function takes in a list of lists of strings, a string, and a string, and adds the data to
   * the portfolio.
   *
   * @param dataToAdd   A list of lists of strings. Each list of strings represents a row of data
   *                    . The
   *                    first string in the list is name of company, the second string is the
   *                    number of shares, and the
   *                    third string is the date.
   * @param name        The name of the portfolio you want to add data to.
   * @param currentDate The date of the data you are adding.
   */
  void addPortfolioData(List<List<String>> dataToAdd, String name, String currentDate);

  /**
   * When the user selects a date, handleDateSelection() is called.
   */
  void handleDateSelection();

  /**
   * Given a portfolio name, return the total stock on the current date.
   *
   * @param portfolioName The name of the portfolio.
   * @return The total stock value of the portfolio on the current date.
   */
  String handleTotalStockOnCurrentDate(String portfolioName);

  /**
   * Given a portfolio name, it will return the total stock value of the portfolio on a different
   * date.
   *
   * @param portfolioName The name of the portfolio.
   */
  void handleTotalStockOnDifferentDate(String portfolioName);

  /**
   * Handles the portfolio file uploaded by user.
   */
  void handleUploadFile();

  /**
   * This method asks the model {@link ModelImpl#getListOfPortfolio()}  to give it an array of
   * strings of all the files in the src\\portfolios\\ directory.
   * Then it tells the view {@link View#displayPortfolioName(String)} to display the portfolio name.
   */
  void handleShowPortfolio();

}
