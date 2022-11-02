import java.io.PrintStream;

/**
 * This the view class for Stocks.
 * It represents the visualization of the data that model contains.
 */
public class View {
  private final PrintStream out;

  public View(PrintStream out) {
    this.out = new PrintStream(out);
  }

  /**
   * Displays the initial options that will be visible to user on start of program.
   */
  void displayInitialOptions() {
    this.out.println("1.Create Portfolio");
    this.out.println("2.Examine Composition of current Portfolio");
    this.out.println("3.Fast forward time");
    this.out.println("4.Determine value of stocks on certain Date");
    this.out.println("5.Upload a portfolio");
    this.out.println("6.List all portfolios");
    this.out.println("7.Exit");
    this.out.println("Choose one of the five options");
    this.out.println();
  }

  /**
   * Displays only integers are valid values.
   */
  void displayOnlyIntegers() {
    this.out.println("Enter only valid Integers");
  }

  /**
   * Displays to enter a valid option.
   */
  void displaySwitchCaseDefault() {
    this.out.println("Enter an valid option.");
    this.out.println();
  }

  /**
   * Displays options if user wants to create a new portfolio.
   */
  void portfolioCreation() {
    this.out.println("1.Give a name for the current Portfolio");
    this.out.println("2.Show list of Companies");
    this.out.println("3.Add a company Stock");
    this.out.println("4.Exit");
    this.out.println();
  }


  /**
   * Displays the name of companies with number of stock.
   *
   * @param stockCompanyName company name
   * @param number           number of stocks.
   */
  void displayCompanies(String stockCompanyName, int number) {
    this.out.println(number + "." + stockCompanyName);
  }

  /**
   * Display an empty line.
   */
  void displayEmptyLine() {
    this.out.println();
  }


  /**
   * Display message that user cant change the name of portfolio.
   */
  void displayCannotEnterNameAgain() {
    this.out.println("You already entered Name for this current Portfolio,cannot change Name.");
    this.out.println();
  }

  /**
   * display message that name is mandatory for portfolio.
   */
  void displayCannotProceedWithoutName() {
    this.out.println("Please Enter a name for the portfolio first.");
    this.out.println();
  }

  /**
   * Display enter name for portfolio.
   */
  void displayEnterNameForPortfolio() {
    this.out.println("Enter Name of the Portfolio:");
    this.out.println();
  }

  /**
   * Displays that name cannot be empty.
   */
  void displayNameCannotBeEmpty() {
    this.out.println("Name cannot be empty. Enter at least one character");
    this.out.println();
  }

  /**
   * Display if the portfolio name already exists.
   */
  void displayAlreadyHaveAnotherPortfolioWithSameName() {
    this.out.println("You already have another Portfolio with the same name.");
    this.out.println();
  }

  /**
   * Display message for user to enter company name.
   */
  void askForCompanyName() {
    this.out.println("Enter the company name:");
    this.out.println();
  }


  /**
   * Display message for user to enter number of stocks of company.
   */
  void askForNumberOfStocks() {
    this.out.println("Enter number of stocks:");
    this.out.println();
  }

  /**
   * Display message for the value of stock cannot be less than or equal 0.
   */
  void displayStockNumberCannotBeLessThanOrEqualToZero() {
    this.out.println("Stock value cannot be less than or equal to zero. Please enter a valid" +
            "number");
    this.out.println();
  }

  /**
   * Displays message that no such company exists.
   */
  void displayNoSuchCompanyExist() {
    this.out.println("There is no such company, enter using the list of companies available");
    this.out.println();
  }

  /**
   * Displays current portfolio name.
   *
   * @param currPortfolio name of current portfolio
   */
  void displayPortfolioName(String currPortfolio) {
    this.out.println("Portfolio: " + currPortfolio);
  }

  /**
   * Displays data in table layout.
   */
  void displayTableLayout() {
    this.out.println("Company\t\tStock-Numbers\t\tDate-obtained");
  }

  /**
   * Displays content of portfolio.
   *
   * @param contents content in string form.
   */
  void displayContentsOfPortfolio(String contents) {
    this.out.print(contents + "\t\t\t");
  }

  /**
   * Display message if portfolio is empty.
   */
  void displayPortfolioIsEmpty() {
    this.out.println("Portfolio is empty, cannot view composition");
    this.out.println();
  }

  /**
   * Display options of select date.
   *
   * @param currentDate Date entered.
   */
  void displaySelectDateOption(String currentDate) {
    this.out.println("Current Date: " + currentDate);
    this.out.println("1.Select Date");
    this.out.println("2.Exit");

    this.out.println();
  }

  /**
   * This function asks the user to enter the day of the month in number.
   */
  void askForDayOfTheMonth() {
    this.out.println("Enter the day of the month in number(1-31): ");
  }

  /**
   * Display message to input month.
   */
  void askForMonth() {
    this.out.println("Enter the month in number(1-12):");
  }

  /**
   * Display message to input year.
   */
  void askForYear() {
    this.out.println("Enter the year you wish to jump to(2001 - 2022):");
  }

  /**
   * Display message to input valid inputs.
   */
  void displayEnterValidDetailsForDate() {
    this.out.println("Enter valid details.");
  }

  /**
   * Display message to show that entered date is invalid.
   */
  void displayDateIsNotValid() {
    this.out.println("The entered date is not a valid date.");
    this.out.println();
  }

  /**
   * Display message options for stock values.
   */
  void displayStockValueMenu() {
    this.out.println("1.Enter the portfolio name to get value for");
    this.out.println("2.Get total Stock Value on current Date");
    this.out.println("3.Change the date and get Stock Value");
    this.out.println("4.Exit");
    this.out.println();
  }

  /**
   * Displays if the user has already entered name for portfolio.
   */
  void displayPortfolioNameAlreadyEntered() {
    this.out.println("You already entered name for portfolio. Choose option 2 or 3 or exit.");
    this.out.println();
  }

  /**
   * Displays data of a particular portfolio.
   *
   * @param portfolioName name of the portfolio
   * @param currentDate   date of creation of portfolio
   * @param totalValue    total value of stocks
   */

  void displayTotalStockValue(String portfolioName, String currentDate, String totalValue) {
    this.out.println("Portfolio: " + portfolioName);
    this.out.println("Date: " + currentDate);
    this.out.println("Total Value: " + totalValue);
    this.out.println();
  }

  /**
   * Displays message if no portfolio exists for the name entered.
   */
  void displayNoSuchPortfolio() {
    this.out.println("No such portfolio exists, enter name again");
    this.out.println();
  }

  /**
   * Display message to create portfolio and then check value.
   */
  void displayNoPortfolio() {
    this.out.println("Create portfolio first.");
    this.out.println();
  }

  /**
   * Display is no stock is present for the entered day.
   */
  void displayNoStockDataForGivenDate() {
    this.out.println("There is no stock data for given date, please enter another date");
    this.out.println();
  }


  /**
   * This function prints out the path of the file where the portfolio is saved
   *
   * @param path The path where the portfolio is saved.
   */
  void displayAllPortfolioSaved(String path) {
    this.out.println("All the portfolio created have been saved and It is in the location: " +
            path);
    this.out.println();
  }


  /**
   * This function asks the user for the file path.
   */
  void askForFilePath() {
    this.out.println("Enter the file path:");
    this.out.println();
  }

  /**
   * This function displays a message to the user that the file path does not exist.
   */
  void displayTheFilePathDoesNotExist() {
    this.out.println("The file path does not exist, Please Enter a valid path");
    this.out.println();
  }


  /**
   * This function prints out a message to the user that the portfolio provided in the text file
   * is not
   * in proper format.
   */
  void displayDataNotInProperFormat() {
    this.out.println("The portfolio provided in the text file is not in proper format," +
            "please look at the documentation");
    this.out.println();
  }

}
