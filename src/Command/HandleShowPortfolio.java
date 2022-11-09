package Command;
import java.io.InputStream;
import java.util.Scanner;

import Model.Model;
import View.View;

public class HandleShowPortfolio implements Command{
  Model model;
  View view;
  Scanner sc;

  public HandleShowPortfolio(Model model, View view, Scanner sc) {
    this.model = model;
    this.view = view;
    this.sc = sc;
  }

  @Override
  public Model execute() {
    return null;
  }
}
