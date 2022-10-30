public class View {

  /**
   *
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
   *
   */
  void displayOnlyIntegers() {
    System.out.println("Enter only valid Integers");
  }

  /**
   *
   */
  void displaySwitchCaseDefault() {
    System.out.println("Enter an valid option.");
    System.out.println();
  }

  /**
   *
   */
  void portfolioCreation() {
    System.out.println("1.Give a name for the current Portfolio");
    System.out.println("2.Show list of Companies");
    System.out.println("3.Add a company Stock");
    System.out.println("4.Exit");
    System.out.println();
  }

  /**
   * @param stockCompanyName
   * @param number
   */
  void displayCompanies(String stockCompanyName, int number) {
    System.out.println(number + "." + stockCompanyName);
  }

  /**
   *
   */
  void displayEmptyLine() {
    System.out.println();
  }

  /**
   *
   */
  void displayCannotEnterNameAgain() {
    System.out.println("You already entered Name for this current Portfolio,cannot change Name.");
    System.out.println();
  }

  /**
   *
   */
  void displayCannotProceedWithoutName() {
    System.out.println("Please Enter a name for the portfolio first.");
    System.out.println();
  }

  /**
   *
   */
  void displayEnterNameForPortfolio() {
    System.out.println("Enter Name of the Portfolio:");
    System.out.println();
  }

  /**
   *
   */
  void displayNameCannotBeEmpty() {
    System.out.println("Name cannot be empty. Enter at least one character");
    System.out.println();
  }

  /**
   *
   */
  void displayAlreadyHaveAnotherPortfolioWithSameName() {
    System.out.println("You already have another Portfolio with the same name.");
    System.out.println();
  }

  /**
   *
   */
  void askForCompanyName() {
    System.out.println("Enter the company name:");
    System.out.println();
  }

  /**
   *
   */
  void askForNumberOfStocks() {
    System.out.println("Enter number of stocks:");
    System.out.println();
  }

  /**
   *
   */
  void displayStockNumberCannotBeLessThanOrEqualToZero() {
    System.out.println("Stock value cannot be less than or equal to zero. Please enter a valid" + "number");
    System.out.println();
  }

  /**
   *
   */
  void displayNoSuchCompanyExist() {
    System.out.println("There is no such company, enter using the list of companies available");
    System.out.println();
  }

  /**
   * @param currPortfolio
   */
  void displayPortfolioName(String currPortfolio) {
    System.out.println("Portfolio: " + currPortfolio);
  }

  /**
   *
   */
  void displayTableLayout() {
    System.out.println("Company\t\tStock-Numbers\t\tDate-obtained");
  }

  /**
   * @param contents
   */
  void displayContentsOfPortfolio(String contents) {
    System.out.print(contents + "\t\t\t");
  }

  /**
   *
   */
  void displayPortfolioIsEmpty() {
    System.out.println("Portfolio is empty, cannot view composition");
    System.out.println();
  }

  /**
   * @param currentDate
   */
  void displaySelectDateOption(String currentDate) {
    System.out.println("Current Date: " + currentDate);
    System.out.println("1.Select Date");
    System.out.println("2.Exit");

    System.out.println();
  }

  /**
   *
   */
  void askForDayOfTheMonth() {
    System.out.println("Enter the day of the month in number(1-31): ");
  }

  /**
   *
   */
  void askForMonth() {
    System.out.println("Enter the month in number(1-12):");
  }

  /**
   *
   */
  void askForYear() {
    System.out.println("Enter the year you wish to jump to(2001 - 2022):");
  }

  /**
   *
   */
  void displayEnterValidDetailsForDate() {
    System.out.println("Enter valid details.");
  }

  /**
   *
   */
  void displayDateIsNotValid() {
    System.out.println("The entered date is not a valid date.");
    System.out.println();
  }

  /**
   *
   */
  void displayStockValueMenu() {
    System.out.println("1.Enter the portfolio name to get value for");
    System.out.println("2.Get total Stock Value on current Date");
    System.out.println("3.Change the date and get Stock Value");
    System.out.println("4.Exit");
    System.out.println();
  }

  /**
   *
   */
  void displayPortfolioNameAlreadyEntered() {
    System.out.println("You already entered name for portfolio. Choose option 2 or 3 or exit.");
    System.out.println();
  }

  /**
   * @param portfolioName
   * @param currentDate
   * @param totalValue
   */

  void displayTotalStockValue(String portfolioName, String currentDate, String totalValue) {
    System.out.println("Portfolio: " + portfolioName);
    System.out.println("Date: " + currentDate);
    System.out.println("Total Value: " + totalValue);
    System.out.println();
  }

  /**
   *
   */
  void displayNoSuchPortfolio() {
    System.out.println("No such portfolio exists, enter name again");
    System.out.println();
  }

  /**
   *
   */
  void displayNoPortfolio() {
    System.out.println("Create portfolio first and then check the value.");
    System.out.println();
  }

  /**
   *
   */
  void displayNoStockDataForGivenDate() {
    System.out.println("There is no stock data for given date, please enter another date");
    System.out.println();
  }
}
