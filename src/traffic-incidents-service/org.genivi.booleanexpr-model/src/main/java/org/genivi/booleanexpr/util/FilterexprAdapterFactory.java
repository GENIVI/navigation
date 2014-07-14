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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.genivi.booleanexpr.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.booleanexpr.FilterexprPackage
 * @generated
 */
public class FilterexprAdapterFactory extends AdapterFactoryImpl {
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static FilterexprPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FilterexprAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FilterexprPackage.eINSTANCE;
		}
	}

  /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
  @Override
  public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

  /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected FilterexprSwitch<Adapter> modelSwitch =
    new FilterexprSwitch<Adapter>() {
			@Override
			public Adapter caseBooleanExpression(BooleanExpression object) {
				return createBooleanExpressionAdapter();
			}
			@Override
			public Adapter caseUnaryExpression(UnaryExpression object) {
				return createUnaryExpressionAdapter();
			}
			@Override
			public Adapter casePredicate(Predicate object) {
				return createPredicateAdapter();
			}
			@Override
			public Adapter caseDyadicExpression(DyadicExpression object) {
				return createDyadicExpressionAdapter();
			}
			@Override
			public Adapter caseComparisonPredicate(ComparisonPredicate object) {
				return createComparisonPredicateAdapter();
			}
			@Override
			public Adapter caseInPredicate(InPredicate object) {
				return createInPredicateAdapter();
			}
			@Override
			public Adapter caseLiteral(Literal object) {
				return createLiteralAdapter();
			}
			@Override
			public Adapter caseSignedIntegerLiteral(SignedIntegerLiteral object) {
				return createSignedIntegerLiteralAdapter();
			}
			@Override
			public Adapter caseStringLiteral(StringLiteral object) {
				return createStringLiteralAdapter();
			}
			@Override
			public Adapter caseBooleanLiteral(BooleanLiteral object) {
				return createBooleanLiteralAdapter();
			}
			@Override
			public Adapter caseSubClassPredicate(SubClassPredicate object) {
				return createSubClassPredicateAdapter();
			}
			@Override
			public Adapter caseClassAttribute(ClassAttribute object) {
				return createClassAttributeAdapter();
			}
			@Override
			public Adapter caseDownCastPredicate(DownCastPredicate object) {
				return createDownCastPredicateAdapter();
			}
			@Override
			public Adapter caseMultiplicityPredicate(MultiplicityPredicate object) {
				return createMultiplicityPredicateAdapter();
			}
			@Override
			public Adapter caseIsSetPredicate(IsSetPredicate object) {
				return createIsSetPredicateAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

  /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
  @Override
  public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.BooleanExpression <em>Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.BooleanExpression
	 * @generated
	 */
  public Adapter createBooleanExpressionAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.UnaryExpression
	 * @generated
	 */
  public Adapter createUnaryExpressionAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.Predicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.Predicate
	 * @generated
	 */
  public Adapter createPredicateAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.DyadicExpression <em>Dyadic Expression</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.DyadicExpression
	 * @generated
	 */
  public Adapter createDyadicExpressionAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.ComparisonPredicate <em>Comparison Predicate</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.ComparisonPredicate
	 * @generated
	 */
  public Adapter createComparisonPredicateAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.InPredicate <em>In Predicate</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.InPredicate
	 * @generated
	 */
  public Adapter createInPredicateAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.Literal
	 * @generated
	 */
  public Adapter createLiteralAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.SignedIntegerLiteral <em>Signed Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.SignedIntegerLiteral
	 * @generated
	 */
  public Adapter createSignedIntegerLiteralAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.StringLiteral
	 * @generated
	 */
  public Adapter createStringLiteralAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.BooleanLiteral
	 * @generated
	 */
  public Adapter createBooleanLiteralAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.SubClassPredicate <em>Sub Class Predicate</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.SubClassPredicate
	 * @generated
	 */
  public Adapter createSubClassPredicateAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.ClassAttribute <em>Class Attribute</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.ClassAttribute
	 * @generated
	 */
  public Adapter createClassAttributeAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.DownCastPredicate <em>Down Cast Predicate</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.DownCastPredicate
	 * @generated
	 */
  public Adapter createDownCastPredicateAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.MultiplicityPredicate <em>Multiplicity Predicate</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.MultiplicityPredicate
	 * @generated
	 */
  public Adapter createMultiplicityPredicateAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.booleanexpr.IsSetPredicate <em>Is Set Predicate</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.booleanexpr.IsSetPredicate
	 * @generated
	 */
  public Adapter createIsSetPredicateAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
  public Adapter createEObjectAdapter() {
		return null;
	}

} //FilterexprAdapterFactory
