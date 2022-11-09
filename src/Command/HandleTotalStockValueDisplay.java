package Command;

import java.util.Scanner;

import Model.Model;
import View.View;

public class HandleTotalStockValueDisplay implements Command {
  final Model model;
  final View view;
  final Scanner sc;

  public HandleTotalStockValueDisplay(Model model, View view, Scanner sc) {
    this.model = model;
    this.view = view;
    this.sc = sc;
  }

  @Override
  public Model execute() {
    return null;
  }
}
