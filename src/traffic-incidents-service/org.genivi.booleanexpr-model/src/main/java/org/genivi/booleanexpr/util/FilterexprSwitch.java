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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.genivi.booleanexpr.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.genivi.booleanexpr.FilterexprPackage
 * @generated
 */
public class FilterexprSwitch<T> extends Switch<T> {
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static FilterexprPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FilterexprSwitch() {
		if (modelPackage == null) {
			modelPackage = FilterexprPackage.eINSTANCE;
		}
	}

  /**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case FilterexprPackage.BOOLEAN_EXPRESSION: {
				BooleanExpression booleanExpression = (BooleanExpression)theEObject;
				T result = caseBooleanExpression(booleanExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FilterexprPackage.UNARY_EXPRESSION: {
				UnaryExpression unaryExpression = (UnaryExpression)theEObject;
				T result = caseUnaryExpression(unaryExpression);
				if (result == null) result = caseBooleanExpression(unaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FilterexprPackage.PREDICATE: {
				Predicate predicate = (Predicate)theEObject;
				T result = casePredicate(predicate);
				if (result == null) result = caseBooleanExpression(predicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FilterexprPackage.DYADIC_EXPRESSION: {
				DyadicExpression dyadicExpression = (DyadicExpression)theEObject;
				T result = caseDyadicExpression(dyadicExpression);
				if (result == null) result = caseBooleanExpression(dyadicExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FilterexprPackage.COMPARISON_PREDICATE: {
				ComparisonPredicate comparisonPredicate = (ComparisonPredicate)theEObject;
				T result = caseComparisonPredicate(comparisonPredicate);
				if (result == null) result = casePredicate(comparisonPredicate);
				if (result == null) result = caseBooleanExpression(comparisonPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FilterexprPackage.IN_PREDICATE: {
				InPredicate inPredicate = (InPredicate)theEObject;
				T result = caseInPredicate(inPredicate);
				if (result == null) result = casePredicate(inPredicate);
				if (result == null) result = caseBooleanExpression(inPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FilterexprPackage.LITERAL: {
				Literal literal = (Literal)theEObject;
				T result = caseLiteral(literal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FilterexprPackage.SIGNED_INTEGER_LITERAL: {
				SignedIntegerLiteral signedIntegerLiteral = (SignedIntegerLiteral)theEObject;
				T result = caseSignedIntegerLiteral(signedIntegerLiteral);
				if (result == null) result = caseLiteral(signedIntegerLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FilterexprPackage.STRING_LITERAL: {
				StringLiteral stringLiteral = (StringLiteral)theEObject;
				T result = caseStringLiteral(stringLiteral);
				if (result == null) result = caseLiteral(stringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FilterexprPackage.BOOLEAN_LITERAL: {
				BooleanLiteral booleanLiteral = (BooleanLiteral)theEObject;
				T result = caseBooleanLiteral(booleanLiteral);
				if (result == null) result = caseLiteral(booleanLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FilterexprPackage.SUB_CLASS_PREDICATE: {
				SubClassPredicate subClassPredicate = (SubClassPredicate)theEObject;
				T result = caseSubClassPredicate(subClassPredicate);
				if (result == null) result = casePredicate(subClassPredicate);
				if (result == null) result = caseBooleanExpression(subClassPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FilterexprPackage.CLASS_ATTRIBUTE: {
				ClassAttribute classAttribute = (ClassAttribute)theEObject;
				T result = caseClassAttribute(classAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FilterexprPackage.DOWN_CAST_PREDICATE: {
				DownCastPredicate downCastPredicate = (DownCastPredicate)theEObject;
				T result = caseDownCastPredicate(downCastPredicate);
				if (result == null) result = casePredicate(downCastPredicate);
				if (result == null) result = caseBooleanExpression(downCastPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FilterexprPackage.MULTIPLICITY_PREDICATE: {
				MultiplicityPredicate multiplicityPredicate = (MultiplicityPredicate)theEObject;
				T result = caseMultiplicityPredicate(multiplicityPredicate);
				if (result == null) result = casePredicate(multiplicityPredicate);
				if (result == null) result = caseBooleanExpression(multiplicityPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FilterexprPackage.IS_SET_PREDICATE: {
				IsSetPredicate isSetPredicate = (IsSetPredicate)theEObject;
				T result = caseIsSetPredicate(isSetPredicate);
				if (result == null) result = casePredicate(isSetPredicate);
				if (result == null) result = caseBooleanExpression(isSetPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseBooleanExpression(BooleanExpression object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseUnaryExpression(UnaryExpression object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Predicate</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePredicate(Predicate object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Dyadic Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dyadic Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDyadicExpression(DyadicExpression object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Comparison Predicate</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comparison Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseComparisonPredicate(ComparisonPredicate object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>In Predicate</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseInPredicate(InPredicate object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseLiteral(Literal object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Signed Integer Literal</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signed Integer Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSignedIntegerLiteral(SignedIntegerLiteral object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseStringLiteral(StringLiteral object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseBooleanLiteral(BooleanLiteral object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Class Predicate</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Class Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSubClassPredicate(SubClassPredicate object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Class Attribute</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseClassAttribute(ClassAttribute object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Down Cast Predicate</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Down Cast Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDownCastPredicate(DownCastPredicate object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicity Predicate</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicity Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMultiplicityPredicate(MultiplicityPredicate object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Is Set Predicate</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Set Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIsSetPredicate(IsSetPredicate object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
  @Override
  public T defaultCase(EObject object) {
		return null;
	}

} //FilterexprSwitch
