package Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModelImpl implements Model{

  List<String> initialOptions = List.of("Create Immutable Portfolio",
          "Examine Composition of current Portfolio",
          "Fast Forward Time","Determine value of stocks on certain Date","Upload a portfolio",
          "List all portfolios","Exit");
  List<String> inputDataSources;

  @Override
  public List<String> getInitialOptions(){
    return initialOptions;
  }

  @Override
  public Set<Class> createListOfInputSources(String packageName) {
    return null;
  }

  @Override
  public void putInputSourcesInList(Set<Class> allClass) {
    for(Class all:allClass){
      String className = all.getName();
      String name = className.split(".")[1];
      if(name.equals("InputDataSource")){
        continue;
      }
      inputDataSources.add(className.split(".")[1]);
    }

  }
  @Override
  public List<String> getInputDataSources(){
    return inputDataSources;
  }


}
