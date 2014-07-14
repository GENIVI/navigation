/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.booleanexpr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.genivi.booleanexpr.util.FilterExprUtil;
import org.genivi.family.Address;
import org.genivi.family.Family;
import org.genivi.family.FamilyFactory;
import org.genivi.family.Person;
import org.genivi.family.Sexe;
import org.genivi.family.WealthyFamily;
import org.genivi.trafficinfo.demo.logging.EclipseConsoleFormatter;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * About the tests:
 * - Literals and attributes are implicitly tested in predicate tests
 */
public class BooleanExprTests {
  private final static Logger LOGGER = Logger.getLogger(BooleanExprTests.class.getName());
  private static final FamilyFactory FAMILY_FACTORY = FamilyFactory.eINSTANCE;
  
  private static final String FAMILY_SURNAME = "Smith";
  private static final int FAMILY_NUMBER_OF_PETS = 2;
  private static final boolean FAMILY_HAS_SWIMMINGPOOL = false;
  private static final String FAMILY_PERSON_1_FIRSTNAME = "Jim";
  private static final Sexe FAMILY_PERSON_1_SEXE = Sexe.MALE;
  private static final String FAMILY_PERSON_2_FIRSTNAME = "John";
  private static final Sexe FAMILY_PERSON_2_SEXE = Sexe.MALE;
  private static final String FAMILY_ADDRESS_STREET = "PacificHwy";
  private static final String[] FAMILY_FAVORITE_HOLIDAY_DESTINATIONS = {
    "Egypt", "Austria"
  };
  
  private static final String WEALTHY_FAMILY_SURNAME = "Slim";
  private static final boolean WEALTHY_FAMILY_HAS_SWIMMINGPOOL = true;
  private static final int WEALTHY_FAMILY_FORBES_RANKING = 1;
  
  private static Family family;
  private static Family wealthyFamily;
  private final static Level logLevel = Level.SEVERE;
  
  @BeforeClass
  public static void setUp() {
    logSetup();
    
    family = createFamily();
    wealthyFamily = createWealthyFamily();
    LOGGER.info("family = " + family);
  }

  @Test
  public void testUnaryExpression() {
    String expressionString;
    BooleanExpression expression;

    expressionString = "not (@surname != \"" + FAMILY_SURNAME + "\")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));

    expressionString = "not (@surname != \"Adams\")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
  }

  @Test
  public void testDyadicExpression() {
    String expressionString;
    BooleanExpression expression;

    expressionString = "(@surname == \"" + FAMILY_SURNAME + "\") and (@numberOfPets == " + FAMILY_NUMBER_OF_PETS + ")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));

    expressionString = "(@surname != \"" + FAMILY_SURNAME + "\") and (@numberOfPets == " + FAMILY_NUMBER_OF_PETS + ")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));

    expressionString = "(@surname != \"" + FAMILY_SURNAME + "\") or (@numberOfPets == " + FAMILY_NUMBER_OF_PETS + ")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
  }

  @Test
  public void testComparisonPredicate() {
    String expressionString;
    BooleanExpression expression;
    
    // Test all supported operations for type String (only EQUAL, NOT_EQUAL)
    expressionString = "@surname == \"" + FAMILY_SURNAME + "\"";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));

    
    expressionString = "@surname == \"Adams\"";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@surname != \"" + FAMILY_SURNAME + "\"";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));

    expressionString = "@surname != \"Adams\"";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));    
    
    // Test all supported operations for type Integer (all operations)
    expressionString = "@numberOfPets == " + FAMILY_NUMBER_OF_PETS;
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@numberOfPets == " + 99;
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@numberOfPets != " + 99;
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@numberOfPets != " + FAMILY_NUMBER_OF_PETS;
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@numberOfPets > " + -1;
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@numberOfPets > " + FAMILY_NUMBER_OF_PETS;
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@numberOfPets >= " + -1;
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@numberOfPets >= " + (FAMILY_NUMBER_OF_PETS + 1);
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@numberOfPets < " + 1000;
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@numberOfPets < " + FAMILY_NUMBER_OF_PETS;
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@numberOfPets <= " + FAMILY_NUMBER_OF_PETS;
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@numberOfPets <= " + (FAMILY_NUMBER_OF_PETS - 1);
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
    
    // Test all supported operations for type boolean (only EQUAL, NOT_EQUAL)
    expressionString = "@hasASwimmingPool == " + FAMILY_HAS_SWIMMINGPOOL;
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@hasASwimmingPool == " + !FAMILY_HAS_SWIMMINGPOOL;
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@hasASwimmingPool != " + !FAMILY_HAS_SWIMMINGPOOL;
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@hasASwimmingPool != " + FAMILY_HAS_SWIMMINGPOOL;
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
    
  }
  
  @Test
  public void testSubClassPredicate() {
    String expressionString;
    BooleanExpression expression;

    expressionString = "@address (@street == \"" + FAMILY_ADDRESS_STREET + "\")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));

    expressionString = "@address (@street != \"" + FAMILY_ADDRESS_STREET + "\")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
  }

  @Test
  public void testDownCastPredicate() {
    String expressionString;
    BooleanExpression expression;
    
    expressionString = "[@WealthyFamily](@forbesRanking < 100)";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(wealthyFamily));
    
    
    expressionString = "[@WealthyFamily](@forbesRanking != 1)";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(wealthyFamily));
  }

  @Test
  public void testIsSetPredicate() {
    String expressionString;
    BooleanExpression expression;

    expressionString = "isSet @numberOfPets";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
    assertFalse("Wrong evaluation result", expression.evaluate(wealthyFamily));
  }
  
  @Test
  public void testInPredicate() {
    String expressionString;
    BooleanExpression expression;

    expressionString = "@surname in [\"Dummy\", \"Smith\", \"Dummy2\"]";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));

    expressionString = "@surname in [\"Dummy\", \"Dummy3\", \"Dummy2\"]";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));

    expressionString = "@surname not-in [\"Dummy\", \"Smith\", \"Dummy2\"]";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));

    expressionString = "@surname not-in [\"Dummy\", \"Dummy3\", \"Dummy2\"]";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));

    expressionString = "@numberOfPets in [2, 3, 4]";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));

    expressionString = "@numberOfPets in [4, 3, 2]";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));

    expressionString = "@numberOfPets in [4, 3, 12]";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));

    expressionString = "@numberOfPets not-in [2, 3, 4]";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));

    expressionString = "@numberOfPets not-in [4, 3, 2]";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));

    expressionString = "@numberOfPets not-in [4, 3, 12]";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
  }

  @Test
  public void testMultiplicityPredicate() {
    String expressionString;
    BooleanExpression expression;

    // ANY
    expressionString = "#any @members (@firstName == \"" + FAMILY_PERSON_1_FIRSTNAME + "\")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "#any @members (@firstName == \"Susan\")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));

    expressionString = "#any @favoriteHolidayDestinations (@ in [\"Netherlands\", \"Egypt\"])";
    System.out.println(expressionString);
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));

    // ALL
    expressionString = "#all @members (@sexe == " + Sexe.MALE.getValue() + ")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));

    expressionString = "#all @members (@firstName == \"" + FAMILY_PERSON_1_FIRSTNAME + "\")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
    
    // NONE
    expressionString = "#none @members (@sexe == " + Sexe.FEMALE.getValue() + ")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "#none @members (@sexe == " + Sexe.MALE.getValue() + ")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
    
    // MetaOperator
    expressionString = "@members^size == 2";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@members^size == 4";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
    
    // index
    expressionString = "@members[1] (@firstName == \"" + FAMILY_PERSON_2_FIRSTNAME + "\")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertTrue("Wrong evaluation result", expression.evaluate(family));
    
    expressionString = "@members[0] (@firstName == \"" + FAMILY_PERSON_2_FIRSTNAME + "\")";
    expression = FilterExprUtil.parseFilterExpression(expressionString);
    assertEquals("Error in expression translation", expressionString, expression.toString());
    assertFalse("Wrong evaluation result", expression.evaluate(family));
  }

  private static void logSetup() {
    // Create Logger
    Logger logger = Logger.getLogger("");
    logger.setLevel(logLevel);
    
    Handler consoleHandler = null;
    for (Handler handler: logger.getHandlers()) {
      if (handler.getClass().getName().equals("java.util.logging.ConsoleHandler")) {
        consoleHandler = handler;
        break;
      }
    }
    consoleHandler.setFormatter(new EclipseConsoleFormatter());
    consoleHandler.setLevel(Level.INFO);
  }
  
  private static Family createFamily() {
    Family family = FAMILY_FACTORY.createFamily();
    
    family.setSurname(FAMILY_SURNAME);
    family.setNumberOfPets(FAMILY_NUMBER_OF_PETS);
    family.setHasASwimmingPool(FAMILY_HAS_SWIMMINGPOOL);
    
    Person person;
    
    person = FAMILY_FACTORY.createPerson();
    person.setFirstName(FAMILY_PERSON_1_FIRSTNAME);
    person.setSexe(FAMILY_PERSON_1_SEXE);
    family.getMembers().add(person);
    
    person = FAMILY_FACTORY.createPerson();
    person.setFirstName(FAMILY_PERSON_2_FIRSTNAME);
    person.setSexe(FAMILY_PERSON_2_SEXE);
    family.getMembers().add(person);
    
    Address address = FAMILY_FACTORY.createAddress();
    address.setStreet(FAMILY_ADDRESS_STREET);
    family.setAddress(address);
    
    for (String destination: FAMILY_FAVORITE_HOLIDAY_DESTINATIONS) {
      family.getFavoriteHolidayDestinations().add(destination);
    }
    
    return family;
  }
  
  private static Family createWealthyFamily() {
    WealthyFamily family = FAMILY_FACTORY.createWealthyFamily();
    
    family.setSurname(WEALTHY_FAMILY_SURNAME);
    family.setHasASwimmingPool(WEALTHY_FAMILY_HAS_SWIMMINGPOOL);
    family.setForbesRanking(WEALTHY_FAMILY_FORBES_RANKING);
    
    return family;
  }
}
