import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class View {
  Scanner sc = new Scanner(System.in);

  int displayInitialOptions() {
    int option = 0;
    try {
      System.out.println("1.Create Portfolio");
      System.out.println("2.Examine Composition of current Portfolio");
      System.out.println("3.Fast forward time");
      System.out.println("4.Determine value of stocks on certain Date");
      System.out.println("5.Exit");
      System.out.println("Choose one of the five options");
      option = sc.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("Enter a valid option.");
      sc.next();
    }
    System.out.println();
    return option;
  }

  void displaySwitchCaseDefault() {
    System.out.println("Enter an valid option.");
    System.out.println();
  }

  int portfolioCreation() {
    int portfolioChoice = 0;
    try {
      System.out.println("1.Give a name for the current Portfolio");
      System.out.println("2.Show list of Companies");
      System.out.println("3.Add a company Stock");
      System.out.println("4.Exit");
      portfolioChoice = sc.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("Enter a valid option.");
      sc.next();
    }
    System.out.println();
    return portfolioChoice;
  }

  void displayCompanies(List<String> stockCompanyName) {
    for (int i = 0; i < stockCompanyName.size(); i++) {
      System.out.println(i + 1 + "." + stockCompanyName.get(i));
    }
    System.out.println();
  }

  void displayCannotEnterNameAgain() {
    System.out.println("You already entered Name for this current Portfolio,cannot change Name.");
    System.out.println();
  }

  void displayCannotProceedWithoutName() {
    System.out.println("Please Enter a name for the portfolio first.");
    System.out.println();
  }

  String displayEnterNameForPortfolio() {
    String portfolioName = "";
    try {
      sc.nextLine();
      System.out.println("Enter Name of the Portfolio:");
      portfolioName = sc.nextLine();
    } catch (InputMismatchException e) {
      System.out.println("Enter a valid option.");
      sc.next();
    }
    System.out.println();
    return portfolioName;
  }

  void displayNameCannotBeEmpty() {
    System.out.println("Name cannot be empty. Enter atleast one character");
    System.out.println();
  }

  void displayAlreadyHaveAnotherPortfolioWithSameName() {
    System.out.println("You already have another Portfolio with the same name.");
    System.out.println();
  }

  List<String> getCompanyNameAndNumberOfStocks() {
    String companyName = "";
    double numberOfStocks = 0;
    List<String> dataToAdd = null;
    try {
      sc.nextLine();
      System.out.println("Enter the company name");
      companyName = sc.nextLine();
      System.out.println("Enter number of stocks");
      numberOfStocks = sc.nextDouble();
      dataToAdd = List.of(companyName, String.valueOf(numberOfStocks));
      System.out.println();
    } catch (InputMismatchException e) {
      System.out.println("Enter a valid option.");
      System.out.println();
      sc.next();
    }
    return dataToAdd;
  }

  void displayStockNumberCannotBeLessThanOrEqualToZero() {
    System.out.println("Stock value cannot be less than or equal to zero. Please enter a valid" +
            "number");
    System.out.println();
  }

  void displayNoSuchCompanyExist() {
    System.out.println("There is no such company, enter using the list of companies available");
    System.out.println();
  }

  void displayPortfolio(HashMap<String, ArrayList<ArrayList<String>>> portfolio) {
    ArrayList<String> portfolioNames = new ArrayList<String>(portfolio.keySet());
    for (int i = 0; i < portfolioNames.size(); i++) {
      String curr = portfolioNames.get(i);
      System.out.println("Portfolio: " + curr);
      ArrayList<ArrayList<String>> contents = portfolio.get(curr);
      System.out.println("Company\t\tStock-Numbers\t\tDate-obtained");
      for (int j = 0; j < contents.size(); j++) {
        for (int k = 0; k < contents.get(j).size(); k++) {
          System.out.print(contents.get(j).get(k) + "\t");
        }
        System.out.println();
      }
    }

  }

  void displayPortfolioIsEmpty() {
    System.out.println("Portfolio is empty, cannot view composition");
    System.out.println();
  }

  int displaySelectDateOption(String currentDate) {
    int option = 0;
    try {
      System.out.println("Current Date: " + currentDate);
      System.out.println("1.Select Date");
      System.out.println("2.Exit");
      option = sc.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("Enter a valid option.");
      sc.next();
    }
    System.out.println();
    return option;
  }

  String displayDateSelectionMenu() {
    System.out.println("Enter the day of the month in number(1-31): ");
    int day = sc.nextInt();
    if (day > 31 || day == 0) {
      System.out.println("Please enter a valid day as specified");
      return "";
    }
    System.out.println("Enter the month in number(1-12):");
    int month = sc.nextInt();
    if (month > 12 || month == 0) {
      System.out.println("Please enter a valid month as specified");
      return "";
    }
    System.out.println("Enter the year you wish to jump to(2001 - 2022):");
    int year = sc.nextInt();
    if (year > 2022 || year < 2001) {
      System.out.println("Please enter a valid year as specified");
      return "";
    }
    String dateVal;
    String monthVal;
    if (day <= 9) {
      dateVal = "0" + day;
    } else {
      dateVal = String.valueOf(day);
    }
    if (month <= 9) {
      monthVal = "0" + month;
    } else {
      monthVal = String.valueOf(month);
    }

    String dateWishedToChangeTo = String.valueOf(year) + "-" + String.valueOf(monthVal) + "-"
            + String.valueOf(dateVal);
    return dateWishedToChangeTo;
  }

  void displayDateIsNotValid() {
    System.out.println("The entered date is not a valid date.");
    System.out.println();
  }

  int displayStockValueMenu() {
    int option = 0;
    try {
      System.out.println("1.Enter the portfolio name to get value for");
      System.out.println("2.Get total Stock Value on current Date");
      System.out.println("3.Change the date and get Stock Value");
      System.out.println("4.Exit");
      option = sc.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("Enter a valid option.");
      sc.next();
    }
    System.out.println();
    return option;
  }

  void displayPortfolioNameAlreadyEntered() {
    System.out.println("You already entered name for portfolio. Choose option 2 or 3 or exit.");
    System.out.println();
  }

  void displayTotalStockValue(String portfolioName, String currentDate, double totalValue) {
    System.out.println("Portfolio: " + portfolioName);
    System.out.println("Date: " + currentDate);
    System.out.println("Total Value: " + totalValue);
    System.out.println();
  }

  void displayNoSuchPortfolio() {
    System.out.println("No such portfolio exists, enter name again");
    System.out.println();
  }

  void displayNoPortfolio() {
    System.out.println("Create portfolio first and then check the value.");
    System.out.println();
  }
}
