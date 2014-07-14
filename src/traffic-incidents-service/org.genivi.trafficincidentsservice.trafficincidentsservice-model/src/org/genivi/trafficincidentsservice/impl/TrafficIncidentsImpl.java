/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.genivi.common.RectangularArea;
import org.genivi.iconset.IconDefinition;
import org.genivi.iconset.IconInfo;
import org.genivi.iconset.IconSet;
import org.genivi.trafficincidentsservice.CategoryDefinition;
import org.genivi.trafficincidentsservice.LengthUnit;
import org.genivi.trafficincidentsservice.TextDetailLevel;
import org.genivi.trafficincidentsservice.TrafficIncidentField;
import org.genivi.trafficincidentsservice.TrafficIncidents;
import org.genivi.trafficincidentsservice.TrafficIncidentsListener;
import org.genivi.trafficincidentsservice.WeightUnit;
import org.genivi.trafficincidentsservice.trafficincidentsservicePackage;
import org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traffic Incidents</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TrafficIncidentsImpl extends EObjectImpl implements TrafficIncidents {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TrafficIncidentsImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return trafficincidentsservicePackage.Literals.TRAFFIC_INCIDENTS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void getVersion(TrafficIncidentsListener listener) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void getTrafficIncidentIds(TrafficIncidentsListener listener, EList<WarningLevel> warningLevels, EList<Integer> categoryIds) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void getTrafficIncidentIdsInAreas(TrafficIncidentsListener listener, EList<WarningLevel> warningLevels, EList<Integer> categoryIds, EList<RectangularArea> areas) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void getTrafficIncidents(TrafficIncidentsListener listener, EList<Integer> trafficIncidentIds, boolean includeTextFields) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void getTrafficIncidentsFields(TrafficIncidentsListener listener, EList<Integer> trafficIncidentIds, EList<TrafficIncidentField> trafficIncidentFields) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void getTexts(TrafficIncidentsListener listener, EList<Integer> trafficIncidentIds, TextDetailLevel textDetailLevel) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void addTrafficIncidentsStatusListener(TrafficIncidentsListener listener, TrafficIncidentsListener trafficIncidentsStatusListener) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void addFeedInformationListener(TrafficIncidentsListener listener, TrafficIncidentsListener feedInformationListener) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void removeUpdateListener(TrafficIncidentsListener listener, TrafficIncidentsListener updateListener) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void removeAreasUpdateListener(TrafficIncidentsListener listener, TrafficIncidentsListener updateListener) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void removeTrafficIncidentsStatusListener(TrafficIncidentsListener listener, TrafficIncidentsListener trafficIncidentsStatusListener) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void removeFeedInformationListener(TrafficIncidentsListener listener, TrafficIncidentsListener feedInformationListener) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void addUpdateListener(TrafficIncidentsListener listener, EList<WarningLevel> warningLevels, EList<Integer> categoryIds, TrafficIncidentsListener updateListener) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void addAreasUpdateListener(TrafficIncidentsListener listener, EList<WarningLevel> warningLevels, EList<Integer> categoryIds, EList<RectangularArea> areas, TrafficIncidentsListener updateListener) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void getLanguage(TrafficIncidentsListener listener) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLanguage(TrafficIncidentsListener listener, String languageCode, String countryCode) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTimeFormat(TrafficIncidentsListener listener, String timeFormat) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDateFormat(TrafficIncidentsListener listener, String dateFormat) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLengthUnit(TrafficIncidentsListener listener, LengthUnit lengthUnit) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setWeightUnit(TrafficIncidentsListener listener, WeightUnit weightUnit) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void reserveIconSetIds(TrafficIncidentsListener listener, int numberOfIds) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void freeIconSetIds(TrafficIncidentsListener listener, EList<Integer> iconSetIds) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void getIconSets(TrafficIncidentsListener listener) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void addIconSetDefinitions(TrafficIncidentsListener listener, EList<IconSet> iconSets) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void removeIconSetDefinitions(TrafficIncidentsListener listener, EList<Integer> iconSetIds) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void getIconDefinitions(TrafficIncidentsListener listener, EList<IconInfo> iconInfos) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void addIconDefinitions(TrafficIncidentsListener listener, EList<IconDefinition> iconDefinitions) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void removeIconDefinitions(TrafficIncidentsListener listener, EList<IconInfo> iconInfos) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void reserveCategoryIds(TrafficIncidentsListener listener, int numberOfIds) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void freeCategoryIds(TrafficIncidentsListener listener, EList<Integer> categoryIds) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void getCategoryDefinitions(TrafficIncidentsListener listener) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void addCategoryDefinitions(TrafficIncidentsListener listener, EList<CategoryDefinition> categoryDefinitions) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void removeCategoryDefinitions(TrafficIncidentsListener listener, EList<Integer> categoryIds) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void getApplicability(TrafficIncidentsListener listener) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setApplicability(TrafficIncidentsListener listener, String filterExpression) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //TrafficIncidentsImpl
