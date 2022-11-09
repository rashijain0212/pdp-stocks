import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * A Junit test class for View. Test various scenarios if the view prints the expected results.
 */
public class ViewTest {
  Model models;
  Controller controller;
  View viewer;
  InputStream input;
  OutputStream outStream;
  String initialOptions = "1.Create Portfolio2.Examine Composition of current Portfolio" +
          "3.Fast forward time4.Determine value of stocks on certain Date" +
          "5.Upload a portfolio6.List all portfolios7.Exit" +
          "Choose one of the seven options";
  String portfolioIsEmpty = "Portfolio is empty, cannot view composition";
  String switchCaseDefault = "Enter an valid option.";
  String displayValidIntegers = "Enter only valid Integers";
  String portfolioCreationMenu = "1.Give a name for the current Portfolio2.Show list of Companies" +
          "3.Add a company Stock4.Exit";
  String cannotProceedWithoutName = "Please Enter a name for the portfolio first.";
  String noSuchCompanyExist = "There is no such company, enter using the list of companies " +
          "available";
  String askCompanyName = "Enter the company name:";
  String askNumberOfStocks = "Enter number of stocks:";
  String askPortfolioName = "Enter Name of the Portfolio:";
  String showCompanies;
  String tableLayout = "CompanyStock-NumbersDate-obtained";

  String portfolioNameAlreadyEntered = "You already entered Name for this current Portfolio" +
          ",cannot change Name.";
  String askForDay = "Enter the day of the month in number(1-31):";
  String askForMonth = "Enter the month in number(1-12):";
  String askForYear = "Enter the year you wish to jump to(2001 - 2022):";
  String fastForwardTimeMenu = "1.Select Date2.Exit";
  String enterValidDetails = "Enter valid details.";

  String notAValidDate = "The entered date is not a valid date.";

  String determineValueOnCertainDateMenu = "1.Enter the portfolio name to get value for2.Get " +
          "total Stock Value on current Date3.Change the date and get Stock Value4.Exit";
  String displayNoPortfolio = "Create portfolio first.";
  String portfolioNameCannotBeEmpty = "Name cannot be empty. Enter at least one character";

  String changeDateAndGetValueMenu = "Current Date: 2001-02-021.Select Date2.Exit";
  String displayForValidPath = "The file path does not exist, Please Enter a valid path";
  String enterFilePath = "Enter the file path:";

  @Before
  public void setup() {
    models = new ModelImpl();
    outStream = new ByteArrayOutputStream();
    viewer = new View(new PrintStream(outStream));
  }

  public void companyNamesHelper() {
    List<String> stockCompanyName = models.getStockCompanyName();
    StringBuilder companies = new StringBuilder();
    for (int i = 0; i < stockCompanyName.size(); i++) {
      companies.append(i + 1).append(".").append(stockCompanyName.get(i));
    }
    showCompanies = companies.toString();
  }

  public void testingHelper(String inp, String assertor) {
    input = new ByteArrayInputStream(inp.getBytes());
    controller = new ControllerImpl(models, viewer, input);
    controller.start();
    assertEquals(assertor, outStream.toString().replaceAll("\n", "")
            .replaceAll("\r", "").replaceAll("\t", ""));
  }

  @Test
  public void initialOptionsTest() {
    int thirdOption = 7;
    String inputString = "" + thirdOption;

    testingHelper(inputString, initialOptions);
  }

  @Test
  public void examineCompositionWithoutAnyPortfolio() {
    String options = "2\n7";
    testingHelper(options, initialOptions + portfolioIsEmpty + initialOptions);
  }

  @Test
  public void switchCaseDefault() {
    String inputString = "8\n7";
    testingHelper(inputString, initialOptions + switchCaseDefault + initialOptions);
  }

  @Test
  public void invalidInput() {
    String inputString = "1234567890076544333\n7";
    testingHelper(inputString, initialOptions + displayValidIntegers + initialOptions);
  }

  @Test
  public void createPortfolioScreen() {
    String inputString = "1\n4\n7";
    testingHelper(inputString, initialOptions + portfolioCreationMenu + initialOptions);
  }

  @Test
  public void addCompanyStockWithoutPortfolioName() {
    String inputString = "1\n3\n4\n7";
    testingHelper(inputString, initialOptions + portfolioCreationMenu +
            cannotProceedWithoutName +
            portfolioCreationMenu + initialOptions);
  }

  @Test
  public void showCompanies() {
    companyNamesHelper();
    String inputString = "1\n2\n4\n7";
    testingHelper(inputString, initialOptions + portfolioCreationMenu + showCompanies
            + portfolioCreationMenu + initialOptions);
  }

  @Test
  public void companyNameDoesNotExist() {
    String inputString = "1\n1\nCollege Savings\n3\nAmam\n30\n4\n7";
    testingHelper(inputString, initialOptions + portfolioCreationMenu + askPortfolioName
            + portfolioCreationMenu + askCompanyName + askNumberOfStocks + noSuchCompanyExist +
            portfolioCreationMenu + initialOptions);
  }

  @Test
  public void samePortfolioNameCannotBeEnteredAgain() {
    String inputString = "1\n1\nCollege Savings\n3\nApple\n30\n1\n4\n7";
    testingHelper(inputString, initialOptions + portfolioCreationMenu + askPortfolioName
            + portfolioCreationMenu + askCompanyName + askNumberOfStocks + portfolioCreationMenu
            + portfolioNameAlreadyEntered + portfolioCreationMenu + initialOptions);
  }

  @Test
  public void showComposition() {
    String inputString = "1\n1\nCollege Savings\n3\nApple\n30\n4\n2\n7";
    String composition = "Apple302001-02-02";
    String portfolioName = "Portfolio: College Savings";

    testingHelper(inputString, initialOptions + portfolioCreationMenu + askPortfolioName
            + portfolioCreationMenu + askCompanyName + askNumberOfStocks
            + portfolioCreationMenu + initialOptions + portfolioName + tableLayout
            + composition + initialOptions);
  }

  @Test
  public void fastForwardTime() {
    String inputString = "3\n1\n15\n12\n2006\n2\n7";
    testingHelper(inputString, initialOptions + "Current Date: 2001-02-02" + fastForwardTimeMenu
            + askForDay + askForMonth + askForYear + "Current Date: 2006-12-15" + fastForwardTimeMenu
            + initialOptions);
  }

  @Test
  public void fastForwardTimeInvalidDay() {
    String inputString = "3\n1\n34\n2\n7";
    testingHelper(inputString, initialOptions + "Current Date: 2001-02-02" + fastForwardTimeMenu
            + askForDay + enterValidDetails + "Current Date: 2001-02-02" + fastForwardTimeMenu + initialOptions);
  }

  @Test
  public void fastForwardTimeInvalidMonth() {
    String inputString = "3\n1\n15\n36\n2\n7";
    testingHelper(inputString, initialOptions + "Current Date: 2001-02-02" + fastForwardTimeMenu
            + askForDay + askForMonth + enterValidDetails + "Current Date: 2001-02-02" +
            fastForwardTimeMenu + initialOptions);
  }


  @Test
  public void fastForwardTimeInvalidDate() {
    String inputString = "3\n1\n31\n02\n2006\n2\n7";
    testingHelper(inputString, initialOptions + "Current Date: 2001-02-02" + fastForwardTimeMenu
            + askForDay + askForMonth + askForYear + notAValidDate + "Current Date: 2001-02-02" + fastForwardTimeMenu
            + initialOptions);
  }

  @Test
  public void determineValueOnDate() {
    String inputString = "4\n7";
    testingHelper(inputString, initialOptions + displayNoPortfolio + initialOptions);
  }

  @Test
  public void getPortfolioNameToDetermineValueTest() {
    String inputString = "1\n1\nsavings\n3\namazon\n1\n4\n4\n1\nsavings\n4\n7";
//    determineValueOnCertainDateMenu
    testingHelper(inputString, initialOptions + portfolioCreationMenu + askPortfolioName
            + portfolioCreationMenu + askCompanyName + askNumberOfStocks + portfolioCreationMenu +
            initialOptions + determineValueOnCertainDateMenu + askPortfolioName +
            determineValueOnCertainDateMenu + initialOptions);
  }

  @Test
  public void getPortfolioNamToDetermineValueTest() {
    String inputString = "1\n1\nsavings\n3\namazon\n1\n4\n4\n1\nsavings\n2\n4\n7";
//    determineValueOnCertainDateMenu
    testingHelper(inputString, initialOptions + portfolioCreationMenu + askPortfolioName
            + portfolioCreationMenu + askCompanyName + askNumberOfStocks + portfolioCreationMenu +
            initialOptions + determineValueOnCertainDateMenu + askPortfolioName +
            determineValueOnCertainDateMenu
            + "Portfolio: savingsDate: 2001-02-02Total Value: 14" +
            ".3800000000000007815970093361102044582366943359375"
            + determineValueOnCertainDateMenu + initialOptions);
  }

  //  portfolioNameCannotBeEmpty
  @Test
  public void toDetermineValuePortfolioNameEmpty() {
    String inputString = "1\n1\nsavings\n3\namazon\n1\n4\n4\n2\n4\n7";
//    determineValueOnCertainDateMenu
    testingHelper(inputString, initialOptions + portfolioCreationMenu + askPortfolioName
            + portfolioCreationMenu + askCompanyName + askNumberOfStocks + portfolioCreationMenu +
            initialOptions + determineValueOnCertainDateMenu + portfolioNameCannotBeEmpty +
            determineValueOnCertainDateMenu
            + initialOptions);
  }

  @Test
  public void toDetermineValueOnChangeDate() {
    String inputString = "1\n1\nsavings\n3\namazon\n1\n4\n4\n1\nsavings\n3\n1\n10\n2\n2021\n4\n7";
    testingHelper(inputString, initialOptions + portfolioCreationMenu + askPortfolioName
            + portfolioCreationMenu + askCompanyName + askNumberOfStocks + portfolioCreationMenu +
            initialOptions + determineValueOnCertainDateMenu + askPortfolioName +
            determineValueOnCertainDateMenu +
            changeDateAndGetValueMenu + askForDay + askForMonth + askForYear + "Portfolio: " +
            "savings" +
            "Date: 2021-02-10" +
            "Total Value: 3286.579999999999927240423858165740966796875" +
            determineValueOnCertainDateMenu + initialOptions);
  }

  @Test
  public void testUploadFileInvalidPath() {
    String inputString = "5\nrandompath\n7";
    testingHelper(inputString,
            initialOptions + enterFilePath + displayForValidPath + initialOptions);
  }

  @Test
  public void testUploadFile() {
    String inputString = "5\nsrc\\portfolios\\college.txt\n2\n7";
    testingHelper(inputString,
            initialOptions + enterFilePath + initialOptions + "Portfolio: college" +
                    "CompanyStock-NumbersDate-obtained" +
                    "amazon162001-02-02" + initialOptions);
  }

  @Test
  public void testListAllPortfolios() {
    String inputString = "6\n7";
    testingHelper(inputString,
            initialOptions + "Portfolio: abc.txt" +
                    "Portfolio: AnotherSavings.txt" +
                    "Portfolio: College Savings.txt" +
                    "Portfolio: college.txt" +
                    "Portfolio: CollegeFund.txt" +
                    "Portfolio: fees.txt" +
                    "Portfolio: newPort.txt" +
                    "Portfolio: saver.txt" +
                    "Portfolio: savers.txt" +
                    "Portfolio: savings.txt" +
                    "Portfolio: savingss.txt" +
                    "Portfolio: test.txt" + initialOptions);
  }

  @Test
  public void testExit() {
    String inputString = "7";
    testingHelper(inputString,
            initialOptions);
  }
}
