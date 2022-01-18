/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.anntraining.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.anntraining.fulfilmentprocess.constants.AnntrainingFulfilmentProcessConstants;

public class AnntrainingFulfilmentProcessManager extends GeneratedAnntrainingFulfilmentProcessManager
{
	public static final AnntrainingFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (AnntrainingFulfilmentProcessManager) em.getExtension(AnntrainingFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}
