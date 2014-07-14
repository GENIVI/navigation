/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.booleanexpr.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.genivi.booleanexpr.BooleanExpression;
import org.genivi.booleanexpr.BooleanLiteral;
import org.genivi.booleanexpr.ClassAttribute;
import org.genivi.booleanexpr.ComparisonOperator;
import org.genivi.booleanexpr.ComparisonPredicate;
import org.genivi.booleanexpr.DownCastPredicate;
import org.genivi.booleanexpr.DyadicExpression;
import org.genivi.booleanexpr.DyadicLogicalOperator;
import org.genivi.booleanexpr.FilterexprFactory;
import org.genivi.booleanexpr.FilterexprPackage;
import org.genivi.booleanexpr.InOperator;
import org.genivi.booleanexpr.InPredicate;
import org.genivi.booleanexpr.IsSetPredicate;
import org.genivi.booleanexpr.ListOperator;
import org.genivi.booleanexpr.Literal;
import org.genivi.booleanexpr.MetaOperator;
import org.genivi.booleanexpr.MultiplicityPredicate;
import org.genivi.booleanexpr.Predicate;
import org.genivi.booleanexpr.SignedIntegerLiteral;
import org.genivi.booleanexpr.StringLiteral;
import org.genivi.booleanexpr.SubClassPredicate;
import org.genivi.booleanexpr.UnaryExpression;
import org.genivi.booleanexpr.UnaryLogicalOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FilterexprPackageImpl extends EPackageImpl implements FilterexprPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass booleanExpressionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass unaryExpressionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass predicateEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass dyadicExpressionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass comparisonPredicateEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass inPredicateEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass literalEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass signedIntegerLiteralEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass stringLiteralEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass booleanLiteralEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass subClassPredicateEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass classAttributeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass downCastPredicateEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass multiplicityPredicateEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass isSetPredicateEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum dyadicLogicalOperatorEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum unaryLogicalOperatorEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum comparisonOperatorEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum listOperatorEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum inOperatorEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum metaOperatorEEnum = null;

  /**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.genivi.booleanexpr.FilterexprPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private FilterexprPackageImpl() {
		super(eNS_URI, FilterexprFactory.eINSTANCE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static boolean isInited = false;

  /**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FilterexprPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static FilterexprPackage init() {
		if (isInited) return (FilterexprPackage)EPackage.Registry.INSTANCE.getEPackage(FilterexprPackage.eNS_URI);

		// Obtain or create and register package
		FilterexprPackageImpl theFilterexprPackage = (FilterexprPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FilterexprPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FilterexprPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theFilterexprPackage.createPackageContents();

		// Initialize created meta-data
		theFilterexprPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFilterexprPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FilterexprPackage.eNS_URI, theFilterexprPackage);
		return theFilterexprPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getBooleanExpression() {
		return booleanExpressionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getUnaryExpression() {
		return unaryExpressionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getUnaryExpression_UnaryOperator() {
		return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getUnaryExpression_Expression() {
		return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getPredicate() {
		return predicateEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDyadicExpression() {
		return dyadicExpressionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDyadicExpression_LogicalOperator() {
		return (EAttribute)dyadicExpressionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDyadicExpression_LeftHandTerm() {
		return (EReference)dyadicExpressionEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDyadicExpression_RightHandTerm() {
		return (EReference)dyadicExpressionEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getComparisonPredicate() {
		return comparisonPredicateEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getComparisonPredicate_ComparisonOperator() {
		return (EAttribute)comparisonPredicateEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getComparisonPredicate_Literal() {
		return (EReference)comparisonPredicateEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getComparisonPredicate_Attribute() {
		return (EReference)comparisonPredicateEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getInPredicate() {
		return inPredicateEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getInPredicate_Attribute() {
		return (EReference)inPredicateEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getInPredicate_InOperator() {
		return (EAttribute)inPredicateEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getInPredicate_Literals() {
		return (EReference)inPredicateEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getLiteral() {
		return literalEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSignedIntegerLiteral() {
		return signedIntegerLiteralEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSignedIntegerLiteral_Value() {
		return (EAttribute)signedIntegerLiteralEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getStringLiteral() {
		return stringLiteralEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getStringLiteral_Value() {
		return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getBooleanLiteral() {
		return booleanLiteralEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getBooleanLiteral_Value() {
		return (EAttribute)booleanLiteralEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSubClassPredicate() {
		return subClassPredicateEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSubClassPredicate_SubClassExpression() {
		return (EReference)subClassPredicateEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSubClassPredicate_SubClassAttribute() {
		return (EReference)subClassPredicateEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getClassAttribute() {
		return classAttributeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getClassAttribute_AttributeName() {
		return (EAttribute)classAttributeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getClassAttribute_MetaOperator() {
		return (EAttribute)classAttributeEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getClassAttribute_Index() {
		return (EAttribute)classAttributeEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDownCastPredicate() {
		return downCastPredicateEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDownCastPredicate_ClassName() {
		return (EAttribute)downCastPredicateEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDownCastPredicate_Expression() {
		return (EReference)downCastPredicateEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getMultiplicityPredicate() {
		return multiplicityPredicateEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMultiplicityPredicate_Expression() {
		return (EReference)multiplicityPredicateEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMultiplicityPredicate_ListOperator() {
		return (EAttribute)multiplicityPredicateEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMultiplicityPredicate_Attribute() {
		return (EReference)multiplicityPredicateEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getIsSetPredicate() {
		return isSetPredicateEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getIsSetPredicate_Attribute() {
		return (EReference)isSetPredicateEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getDyadicLogicalOperator() {
		return dyadicLogicalOperatorEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getUnaryLogicalOperator() {
		return unaryLogicalOperatorEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getComparisonOperator() {
		return comparisonOperatorEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getListOperator() {
		return listOperatorEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getInOperator() {
		return inOperatorEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getMetaOperator() {
		return metaOperatorEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FilterexprFactory getFilterexprFactory() {
		return (FilterexprFactory)getEFactoryInstance();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isCreated = false;

  /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		booleanExpressionEClass = createEClass(BOOLEAN_EXPRESSION);

		unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
		createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__UNARY_OPERATOR);
		createEReference(unaryExpressionEClass, UNARY_EXPRESSION__EXPRESSION);

		predicateEClass = createEClass(PREDICATE);

		dyadicExpressionEClass = createEClass(DYADIC_EXPRESSION);
		createEAttribute(dyadicExpressionEClass, DYADIC_EXPRESSION__LOGICAL_OPERATOR);
		createEReference(dyadicExpressionEClass, DYADIC_EXPRESSION__LEFT_HAND_TERM);
		createEReference(dyadicExpressionEClass, DYADIC_EXPRESSION__RIGHT_HAND_TERM);

		comparisonPredicateEClass = createEClass(COMPARISON_PREDICATE);
		createEReference(comparisonPredicateEClass, COMPARISON_PREDICATE__LITERAL);
		createEReference(comparisonPredicateEClass, COMPARISON_PREDICATE__ATTRIBUTE);
		createEAttribute(comparisonPredicateEClass, COMPARISON_PREDICATE__COMPARISON_OPERATOR);

		inPredicateEClass = createEClass(IN_PREDICATE);
		createEReference(inPredicateEClass, IN_PREDICATE__ATTRIBUTE);
		createEAttribute(inPredicateEClass, IN_PREDICATE__IN_OPERATOR);
		createEReference(inPredicateEClass, IN_PREDICATE__LITERALS);

		literalEClass = createEClass(LITERAL);

		signedIntegerLiteralEClass = createEClass(SIGNED_INTEGER_LITERAL);
		createEAttribute(signedIntegerLiteralEClass, SIGNED_INTEGER_LITERAL__VALUE);

		stringLiteralEClass = createEClass(STRING_LITERAL);
		createEAttribute(stringLiteralEClass, STRING_LITERAL__VALUE);

		booleanLiteralEClass = createEClass(BOOLEAN_LITERAL);
		createEAttribute(booleanLiteralEClass, BOOLEAN_LITERAL__VALUE);

		subClassPredicateEClass = createEClass(SUB_CLASS_PREDICATE);
		createEReference(subClassPredicateEClass, SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION);
		createEReference(subClassPredicateEClass, SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE);

		classAttributeEClass = createEClass(CLASS_ATTRIBUTE);
		createEAttribute(classAttributeEClass, CLASS_ATTRIBUTE__ATTRIBUTE_NAME);
		createEAttribute(classAttributeEClass, CLASS_ATTRIBUTE__META_OPERATOR);
		createEAttribute(classAttributeEClass, CLASS_ATTRIBUTE__INDEX);

		downCastPredicateEClass = createEClass(DOWN_CAST_PREDICATE);
		createEAttribute(downCastPredicateEClass, DOWN_CAST_PREDICATE__CLASS_NAME);
		createEReference(downCastPredicateEClass, DOWN_CAST_PREDICATE__EXPRESSION);

		multiplicityPredicateEClass = createEClass(MULTIPLICITY_PREDICATE);
		createEReference(multiplicityPredicateEClass, MULTIPLICITY_PREDICATE__EXPRESSION);
		createEReference(multiplicityPredicateEClass, MULTIPLICITY_PREDICATE__ATTRIBUTE);
		createEAttribute(multiplicityPredicateEClass, MULTIPLICITY_PREDICATE__LIST_OPERATOR);

		isSetPredicateEClass = createEClass(IS_SET_PREDICATE);
		createEReference(isSetPredicateEClass, IS_SET_PREDICATE__ATTRIBUTE);

		// Create enums
		dyadicLogicalOperatorEEnum = createEEnum(DYADIC_LOGICAL_OPERATOR);
		unaryLogicalOperatorEEnum = createEEnum(UNARY_LOGICAL_OPERATOR);
		comparisonOperatorEEnum = createEEnum(COMPARISON_OPERATOR);
		listOperatorEEnum = createEEnum(LIST_OPERATOR);
		inOperatorEEnum = createEEnum(IN_OPERATOR);
		metaOperatorEEnum = createEEnum(META_OPERATOR);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isInitialized = false;

  /**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		unaryExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
		predicateEClass.getESuperTypes().add(this.getBooleanExpression());
		dyadicExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
		comparisonPredicateEClass.getESuperTypes().add(this.getPredicate());
		inPredicateEClass.getESuperTypes().add(this.getPredicate());
		signedIntegerLiteralEClass.getESuperTypes().add(this.getLiteral());
		stringLiteralEClass.getESuperTypes().add(this.getLiteral());
		booleanLiteralEClass.getESuperTypes().add(this.getLiteral());
		subClassPredicateEClass.getESuperTypes().add(this.getPredicate());
		downCastPredicateEClass.getESuperTypes().add(this.getPredicate());
		multiplicityPredicateEClass.getESuperTypes().add(this.getPredicate());
		isSetPredicateEClass.getESuperTypes().add(this.getPredicate());

		// Initialize classes and features; add operations and parameters
		initEClass(booleanExpressionEClass, BooleanExpression.class, "BooleanExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(booleanExpressionEClass, ecorePackage.getEBoolean(), "evaluate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(booleanExpressionEClass, ecorePackage.getEString(), "format", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "indent", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "indentSize", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(unaryExpressionEClass, UnaryExpression.class, "UnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnaryExpression_UnaryOperator(), this.getUnaryLogicalOperator(), "unaryOperator", "NOT", 1, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnaryExpression_Expression(), this.getBooleanExpression(), null, "expression", null, 1, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(predicateEClass, Predicate.class, "Predicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dyadicExpressionEClass, DyadicExpression.class, "DyadicExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDyadicExpression_LogicalOperator(), this.getDyadicLogicalOperator(), "logicalOperator", "AND", 1, 1, DyadicExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDyadicExpression_LeftHandTerm(), this.getBooleanExpression(), null, "leftHandTerm", null, 1, 1, DyadicExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDyadicExpression_RightHandTerm(), this.getBooleanExpression(), null, "rightHandTerm", null, 1, 1, DyadicExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(comparisonPredicateEClass, ComparisonPredicate.class, "ComparisonPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComparisonPredicate_Literal(), this.getLiteral(), null, "literal", null, 1, 1, ComparisonPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComparisonPredicate_Attribute(), this.getClassAttribute(), null, "attribute", null, 1, 1, ComparisonPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComparisonPredicate_ComparisonOperator(), this.getComparisonOperator(), "comparisonOperator", null, 1, 1, ComparisonPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inPredicateEClass, InPredicate.class, "InPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInPredicate_Attribute(), this.getClassAttribute(), null, "attribute", null, 1, 1, InPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInPredicate_InOperator(), this.getInOperator(), "inOperator", null, 1, 1, InPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInPredicate_Literals(), this.getLiteral(), null, "literals", null, 0, -1, InPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalEClass, Literal.class, "Literal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(signedIntegerLiteralEClass, SignedIntegerLiteral.class, "SignedIntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSignedIntegerLiteral_Value(), ecorePackage.getELong(), "value", null, 1, 1, SignedIntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteral_Value(), ecorePackage.getEString(), "value", null, 1, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanLiteralEClass, BooleanLiteral.class, "BooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteral_Value(), ecorePackage.getEBoolean(), "value", null, 1, 1, BooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subClassPredicateEClass, SubClassPredicate.class, "SubClassPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubClassPredicate_SubClassExpression(), this.getBooleanExpression(), null, "subClassExpression", null, 1, 1, SubClassPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubClassPredicate_SubClassAttribute(), this.getClassAttribute(), null, "subClassAttribute", null, 1, 1, SubClassPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classAttributeEClass, ClassAttribute.class, "ClassAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassAttribute_AttributeName(), ecorePackage.getEString(), "attributeName", null, 1, 1, ClassAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassAttribute_MetaOperator(), this.getMetaOperator(), "metaOperator", null, 0, 1, ClassAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassAttribute_Index(), ecorePackage.getEInt(), "index", null, 0, 1, ClassAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(classAttributeEClass, ecorePackage.getEBoolean(), "isSet", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(classAttributeEClass, null, "getListValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(classAttributeEClass, ecorePackage.getEJavaObject(), "getValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(downCastPredicateEClass, DownCastPredicate.class, "DownCastPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDownCastPredicate_ClassName(), ecorePackage.getEString(), "className", null, 1, 1, DownCastPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDownCastPredicate_Expression(), this.getBooleanExpression(), null, "expression", null, 1, 1, DownCastPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiplicityPredicateEClass, MultiplicityPredicate.class, "MultiplicityPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiplicityPredicate_Expression(), this.getBooleanExpression(), null, "expression", null, 1, 1, MultiplicityPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiplicityPredicate_Attribute(), this.getClassAttribute(), null, "attribute", null, 1, 1, MultiplicityPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiplicityPredicate_ListOperator(), this.getListOperator(), "listOperator", null, 1, 1, MultiplicityPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(isSetPredicateEClass, IsSetPredicate.class, "IsSetPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIsSetPredicate_Attribute(), this.getClassAttribute(), null, "attribute", null, 1, 1, IsSetPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(dyadicLogicalOperatorEEnum, DyadicLogicalOperator.class, "DyadicLogicalOperator");
		addEEnumLiteral(dyadicLogicalOperatorEEnum, DyadicLogicalOperator.AND);
		addEEnumLiteral(dyadicLogicalOperatorEEnum, DyadicLogicalOperator.OR);

		initEEnum(unaryLogicalOperatorEEnum, UnaryLogicalOperator.class, "UnaryLogicalOperator");
		addEEnumLiteral(unaryLogicalOperatorEEnum, UnaryLogicalOperator.NOT);

		initEEnum(comparisonOperatorEEnum, ComparisonOperator.class, "ComparisonOperator");
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.EQUAL);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.NOT_EQUAL);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.GREATER_THEN);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.GREATER_OR_EQUAL_THAN);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.LESS_THAN);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.LESS_OR_EQUAL_THAN);

		initEEnum(listOperatorEEnum, ListOperator.class, "ListOperator");
		addEEnumLiteral(listOperatorEEnum, ListOperator.ANY);
		addEEnumLiteral(listOperatorEEnum, ListOperator.ALL);
		addEEnumLiteral(listOperatorEEnum, ListOperator.NONE);

		initEEnum(inOperatorEEnum, InOperator.class, "InOperator");
		addEEnumLiteral(inOperatorEEnum, InOperator.IN);
		addEEnumLiteral(inOperatorEEnum, InOperator.NOT_IN);

		initEEnum(metaOperatorEEnum, MetaOperator.class, "MetaOperator");
		addEEnumLiteral(metaOperatorEEnum, MetaOperator.SIZE);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// GenModel
		createGenModelAnnotations();
	}

  /**
	 * Initializes the annotations for <b>GenModel</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createGenModelAnnotations() {
		String source = "GenModel";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "documentation", "Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/."
		   });																		
	}

} //FilterexprPackageImpl
