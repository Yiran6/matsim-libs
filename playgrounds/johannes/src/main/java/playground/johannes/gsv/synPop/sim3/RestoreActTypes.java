/* *********************************************************************** *
 * project: org.matsim.*
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2015 by the members listed in the COPYING,        *
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

package playground.johannes.gsv.synPop.sim3;

import playground.johannes.synpop.data.CommonKeys;
import playground.johannes.synpop.processing.EpisodeTask;
import playground.johannes.synpop.data.Attributable;
import playground.johannes.synpop.data.Episode;

/**
 * @author johannes
 *
 */
public class RestoreActTypes implements EpisodeTask {

	@Override
	public void apply(Episode plan) {
		for(Attributable act : plan.getActivities()) {
			String orig = act.getAttribute(ReplaceActTypes.ORIGINAL_TYPE);
			if(orig != null) {
				act.setAttribute(CommonKeys.ACTIVITY_TYPE, orig);
			}
		}

	}

}
