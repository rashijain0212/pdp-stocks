import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for ControllerImpl. It tests the controller using a mock model on various
 * scenarios to see if the controller sends the correct data to the model.
 */
public class ControllerImplTest {
  Controller controller;
  View viewer;
  InputStream input;
  OutputStream outStream;
  MockModel tester;


  @Before
  public void setup() {
    outStream = new ByteArrayOutputStream();
    viewer = new View(new PrintStream(outStream));
    tester = new MockModel();
  }

  public MockModel testingHelper(String inputString) {
    input = new ByteArrayInputStream(inputString.getBytes());
    MockModel mock = new MockModel();
    controller = new ControllerImpl(mock, viewer, input);
    controller.start();
    return mock;
  }

  @Test
  public void portfolioCreationTest() {

    String inputString = "1\n1\nsavings\n3\nApple\n16\n3\nAmazon\n20\n3\nstarbucks\n30\n4\n7";
    String assertVal = "savings Apple 16 Amazon 20 starbucks 30";
    tester = testingHelper(inputString);
    assertEquals(assertVal, tester.getLogForAddPortfolioData());
  }

  @Test
  public void checkIfCompanyNameExists() {
    String inputString = "1\n1\nsavings\n3\nApple\n16\n3\nAmazon\n20\n3\nstarbucks\n30\n4\n7";
    String assertVal = "Received:AppleReceived:AmazonReceived:starbucks";
    tester = testingHelper(inputString);
    assertEquals(assertVal, tester.getLogForCheckingCompanyNameExist());
  }

  @Test
  public void checkIfDateIsValid() {
    String inputString = "3\n1\n31\n02\n2006\n2\n7";
    String assertVal = "Received:2006-02-31";
    tester = testingHelper(inputString);
    assertEquals(assertVal, tester.getLogForIsValidDate());
  }

  @Test
  public void checkMakeString() {
    String inputString = "3\n1\n31\n12\n2006\n2\n7";
    String assertVal = "Day:31Month:12Year:2006";
    tester = testingHelper(inputString);
    assertEquals(assertVal, tester.getLogForMakeString());
  }

  @Test
  public void readFromFile() {
    String inputString = "5\nsrc\\userInput\\saving.txt\n7";
    String assertVal = "Received:src\\userInput\\saving.txt";
    tester = testingHelper(inputString);
    assertEquals(assertVal, tester.getLogForReadFromFile());
  }

  @Test
  public void checkParseJson() {
    String inputString = "5\nsrc\\userInput\\saving.txt\n7";
    String assertVal = "{\"saving\":[[\"apple\",\"16\",\"2001-02-02\"],[\"amazon\",\"18\"," +
            "\"2001-02-02\"],[\"wells fargo\",\"5\",\"2001-02-02\"]]}";
    tester = testingHelper(inputString);
    assertEquals(assertVal, tester.getLogForParseJson());
  }

  @Test
  public void checkParsedPortfolio() {
    String inputString = "5\nsrc\\userInput\\saving.txt\n7";
    String assertVal = "savingapple162001-02-02amazon182001-02-02wells fargo52001-02-02";
    tester = testingHelper(inputString);
    assertEquals(assertVal, tester.getLogForCheckParsedPortfolio());
  }

  @Test
  public void setPortfolio() {
    String inputString = "5\nsrc\\userInput\\saving.txt\n7";
    String assertVal = "savingapple162001-02-02amazon182001-02-02wells fargo52001-02-02";
    tester = testingHelper(inputString);
    assertEquals(assertVal, tester.getLogForSetPortfolio());
  }

  @Test
  public void helperTest() {
    String inputString = "1\n1\ntest\n3\napple\n1.5\n4\n2\n7\n";
    String assertVal = "Received:1.5";
    tester = testingHelper(inputString);
    assertEquals(assertVal, tester.getLogForHelper());
  }

  @Test
  public void setCurrentDateTest() {
    String inputString = "3\n1\n1\n2\n2022\n2\n7";
    String assertVal = "2022-02-01";
    tester = testingHelper(inputString);
    assertEquals(assertVal, tester.getLogForSetCurrentDate());
  }

  @Test
  public void portfolioContainsCertainKeyTest() {
    String inputString = "1\n1\nabc\n3\namazon\n10\n4\n4\n1\nabc\n4\n7";
    String assertVal = "abc";
    tester = testingHelper(inputString);
    assertEquals(assertVal, tester.getLogForPortfolioContainsCertainKey());
  }

  @Test
  public void hasAnotherPortfolioWithSameNameTest() {
    String inputString = "1\n1\nsavings\n3\namazon\n10\n4\n1\n1\nsavings\n4\n7";
    String assertVal = "savingssavings";
    tester = testingHelper(inputString);
    assertEquals(assertVal, tester.getLogForHasAnotherPortfolioWithSameName());
  }

  @Test
  public void setContainsGivenDateTest() {
    String inputString = "1\n1\nabc\n3\namazon\n10\n4\n4\n1\nabc\n3\n1\n12\n2\n2020\n4\n7";
    String assertVal = "2020-02-12";
    tester = testingHelper(inputString);
    assertEquals(assertVal, tester.getSetContainsGivenDate());
  }

  @Test
  public void getTotalStockValueTest() {
    String inputString = "1\n1\nsavings\n3\napple\n10\n4\n4\n1\nsavings\n2\n4\n7";
    String assertVal = "savings2001-02-02";
    tester = testingHelper(inputString);
    assertEquals(assertVal, tester.getLogForTotalStockValue());
  }
}
