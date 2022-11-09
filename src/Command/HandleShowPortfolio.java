package Command;

import java.util.Scanner;

import Model.Model;
import View.View;

public class HandleShowPortfolio implements Command {
  final Model model;
  final View view;
  final Scanner sc;

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
