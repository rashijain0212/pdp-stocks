package Model;

import java.util.List;
import java.util.Set;

/**
 * This is an interface for stock model.
 * Contains all the data-related logic that the user requires.
 */
public interface Model {

  /**
   * This method returns a list of Strings which is used for displaying Inital options that a user
   * sees when using the applications. If new Features are added, Editing this list alone is enough.
   * @return List of Strings, contains all the options.
   */
  List<String> getInitialOptions();

  /**
   * Creates a Set Containing names of all Classes which implements the InputDataSource Interface.
   */
  Set<Class> createListOfInputSources(String packageName);

  /**
   * This method puts all the classes in the parameter in a list of strings.
   * @param allClass Set of Class, containing Classes.
   */
  void putInputSourcesInList(Set<Class> allClass);

  /**
   * This method returns a List containing all the available
   * @return List of String, containing names of all Classes implementing InputDataSource Interface.
   */
  List<String> getInputDataSources();
}
