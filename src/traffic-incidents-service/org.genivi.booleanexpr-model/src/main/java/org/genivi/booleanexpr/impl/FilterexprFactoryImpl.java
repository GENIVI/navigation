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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.genivi.booleanexpr.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FilterexprFactoryImpl extends EFactoryImpl implements FilterexprFactory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static FilterexprFactory init() {
		try {
			FilterexprFactory theFilterexprFactory = (FilterexprFactory)EPackage.Registry.INSTANCE.getEFactory(FilterexprPackage.eNS_URI);
			if (theFilterexprFactory != null) {
				return theFilterexprFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FilterexprFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FilterexprFactoryImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FilterexprPackage.UNARY_EXPRESSION: return createUnaryExpression();
			case FilterexprPackage.DYADIC_EXPRESSION: return createDyadicExpression();
			case FilterexprPackage.COMPARISON_PREDICATE: return createComparisonPredicate();
			case FilterexprPackage.IN_PREDICATE: return createInPredicate();
			case FilterexprPackage.SIGNED_INTEGER_LITERAL: return createSignedIntegerLiteral();
			case FilterexprPackage.STRING_LITERAL: return createStringLiteral();
			case FilterexprPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
			case FilterexprPackage.SUB_CLASS_PREDICATE: return createSubClassPredicate();
			case FilterexprPackage.CLASS_ATTRIBUTE: return createClassAttribute();
			case FilterexprPackage.DOWN_CAST_PREDICATE: return createDownCastPredicate();
			case FilterexprPackage.MULTIPLICITY_PREDICATE: return createMultiplicityPredicate();
			case FilterexprPackage.IS_SET_PREDICATE: return createIsSetPredicate();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FilterexprPackage.DYADIC_LOGICAL_OPERATOR:
				return createDyadicLogicalOperatorFromString(eDataType, initialValue);
			case FilterexprPackage.UNARY_LOGICAL_OPERATOR:
				return createUnaryLogicalOperatorFromString(eDataType, initialValue);
			case FilterexprPackage.COMPARISON_OPERATOR:
				return createComparisonOperatorFromString(eDataType, initialValue);
			case FilterexprPackage.LIST_OPERATOR:
				return createListOperatorFromString(eDataType, initialValue);
			case FilterexprPackage.IN_OPERATOR:
				return createInOperatorFromString(eDataType, initialValue);
			case FilterexprPackage.META_OPERATOR:
				return createMetaOperatorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FilterexprPackage.DYADIC_LOGICAL_OPERATOR:
				return convertDyadicLogicalOperatorToString(eDataType, instanceValue);
			case FilterexprPackage.UNARY_LOGICAL_OPERATOR:
				return convertUnaryLogicalOperatorToString(eDataType, instanceValue);
			case FilterexprPackage.COMPARISON_OPERATOR:
				return convertComparisonOperatorToString(eDataType, instanceValue);
			case FilterexprPackage.LIST_OPERATOR:
				return convertListOperatorToString(eDataType, instanceValue);
			case FilterexprPackage.IN_OPERATOR:
				return convertInOperatorToString(eDataType, instanceValue);
			case FilterexprPackage.META_OPERATOR:
				return convertMetaOperatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public UnaryExpression createUnaryExpression() {
		UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
		return unaryExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DyadicExpression createDyadicExpression() {
		DyadicExpressionImpl dyadicExpression = new DyadicExpressionImpl();
		return dyadicExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ComparisonPredicate createComparisonPredicate() {
		ComparisonPredicateImpl comparisonPredicate = new ComparisonPredicateImpl();
		return comparisonPredicate;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public InPredicate createInPredicate() {
		InPredicateImpl inPredicate = new InPredicateImpl();
		return inPredicate;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SignedIntegerLiteral createSignedIntegerLiteral() {
		SignedIntegerLiteralImpl signedIntegerLiteral = new SignedIntegerLiteralImpl();
		return signedIntegerLiteral;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringLiteral createStringLiteral() {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BooleanLiteral createBooleanLiteral() {
		BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
		return booleanLiteral;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SubClassPredicate createSubClassPredicate() {
		SubClassPredicateImpl subClassPredicate = new SubClassPredicateImpl();
		return subClassPredicate;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ClassAttribute createClassAttribute() {
		ClassAttributeImpl classAttribute = new ClassAttributeImpl();
		return classAttribute;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DownCastPredicate createDownCastPredicate() {
		DownCastPredicateImpl downCastPredicate = new DownCastPredicateImpl();
		return downCastPredicate;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MultiplicityPredicate createMultiplicityPredicate() {
		MultiplicityPredicateImpl multiplicityPredicate = new MultiplicityPredicateImpl();
		return multiplicityPredicate;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IsSetPredicate createIsSetPredicate() {
		IsSetPredicateImpl isSetPredicate = new IsSetPredicateImpl();
		return isSetPredicate;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DyadicLogicalOperator createDyadicLogicalOperatorFromString(EDataType eDataType, String initialValue) {
		DyadicLogicalOperator result = DyadicLogicalOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertDyadicLogicalOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public UnaryLogicalOperator createUnaryLogicalOperatorFromString(EDataType eDataType, String initialValue) {
		UnaryLogicalOperator result = UnaryLogicalOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertUnaryLogicalOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ComparisonOperator createComparisonOperatorFromString(EDataType eDataType, String initialValue) {
		ComparisonOperator result = ComparisonOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertComparisonOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ListOperator createListOperatorFromString(EDataType eDataType, String initialValue) {
		ListOperator result = ListOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertListOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public InOperator createInOperatorFromString(EDataType eDataType, String initialValue) {
		InOperator result = InOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertInOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MetaOperator createMetaOperatorFromString(EDataType eDataType, String initialValue) {
		MetaOperator result = MetaOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertMetaOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FilterexprPackage getFilterexprPackage() {
		return (FilterexprPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static FilterexprPackage getPackage() {
		return FilterexprPackage.eINSTANCE;
	}

} //FilterexprFactoryImpl
