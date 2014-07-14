/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.genivi.trafficinfo.tpeg.tec.event.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventFactoryImpl extends EFactoryImpl implements EventFactory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static EventFactory init() {
		try {
			EventFactory theEventFactory = (EventFactory)EPackage.Registry.INSTANCE.getEFactory(EventPackage.eNS_URI);
			if (theEventFactory != null) {
				return theEventFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EventFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EventFactoryImpl() {
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
			case EventPackage.EVENT: return createEvent();
			case EventPackage.CAUSE: return createCause();
			case EventPackage.LINKED_CAUSE: return createLinkedCause();
			case EventPackage.DIRECT_CAUSE: return createDirectCause();
			case EventPackage.ADVICE: return createAdvice();
			case EventPackage.VEHICLE_RESTRICTION: return createVehicleRestriction();
			case EventPackage.VEHICLE_RELATED_RESTRICTION: return createVehicleRelatedRestriction();
			case EventPackage.TEC_MESSAGE: return createTECMessage();
			case EventPackage.TEMPORARY_SPEED_LIMIT_SECTION: return createTemporarySpeedLimitSection();
			case EventPackage.TEMPORARY_SPEED_LIMIT: return createTemporarySpeedLimit();
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
			case EventPackage.EFFECT_CODE:
				return createEffectCodeFromString(eDataType, initialValue);
			case EventPackage.TENDENCY:
				return createTendencyFromString(eDataType, initialValue);
			case EventPackage.CAUSE_CODE:
				return createCauseCodeFromString(eDataType, initialValue);
			case EventPackage.WARNING_LEVEL:
				return createWarningLevelFromString(eDataType, initialValue);
			case EventPackage.TRAFFIC_CONGESTION:
				return createTrafficCongestionFromString(eDataType, initialValue);
			case EventPackage.ACCIDENT:
				return createAccidentFromString(eDataType, initialValue);
			case EventPackage.ROAD_WORKS:
				return createRoadWorksFromString(eDataType, initialValue);
			case EventPackage.NARROW_LANES:
				return createNarrowLanesFromString(eDataType, initialValue);
			case EventPackage.IMPASSIBILITY:
				return createImpassibilityFromString(eDataType, initialValue);
			case EventPackage.SLIPPERY_ROAD:
				return createSlipperyRoadFromString(eDataType, initialValue);
			case EventPackage.FIRE:
				return createFireFromString(eDataType, initialValue);
			case EventPackage.HAZARDOUS_DRIVING_CONDITIONS:
				return createHazardousDrivingConditionsFromString(eDataType, initialValue);
			case EventPackage.OBJECTS_ON_THE_ROAD:
				return createObjectsOnTheRoadFromString(eDataType, initialValue);
			case EventPackage.ANIMALS_ON_ROADWAY:
				return createAnimalsOnRoadwayFromString(eDataType, initialValue);
			case EventPackage.PEOPLE_ON_ROADWAY:
				return createPeopleOnRoadwayFromString(eDataType, initialValue);
			case EventPackage.BROKEN_DOWN_VEHICLES:
				return createBrokenDownVehiclesFromString(eDataType, initialValue);
			case EventPackage.RESCUE_AND_RECOVERY_WORK_IN_PROGRESS:
				return createRescueAndRecoveryWorkInProgressFromString(eDataType, initialValue);
			case EventPackage.REGULATORY_MEASURE:
				return createRegulatoryMeasureFromString(eDataType, initialValue);
			case EventPackage.LANE_RESTRICTION_TYPE:
				return createLaneRestrictionTypeFromString(eDataType, initialValue);
			case EventPackage.ADVICE_CODE:
				return createAdviceCodeFromString(eDataType, initialValue);
			case EventPackage.VEHICLE_TYPE:
				return createVehicleTypeFromString(eDataType, initialValue);
			case EventPackage.RESTRICTION_TYPE:
				return createRestrictionTypeFromString(eDataType, initialValue);
			case EventPackage.EXTREME_WEATHER_CONDITIONS:
				return createExtremeWeatherConditionsFromString(eDataType, initialValue);
			case EventPackage.VISIBILITY_REDUCED:
				return createVisibilityReducedFromString(eDataType, initialValue);
			case EventPackage.PRECIPITATION:
				return createPrecipitationFromString(eDataType, initialValue);
			case EventPackage.RECKLESS_PERSONS:
				return createRecklessPersonsFromString(eDataType, initialValue);
			case EventPackage.MAJOR_EVENT:
				return createMajorEventFromString(eDataType, initialValue);
			case EventPackage.SERVICE_NOT_OPERATING:
				return createServiceNotOperatingFromString(eDataType, initialValue);
			case EventPackage.SERVICE_NOT_USABLE:
				return createServiceNotUsableFromString(eDataType, initialValue);
			case EventPackage.SLOW_MOVING_VEHICLES:
				return createSlowMovingVehiclesFromString(eDataType, initialValue);
			case EventPackage.DANGEROUS_END_OF_QUEUE:
				return createDangerousEndOfQueueFromString(eDataType, initialValue);
			case EventPackage.RISK_OF_FIRE:
				return createRiskOfFireFromString(eDataType, initialValue);
			case EventPackage.TIME_DELAY:
				return createTimeDelayFromString(eDataType, initialValue);
			case EventPackage.POLICE_CHECKPOINT:
				return createPoliceCheckpointFromString(eDataType, initialValue);
			case EventPackage.MALFUNCTIONING_ROADSIDE_EQUIPMENT:
				return createMalfunctioningRoadsideEquipmentFromString(eDataType, initialValue);
			case EventPackage.OVERTAKING_NOT_ALLOWED:
				return createOvertakingNotAllowedFromString(eDataType, initialValue);
			case EventPackage.DRIVING_NOT_ALLOWED:
				return createDrivingNotAllowedFromString(eDataType, initialValue);
			case EventPackage.GIVING_PATH_VEHICLES_FROM_BEHIND:
				return createGivingPathVehiclesFromBehindFromString(eDataType, initialValue);
			case EventPackage.FOLLOW_DIVERSION:
				return createFollowDiversionFromString(eDataType, initialValue);
			case EventPackage.DRIVE_CAREFULLY:
				return createDriveCarefullyFromString(eDataType, initialValue);
			case EventPackage.DO_NOT_LEAVE_YOUR_VEHICLE:
				return createDoNotLeaveYourVehicleFromString(eDataType, initialValue);
			case EventPackage.USE_TOLL_LANES:
				return createUseTollLanesFromString(eDataType, initialValue);
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
			case EventPackage.EFFECT_CODE:
				return convertEffectCodeToString(eDataType, instanceValue);
			case EventPackage.TENDENCY:
				return convertTendencyToString(eDataType, instanceValue);
			case EventPackage.CAUSE_CODE:
				return convertCauseCodeToString(eDataType, instanceValue);
			case EventPackage.WARNING_LEVEL:
				return convertWarningLevelToString(eDataType, instanceValue);
			case EventPackage.TRAFFIC_CONGESTION:
				return convertTrafficCongestionToString(eDataType, instanceValue);
			case EventPackage.ACCIDENT:
				return convertAccidentToString(eDataType, instanceValue);
			case EventPackage.ROAD_WORKS:
				return convertRoadWorksToString(eDataType, instanceValue);
			case EventPackage.NARROW_LANES:
				return convertNarrowLanesToString(eDataType, instanceValue);
			case EventPackage.IMPASSIBILITY:
				return convertImpassibilityToString(eDataType, instanceValue);
			case EventPackage.SLIPPERY_ROAD:
				return convertSlipperyRoadToString(eDataType, instanceValue);
			case EventPackage.FIRE:
				return convertFireToString(eDataType, instanceValue);
			case EventPackage.HAZARDOUS_DRIVING_CONDITIONS:
				return convertHazardousDrivingConditionsToString(eDataType, instanceValue);
			case EventPackage.OBJECTS_ON_THE_ROAD:
				return convertObjectsOnTheRoadToString(eDataType, instanceValue);
			case EventPackage.ANIMALS_ON_ROADWAY:
				return convertAnimalsOnRoadwayToString(eDataType, instanceValue);
			case EventPackage.PEOPLE_ON_ROADWAY:
				return convertPeopleOnRoadwayToString(eDataType, instanceValue);
			case EventPackage.BROKEN_DOWN_VEHICLES:
				return convertBrokenDownVehiclesToString(eDataType, instanceValue);
			case EventPackage.RESCUE_AND_RECOVERY_WORK_IN_PROGRESS:
				return convertRescueAndRecoveryWorkInProgressToString(eDataType, instanceValue);
			case EventPackage.REGULATORY_MEASURE:
				return convertRegulatoryMeasureToString(eDataType, instanceValue);
			case EventPackage.LANE_RESTRICTION_TYPE:
				return convertLaneRestrictionTypeToString(eDataType, instanceValue);
			case EventPackage.ADVICE_CODE:
				return convertAdviceCodeToString(eDataType, instanceValue);
			case EventPackage.VEHICLE_TYPE:
				return convertVehicleTypeToString(eDataType, instanceValue);
			case EventPackage.RESTRICTION_TYPE:
				return convertRestrictionTypeToString(eDataType, instanceValue);
			case EventPackage.EXTREME_WEATHER_CONDITIONS:
				return convertExtremeWeatherConditionsToString(eDataType, instanceValue);
			case EventPackage.VISIBILITY_REDUCED:
				return convertVisibilityReducedToString(eDataType, instanceValue);
			case EventPackage.PRECIPITATION:
				return convertPrecipitationToString(eDataType, instanceValue);
			case EventPackage.RECKLESS_PERSONS:
				return convertRecklessPersonsToString(eDataType, instanceValue);
			case EventPackage.MAJOR_EVENT:
				return convertMajorEventToString(eDataType, instanceValue);
			case EventPackage.SERVICE_NOT_OPERATING:
				return convertServiceNotOperatingToString(eDataType, instanceValue);
			case EventPackage.SERVICE_NOT_USABLE:
				return convertServiceNotUsableToString(eDataType, instanceValue);
			case EventPackage.SLOW_MOVING_VEHICLES:
				return convertSlowMovingVehiclesToString(eDataType, instanceValue);
			case EventPackage.DANGEROUS_END_OF_QUEUE:
				return convertDangerousEndOfQueueToString(eDataType, instanceValue);
			case EventPackage.RISK_OF_FIRE:
				return convertRiskOfFireToString(eDataType, instanceValue);
			case EventPackage.TIME_DELAY:
				return convertTimeDelayToString(eDataType, instanceValue);
			case EventPackage.POLICE_CHECKPOINT:
				return convertPoliceCheckpointToString(eDataType, instanceValue);
			case EventPackage.MALFUNCTIONING_ROADSIDE_EQUIPMENT:
				return convertMalfunctioningRoadsideEquipmentToString(eDataType, instanceValue);
			case EventPackage.OVERTAKING_NOT_ALLOWED:
				return convertOvertakingNotAllowedToString(eDataType, instanceValue);
			case EventPackage.DRIVING_NOT_ALLOWED:
				return convertDrivingNotAllowedToString(eDataType, instanceValue);
			case EventPackage.GIVING_PATH_VEHICLES_FROM_BEHIND:
				return convertGivingPathVehiclesFromBehindToString(eDataType, instanceValue);
			case EventPackage.FOLLOW_DIVERSION:
				return convertFollowDiversionToString(eDataType, instanceValue);
			case EventPackage.DRIVE_CAREFULLY:
				return convertDriveCarefullyToString(eDataType, instanceValue);
			case EventPackage.DO_NOT_LEAVE_YOUR_VEHICLE:
				return convertDoNotLeaveYourVehicleToString(eDataType, instanceValue);
			case EventPackage.USE_TOLL_LANES:
				return convertUseTollLanesToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Cause createCause() {
		CauseImpl cause = new CauseImpl();
		return cause;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LinkedCause createLinkedCause() {
		LinkedCauseImpl linkedCause = new LinkedCauseImpl();
		return linkedCause;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DirectCause createDirectCause() {
		DirectCauseImpl directCause = new DirectCauseImpl();
		return directCause;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Advice createAdvice() {
		AdviceImpl advice = new AdviceImpl();
		return advice;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VehicleRestriction createVehicleRestriction() {
		VehicleRestrictionImpl vehicleRestriction = new VehicleRestrictionImpl();
		return vehicleRestriction;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VehicleRelatedRestriction createVehicleRelatedRestriction() {
		VehicleRelatedRestrictionImpl vehicleRelatedRestriction = new VehicleRelatedRestrictionImpl();
		return vehicleRelatedRestriction;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TECMessage createTECMessage() {
		TECMessageImpl tecMessage = new TECMessageImpl();
		return tecMessage;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemporarySpeedLimitSection createTemporarySpeedLimitSection() {
		TemporarySpeedLimitSectionImpl temporarySpeedLimitSection = new TemporarySpeedLimitSectionImpl();
		return temporarySpeedLimitSection;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemporarySpeedLimit createTemporarySpeedLimit() {
		TemporarySpeedLimitImpl temporarySpeedLimit = new TemporarySpeedLimitImpl();
		return temporarySpeedLimit;
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EffectCode createEffectCodeFromString(EDataType eDataType, String initialValue) {
		EffectCode result = EffectCode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertEffectCodeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Tendency createTendencyFromString(EDataType eDataType, String initialValue) {
		Tendency result = Tendency.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertTendencyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CauseCode createCauseCodeFromString(EDataType eDataType, String initialValue) {
		CauseCode result = CauseCode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertCauseCodeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public WarningLevel createWarningLevelFromString(EDataType eDataType, String initialValue) {
		WarningLevel result = WarningLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertWarningLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TrafficCongestion createTrafficCongestionFromString(EDataType eDataType, String initialValue) {
		TrafficCongestion result = TrafficCongestion.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertTrafficCongestionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Accident createAccidentFromString(EDataType eDataType, String initialValue) {
		Accident result = Accident.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertAccidentToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RoadWorks createRoadWorksFromString(EDataType eDataType, String initialValue) {
		RoadWorks result = RoadWorks.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertRoadWorksToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NarrowLanes createNarrowLanesFromString(EDataType eDataType, String initialValue) {
		NarrowLanes result = NarrowLanes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertNarrowLanesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Impassibility createImpassibilityFromString(EDataType eDataType, String initialValue) {
		Impassibility result = Impassibility.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertImpassibilityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SlipperyRoad createSlipperyRoadFromString(EDataType eDataType, String initialValue) {
		SlipperyRoad result = SlipperyRoad.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertSlipperyRoadToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Fire createFireFromString(EDataType eDataType, String initialValue) {
		Fire result = Fire.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertFireToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public HazardousDrivingConditions createHazardousDrivingConditionsFromString(EDataType eDataType, String initialValue) {
		HazardousDrivingConditions result = HazardousDrivingConditions.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertHazardousDrivingConditionsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ObjectsOnTheRoad createObjectsOnTheRoadFromString(EDataType eDataType, String initialValue) {
		ObjectsOnTheRoad result = ObjectsOnTheRoad.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertObjectsOnTheRoadToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AnimalsOnRoadway createAnimalsOnRoadwayFromString(EDataType eDataType, String initialValue) {
		AnimalsOnRoadway result = AnimalsOnRoadway.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertAnimalsOnRoadwayToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PeopleOnRoadway createPeopleOnRoadwayFromString(EDataType eDataType, String initialValue) {
		PeopleOnRoadway result = PeopleOnRoadway.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertPeopleOnRoadwayToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BrokenDownVehicles createBrokenDownVehiclesFromString(EDataType eDataType, String initialValue) {
		BrokenDownVehicles result = BrokenDownVehicles.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertBrokenDownVehiclesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RescueAndRecoveryWorkInProgress createRescueAndRecoveryWorkInProgressFromString(EDataType eDataType, String initialValue) {
		RescueAndRecoveryWorkInProgress result = RescueAndRecoveryWorkInProgress.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertRescueAndRecoveryWorkInProgressToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RegulatoryMeasure createRegulatoryMeasureFromString(EDataType eDataType, String initialValue) {
		RegulatoryMeasure result = RegulatoryMeasure.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertRegulatoryMeasureToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LaneRestrictionType createLaneRestrictionTypeFromString(EDataType eDataType, String initialValue) {
		LaneRestrictionType result = LaneRestrictionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertLaneRestrictionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AdviceCode createAdviceCodeFromString(EDataType eDataType, String initialValue) {
		AdviceCode result = AdviceCode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertAdviceCodeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VehicleType createVehicleTypeFromString(EDataType eDataType, String initialValue) {
		VehicleType result = VehicleType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertVehicleTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RestrictionType createRestrictionTypeFromString(EDataType eDataType, String initialValue) {
		RestrictionType result = RestrictionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertRestrictionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ExtremeWeatherConditions createExtremeWeatherConditionsFromString(EDataType eDataType, String initialValue) {
		ExtremeWeatherConditions result = ExtremeWeatherConditions.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertExtremeWeatherConditionsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VisibilityReduced createVisibilityReducedFromString(EDataType eDataType, String initialValue) {
		VisibilityReduced result = VisibilityReduced.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertVisibilityReducedToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Precipitation createPrecipitationFromString(EDataType eDataType, String initialValue) {
		Precipitation result = Precipitation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertPrecipitationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RecklessPersons createRecklessPersonsFromString(EDataType eDataType, String initialValue) {
		RecklessPersons result = RecklessPersons.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertRecklessPersonsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MajorEvent createMajorEventFromString(EDataType eDataType, String initialValue) {
		MajorEvent result = MajorEvent.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertMajorEventToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ServiceNotOperating createServiceNotOperatingFromString(EDataType eDataType, String initialValue) {
		ServiceNotOperating result = ServiceNotOperating.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertServiceNotOperatingToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ServiceNotUsable createServiceNotUsableFromString(EDataType eDataType, String initialValue) {
		ServiceNotUsable result = ServiceNotUsable.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertServiceNotUsableToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SlowMovingVehicles createSlowMovingVehiclesFromString(EDataType eDataType, String initialValue) {
		SlowMovingVehicles result = SlowMovingVehicles.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertSlowMovingVehiclesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DangerousEndOfQueue createDangerousEndOfQueueFromString(EDataType eDataType, String initialValue) {
		DangerousEndOfQueue result = DangerousEndOfQueue.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertDangerousEndOfQueueToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RiskOfFire createRiskOfFireFromString(EDataType eDataType, String initialValue) {
		RiskOfFire result = RiskOfFire.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertRiskOfFireToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TimeDelay createTimeDelayFromString(EDataType eDataType, String initialValue) {
		TimeDelay result = TimeDelay.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertTimeDelayToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PoliceCheckpoint createPoliceCheckpointFromString(EDataType eDataType, String initialValue) {
		PoliceCheckpoint result = PoliceCheckpoint.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertPoliceCheckpointToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MalfunctioningRoadsideEquipment createMalfunctioningRoadsideEquipmentFromString(EDataType eDataType, String initialValue) {
		MalfunctioningRoadsideEquipment result = MalfunctioningRoadsideEquipment.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertMalfunctioningRoadsideEquipmentToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public OvertakingNotAllowed createOvertakingNotAllowedFromString(EDataType eDataType, String initialValue) {
		OvertakingNotAllowed result = OvertakingNotAllowed.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertOvertakingNotAllowedToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DrivingNotAllowed createDrivingNotAllowedFromString(EDataType eDataType, String initialValue) {
		DrivingNotAllowed result = DrivingNotAllowed.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertDrivingNotAllowedToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public GivingPathVehiclesFromBehind createGivingPathVehiclesFromBehindFromString(EDataType eDataType, String initialValue) {
		GivingPathVehiclesFromBehind result = GivingPathVehiclesFromBehind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertGivingPathVehiclesFromBehindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FollowDiversion createFollowDiversionFromString(EDataType eDataType, String initialValue) {
		FollowDiversion result = FollowDiversion.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertFollowDiversionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DriveCarefully createDriveCarefullyFromString(EDataType eDataType, String initialValue) {
		DriveCarefully result = DriveCarefully.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertDriveCarefullyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DoNotLeaveYourVehicle createDoNotLeaveYourVehicleFromString(EDataType eDataType, String initialValue) {
		DoNotLeaveYourVehicle result = DoNotLeaveYourVehicle.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertDoNotLeaveYourVehicleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public UseTollLanes createUseTollLanesFromString(EDataType eDataType, String initialValue) {
		UseTollLanes result = UseTollLanes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertUseTollLanesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EventPackage getEventPackage() {
		return (EventPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static EventPackage getPackage() {
		return EventPackage.eINSTANCE;
	}

} //EventFactoryImpl
