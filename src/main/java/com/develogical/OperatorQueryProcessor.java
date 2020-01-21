package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperatorQueryProcessor extends AbstractQueryProcessor{

  @Override
  public Pattern getRegex() {
    return Pattern.compile("what is (\\d+) (plus|minus) (\\d+)");
  }

  @Override
  public String getAnswer(Matcher parsedQuery) {
    int firstNum = Integer.parseInt(parsedQuery.group(1));
    int secondNum = Integer.parseInt(parsedQuery.group(3));
    if (parsedQuery.group(2).equals("plus")) {
      return String.valueOf((firstNum + secondNum));
    } else {
      return String.valueOf((firstNum - secondNum));
    }
  }
}
