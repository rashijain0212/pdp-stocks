import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ControllerImpl implements Controller {
  Scanner sc = new Scanner(System.in);
  View viewer = new View();
  ModelImpl models = new ModelImpl();

  @Override
  public void start() {
    //tell the model to get the data ready.
    models.getContentsFromFile();
    models.makeListOfDates();

    //tell the view to display starting screen
    boolean initialOptions = false;
    while (!initialOptions) {

      viewer.displayInitialOptions();
      int choice;
      try {
        choice = sc.nextInt();
      } catch (InputMismatchException e) {
        viewer.displayOnlyIntegers();
        sc.next();
        continue;
      }
      switch (choice) {
        case 1:
          handlePortfolioCreation();
          break;
        case 2:
          handlePortfolioComposition();
          break;
        case 3:
          handleFastForwardTime();
          break;
        case 4:
          handleTotalStockValueDisplay();
          break;
        case 5:
          initialOptions = true;
          break;
        default:
          viewer.displaySwitchCaseDefault();
          break;
      }
      //change this in switch case
      if (choice == 5) break;
    }
  }

  @Override
  public void handlePortfolioCreation() {
    boolean portfolioOptionExit = false;
    boolean nameEntered = false;
    String name = "";
    List<List<String>> dataToAdd = new ArrayList<>();
    String currentDate = models.getCurrentDate();
    while (!portfolioOptionExit) {
      int ans;
      viewer.portfolioCreation();
      try {
        ans = sc.nextInt();
      } catch (InputMismatchException e) {
        viewer.displayOnlyIntegers();
        sc.next();
        continue;
      }

      switch (ans) {
        case 1:
          if (nameEntered && dataToAdd.size() != 0) {
            viewer.displayCannotEnterNameAgain();
            break;
          }
          name = handleGetPortfolioName();
          if (name.length() != 0) {
            nameEntered = true;
          }
          break;
        case 2:
          handleShowCompanies();
          break;
        case 3:
          if (!nameEntered) {
            viewer.displayCannotProceedWithoutName();
            break;
          }
          List<String> newData = handleAddACompanyStock();
          if (newData == null) {
            break;
          }
          //check if the company name exists
          if (models.checkIfCompanyExists(newData.get(0))) {
            if (dataToAdd.toArray().length > 0) {
              boolean check = false;
              for (int i = 0; i < dataToAdd.toArray().length; i++) {
                if (Objects.equals(dataToAdd.get(i).get(0), newData.get(0))) {
                  check = true;
                  BigDecimal totalValue = new BigDecimal(Double.parseDouble(dataToAdd.get(i).get(1)) +
                          Double.parseDouble(newData.get(1)));
                  dataToAdd.get(i).set(1, totalValue.toPlainString()
                  );
                }
              }
              if (!check) {
                dataToAdd.add(newData);
              }
            } else {
              dataToAdd.add(newData);
            }

          } else {
            viewer.displayNoSuchCompanyExist();
          }
          break;
        case 4:
          portfolioOptionExit = true;
          if (dataToAdd.size() != 0) {
            addPortfolioData(dataToAdd, name, currentDate);
            models.savePortfolio();
            break;
          } else {
            name = "";
            nameEntered = false;
          }
          break;
        default:
          viewer.displaySwitchCaseDefault();
          break;
      }
    }
  }

  @Override
  public void handlePortfolioComposition() {
    HashMap<String, ArrayList<ArrayList<String>>> portfolio = models.getPortfolio();
    if (portfolio.size() == 0) {
      viewer.displayPortfolioIsEmpty();
    } else {
      ArrayList<String> portfolioNames = models.getPortfolioKeys();
      for (String curr : portfolioNames) {
        viewer.displayPortfolioName(curr);
        ArrayList<ArrayList<String>> contents = portfolio.get(curr);
        viewer.displayTableLayout();
        for (ArrayList<String> content : contents) {
          for (String s : content) {
            viewer.displayContentsOfPortfolio(s);
          }
          viewer.displayEmptyLine();
        }
      }
      viewer.displayEmptyLine();
    }

  }

  @Override
  public void handleFastForwardTime() {
    boolean continueLoop = false;
    while (!continueLoop) {
      int choice;
      viewer.displaySelectDateOption(models.getCurrentDate());
      try {
        choice = sc.nextInt();
      } catch (InputMismatchException e) {
        viewer.displayOnlyIntegers();
        sc.next();
        continue;
      }
      switch (choice) {
        case 1:
          handleDateSelection();
          break;
        case 2:
          continueLoop = true;
          break;
        default:
          viewer.displaySwitchCaseDefault();
          break;
      }
    }

  }

  @Override
  public void handleTotalStockValueDisplay() {
    boolean continueLoop = false;
    String name = "";
    int num = models.getPortfolioSize();
    if (num == 0) {
      viewer.displayNoPortfolio();
    } else {
      while (!continueLoop) {
        int choice;
        viewer.displayStockValueMenu();
        try {
          choice = sc.nextInt();
        } catch (InputMismatchException e) {
          viewer.displayOnlyIntegers();
          sc.next();
          continue;
        }
        switch (choice) {
          case 1:
            if (name.length() != 0) {
              viewer.displayPortfolioNameAlreadyEntered();
              break;
            }
            //check if we need to add try catch
            viewer.displayEnterNameForPortfolio();
            sc.nextLine();
            name = sc.nextLine();


            if (!models.portfolioContainsCertainKey(name)) {
              viewer.displayNoPortfolio();
              name = "";
            }
            break;
          case 2:
            if (name.length() == 0) {
              viewer.displayNameCannotBeEmpty();
              break;
            }
            String result = handleTotalStockOnCurrentDate(name);
            if (Objects.equals(result, "Failure")) {
              name = "";
              viewer.displayNoSuchPortfolio();
            }
            break;
          case 3:
            if (name.length() == 0) {
              viewer.displayNameCannotBeEmpty();
              break;
            }
            handleTotalStockOnDifferentDate(name);
            break;
          case 4:
            continueLoop = true;
            break;
          default:
            viewer.displaySwitchCaseDefault();
            break;
        }
      }
    }
  }


  @Override
  public void handleShowCompanies() {
    List<String> stockCompanyName = models.getStockCompanyName();
    for (int i = 0; i < stockCompanyName.size(); i++) {
      viewer.displayCompanies(stockCompanyName.get(i), i + 1);
    }
    viewer.displayEmptyLine();
  }

  @Override
  public List<String> handleAddACompanyStock() {
    sc.nextLine();
    String companyName;
    double numberOfStocks = 0;
    viewer.askForCompanyName();
    companyName = sc.nextLine();
    viewer.askForNumberOfStocks();
    try {
      numberOfStocks = sc.nextDouble();
    } catch (InputMismatchException e) {
      viewer.displayOnlyIntegers();
      sc.next();
    }
    String[] array = {companyName, new BigDecimal(numberOfStocks).toPlainString()};
    List<String> dataToAdd = new ArrayList<String>(Arrays.asList(array));
    if (dataToAdd.get(0).length() == 0) {
      viewer.displayNameCannotBeEmpty();
      dataToAdd = null;
    } else {
      double stockNumber = Double.parseDouble(dataToAdd.get(1));
      if (stockNumber <= 0) {
        viewer.displayStockNumberCannotBeLessThanOrEqualToZero();
        dataToAdd = null;
      }
    }
    return dataToAdd;
  }

  @Override
  public String handleGetPortfolioName() {
    String name;
    viewer.displayEnterNameForPortfolio();
    //check if we need to dd try catch
    sc.nextLine();
    name = sc.nextLine();

    if (name.length() == 0) {
      viewer.displayNameCannotBeEmpty();
      return "";
    }
    boolean alreadyContainsTheName = models.hasAnotherPortfolioWithSameName(name);
    if (alreadyContainsTheName) {
      viewer.displayAlreadyHaveAnotherPortfolioWithSameName();
      return "";
    }
    return name;
  }

  @Override
  public void addPortfolioData(List<List<String>> dataToAdd, String name, String currentDate) {
    models.addsFinalDataToPortfolio(dataToAdd, name, currentDate);
  }

  @Override
  public void handleDateSelection() {
    LocalDate currentDate = models.localDateParser(models.currentDate);

    String dateChange;
    int day;
    int month;
    int year;
    viewer.askForDayOfTheMonth();
    try {
      day = sc.nextInt();
    } catch (InputMismatchException e) {
      viewer.displayOnlyIntegers();
      sc.next();
      return;
    }
    if (day > 31 || day == 0) {
      viewer.displayEnterValidDetailsForDate();
      return;
    }
    viewer.askForMonth();
    try {
      month = sc.nextInt();
    } catch (InputMismatchException e) {
      viewer.displayOnlyIntegers();
      sc.next();
      return;
    }
    if (month > 12 || month == 0) {
      viewer.displayEnterValidDetailsForDate();
      return;
    }
    viewer.askForYear();
    try {
      year = sc.nextInt();
    } catch (InputMismatchException e) {
      viewer.displayOnlyIntegers();
      sc.next();
      return;
    }
    if (year > 2022 || year < 2001) {
      viewer.displayEnterValidDetailsForDate();
      return;
    }

    dateChange = models.makeStringDate(day, month, year);

    if (dateChange.length() != 0) {
      boolean checker = models.isValidDate(dateChange);
      if (checker) {
        boolean anotherChecker = models.setContainsGivenDate(dateChange);
        if (anotherChecker) {
          currentDate = LocalDate.parse(dateChange);
          models.setCurrentDate(currentDate.toString());
        } else {
          viewer.displayNoStockDataForGivenDate();
        }
      } else {
        viewer.displayDateIsNotValid();
      }
    }
  }

  @Override
  public String handleTotalStockOnCurrentDate(String portfolioName) {
    double totalValue = models.getTotalStockValue(portfolioName, models.getCurrentDate());
    if (totalValue == -1) {
      return "Failure";
    }
    viewer.displayTotalStockValue(portfolioName, models.getCurrentDate(),
            new BigDecimal(totalValue).toPlainString());
    return "Success";
  }

  @Override
  public void handleTotalStockOnDifferentDate(String portfolioName) {
    int choice;
    viewer.displaySelectDateOption(models.getCurrentDate());
    try {
      choice = sc.nextInt();
    } catch (InputMismatchException e) {
      viewer.displayOnlyIntegers();
      sc.next();
      return;
    }

    if (choice == 1) {
      int day;
      int month;
      int year;
      viewer.askForDayOfTheMonth();
      try {
        day = sc.nextInt();
      } catch (InputMismatchException e) {
        viewer.displayOnlyIntegers();
        sc.next();
        return;
      }
      if (day > 31 || day == 0) {
        viewer.displayEnterValidDetailsForDate();
        return;
      }
      viewer.askForMonth();
      try {
        month = sc.nextInt();
      } catch (InputMismatchException e) {
        viewer.displayOnlyIntegers();
        sc.next();
        return;
      }
      if (month > 12 || month == 0) {
        viewer.displayEnterValidDetailsForDate();
        return;
      }
      viewer.askForYear();
      try {
        year = sc.nextInt();
      } catch (InputMismatchException e) {
        viewer.displayOnlyIntegers();
        sc.next();
        return;
      }
      if (year > 2022 || year < 2001) {
        viewer.displayEnterValidDetailsForDate();
        return;
      }

      String dateWishToChange = models.makeStringDate(day, month, year);

      boolean checker1 = models.isValidDate(dateWishToChange);
      if (checker1) {
        //check if date exist
        boolean checker = models.setContainsGivenDate(dateWishToChange);
        if (checker) {
          double amount = models.getTotalStockValue(portfolioName, dateWishToChange);
          viewer.displayTotalStockValue(portfolioName, dateWishToChange,
                  new BigDecimal(amount).toPlainString());
        } else {
          viewer.displayNoStockDataForGivenDate();
        }
      } else {
        viewer.displayDateIsNotValid();
      }
    } else if (choice == 2) ;
    else {
      viewer.displaySwitchCaseDefault();
    }
  }
}
