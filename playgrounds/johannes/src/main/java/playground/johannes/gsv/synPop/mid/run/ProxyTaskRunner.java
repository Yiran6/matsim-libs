/* *********************************************************************** *
 * project: org.matsim.*
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2014 by the members listed in the COPYING,        *
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

package playground.johannes.gsv.synPop.mid.run;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import playground.johannes.gsv.synPop.CommonKeys;
import playground.johannes.gsv.synPop.ProxyPerson;
import playground.johannes.gsv.synPop.ProxyPersonTask;
import playground.johannes.gsv.synPop.ProxyPlanTask;

/**
 * @author johannes
 *
 */
public class ProxyTaskRunner {

	public static void run(ProxyPersonTask task, Collection<ProxyPerson> persons) {
		for(ProxyPerson person : persons)
			task.apply(person);
	}
	
	public static void run(ProxyPlanTask task, Collection<ProxyPerson> persons) {
		for(ProxyPerson person : persons)
			task.apply(person.getPlan());
	}
	
	public static Set<ProxyPerson> runAndDelete(ProxyPersonTask task, Collection<ProxyPerson> persons) {
		Set<ProxyPerson> newPersons = new HashSet<ProxyPerson>(persons.size());
		
		run(task, persons);
		
		for(ProxyPerson person : persons) {
			if(!"true".equalsIgnoreCase(person.getAttribute(CommonKeys.DELETE))) {
				newPersons.add(person);
			}
		}
		
		return newPersons;
	}
}
