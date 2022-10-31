import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class Json {
  HashMap<String, List<List<String>>> portfolio;
  List<String> keys;

  /**
   *
   * @param portfolio
   * @param keys
   */
  public Json(HashMap<String, List<List<String>>> portfolio, List<String> keys){
    this.portfolio = portfolio;
    this.keys = keys;
  }

  public Json(){
    portfolio = new HashMap<>();
    keys = new ArrayList<>();
  }

  /**
   *
   * @return
   */
  List<String> jsonFormatFromHashMap(){
    List<String> jsonPortfolio = new ArrayList<>();

    for (String portfolioName : keys) {
      StringBuilder currPortfolio = new StringBuilder("{");
      currPortfolio.append("\"");
      currPortfolio.append(portfolioName);
      currPortfolio.append("\":");
      currPortfolio.append("[");

      List<List<String>> currContents = portfolio.get(portfolioName);
      String anotherPrefix = "";
      for (List<String> currContent : currContents) {
        currPortfolio.append(anotherPrefix);
        currPortfolio.append("[");

        String prefix = "";
        for (String s : currContent) {
          currPortfolio.append(prefix);
          prefix = ",";
          currPortfolio.append("\"");
          currPortfolio.append(s);
          currPortfolio.append("\"");
        }
        currPortfolio.append("]");
        anotherPrefix = ",";
      }
      currPortfolio.append("]");
      currPortfolio.append("}");

      jsonPortfolio.add(currPortfolio.toString());
    }

    return jsonPortfolio;
  }

  /**
   *
   * @param json
   * @return
   */
  HashMap<String,List<List<String>>> jsonParser(String json){

    HashMap<String,List<List<String>>> portfolio = new HashMap<>();
    List<String> portfolioNameAndData = Arrays.asList(json.split(":"));

    //sanity check
    for (String portfolioNameAndDatum : portfolioNameAndData) {
      System.out.println(portfolioNameAndDatum);
    }

    if(portfolioNameAndData.size()!=2){
      return null;
    }
    List<String> possibleWaste = List.of("[","[[",",","]","]]}");

    List<String> splittingCompanyData = Arrays.asList(portfolioNameAndData.get(1).split("],"));
    List<List<String>> furtherSplittingCompanyData = new ArrayList<>();

    for (String splittingCompanyDatum : splittingCompanyData) {
      List<String> gettingAllData = Arrays.asList(splittingCompanyDatum.split("\""));
      furtherSplittingCompanyData.add(gettingAllData);
    }

    List<List<String>> actualPortfolioContents = new ArrayList<>();
    for (List<String> furtherSplittingCompanyDatum : furtherSplittingCompanyData) {
      List<String> adder = new ArrayList<>();
      for (String temp : furtherSplittingCompanyDatum) {
        if (possibleWaste.contains(temp)) continue;
        adder.add(temp);
      }
      actualPortfolioContents.add(adder);
    }

    String companyNameWithNoise = portfolioNameAndData.get(0);
    String companyName = companyNameWithNoise.substring(2,companyNameWithNoise.length()-1);
    portfolio.put(companyName,actualPortfolioContents);


    return portfolio;
  }
}
