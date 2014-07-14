/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.location.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.genivi.location.AreaLocation;
import org.genivi.location.AreaLocationInfo;
import org.genivi.location.LinearLocation;
import org.genivi.location.LinearLocationInfo;
import org.genivi.location.Location;
import org.genivi.location.LocationInfo;
import org.genivi.location.LocationPackage;
import org.genivi.location.PointLocation;
import org.genivi.location.PointLocationInfo;

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
 * @see org.genivi.location.LocationPackage
 * @generated
 */
public class LocationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LocationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationSwitch() {
		if (modelPackage == null) {
			modelPackage = LocationPackage.eINSTANCE;
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
			case LocationPackage.LOCATION: {
				Location location = (Location)theEObject;
				T result = caseLocation(location);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LocationPackage.POINT_LOCATION: {
				PointLocation pointLocation = (PointLocation)theEObject;
				T result = casePointLocation(pointLocation);
				if (result == null) result = caseLocation(pointLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LocationPackage.AREA_LOCATION: {
				AreaLocation areaLocation = (AreaLocation)theEObject;
				T result = caseAreaLocation(areaLocation);
				if (result == null) result = caseLocation(areaLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LocationPackage.LINEAR_LOCATION: {
				LinearLocation linearLocation = (LinearLocation)theEObject;
				T result = caseLinearLocation(linearLocation);
				if (result == null) result = caseLocation(linearLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LocationPackage.LOCATION_INFO: {
				LocationInfo locationInfo = (LocationInfo)theEObject;
				T result = caseLocationInfo(locationInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LocationPackage.POINT_LOCATION_INFO: {
				PointLocationInfo pointLocationInfo = (PointLocationInfo)theEObject;
				T result = casePointLocationInfo(pointLocationInfo);
				if (result == null) result = caseLocationInfo(pointLocationInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LocationPackage.LINEAR_LOCATION_INFO: {
				LinearLocationInfo linearLocationInfo = (LinearLocationInfo)theEObject;
				T result = caseLinearLocationInfo(linearLocationInfo);
				if (result == null) result = caseLocationInfo(linearLocationInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LocationPackage.AREA_LOCATION_INFO: {
				AreaLocationInfo areaLocationInfo = (AreaLocationInfo)theEObject;
				T result = caseAreaLocationInfo(areaLocationInfo);
				if (result == null) result = caseLocationInfo(areaLocationInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocation(Location object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePointLocation(PointLocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Area Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Area Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAreaLocation(AreaLocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linear Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linear Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinearLocation(LinearLocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Info</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseLocationInfo(LocationInfo object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Point Location Info</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point Location Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePointLocationInfo(PointLocationInfo object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Linear Location Info</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linear Location Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseLinearLocationInfo(LinearLocationInfo object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Area Location Info</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Area Location Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAreaLocationInfo(AreaLocationInfo object) {
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

} //LocationSwitch
