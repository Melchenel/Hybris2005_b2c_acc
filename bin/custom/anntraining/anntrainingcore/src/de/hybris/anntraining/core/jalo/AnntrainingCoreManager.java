/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.anntraining.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.anntraining.core.constants.AnntrainingCoreConstants;
import de.hybris.anntraining.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
public class AnntrainingCoreManager extends GeneratedAnntrainingCoreManager
{
	public static final AnntrainingCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (AnntrainingCoreManager) em.getExtension(AnntrainingCoreConstants.EXTENSIONNAME);
	}
}
