package View;

import java.io.PrintStream;

/**
 * This the view class for Stocks.
 * It represents the visualization of the data that model contains.
 */
public class View {
  private final PrintStream out;

  /**
   * Constructor for the View.View Class.
   *
   * @param out PrintStream object, required way ex. main method sends System.out.
   */
  public View(PrintStream out) {
    this.out = out;
  }

  /**
   * A Method to display contents which has numbered, example 1. Display 2.Exit etc.
   * @param optionNumber integer, option number.
   * @param needToDisplay String, contents to display for particular option.
   */
  public void displayWhatIsInParameter(int optionNumber,String needToDisplay){
   this.out.println(optionNumber+"."+" "+needToDisplay);
  }

  /**
   * Displays only integers are valid values.
   */
  public void displayOnlyIntegers() {
    this.out.println("Enter only valid Integers");
    this.out.println();
  }

  /**
   * Tells the user to enter a valid option.
   */
  public void displaySwitchCaseDefault() {
    this.out.println("Enter an valid option.");
    this.out.println();
  }
}
