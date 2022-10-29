import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControllerImpl implements Controller {
  View viewer = new View();
  Model models = new Model();

  public void start() {
    //tell the model to get the data ready.
    models.getContentsFromFile();

    //tell the view to display starting screen
    boolean initialOptions = false;
    while (!initialOptions) {
      int choice = viewer.displayInitialOptions();

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

  public void handlePortfolioCreation() {
    boolean portfolioOptionExit = false;
    boolean nameEntered = false;
    String name = "";
    List<List<String>> dataToAdd = new ArrayList<>();
    String currentDate = models.getCurrentDate();
    while (!portfolioOptionExit) {
      int ans = viewer.portfolioCreation();
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
            dataToAdd.add(newData);
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

  public void handlePortfolioComposition() {
    HashMap<String, ArrayList<ArrayList<String>>> portfolio = models.getPortfolio();
    if (portfolio.size() == 0) {
      viewer.displayPortfolioIsEmpty();
    } else {
      viewer.displayPortfolio(portfolio);
    }

  }

  public void handleFastForwardTime() {
    boolean continueLoop = false;
    while (!continueLoop) {
      int choice = viewer.displaySelectDateOption(models.getCurrentDate());
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

  public void handleTotalStockValueDisplay() {
    boolean continueLoop = false;
    String name = "";
    int num = models.getPortfolioSize();
    if (num == 0) {
      viewer.displayNoPortfolio();
    } else {
      while (!continueLoop) {
        int choice = viewer.displayStockValueMenu();
        switch (choice) {
          case 1:
            if (name.length() != 0) {
              viewer.displayPortfolioNameAlreadyEntered();
              break;
            }
            name = viewer.displayEnterNameForPortfolio();
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
            if (result == "Failure") {
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

  public void handleShowCompanies() {
    List<String> stockCompanyName = models.getStockCompanyName();
    viewer.displayCompanies(stockCompanyName);
  }

  public List<String> handleAddACompanyStock() {
    List<String> dataToAdd = viewer.getCompanyNameAndNumberOfStocks();
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

  public String handleGetPortfolioName() {
    String name = viewer.displayEnterNameForPortfolio();
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

  public void addPortfolioData(List<List<String>> dataToAdd, String name, String currentDate) {
    models.addsFinalDataToPortfolio(dataToAdd, name, currentDate);
  }

  public void handleDateSelection() {
    LocalDate startingDate = LocalDate.parse(models.getStartingDate());
    LocalDate currentDate = LocalDate.parse(models.getCurrentDate());
    LocalDate lastDate = LocalDate.parse(models.getEndingDate());

    String dateChange = viewer.displayDateSelectionMenu();
    if (dateChange.length() != 0) {
      boolean checker = models.isValidDate(dateChange);
      if (checker) {
        currentDate = LocalDate.parse(dateChange);
        models.setCurrentDate(currentDate.toString());
      } else {
        viewer.displayDateIsNotValid();
      }
    }
  }

  public String handleTotalStockOnCurrentDate(String portfolioName) {
    double totalValue = models.getTotalStockValue(portfolioName, models.getCurrentDate());
    if (totalValue == -1) {
      return "Failure";
    }
    viewer.displayTotalStockValue(portfolioName, models.getCurrentDate(), totalValue);
    return "Success";
  }

  public void handleTotalStockOnDifferentDate(String portfolioName) {
    int choice = viewer.displaySelectDateOption(models.getCurrentDate());
    if (choice == 1) {
      String dateWishToChange = viewer.displayDateSelectionMenu();
      double amount = models.getTotalStockValue(portfolioName, dateWishToChange);
      viewer.displayTotalStockValue(portfolioName, dateWishToChange, amount);
    } else if (choice == 2) {
    } else {
      viewer.displaySwitchCaseDefault();
    }
  }
}
