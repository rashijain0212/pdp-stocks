import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ControllerImplTest {
  Controller controller;
  View viewer;
  InputStream input;
  OutputStream outStream;

  MockModelForAddPortfolioData mock;

  @Before
  public void setup(){
    mock = new MockModelForAddPortfolioData();

    outStream = new ByteArrayOutputStream();
    viewer = new View(new PrintStream(outStream));
  }

  @Test
  public void portfolioCreationTest(){
    String inputString = "1\n1\nsavings\n3\nApple\n16\n3\nAmazon\n20\n3\nstarbucks\n30\n4\n7";
    String assertVal = "savings Apple 16 Amazon 20 starbucks 30";
    input = new ByteArrayInputStream(inputString.getBytes());
    controller = new ControllerImpl(mock,viewer,input);

    controller.start();
    assertEquals(assertVal,mock.logGetter());
  }
}