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
   * Lets the user add the name of company for which he wants to buy stocks.
   *
   * @return The list of name of company with number of stocks.
   */
  List<String> handleAddACompanyStock();

  /**
   * Gets the name to the portfolio already created.
   *
   * @return Returns the name entered by user
   */
  String handleGetPortfolioName();

  /**
   * Creates a portfolio with the company name, number of stocks and name of portfolio.
   *
   * @param dataToAdd   Name and number of stocks of the company
   * @param name        name of the portfolio
   * @param currentDate date of creation of portfolio
   */
  void addPortfolioData(List<List<String>> dataToAdd, String name, String currentDate);

  /**
   * Allows user to select a date for future price projection of stocks.
   */
  void handleDateSelection();

  /**
   * Shows the total stock on current date with the user.
   *
   * @param portfolioName name of the portfolio
   * @return success or failure of the method.
   */

  String handleTotalStockOnCurrentDate(String portfolioName);

  /**
   * Allows the user to check stock price on different date.
   *
   * @param portfolioName name of the portfolio
   */
  void handleTotalStockOnDifferentDate(String portfolioName);


  /**
   *
   */
  void handleUploadFile();
}
