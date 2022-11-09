package Controller;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Command.Command;
import Command.HandleFastForwardTime;
import Command.HandlePortfolioCreation;
import Command.HandleShowPortfolio;
import Command.HandleUploadFile;
import Command.HandlePortfolioComposition;
import Command.HandleTotalStockValueDisplay;
import Model.Model;
import View.View;

/**
 * This class implements the Controller.Controller interface. It has two main fields of objects of classes
 * Model.Model,View.View. This class tells the model to perform calculations, store results and
 * this class tells the view to display certain information.
 */
public class ControllerImpl implements Controller{
  private final InputStream input;
  Scanner sc;
  View view;
  Model model;
  Command command;

  /**
   * Constructor for the Controller.ControllerImpl class. Initializes the field viewer,models,sc with
   * appropriate parameters.
   *
   * @param models Model.Model object.
   * @param viewer View.View object.
   * @param in     InputStream object,main method gives System.in,ByteArrayInputStream is used
   *               for test.
   */
  public ControllerImpl(Model models, View viewer, InputStream in) {
    this.model = models;
    this.view = viewer;
    this.input = in;
    this.sc = new Scanner(this.input);
  }


  public void start(){
    //model.createDirectory();

    boolean initialOptions = false;
    while (!initialOptions) {
      List<String> currInitialOptions = model.getInitialOptions();
      for(int i=0;i<currInitialOptions.size();i++){
        view.displayWhatIsInParameter(i+1,currInitialOptions.get(i));
      }

      int choice;
      try {
        choice = sc.nextInt();
      } catch (InputMismatchException e) {
        view.displayOnlyIntegers();
        sc.next();
        continue;
      }
      switch (choice) {
        case 1:
          command = new HandlePortfolioCreation();
          break;
        case 2:
          command = new HandlePortfolioComposition();
          break;
        case 3:
          command = new HandleFastForwardTime();
          break;
        case 4:
          command = new HandleTotalStockValueDisplay();
          break;
        case 5:
          command = new HandleUploadFile();
          break;
        case 6:
          command = new HandleShowPortfolio();
          break;
        case 7:
          initialOptions = true;
          break;
        default:
          view.displaySwitchCaseDefault();
          break;
      }
      if(!(command ==null)){
        model = command.execute(model,sc,view);
      }
    }
  }


}
