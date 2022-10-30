/**
 * This the view class for Stocks.
 * It represents the visualization of the data that model contains.
 */
public class View {

  /**
   * Displays the initial options that will be visible to user on start of program.
   */
  void displayInitialOptions() {
    System.out.println("1.Create Portfolio");
    System.out.println("2.Examine Composition of current Portfolio");
    System.out.println("3.Fast forward time");
    System.out.println("4.Determine value of stocks on certain Date");
    System.out.println("5.Exit");
    System.out.println("Choose one of the five options");
    System.out.println();
  }

  /**
   * Displays only integers are valid values.
   */
  void displayOnlyIntegers() {
    System.out.println("Enter only valid Integers");
  }

  /**
   * Displays to enter a valid option.
   */
  void displaySwitchCaseDefault() {
    System.out.println("Enter an valid option.");
    System.out.println();
  }

  /**
   * Displays options if user wants to create a new portfolio.
   */
  void portfolioCreation() {
    System.out.println("1.Give a name for the current Portfolio");
    System.out.println("2.Show list of Companies");
    System.out.println("3.Add a company Stock");
    System.out.println("4.Exit");
    System.out.println();
  }

  /**
   * Displays the name of companies with number of stock.
   *
   * @param stockCompanyName company name
   * @param number           number of stocks.
   */
  void displayCompanies(String stockCompanyName, int number) {
    System.out.println(number + "." + stockCompanyName);
  }

  /**
   * Display an empty line.
   */
  void displayEmptyLine() {
    System.out.println();
  }

  /**
   * Display message that user cant change the name of portfolio.
   */
  void displayCannotEnterNameAgain() {
    System.out.println("You already entered Name for this current Portfolio,cannot change Name.");
    System.out.println();
  }

  /**
   * display message that name is mandatory for portfolio.
   */
  void displayCannotProceedWithoutName() {
    System.out.println("Please Enter a name for the portfolio first.");
    System.out.println();
  }

  /**
   * Display enter name for portfolio.
   */
  void displayEnterNameForPortfolio() {
    System.out.println("Enter Name of the Portfolio:");
    System.out.println();
  }

  /**
   * Displays that name cannot be empty.
   */
  void displayNameCannotBeEmpty() {
    System.out.println("Name cannot be empty. Enter at least one character");
    System.out.println();
  }

  /**
   * Display if the portfolio name already exists.
   */
  void displayAlreadyHaveAnotherPortfolioWithSameName() {
    System.out.println("You already have another Portfolio with the same name.");
    System.out.println();
  }

  /**
   * Display message for user to enter company name.
   */
  void askForCompanyName() {
    System.out.println("Enter the company name:");
    System.out.println();
  }

  /**
   * Display message for user to enter number of stocks of company.
   */
  void askForNumberOfStocks() {
    System.out.println("Enter number of stocks:");
    System.out.println();
  }

  /**
   * Display message for the value of stock cannot be less than or equal 0.
   */
  void displayStockNumberCannotBeLessThanOrEqualToZero() {
    System.out.println("Stock value cannot be less than or equal to zero. Please enter a valid" + "number");
    System.out.println();
  }

  /**
   * Displays message that no such company exists.
   */
  void displayNoSuchCompanyExist() {
    System.out.println("There is no such company, enter using the list of companies available");
    System.out.println();
  }

  /**
   * Displays current portfolio name.
   *
   * @param currPortfolio name of current portfolio
   */
  void displayPortfolioName(String currPortfolio) {
    System.out.println("Portfolio: " + currPortfolio);
  }

  /**
   * Displays data in table layout.
   */
  void displayTableLayout() {
    System.out.println("Company\t\tStock-Numbers\t\tDate-obtained");
  }

  /**
   * Displays content of portfolio.
   *
   * @param contents content in string form.
   */
  void displayContentsOfPortfolio(String contents) {
    System.out.print(contents + "\t\t\t");
  }

  /**
   * Display message if portfolio is empty.
   */
  void displayPortfolioIsEmpty() {
    System.out.println("Portfolio is empty, cannot view composition");
    System.out.println();
  }

  /**
   * Display options of select date.
   *
   * @param currentDate Date entered.
   */
  void displaySelectDateOption(String currentDate) {
    System.out.println("Current Date: " + currentDate);
    System.out.println("1.Select Date");
    System.out.println("2.Exit");

    System.out.println();
  }

  /**
   * Display message to input date.
   */
  void askForDayOfTheMonth() {
    System.out.println("Enter the day of the month in number(1-31): ");
  }

  /**
   * Display message to input month.
   */
  void askForMonth() {
    System.out.println("Enter the month in number(1-12):");
  }

  /**
   * Display message to input year.
   */
  void askForYear() {
    System.out.println("Enter the year you wish to jump to(2001 - 2022):");
  }

  /**
   * Display message to input valid inputs.
   */
  void displayEnterValidDetailsForDate() {
    System.out.println("Enter valid details.");
  }

  /**
   * Display message to show that entered date is invalid.
   */
  void displayDateIsNotValid() {
    System.out.println("The entered date is not a valid date.");
    System.out.println();
  }

  /**
   * Display message options for stock values.
   */
  void displayStockValueMenu() {
    System.out.println("1.Enter the portfolio name to get value for");
    System.out.println("2.Get total Stock Value on current Date");
    System.out.println("3.Change the date and get Stock Value");
    System.out.println("4.Exit");
    System.out.println();
  }

  /**
   * Displays if the user has already entered name for portfolio.
   */
  void displayPortfolioNameAlreadyEntered() {
    System.out.println("You already entered name for portfolio. Choose option 2 or 3 or exit.");
    System.out.println();
  }

  /**
   * Displays data of a particular portfolio.
   *
   * @param portfolioName name of the portfolio
   * @param currentDate   date of creation of portfolio
   * @param totalValue    total value of stocks
   */

  void displayTotalStockValue(String portfolioName, String currentDate, String totalValue) {
    System.out.println("Portfolio: " + portfolioName);
    System.out.println("Date: " + currentDate);
    System.out.println("Total Value: " + totalValue);
    System.out.println();
  }

  /**
   * Displays message if no portfolio exists for the name entered.
   */
  void displayNoSuchPortfolio() {
    System.out.println("No such portfolio exists, enter name again");
    System.out.println();
  }

  /**
   * Display message to create portfolio and then check value.
   */
  void displayNoPortfolio() {
    System.out.println("Create portfolio first and then check the value.");
    System.out.println();
  }

  /**
   * Display is no stock is present for the entered day.
   */
  void displayNoStockDataForGivenDate() {
    System.out.println("There is no stock data for given date, please enter another date");
    System.out.println();
  }
}
