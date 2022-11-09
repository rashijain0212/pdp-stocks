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
 * A Junit test class for ModelImpl. This class uses a mock model to log the results of the
 * operations that controller asked to perform.
 */
public class ModelImplTest {
  Model models;
  Controller controller;
  View viewer;
  InputStream input;
  OutputStream outStream;
  MockModel mock;

  @Before
  public void setUp() {
    outStream = new ByteArrayOutputStream();
    viewer = new View(new PrintStream(outStream));
    models = new ModelImpl();
    mock = new MockModel();
  }

  @Test
  public void showCompanyTest() {
    List<String> stockCompanyName = List.of("APPLE", "AMAZON", "ACTIVISION", "BARCLAYS"
            , "CANON INC", "CISCO SYSTEMS", "DISNEY", "JP MORGAN", "MCDONALD", "MICROSOFT"
            , "ORACLE", "STARBUCKS", "WELLS FARGO");
    List<String> stockCompanyNameFromModel = models.getStockCompanyName();

    assertEquals(stockCompanyName.size(), stockCompanyNameFromModel.size());
    for (int i = 0; i < stockCompanyName.size(); i++) {
      assertEquals(stockCompanyName.get(i), stockCompanyNameFromModel.get(i));
    }
  }

  @Test
  public void getListOfPortfoliosTest() {
    String[] portfoliosInDirectory = {"abc.txt",
            "AnotherSavings.txt",
            "College Savings.txt",
            "college.txt",
            "CollegeFund.txt",
            "fees.txt",
            "newPort.txt",
            "saver.txt",
            "savers.txt",
            "savings.txt",
            "savingss.txt",
            "test.txt"};
    List<String> portfoliosInDirectoryFromModel = models.getListOfPortfolio();
    assertEquals(portfoliosInDirectory.length, portfoliosInDirectoryFromModel.size());
    for (int i = 0; i < portfoliosInDirectory.length; i++) {
      assertEquals(portfoliosInDirectory[i], portfoliosInDirectoryFromModel.get(i));
    }
  }

  public void testingHelper(String inp) {
    input = new ByteArrayInputStream(inp.getBytes());
    controller = new ControllerImpl(mock, viewer, input);
    controller.start();
  }

  @Test
  public void getPortfolioKeysTest() {
    String inputString = "5\nsrc\\portfolios\\fees.txt\n2\n7";
    testingHelper(inputString);
    assertEquals("fees", mock.getLogForPortfolioKeys());
  }

  @Test
  public void getPortfolioTest() {
    String inputString = "5\nsrc\\portfolios\\fees.txt\n2\n7";
    String assertVal = "feesapple152001-02-02amazon182001-02-02";
    testingHelper(inputString);

    assertEquals(assertVal, mock.getLogForGetPortfolio());
  }

  @Test
  public void getHelperTest() {
    String inputString = "1\n1\ntest\n3\napple\n1.5\n4\n2\n7\n";
    testingHelper(inputString);
    assertEquals("2.0", mock.getLogForCheckingHelper());

  }


  @Test
  public void getPortfolioSizeTest() {
    String inputString = "1\n1\nsaver\n3\napple\n10\n4\n1\n1\nsavingss\n3\napple\n12\n4\n" +
            "1\n1\nsavers\n3\napple\n10\n4\n4\n4\n7";
    testingHelper(inputString);
    assertEquals("3", mock.getLogForGetPortfolioSize());

  }

  @Test
  public void savePortfolioTest() {
    String inputString = "1\n1\nnewPort\n3\namazon\n10\n4\n7";

    testingHelper(inputString);
    String inputStringCheck = "5\nsrc\\portfolios\\newPort.txt\n2\n7";
    testingHelper(inputStringCheck);
    assertEquals("{\"newPort\":[[\"amazon\",\"10\",\"2001-02-02\"]]}",
            mock.getLogForSavePortfolio());
  }

  @Test
  public void getModelTotalStock() {
    String inputString = "1\n1\nabc\n3\namazon\n10\n4\n4\n1\nabc\n3\n1\n12\n2\n2020\n4\n7";
    input = new ByteArrayInputStream(inputString.getBytes());
    controller = new ControllerImpl(mock, viewer, input);
    controller.start();
    assertEquals("21600.0", mock.getLogForModelSavePortfolio());
  }
}
