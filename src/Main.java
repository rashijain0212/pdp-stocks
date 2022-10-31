public class Main {
  public static void main(String[] args) {
    ControllerImpl control = new ControllerImpl();
    control.start();
    //finish implementing saving part, add it to interface

    //confirm if we can limit number of companies?

    //high priority
    //adding same company stocks multiple times(need to consolidate)
    //finish comments


    //final changes
    //change arraylist and hashmap
    //display values in more well manner
    //display all the available portfolios? -> needed or not
    // displayEmptyLine in view . purpose?
    // change name askForDayOfTheMonth in view.
    // portfolioContainsCertainKey, makeListOfDates, setContainsGivenDate, localDateParser check this method.what it does in model interface


    //details to tell the user
    //the files created using this program is read only, so if you try to create another
    //portfolio with same name, it will not be overwritten. Nothing will happen if you use already
    //existing portfolio name.
    // setPortfolio check this function in model file
    // checkParsedPortfolio in model

    //mention in deliverable that we support only certain company stocks

    //each text file provided as input should contain only one portfolio
  }
}