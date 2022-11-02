public class Main {
  public static void main(String[] args){
    Model models = new ModelImpl();
    View viewer = new View(System.out);
    ControllerImpl control = new ControllerImpl(models,viewer,System.in);
    control.start();
    //high priority
    //adding same company stocks multiple times(need to consolidate)
    //finish comments


    //final changes
    //change arraylist and hashmap
    //display values in more well manner
    //details to tell the user
    //the files created using this program is read only, so if you try to create another
    //portfolio with same name, it will not be overwritten. Nothing will happen if you use already
    //existing portfolio name.

    //mention in deliverable that we support only certain company stocks

    //each text file provided as input should contain only one portfolio
  }
}