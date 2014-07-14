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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.genivi.booleanexpr.FilterexprFactory
 * @model kind="package"
 *        annotation="GenModel documentation='Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/.'"
 * @generated
 */
public interface FilterexprPackage extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "booleanexpr";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://org.genivi.booleanexpr";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "booleanexpr";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  FilterexprPackage eINSTANCE = org.genivi.booleanexpr.impl.FilterexprPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.BooleanExpressionImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getBooleanExpression()
	 * @generated
	 */
  int BOOLEAN_EXPRESSION = 0;

  /**
	 * The number of structural features of the '<em>Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int BOOLEAN_EXPRESSION_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.UnaryExpressionImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getUnaryExpression()
	 * @generated
	 */
  int UNARY_EXPRESSION = 1;

  /**
	 * The feature id for the '<em><b>Unary Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UNARY_EXPRESSION__UNARY_OPERATOR = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UNARY_EXPRESSION__EXPRESSION = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UNARY_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.PredicateImpl <em>Predicate</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.PredicateImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getPredicate()
	 * @generated
	 */
  int PREDICATE = 2;

  /**
	 * The number of structural features of the '<em>Predicate</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PREDICATE_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.DyadicExpressionImpl <em>Dyadic Expression</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.DyadicExpressionImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getDyadicExpression()
	 * @generated
	 */
  int DYADIC_EXPRESSION = 3;

  /**
	 * The feature id for the '<em><b>Logical Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DYADIC_EXPRESSION__LOGICAL_OPERATOR = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Left Hand Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DYADIC_EXPRESSION__LEFT_HAND_TERM = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Right Hand Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DYADIC_EXPRESSION__RIGHT_HAND_TERM = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Dyadic Expression</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DYADIC_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.ComparisonPredicateImpl <em>Comparison Predicate</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.ComparisonPredicateImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getComparisonPredicate()
	 * @generated
	 */
  int COMPARISON_PREDICATE = 4;

  /**
	 * The feature id for the '<em><b>Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COMPARISON_PREDICATE__LITERAL = PREDICATE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COMPARISON_PREDICATE__ATTRIBUTE = PREDICATE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Comparison Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COMPARISON_PREDICATE__COMPARISON_OPERATOR = PREDICATE_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Comparison Predicate</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COMPARISON_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.InPredicateImpl <em>In Predicate</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.InPredicateImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getInPredicate()
	 * @generated
	 */
  int IN_PREDICATE = 5;

  /**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IN_PREDICATE__ATTRIBUTE = PREDICATE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>In Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IN_PREDICATE__IN_OPERATOR = PREDICATE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IN_PREDICATE__LITERALS = PREDICATE_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>In Predicate</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IN_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.LiteralImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getLiteral()
	 * @generated
	 */
  int LITERAL = 6;

  /**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LITERAL_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.SignedIntegerLiteralImpl <em>Signed Integer Literal</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.SignedIntegerLiteralImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getSignedIntegerLiteral()
	 * @generated
	 */
  int SIGNED_INTEGER_LITERAL = 7;

  /**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SIGNED_INTEGER_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Signed Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SIGNED_INTEGER_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.StringLiteralImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getStringLiteral()
	 * @generated
	 */
  int STRING_LITERAL = 8;

  /**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int STRING_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int STRING_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.BooleanLiteralImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getBooleanLiteral()
	 * @generated
	 */
  int BOOLEAN_LITERAL = 9;

  /**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int BOOLEAN_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int BOOLEAN_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.SubClassPredicateImpl <em>Sub Class Predicate</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.SubClassPredicateImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getSubClassPredicate()
	 * @generated
	 */
  int SUB_CLASS_PREDICATE = 10;

  /**
	 * The feature id for the '<em><b>Sub Class Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION = PREDICATE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Sub Class Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE = PREDICATE_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Sub Class Predicate</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SUB_CLASS_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.ClassAttributeImpl <em>Class Attribute</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.ClassAttributeImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getClassAttribute()
	 * @generated
	 */
  int CLASS_ATTRIBUTE = 11;

  /**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CLASS_ATTRIBUTE__ATTRIBUTE_NAME = 0;

  /**
	 * The feature id for the '<em><b>Meta Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CLASS_ATTRIBUTE__META_OPERATOR = 1;

  /**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CLASS_ATTRIBUTE__INDEX = 2;

  /**
	 * The number of structural features of the '<em>Class Attribute</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CLASS_ATTRIBUTE_FEATURE_COUNT = 3;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.DownCastPredicateImpl <em>Down Cast Predicate</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.DownCastPredicateImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getDownCastPredicate()
	 * @generated
	 */
  int DOWN_CAST_PREDICATE = 12;

  /**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOWN_CAST_PREDICATE__CLASS_NAME = PREDICATE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOWN_CAST_PREDICATE__EXPRESSION = PREDICATE_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Down Cast Predicate</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOWN_CAST_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.MultiplicityPredicateImpl <em>Multiplicity Predicate</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.MultiplicityPredicateImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getMultiplicityPredicate()
	 * @generated
	 */
  int MULTIPLICITY_PREDICATE = 13;

  /**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MULTIPLICITY_PREDICATE__EXPRESSION = PREDICATE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MULTIPLICITY_PREDICATE__ATTRIBUTE = PREDICATE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>List Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MULTIPLICITY_PREDICATE__LIST_OPERATOR = PREDICATE_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Multiplicity Predicate</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MULTIPLICITY_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.impl.IsSetPredicateImpl <em>Is Set Predicate</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.impl.IsSetPredicateImpl
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getIsSetPredicate()
	 * @generated
	 */
  int IS_SET_PREDICATE = 14;

  /**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IS_SET_PREDICATE__ATTRIBUTE = PREDICATE_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Is Set Predicate</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IS_SET_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.DyadicLogicalOperator <em>Dyadic Logical Operator</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.DyadicLogicalOperator
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getDyadicLogicalOperator()
	 * @generated
	 */
  int DYADIC_LOGICAL_OPERATOR = 15;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.UnaryLogicalOperator <em>Unary Logical Operator</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.UnaryLogicalOperator
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getUnaryLogicalOperator()
	 * @generated
	 */
  int UNARY_LOGICAL_OPERATOR = 16;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.ComparisonOperator <em>Comparison Operator</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.ComparisonOperator
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getComparisonOperator()
	 * @generated
	 */
  int COMPARISON_OPERATOR = 17;


  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.ListOperator <em>List Operator</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.ListOperator
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getListOperator()
	 * @generated
	 */
  int LIST_OPERATOR = 18;

  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.InOperator <em>In Operator</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.InOperator
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getInOperator()
	 * @generated
	 */
  int IN_OPERATOR = 19;


  /**
	 * The meta object id for the '{@link org.genivi.booleanexpr.MetaOperator <em>Meta Operator</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.booleanexpr.MetaOperator
	 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getMetaOperator()
	 * @generated
	 */
  int META_OPERATOR = 20;


  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.BooleanExpression <em>Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Expression</em>'.
	 * @see org.genivi.booleanexpr.BooleanExpression
	 * @generated
	 */
  EClass getBooleanExpression();

  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expression</em>'.
	 * @see org.genivi.booleanexpr.UnaryExpression
	 * @generated
	 */
  EClass getUnaryExpression();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.booleanexpr.UnaryExpression#getUnaryOperator <em>Unary Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unary Operator</em>'.
	 * @see org.genivi.booleanexpr.UnaryExpression#getUnaryOperator()
	 * @see #getUnaryExpression()
	 * @generated
	 */
  EAttribute getUnaryExpression_UnaryOperator();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.booleanexpr.UnaryExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.genivi.booleanexpr.UnaryExpression#getExpression()
	 * @see #getUnaryExpression()
	 * @generated
	 */
  EReference getUnaryExpression_Expression();

  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.Predicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate</em>'.
	 * @see org.genivi.booleanexpr.Predicate
	 * @generated
	 */
  EClass getPredicate();

  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.DyadicExpression <em>Dyadic Expression</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dyadic Expression</em>'.
	 * @see org.genivi.booleanexpr.DyadicExpression
	 * @generated
	 */
  EClass getDyadicExpression();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.booleanexpr.DyadicExpression#getLogicalOperator <em>Logical Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logical Operator</em>'.
	 * @see org.genivi.booleanexpr.DyadicExpression#getLogicalOperator()
	 * @see #getDyadicExpression()
	 * @generated
	 */
  EAttribute getDyadicExpression_LogicalOperator();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.booleanexpr.DyadicExpression#getLeftHandTerm <em>Left Hand Term</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Hand Term</em>'.
	 * @see org.genivi.booleanexpr.DyadicExpression#getLeftHandTerm()
	 * @see #getDyadicExpression()
	 * @generated
	 */
  EReference getDyadicExpression_LeftHandTerm();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.booleanexpr.DyadicExpression#getRightHandTerm <em>Right Hand Term</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Hand Term</em>'.
	 * @see org.genivi.booleanexpr.DyadicExpression#getRightHandTerm()
	 * @see #getDyadicExpression()
	 * @generated
	 */
  EReference getDyadicExpression_RightHandTerm();

  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.ComparisonPredicate <em>Comparison Predicate</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comparison Predicate</em>'.
	 * @see org.genivi.booleanexpr.ComparisonPredicate
	 * @generated
	 */
  EClass getComparisonPredicate();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.booleanexpr.ComparisonPredicate#getComparisonOperator <em>Comparison Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comparison Operator</em>'.
	 * @see org.genivi.booleanexpr.ComparisonPredicate#getComparisonOperator()
	 * @see #getComparisonPredicate()
	 * @generated
	 */
  EAttribute getComparisonPredicate_ComparisonOperator();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.booleanexpr.ComparisonPredicate#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Literal</em>'.
	 * @see org.genivi.booleanexpr.ComparisonPredicate#getLiteral()
	 * @see #getComparisonPredicate()
	 * @generated
	 */
  EReference getComparisonPredicate_Literal();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.booleanexpr.ComparisonPredicate#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attribute</em>'.
	 * @see org.genivi.booleanexpr.ComparisonPredicate#getAttribute()
	 * @see #getComparisonPredicate()
	 * @generated
	 */
  EReference getComparisonPredicate_Attribute();

  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.InPredicate <em>In Predicate</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Predicate</em>'.
	 * @see org.genivi.booleanexpr.InPredicate
	 * @generated
	 */
  EClass getInPredicate();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.booleanexpr.InPredicate#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attribute</em>'.
	 * @see org.genivi.booleanexpr.InPredicate#getAttribute()
	 * @see #getInPredicate()
	 * @generated
	 */
  EReference getInPredicate_Attribute();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.booleanexpr.InPredicate#getInOperator <em>In Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>In Operator</em>'.
	 * @see org.genivi.booleanexpr.InPredicate#getInOperator()
	 * @see #getInPredicate()
	 * @generated
	 */
  EAttribute getInPredicate_InOperator();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.booleanexpr.InPredicate#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see org.genivi.booleanexpr.InPredicate#getLiterals()
	 * @see #getInPredicate()
	 * @generated
	 */
  EReference getInPredicate_Literals();

  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see org.genivi.booleanexpr.Literal
	 * @generated
	 */
  EClass getLiteral();

  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.SignedIntegerLiteral <em>Signed Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signed Integer Literal</em>'.
	 * @see org.genivi.booleanexpr.SignedIntegerLiteral
	 * @generated
	 */
  EClass getSignedIntegerLiteral();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.booleanexpr.SignedIntegerLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.genivi.booleanexpr.SignedIntegerLiteral#getValue()
	 * @see #getSignedIntegerLiteral()
	 * @generated
	 */
  EAttribute getSignedIntegerLiteral_Value();

  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see org.genivi.booleanexpr.StringLiteral
	 * @generated
	 */
  EClass getStringLiteral();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.booleanexpr.StringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.genivi.booleanexpr.StringLiteral#getValue()
	 * @see #getStringLiteral()
	 * @generated
	 */
  EAttribute getStringLiteral_Value();

  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal</em>'.
	 * @see org.genivi.booleanexpr.BooleanLiteral
	 * @generated
	 */
  EClass getBooleanLiteral();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.booleanexpr.BooleanLiteral#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.genivi.booleanexpr.BooleanLiteral#isValue()
	 * @see #getBooleanLiteral()
	 * @generated
	 */
  EAttribute getBooleanLiteral_Value();

  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.SubClassPredicate <em>Sub Class Predicate</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Class Predicate</em>'.
	 * @see org.genivi.booleanexpr.SubClassPredicate
	 * @generated
	 */
  EClass getSubClassPredicate();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.booleanexpr.SubClassPredicate#getSubClassExpression <em>Sub Class Expression</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Class Expression</em>'.
	 * @see org.genivi.booleanexpr.SubClassPredicate#getSubClassExpression()
	 * @see #getSubClassPredicate()
	 * @generated
	 */
  EReference getSubClassPredicate_SubClassExpression();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.booleanexpr.SubClassPredicate#getSubClassAttribute <em>Sub Class Attribute</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Class Attribute</em>'.
	 * @see org.genivi.booleanexpr.SubClassPredicate#getSubClassAttribute()
	 * @see #getSubClassPredicate()
	 * @generated
	 */
  EReference getSubClassPredicate_SubClassAttribute();

  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.ClassAttribute <em>Class Attribute</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Attribute</em>'.
	 * @see org.genivi.booleanexpr.ClassAttribute
	 * @generated
	 */
  EClass getClassAttribute();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.booleanexpr.ClassAttribute#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see org.genivi.booleanexpr.ClassAttribute#getAttributeName()
	 * @see #getClassAttribute()
	 * @generated
	 */
  EAttribute getClassAttribute_AttributeName();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.booleanexpr.ClassAttribute#getMetaOperator <em>Meta Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Operator</em>'.
	 * @see org.genivi.booleanexpr.ClassAttribute#getMetaOperator()
	 * @see #getClassAttribute()
	 * @generated
	 */
  EAttribute getClassAttribute_MetaOperator();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.booleanexpr.ClassAttribute#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.genivi.booleanexpr.ClassAttribute#getIndex()
	 * @see #getClassAttribute()
	 * @generated
	 */
  EAttribute getClassAttribute_Index();

  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.DownCastPredicate <em>Down Cast Predicate</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Down Cast Predicate</em>'.
	 * @see org.genivi.booleanexpr.DownCastPredicate
	 * @generated
	 */
  EClass getDownCastPredicate();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.booleanexpr.DownCastPredicate#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.genivi.booleanexpr.DownCastPredicate#getClassName()
	 * @see #getDownCastPredicate()
	 * @generated
	 */
  EAttribute getDownCastPredicate_ClassName();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.booleanexpr.DownCastPredicate#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.genivi.booleanexpr.DownCastPredicate#getExpression()
	 * @see #getDownCastPredicate()
	 * @generated
	 */
  EReference getDownCastPredicate_Expression();

  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.MultiplicityPredicate <em>Multiplicity Predicate</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity Predicate</em>'.
	 * @see org.genivi.booleanexpr.MultiplicityPredicate
	 * @generated
	 */
  EClass getMultiplicityPredicate();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.booleanexpr.MultiplicityPredicate#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.genivi.booleanexpr.MultiplicityPredicate#getExpression()
	 * @see #getMultiplicityPredicate()
	 * @generated
	 */
  EReference getMultiplicityPredicate_Expression();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.booleanexpr.MultiplicityPredicate#getListOperator <em>List Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>List Operator</em>'.
	 * @see org.genivi.booleanexpr.MultiplicityPredicate#getListOperator()
	 * @see #getMultiplicityPredicate()
	 * @generated
	 */
  EAttribute getMultiplicityPredicate_ListOperator();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.booleanexpr.MultiplicityPredicate#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attribute</em>'.
	 * @see org.genivi.booleanexpr.MultiplicityPredicate#getAttribute()
	 * @see #getMultiplicityPredicate()
	 * @generated
	 */
  EReference getMultiplicityPredicate_Attribute();

  /**
	 * Returns the meta object for class '{@link org.genivi.booleanexpr.IsSetPredicate <em>Is Set Predicate</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Set Predicate</em>'.
	 * @see org.genivi.booleanexpr.IsSetPredicate
	 * @generated
	 */
  EClass getIsSetPredicate();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.booleanexpr.IsSetPredicate#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attribute</em>'.
	 * @see org.genivi.booleanexpr.IsSetPredicate#getAttribute()
	 * @see #getIsSetPredicate()
	 * @generated
	 */
  EReference getIsSetPredicate_Attribute();

  /**
	 * Returns the meta object for enum '{@link org.genivi.booleanexpr.DyadicLogicalOperator <em>Dyadic Logical Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dyadic Logical Operator</em>'.
	 * @see org.genivi.booleanexpr.DyadicLogicalOperator
	 * @generated
	 */
  EEnum getDyadicLogicalOperator();

  /**
	 * Returns the meta object for enum '{@link org.genivi.booleanexpr.UnaryLogicalOperator <em>Unary Logical Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unary Logical Operator</em>'.
	 * @see org.genivi.booleanexpr.UnaryLogicalOperator
	 * @generated
	 */
  EEnum getUnaryLogicalOperator();

  /**
	 * Returns the meta object for enum '{@link org.genivi.booleanexpr.ComparisonOperator <em>Comparison Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Comparison Operator</em>'.
	 * @see org.genivi.booleanexpr.ComparisonOperator
	 * @generated
	 */
  EEnum getComparisonOperator();

  /**
	 * Returns the meta object for enum '{@link org.genivi.booleanexpr.ListOperator <em>List Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>List Operator</em>'.
	 * @see org.genivi.booleanexpr.ListOperator
	 * @generated
	 */
  EEnum getListOperator();

  /**
	 * Returns the meta object for enum '{@link org.genivi.booleanexpr.InOperator <em>In Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>In Operator</em>'.
	 * @see org.genivi.booleanexpr.InOperator
	 * @generated
	 */
  EEnum getInOperator();

  /**
	 * Returns the meta object for enum '{@link org.genivi.booleanexpr.MetaOperator <em>Meta Operator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Meta Operator</em>'.
	 * @see org.genivi.booleanexpr.MetaOperator
	 * @generated
	 */
  EEnum getMetaOperator();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  FilterexprFactory getFilterexprFactory();

  /**
	 * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
	 * @generated
	 */
  interface Literals {
    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.BooleanExpressionImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getBooleanExpression()
		 * @generated
		 */
    EClass BOOLEAN_EXPRESSION = eINSTANCE.getBooleanExpression();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.UnaryExpressionImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getUnaryExpression()
		 * @generated
		 */
    EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

    /**
		 * The meta object literal for the '<em><b>Unary Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute UNARY_EXPRESSION__UNARY_OPERATOR = eINSTANCE.getUnaryExpression_UnaryOperator();

    /**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference UNARY_EXPRESSION__EXPRESSION = eINSTANCE.getUnaryExpression_Expression();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.PredicateImpl <em>Predicate</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.PredicateImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getPredicate()
		 * @generated
		 */
    EClass PREDICATE = eINSTANCE.getPredicate();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.DyadicExpressionImpl <em>Dyadic Expression</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.DyadicExpressionImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getDyadicExpression()
		 * @generated
		 */
    EClass DYADIC_EXPRESSION = eINSTANCE.getDyadicExpression();

    /**
		 * The meta object literal for the '<em><b>Logical Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute DYADIC_EXPRESSION__LOGICAL_OPERATOR = eINSTANCE.getDyadicExpression_LogicalOperator();

    /**
		 * The meta object literal for the '<em><b>Left Hand Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DYADIC_EXPRESSION__LEFT_HAND_TERM = eINSTANCE.getDyadicExpression_LeftHandTerm();

    /**
		 * The meta object literal for the '<em><b>Right Hand Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DYADIC_EXPRESSION__RIGHT_HAND_TERM = eINSTANCE.getDyadicExpression_RightHandTerm();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.ComparisonPredicateImpl <em>Comparison Predicate</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.ComparisonPredicateImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getComparisonPredicate()
		 * @generated
		 */
    EClass COMPARISON_PREDICATE = eINSTANCE.getComparisonPredicate();

    /**
		 * The meta object literal for the '<em><b>Comparison Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute COMPARISON_PREDICATE__COMPARISON_OPERATOR = eINSTANCE.getComparisonPredicate_ComparisonOperator();

    /**
		 * The meta object literal for the '<em><b>Literal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference COMPARISON_PREDICATE__LITERAL = eINSTANCE.getComparisonPredicate_Literal();

    /**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference COMPARISON_PREDICATE__ATTRIBUTE = eINSTANCE.getComparisonPredicate_Attribute();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.InPredicateImpl <em>In Predicate</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.InPredicateImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getInPredicate()
		 * @generated
		 */
    EClass IN_PREDICATE = eINSTANCE.getInPredicate();

    /**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference IN_PREDICATE__ATTRIBUTE = eINSTANCE.getInPredicate_Attribute();

    /**
		 * The meta object literal for the '<em><b>In Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute IN_PREDICATE__IN_OPERATOR = eINSTANCE.getInPredicate_InOperator();

    /**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference IN_PREDICATE__LITERALS = eINSTANCE.getInPredicate_Literals();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.LiteralImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getLiteral()
		 * @generated
		 */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.SignedIntegerLiteralImpl <em>Signed Integer Literal</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.SignedIntegerLiteralImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getSignedIntegerLiteral()
		 * @generated
		 */
    EClass SIGNED_INTEGER_LITERAL = eINSTANCE.getSignedIntegerLiteral();

    /**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SIGNED_INTEGER_LITERAL__VALUE = eINSTANCE.getSignedIntegerLiteral_Value();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.StringLiteralImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getStringLiteral()
		 * @generated
		 */
    EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

    /**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.BooleanLiteralImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getBooleanLiteral()
		 * @generated
		 */
    EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

    /**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute BOOLEAN_LITERAL__VALUE = eINSTANCE.getBooleanLiteral_Value();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.SubClassPredicateImpl <em>Sub Class Predicate</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.SubClassPredicateImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getSubClassPredicate()
		 * @generated
		 */
    EClass SUB_CLASS_PREDICATE = eINSTANCE.getSubClassPredicate();

    /**
		 * The meta object literal for the '<em><b>Sub Class Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION = eINSTANCE.getSubClassPredicate_SubClassExpression();

    /**
		 * The meta object literal for the '<em><b>Sub Class Attribute</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE = eINSTANCE.getSubClassPredicate_SubClassAttribute();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.ClassAttributeImpl <em>Class Attribute</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.ClassAttributeImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getClassAttribute()
		 * @generated
		 */
    EClass CLASS_ATTRIBUTE = eINSTANCE.getClassAttribute();

    /**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CLASS_ATTRIBUTE__ATTRIBUTE_NAME = eINSTANCE.getClassAttribute_AttributeName();

    /**
		 * The meta object literal for the '<em><b>Meta Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CLASS_ATTRIBUTE__META_OPERATOR = eINSTANCE.getClassAttribute_MetaOperator();

    /**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CLASS_ATTRIBUTE__INDEX = eINSTANCE.getClassAttribute_Index();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.DownCastPredicateImpl <em>Down Cast Predicate</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.DownCastPredicateImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getDownCastPredicate()
		 * @generated
		 */
    EClass DOWN_CAST_PREDICATE = eINSTANCE.getDownCastPredicate();

    /**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute DOWN_CAST_PREDICATE__CLASS_NAME = eINSTANCE.getDownCastPredicate_ClassName();

    /**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DOWN_CAST_PREDICATE__EXPRESSION = eINSTANCE.getDownCastPredicate_Expression();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.MultiplicityPredicateImpl <em>Multiplicity Predicate</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.MultiplicityPredicateImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getMultiplicityPredicate()
		 * @generated
		 */
    EClass MULTIPLICITY_PREDICATE = eINSTANCE.getMultiplicityPredicate();

    /**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference MULTIPLICITY_PREDICATE__EXPRESSION = eINSTANCE.getMultiplicityPredicate_Expression();

    /**
		 * The meta object literal for the '<em><b>List Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute MULTIPLICITY_PREDICATE__LIST_OPERATOR = eINSTANCE.getMultiplicityPredicate_ListOperator();

    /**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference MULTIPLICITY_PREDICATE__ATTRIBUTE = eINSTANCE.getMultiplicityPredicate_Attribute();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.impl.IsSetPredicateImpl <em>Is Set Predicate</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.impl.IsSetPredicateImpl
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getIsSetPredicate()
		 * @generated
		 */
    EClass IS_SET_PREDICATE = eINSTANCE.getIsSetPredicate();

    /**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference IS_SET_PREDICATE__ATTRIBUTE = eINSTANCE.getIsSetPredicate_Attribute();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.DyadicLogicalOperator <em>Dyadic Logical Operator</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.DyadicLogicalOperator
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getDyadicLogicalOperator()
		 * @generated
		 */
    EEnum DYADIC_LOGICAL_OPERATOR = eINSTANCE.getDyadicLogicalOperator();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.UnaryLogicalOperator <em>Unary Logical Operator</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.UnaryLogicalOperator
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getUnaryLogicalOperator()
		 * @generated
		 */
    EEnum UNARY_LOGICAL_OPERATOR = eINSTANCE.getUnaryLogicalOperator();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.ComparisonOperator <em>Comparison Operator</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.ComparisonOperator
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getComparisonOperator()
		 * @generated
		 */
    EEnum COMPARISON_OPERATOR = eINSTANCE.getComparisonOperator();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.ListOperator <em>List Operator</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.ListOperator
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getListOperator()
		 * @generated
		 */
    EEnum LIST_OPERATOR = eINSTANCE.getListOperator();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.InOperator <em>In Operator</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.InOperator
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getInOperator()
		 * @generated
		 */
    EEnum IN_OPERATOR = eINSTANCE.getInOperator();

    /**
		 * The meta object literal for the '{@link org.genivi.booleanexpr.MetaOperator <em>Meta Operator</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.booleanexpr.MetaOperator
		 * @see org.genivi.booleanexpr.impl.FilterexprPackageImpl#getMetaOperator()
		 * @generated
		 */
    EEnum META_OPERATOR = eINSTANCE.getMetaOperator();

  }

} //FilterexprPackage
