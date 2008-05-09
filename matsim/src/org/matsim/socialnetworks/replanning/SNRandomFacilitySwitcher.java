/* *********************************************************************** *
 * project: org.matsim.*
 * SNFacilitySwitcher.java
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2007 by the members listed in the COPYING,        *
 *                   LICENSE and WARRANTY file.                            *
 * email           : info at matsim dot org                                *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *   See also COPYING, LICENSE and WARRANTY file                           *
 *                                                                         *
 * *********************************************************************** */

package org.matsim.socialnetworks.replanning;

import org.matsim.gbl.Gbl;
import org.matsim.network.NetworkLayer;
import org.matsim.plans.Plan;
import org.matsim.plans.algorithms.PlanAlgorithmI;
import org.matsim.replanning.modules.StrategyModuleI;
import org.matsim.router.util.TravelCostI;
import org.matsim.router.util.TravelTimeI;
import org.matsim.replanning.modules.*;
/**
 * The social network replanning StrategyModule is not multi-threaded because each
 * agent could refer to and alter other agent objects in a random manner.
 *  
 * @author jhackney
 *
 */

//public class SNRandomFacilitySwitcher implements StrategyModuleI {
public class SNRandomFacilitySwitcher extends MultithreadedModuleA {
	private NetworkLayer network=null;
	private TravelCostI tcost=null;
	private TravelTimeI ttime=null;
	/** 
	 * TODO [JH] this is hard-coded here but has to match the standard facility types
	 * in the facilities object. Need to make this change in the SNControllers, too.
	 */
	private String[] factypes={"home","work","shop","education","leisure"};
	
    public SNRandomFacilitySwitcher(NetworkLayer network, TravelCostI tcost, TravelTimeI ttime) {
//	public SNRandomFacilitySwitcher() {
		System.out.println("initializing SNRandomFacilitySwitcher");
    	this.network=network;
    	this.tcost = tcost;
    	this.ttime = ttime;
//    	This is a workaround until factypes can be put into a config file that is
//    	available to all elements of the SN run
//    	this.factypes = playground.jhackney.controler.SNControllerListenerRePlanSecLoc.activityTypesForEncounters;
    }

    public PlanAlgorithmI getPlanAlgoInstance() {
//	return new SNSecLocShortest(factypes, network, tcost, ttime);
	return new SNSecLocRandom(factypes, network, tcost, ttime);
    }
//
//	public void finish() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void handlePlan(Plan plan) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void init() {
//		// TODO Auto-generated method stub
//		
//	}



}
