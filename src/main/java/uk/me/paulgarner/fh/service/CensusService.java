package uk.me.paulgarner.fh.service;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import uk.me.paulgarner.fh.dao.CensusDAO;
import uk.me.paulgarner.fh.dao.CensusHouseholdDAO;
import uk.me.paulgarner.fh.dao.CensusHouseholdPersonDAO;

@Model
public class CensusService {
	
	@Inject
	private CensusDAO censusDAO;

	@Inject
	private CensusHouseholdDAO censusHouseholdDAO;

	@Inject
	private CensusHouseholdPersonDAO censusHouseholdPersonDAO;

}
