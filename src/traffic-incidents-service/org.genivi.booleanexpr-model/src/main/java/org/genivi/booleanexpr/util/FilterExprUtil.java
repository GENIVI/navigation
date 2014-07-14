/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.booleanexpr.util;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.genivi.booleanexpr.BooleanExpression;
import org.genivi.booleanexpr.BooleanLiteral;
import org.genivi.booleanexpr.ClassAttribute;
import org.genivi.booleanexpr.ComparisonOperator;
import org.genivi.booleanexpr.ComparisonPredicate;
import org.genivi.booleanexpr.DownCastPredicate;
import org.genivi.booleanexpr.DyadicExpression;
import org.genivi.booleanexpr.DyadicLogicalOperator;
import org.genivi.booleanexpr.FilterexprFactory;
import org.genivi.booleanexpr.InOperator;
import org.genivi.booleanexpr.InPredicate;
import org.genivi.booleanexpr.IsSetPredicate;
import org.genivi.booleanexpr.ListOperator;
import org.genivi.booleanexpr.Literal;
import org.genivi.booleanexpr.MetaOperator;
import org.genivi.booleanexpr.MultiplicityPredicate;
import org.genivi.booleanexpr.SignedIntegerLiteral;
import org.genivi.booleanexpr.StringLiteral;
import org.genivi.booleanexpr.SubClassPredicate;
import org.genivi.booleanexpr.UnaryExpression;
import org.genivi.booleanexpr.UnaryLogicalOperator;


public class FilterExprUtil {
  private final static Logger LOGGER = Logger.getLogger(FilterExprUtil.class.getName());
  private final static FilterexprFactory FILTER_EXPR_FACTORY = FilterexprFactory.eINSTANCE;
  private static Map<ComparisonOperator, String> comparisonOperatorToString = new HashMap<>();
  private static Map<String, ComparisonOperator> stringToComparisonOperator = new HashMap<>();
  private static Map<ListOperator, String> listOperatorToString = new HashMap<>();
  private static Map<String, ListOperator> stringToListOperator = new HashMap<>();
  private static Map<UnaryLogicalOperator, String> unaryLogicalOperatorToString = new HashMap<>();
  private static Map<String, UnaryLogicalOperator> stringToUnaryLogicalOperator = new HashMap<>();
  private static Map<DyadicLogicalOperator, String> dyadicLogicalOperatorToString = new HashMap<>();
  private static Map<String, DyadicLogicalOperator> stringToDyadicLogicalOperator = new HashMap<>();
  private static Map<MetaOperator, String> metaOperatorToString = new HashMap<>();
  private static Map<String, MetaOperator> stringToMetaOperator = new HashMap<>();
  private static Map<InOperator, String> inOperatorToString = new HashMap<>();
  private static Map<String, InOperator> stringToInOperator = new HashMap<>();
  
  static {
    LOGGER.setLevel(Level.SEVERE);
    
    comparisonOperatorToString.put(ComparisonOperator.EQUAL, "==");
    comparisonOperatorToString.put(ComparisonOperator.NOT_EQUAL, "!=");
    comparisonOperatorToString.put(ComparisonOperator.GREATER_THEN, ">");
    comparisonOperatorToString.put(ComparisonOperator.GREATER_OR_EQUAL_THAN, ">=");
    comparisonOperatorToString.put(ComparisonOperator.LESS_THAN, "<");
    comparisonOperatorToString.put(ComparisonOperator.LESS_OR_EQUAL_THAN, "<=");
    
    stringToComparisonOperator.put("==", ComparisonOperator.EQUAL);
    stringToComparisonOperator.put("!=", ComparisonOperator.NOT_EQUAL);
    stringToComparisonOperator.put(">", ComparisonOperator.GREATER_THEN);
    stringToComparisonOperator.put(">=", ComparisonOperator.GREATER_OR_EQUAL_THAN);
    stringToComparisonOperator.put("<", ComparisonOperator.LESS_THAN);
    stringToComparisonOperator.put("<=", ComparisonOperator.LESS_OR_EQUAL_THAN);

    listOperatorToString.put(ListOperator.ANY, "any");
    listOperatorToString.put(ListOperator.ALL, "all");
    listOperatorToString.put(ListOperator.NONE, "none");
    
    stringToListOperator.put("any", ListOperator.ANY);
    stringToListOperator.put("all", ListOperator.ALL);
    stringToListOperator.put("none", ListOperator.NONE);
    
    unaryLogicalOperatorToString.put(UnaryLogicalOperator.NOT, "not");
    
    stringToUnaryLogicalOperator.put("not", UnaryLogicalOperator.NOT);

    dyadicLogicalOperatorToString.put(DyadicLogicalOperator.AND, "and");
    dyadicLogicalOperatorToString.put(DyadicLogicalOperator.OR, "or");
    
    stringToDyadicLogicalOperator.put("and", DyadicLogicalOperator.AND);
    stringToDyadicLogicalOperator.put("or", DyadicLogicalOperator.OR);

    metaOperatorToString.put(MetaOperator.SIZE, "size");
    stringToMetaOperator.put("size", MetaOperator.SIZE);
    
    inOperatorToString.put(InOperator.IN, "in");
    inOperatorToString.put(InOperator.NOT_IN, "not-in");
    
    stringToInOperator.put("in", InOperator.IN);
    stringToInOperator.put("not-in", InOperator.NOT_IN);
  }
  
  public static BooleanExpression parseFilterExpression(String expressionString) {
    LOGGER.info("=> " + expressionString);
    BooleanExpression booleanExpression = null;
    
    expressionString = expressionString.trim();
    if (!expressionString.isEmpty()) {
      
      if (booleanExpression == null) {
        try {
          booleanExpression = parseComparisonPredicate(expressionString);
        } catch (IllegalArgumentException e) {
          LOGGER.info("expression is not ComparisonPredicate, continue ...   (" + e.getMessage() + ")");
        }
      }
      
      if (booleanExpression == null) {
        try {
          booleanExpression = parseDownCastPredicate(expressionString);
        } catch (IllegalArgumentException e) {
          LOGGER.info("expression is not DownCastPredicate, continue ... (" + e.getMessage() + ")");
        }
      }
      
      if (booleanExpression == null) {
        try {
          booleanExpression = parseDyadicExpression(expressionString);
        } catch (IllegalArgumentException e) {
          LOGGER.info("expression is not DyadicExpression, continue ...");
        }
      }
      
      if (booleanExpression == null) {
        try {
          booleanExpression = parseIsSetPredicate(expressionString);
        } catch (IllegalArgumentException e) {
          LOGGER.info("expression is not IsSetPredicate, continue ...");
        }
      }
      
      if (booleanExpression == null) {
        try {
          booleanExpression = parseMultiplicityPredicate(expressionString);
        } catch (IllegalArgumentException e) {
          LOGGER.info("expression is not MultiplicityPredicate, continue ...");
        }
      }
      
      if (booleanExpression == null) {
        try {
          booleanExpression = parseSubClassPredicate(expressionString);
        } catch (IllegalArgumentException e) {
          LOGGER.info("expression is not SubClassPredicate, continue ...");
        }
      }
      
      if (booleanExpression == null) {
        try {
          booleanExpression = parseUnaryExpression(expressionString);
        } catch (IllegalArgumentException e) {
          LOGGER.info("expression is not UnaryExpression, continue ...");
        }
      }
      
      if (booleanExpression == null) {
        try {
          booleanExpression = parseInPredicate(expressionString);
        } catch (IllegalArgumentException e) {
          LOGGER.info("expression is not InPredicate, continue ...");
        }
      }
      
      if (booleanExpression == null) {
        throw new IllegalArgumentException("Wrong expression format: " + expressionString);
      }
    }
    
    LOGGER.info("<= " + booleanExpression);
    return booleanExpression;

  }

  public static BooleanExpression parseUnaryExpression(String expressionString) {
    LOGGER.info("=> " + expressionString);
    UnaryExpression unaryExpression = FILTER_EXPR_FACTORY.createUnaryExpression();
    
    expressionString = expressionString.trim();
    
    // UnaryLogicalOperator
    int spaceAfterOperatorIndex = expressionString.indexOf(" ");
    if (spaceAfterOperatorIndex == -1) {
      throw new IllegalArgumentException("Cannot find operator: " + expressionString);
    }
    String operatorString = expressionString.substring(0, spaceAfterOperatorIndex);
    UnaryLogicalOperator operator = parseUnaryLogicalOperator(operatorString);
    unaryExpression.setUnaryOperator(operator);
    
    // Followed by expression between braces
    expressionString = expressionString.substring(spaceAfterOperatorIndex);
    expressionString = expressionString.trim();
    if (!expressionString.startsWith("(")) {
      throw new IllegalArgumentException("Term not starting with '(': " + expressionString);
    }
    int matchingClosingParenthesisIndex = findMatchingClosingParenthesis(expressionString);
    if (matchingClosingParenthesisIndex == -1) {
      throw new IllegalArgumentException("No matching parenthesis in term: " + expressionString);
    }
    String termString = expressionString.substring(1, matchingClosingParenthesisIndex);
    BooleanExpression filterExpression = parseFilterExpression(termString);
    unaryExpression.setExpression(filterExpression);
    
    return unaryExpression;
  }

  public static DyadicExpression parseDyadicExpression(String expressionString) {
    LOGGER.info("=> " + expressionString);
    DyadicExpression dyadicExpression = FILTER_EXPR_FACTORY.createDyadicExpression();
    
    expressionString = expressionString.trim();
    
    // Left hand Expression
    if (!expressionString.startsWith("(")) {
      throw new IllegalArgumentException("Left hand term not starting with '(': " + expressionString);
    }
    int matchingClosingParenthesisIndex = findMatchingClosingParenthesis(expressionString);
    if (matchingClosingParenthesisIndex == -1) {
      throw new IllegalArgumentException("No matching parenthesis in left hand term: " + expressionString);
    }
    String termString = expressionString.substring(1, matchingClosingParenthesisIndex);
    BooleanExpression filterExpression = parseFilterExpression(termString);
    dyadicExpression.setLeftHandTerm(filterExpression);
    
    expressionString = expressionString.substring(matchingClosingParenthesisIndex + 1);
    
    // DyadicLogicalOperator
    expressionString = expressionString.trim();
    int spaceAfterOperatorIndex = expressionString.indexOf(" ");
    if (spaceAfterOperatorIndex == -1) {
      throw new IllegalArgumentException("Cannot find operator: " + expressionString);
    }
    String operatorString = expressionString.substring(0, spaceAfterOperatorIndex);
    DyadicLogicalOperator operator = parseDyadicLogicalOperator(operatorString);
    dyadicExpression.setLogicalOperator(operator);
    
    expressionString = expressionString.substring(spaceAfterOperatorIndex);
    expressionString = expressionString.trim();
    
    // Right hand Expression
    if (!expressionString.startsWith("(")) {
      throw new IllegalArgumentException("Right hand term not starting with '(': " + expressionString);
    }
    matchingClosingParenthesisIndex = findMatchingClosingParenthesis(expressionString);
    if (matchingClosingParenthesisIndex == -1) {
      throw new IllegalArgumentException("No matching parenthesis in right hand term: " + expressionString);
    }
    termString = expressionString.substring(1, matchingClosingParenthesisIndex);
    filterExpression = parseFilterExpression(termString);
    dyadicExpression.setRightHandTerm(filterExpression);
    
    return dyadicExpression;
  }
  
  private static int findMatchingClosingParenthesis(String expressionString) {
    int bracesToMatch = 0;
    int matchIndex = -1;
    
    for (int i = 0; i < expressionString.length(); i++) {
      char c = expressionString.charAt(i);
      if (c == '(') {
        bracesToMatch++;
      } else if (c == ')') {
        bracesToMatch--;
        if (bracesToMatch == 0) {
          matchIndex = i;
          break;
        }
      }
    }
    
    return matchIndex;
  }

  public static ComparisonPredicate parseComparisonPredicate(String expressionString) {
    LOGGER.info("=> " + expressionString);
    ComparisonPredicate comparisonPredicate = FILTER_EXPR_FACTORY.createComparisonPredicate();
    
    expressionString = expressionString.trim();
    
    StringTokenizer tokens = new StringTokenizer(expressionString, " ");
    if (tokens.countTokens() != 3) {
      throw new IllegalArgumentException("wrong number of tokens in comparison predicate: " + expressionString);
    }
    
    // Attribute
    ClassAttribute attribute = parseClassAttribute(tokens.nextToken());
    comparisonPredicate.setAttribute(attribute);
    
    // ComparisonOperator
    ComparisonOperator comparisonOperator = parseComparisonOperator(tokens.nextToken());
    comparisonPredicate.setComparisonOperator(comparisonOperator);
    
    // Literal
    Literal literal = parseLiteral(tokens.nextToken());
    comparisonPredicate.setLiteral(literal);
    
    LOGGER.info("<= " + comparisonPredicate);
    return comparisonPredicate;
  }

  public static DownCastPredicate parseDownCastPredicate(String expressionString) {
    LOGGER.info("=> " + expressionString);
    DownCastPredicate downCastPredicate = FILTER_EXPR_FACTORY.createDownCastPredicate();
    
    expressionString = expressionString.trim();
    
    // 'DownCast to' class between '[' and ']'
    if (!expressionString.startsWith("[")) {
      throw new IllegalArgumentException("DownCastPredicate not starting with '[': " + expressionString);
    }
    
    int closingBracketIndex = expressionString.indexOf("]");
    if (closingBracketIndex == -1) {
      throw new IllegalArgumentException("DownCastPredicate is missing ']': " + expressionString);
    }
        
    String className = expressionString.substring(1, closingBracketIndex);
    downCastPredicate.setClassName(className);
    
    expressionString = expressionString.substring(closingBracketIndex + 1);
    expressionString = expressionString.trim();
    
    // Expression
    if (!expressionString.startsWith("(")) {
      throw new IllegalArgumentException("DownCastPredicate is missing '(': " + expressionString);
    }
    
    if (!expressionString.endsWith(")")) {
      throw new IllegalArgumentException("DownCastPredicate is missing ')': " + expressionString);
    }
    
    expressionString = expressionString.substring(1, expressionString.length() - 1);
    BooleanExpression filterExpression = parseFilterExpression(expressionString);
    downCastPredicate.setExpression(filterExpression);
    
    LOGGER.info("<= " + downCastPredicate);
    return downCastPredicate;
  }


  public static IsSetPredicate parseIsSetPredicate(String expressionString) {
    LOGGER.info("=> " + expressionString);
    IsSetPredicate isSetPredicate = FILTER_EXPR_FACTORY.createIsSetPredicate();
    
    expressionString = expressionString.trim();
    
    // isSet operator
    if (!expressionString.startsWith("isSet")) {
      LOGGER.info("Not starting with isSet");
      throw new IllegalArgumentException("IsSetPredicate not starting with 'isSet': " + expressionString);
    }
    LOGGER.info("Starting with isSet: " + expressionString);
    expressionString = expressionString.substring(5);
    expressionString = expressionString.trim();
    
    // Expression
//    if (!expressionString.startsWith("(")) {
//      LOGGER.info("Not opening brace");
//      throw new IllegalArgumentException("IsSetPredicate is missing '(': " + expressionString);
//    }
//    if (!expressionString.endsWith(")")) {
//      LOGGER.info("Not closing brace");
//      throw new IllegalArgumentException("IsSetPredicate is missing ')': " + expressionString);
//    }
            
//    String className = expressionString.substring(1, expressionString.length() - 1);
//    ClassAttribute classAttribute = parseClassAttribute(className);  
    
    // ClassAttribute
    ClassAttribute classAttribute = parseClassAttribute(expressionString);    
    isSetPredicate.setAttribute(classAttribute);
    
    LOGGER.info("<= " + isSetPredicate);
    return isSetPredicate;
  }

  public static MultiplicityPredicate parseMultiplicityPredicate(String expressionString) {
    LOGGER.info("=> " + expressionString);
    MultiplicityPredicate multiplicityPredicate = FILTER_EXPR_FACTORY.createMultiplicityPredicate();
    
    expressionString = expressionString.trim();
    
    // ListOperator
    int spaceAfterOperator = expressionString.indexOf(" ");
    if (spaceAfterOperator == -1) {
      throw new IllegalArgumentException("No operator found: " + expressionString);
    }
    String operatorString = expressionString.substring(0, spaceAfterOperator);
    ListOperator listOperator = parseListOperator(operatorString);    
    multiplicityPredicate.setListOperator(listOperator);
    
    
    expressionString = expressionString.substring(spaceAfterOperator);
    expressionString = expressionString.trim();
    
    // ClassAttribute
    int spaceAfterAttribute = expressionString.indexOf(" ");
    String attributeString = expressionString.substring(0, spaceAfterAttribute);
    ClassAttribute classAttribute = parseClassAttribute(attributeString);    
    multiplicityPredicate.setAttribute(classAttribute);
    
    expressionString = expressionString.substring(spaceAfterAttribute);
    expressionString = expressionString.trim();
    
    // Expression
    if (!expressionString.startsWith("(")) {
      throw new IllegalArgumentException("'(' expected: " + expressionString);
    }
    if (!expressionString.endsWith(")")) {
      throw new IllegalArgumentException("')' expected: " + expressionString);
    }

    expressionString = expressionString.substring(1, expressionString.length() - 1);
    BooleanExpression filterExpression = parseFilterExpression(expressionString);
    multiplicityPredicate.setExpression(filterExpression);
    
    LOGGER.info("<= " + multiplicityPredicate);
    return multiplicityPredicate;
  }

  public static SubClassPredicate parseSubClassPredicate(String expressionString) {
    LOGGER.info("=> " + expressionString);
    SubClassPredicate subClassPredicate = FILTER_EXPR_FACTORY.createSubClassPredicate();
    
    expressionString = expressionString.trim();
    
    // ClassAttribute
    int spaceAfterAttribute = expressionString.indexOf(" ");
    if (spaceAfterAttribute == -1) {
      throw new IllegalArgumentException("No attribute found: " + expressionString);
    }
    String attributeString = expressionString.substring(0, spaceAfterAttribute);
    if (attributeString.equals("@")) {
      subClassPredicate.setSubClassAttribute(null);
    } else {
      ClassAttribute classAttribute = parseClassAttribute(attributeString);    
      subClassPredicate.setSubClassAttribute(classAttribute);
    }
    
    expressionString = expressionString.substring(spaceAfterAttribute);
    expressionString = expressionString.trim();
    
    // Expression
    if (!expressionString.startsWith("(")) {
      throw new IllegalArgumentException("'(' expected: " + expressionString);
    }
    if (!expressionString.endsWith(")")) {
      throw new IllegalArgumentException("')' expected: " + expressionString);
    }

    expressionString = expressionString.substring(1, expressionString.length() - 1);
    BooleanExpression filterExpression = parseFilterExpression(expressionString);
    subClassPredicate.setSubClassExpression(filterExpression);
    
    LOGGER.info("<= " + subClassPredicate);
    return subClassPredicate;
  }

  public static InPredicate parseInPredicate(String expressionString) {
    LOGGER.info("=> " + expressionString);
    InPredicate inPredicate = FILTER_EXPR_FACTORY.createInPredicate();
    
    expressionString = expressionString.trim();
    
    
    // Attribute - text before the first space character
    int index = expressionString.indexOf(" ");
    if (index == -1) {
      throw new IllegalArgumentException("no space after class attribute found: " + expressionString);
    }
    String token = expressionString.substring(0, index);
    ClassAttribute attribute = parseClassAttribute(token);
    inPredicate.setAttribute(attribute);
    
    // in operator - text before the next space
    String remainingExpressioString = expressionString.substring(index).trim();
    index = remainingExpressioString.indexOf(" ");
    if (index == -1) {
      throw new IllegalArgumentException("no space after in operator found: " + remainingExpressioString);
    }
    token = remainingExpressioString.substring(0, index);
    InOperator inOperator = parseInOperator(token);
    inPredicate.setInOperator(inOperator);
    
    // Set of Literals
    remainingExpressioString = remainingExpressioString.substring(index).trim();
    if (remainingExpressioString.startsWith("[")  &&
        remainingExpressioString.endsWith("]")) {
      // TODO This simple implementation doesn't handle comma's in string literals.
      remainingExpressioString = remainingExpressioString.substring(1, remainingExpressioString.length() - 1);
      StringTokenizer tokens = new StringTokenizer(remainingExpressioString, ",");
      while (tokens.hasMoreElements()) {
        Literal literal = parseLiteral(tokens.nextToken());
        inPredicate.getLiterals().add(literal);
      }
    } else {
      throw new IllegalArgumentException("no brackets around literals found: " + remainingExpressioString);
    }
        
    LOGGER.info("<= " + inPredicate);
    return inPredicate;
  }
  
  public static ClassAttribute parseClassAttribute(String expressionString) {
    LOGGER.info("=> " + expressionString);
    
    expressionString = expressionString.trim();
    if (!expressionString.startsWith("@")) {
      throw new IllegalArgumentException("Class attribute is not starting with @:" + expressionString);
    }
    expressionString = expressionString.substring(1);
    
    // Handle 'empty' attribute
    if (expressionString.length() == 0) {
      return null;
    }
    
    ClassAttribute classAttribute = FILTER_EXPR_FACTORY.createClassAttribute();
    
    // Handle optional meta operator
    int metaOperatorSeparatorIndex = expressionString.indexOf("^");
    if (metaOperatorSeparatorIndex != -1) {
      String metaOperatorString = expressionString.substring(metaOperatorSeparatorIndex + 1);
      MetaOperator metaOperator = stringToMetaOperator.get(metaOperatorString);
      if (metaOperator == null) {
        LOGGER.severe("Unknown meta operator: " + metaOperatorString);
        throw new IllegalArgumentException("Unknown meta operator: " + metaOperatorString);
      }
      classAttribute.setMetaOperator(metaOperator);
      
      expressionString = expressionString.substring(0, metaOperatorSeparatorIndex);
    }
    
    // Handle optional index
    int openBracketIndex = expressionString.indexOf("[");
    if (openBracketIndex != -1) {
      int closeBracketIndex = expressionString.indexOf("]");
      if (closeBracketIndex == -1) {
        throw new IllegalArgumentException("No matching \']\' found.");
      }
      String indexString = expressionString.substring(openBracketIndex + 1, closeBracketIndex);
      indexString = indexString.trim();
      int index = Integer.valueOf(indexString);
      classAttribute.setIndex(index);
      
      expressionString = expressionString.substring(0, openBracketIndex);
    }
    
    char firstChar = expressionString.charAt(0);
    if (!Character.isLetter(firstChar)) {
      throw new IllegalArgumentException("Attribute name is not starting with a letter: " + expressionString);
    }
    classAttribute.setAttributeName(expressionString);
    
    LOGGER.info("<= " + classAttribute);
    return classAttribute;
  }
  
  public static Literal parseLiteral(String expressionString) {
    LOGGER.info("=> " + expressionString);
    expressionString = expressionString.trim();
    
    Literal literal;
    
    char firstChar = expressionString.charAt(0);
    if (firstChar == '+'  || firstChar == '-' ||
        (firstChar >= '0' && firstChar <= '9')) {
      literal = parseSignedIntegerLiteral(expressionString);
    } else if (firstChar == '\"') {
      literal = parseStringLiteral(expressionString);
    } else if (expressionString.equals("true") ||  expressionString.equals("false")) {
      literal = parseBooleanLiteral(expressionString);
    } else {
      throw new IllegalArgumentException(expressionString);
    }
    
    LOGGER.info("<= " + literal);
    return literal;
  }
  
  public static BooleanLiteral parseBooleanLiteral(String expressionString) {
    LOGGER.info("=> " + expressionString);
    BooleanLiteral booleanLiteral = FILTER_EXPR_FACTORY.createBooleanLiteral();
    
    expressionString = expressionString.trim();
    if (expressionString.equals("true")) {
      booleanLiteral.setValue(true);
    } else if (expressionString.equals("false")) {
      booleanLiteral.setValue(false);
    } else {
      throw new IllegalArgumentException(expressionString);
    }
    
    LOGGER.info("<= " + booleanLiteral);
    return booleanLiteral;
  }
  
  public static SignedIntegerLiteral parseSignedIntegerLiteral(String expressionString) {
    LOGGER.info("=> " + expressionString);
    SignedIntegerLiteral signedIntegerLiteral = FILTER_EXPR_FACTORY.createSignedIntegerLiteral();
    
    expressionString = expressionString.trim();
    signedIntegerLiteral.setValue(Long.parseLong(expressionString));
    
    LOGGER.info("<= " + signedIntegerLiteral);
    return signedIntegerLiteral;
  }
  
  public static StringLiteral parseStringLiteral(String expressionString) {
    LOGGER.info("=> " + expressionString);
    StringLiteral stringLiteral = FILTER_EXPR_FACTORY.createStringLiteral();
    
    expressionString = expressionString.trim();
    if (!expressionString.startsWith("\"")) {
      throw new IllegalArgumentException("String not starting with quotes: " + expressionString);
    }
    if (!expressionString.endsWith("\"")) {
      throw new IllegalArgumentException("String not ending with quotes: " + expressionString);
    }
   
    String value = expressionString.substring(1, expressionString.length() - 1);
    stringLiteral.setValue(value);
    
    LOGGER.info("<= " + stringLiteral);
    return stringLiteral;
  }
  
  public static ComparisonOperator parseComparisonOperator(String expressionString) {
    LOGGER.info("=> " + expressionString);
    expressionString = expressionString.trim();
    
    ComparisonOperator comparisonOperator = stringToComparisonOperator.get(expressionString);
    
    LOGGER.info("<= " + comparisonOperator);
    return comparisonOperator;
  }
  
  public static String comparisonOperatorToString(ComparisonOperator comparisonOperator) {
    return comparisonOperatorToString.get(comparisonOperator);
  }

  public static UnaryLogicalOperator parseUnaryLogicalOperator(String expressionString) {
    LOGGER.info("=> " + expressionString);
    expressionString = expressionString.trim();
    
    UnaryLogicalOperator unaryLogicalOperator = stringToUnaryLogicalOperator.get(expressionString);
    
    LOGGER.info("<= " + unaryLogicalOperator);
    return unaryLogicalOperator;
  }
  
  public static String unaryLogicalOperatorToString(UnaryLogicalOperator unaryLogicalOperator) {
    return unaryLogicalOperatorToString.get(unaryLogicalOperator);
  }
  
  public static DyadicLogicalOperator parseDyadicLogicalOperator(String expressionString) {
    LOGGER.info("=> " + expressionString);
    expressionString = expressionString.trim();
    
    DyadicLogicalOperator dyadicLogicalOperator = stringToDyadicLogicalOperator.get(expressionString);
    
    LOGGER.info("<= " + dyadicLogicalOperator);
    return dyadicLogicalOperator;
  }
  
  public static String dyadicLogicalOperatorToString(DyadicLogicalOperator dyadicLogicalOperator) {
    return dyadicLogicalOperatorToString.get(dyadicLogicalOperator);
  }
  
  public static ListOperator parseListOperator(String expressionString) {
    LOGGER.info("=> " + expressionString);
    expressionString = expressionString.trim();
    
    if (!expressionString.startsWith("#")) {
      throw new IllegalArgumentException("List operator not starting with '#': " + expressionString);
    }
    expressionString = expressionString.substring(1);
    ListOperator listOperator = stringToListOperator.get(expressionString);
    
    LOGGER.info("<= " + listOperator);
    return listOperator;
  }
  
  public static String listOperatorToString(ListOperator listOperator) {
    return "#" + listOperatorToString.get(listOperator);
  }
  
  public static String metaOperatorToString(MetaOperator metaOperator) {
    return metaOperatorToString.get(metaOperator);
  }
  
  public static InOperator parseInOperator(String expressionString) {
    LOGGER.info("=> " + expressionString);
    expressionString = expressionString.trim();
    
    InOperator inOperator = stringToInOperator.get(expressionString);
    
    LOGGER.info("<= " + inOperator);
    return inOperator;
  }
  
  public static String inOperatorToString(InOperator inOperator) {
    return inOperatorToString.get(inOperator);
  }
}
