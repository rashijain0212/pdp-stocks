import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ViewTest {
  Model models;
  Controller controller;
  View viewer;
  InputStream input;
  String initalOptions;
  OutputStream outStream;

  @Before
  public void setup() {
    models = new ModelImpl();
    initalOptions = "1.Create Portfolio2.Examine Composition of current Portfolio" +
            "3.Fast forward time4.Determine value of stocks on certain Date" +
            "5.Upload a portfolio6.List all portfolios7.Exit" +
            "Choose one of the five options";
    outStream = new ByteArrayOutputStream();
    viewer = new View(new PrintStream(outStream));

  }

  @Test
  public void initialOptionsTest() {
    int thirdOption = 7;
    String inputString = "" + thirdOption;

    input = new ByteArrayInputStream(inputString.getBytes());

    controller = new ControllerImpl(models, viewer, input);
    controller.start();

    assertEquals(initalOptions, outStream.toString().replaceAll("\n", "")
            .replaceAll("\r", ""));
  }
}