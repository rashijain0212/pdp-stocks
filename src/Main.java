/**
 * This is the class which contains main method. Creates an object for view with PrintStream
 * as System.out. Creates an object for Model Interface and provides all these objects
 * as parameter to controller. Calls the controller's start method, which is the starting point
 * in the application.
 */
public class Main {
  /**
   * It creates a new Model, View, and Controller, and then starts the controller.
   * @param args accepts a single argument of type String array
   */
  public static void main(String[] args) {
    Model models = new ModelImpl();
    View viewer = new View(System.out);
    ControllerImpl control = new ControllerImpl(models, viewer, System.in);
    control.start();
  }
}
