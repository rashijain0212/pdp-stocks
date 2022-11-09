package Command;
import java.io.InputStream;
import java.util.Scanner;

import Model.Model;
import View.View;

public class HandleFastForwardTime implements Command{
  Model model;
  View view;
  Scanner sc;

  public HandleFastForwardTime(Model model, View view, Scanner sc) {
    this.model = model;
    this.view = view;
    this.sc = sc;
  }

  @Override
  public Model execute() {
    return null;
  }
}
