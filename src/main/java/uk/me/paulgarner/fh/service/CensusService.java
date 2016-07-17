package uk.me.paulgarner.fh.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import uk.me.paulgarner.fh.dao.CensusDAO;
import uk.me.paulgarner.fh.dao.CensusHouseholdDAO;
import uk.me.paulgarner.fh.dao.CensusHouseholdPersonDAO;
import uk.me.paulgarner.fh.domain.CensusSummary;
import uk.me.paulgarner.fh.entity.Census;
import uk.me.paulgarner.fh.entity.CensusHousehold;
import uk.me.paulgarner.fh.entity.CensusHouseholdPerson;

@Model
public class CensusService {
	
	@Inject
	private CensusDAO censusDAO;

	@Inject
	private CensusHouseholdDAO censusHouseholdDAO;

	@Inject
	private CensusHouseholdPersonDAO censusHouseholdPersonDAO;
	
	@SuppressWarnings("unchecked")
	public List<CensusSummary> getAllCensusSummaryForPerson(long personId) {
		
		List<CensusSummary> result = new ArrayList<CensusSummary>();
		
		List<Census> censuses = censusDAO.findAll();
		
		Map<Long, Census> censusMap = new HashMap<Long, Census>();  
		for (Census census : censuses) {
			censusMap.put(census.getId(), census);
		}
		
		List<CensusHouseholdPerson> censusHouseholdEntries = censusHouseholdPersonDAO.findAllByPersonId(personId);
		
		for (CensusHouseholdPerson censusEntry : censusHouseholdEntries) {
			CensusSummary censusSummary = new CensusSummary();
			
			CensusHousehold censusHousehold = censusHouseholdDAO.findById(censusEntry.getCensusHouseholdId());

			CensusHouseholdPerson censusHouseholdPerson = censusHouseholdPersonDAO.findByCensusHouseholdIdAndPersonId(censusEntry.getCensusHouseholdId(), personId);
			
			censusSummary.setAddress(censusHousehold.getAddress());
			censusSummary.setAge(censusHouseholdPerson.getAge());
			censusSummary.setDate(censusMap.get(censusHousehold.getCensusId()).getDate());
			censusSummary.setId(censusHousehold.getId());
			censusSummary.setName(censusHouseholdPerson.getName());
			censusSummary.setOccupation(censusHouseholdPerson.getOccupation());
			censusSummary.setTitle(censusMap.get(censusHousehold.getCensusId()).getTitle());
			
			result.add(censusSummary);
		}
		
		Collections.sort(result);
		
		return result;
	}

	public Census getCensusById(long censusId) {
		return censusDAO.findById(censusId);
	}

	public CensusHousehold getCensusHouseholdById(long censusHouseholdId) {
		return censusHouseholdDAO.findById(censusHouseholdId);
	}
	
	public List<CensusHouseholdPerson> getAllCensusHouseholdPersonByCensusHouseholdId(long censusHouseholdId) {
		return censusHouseholdPersonDAO.findAllByCensusHouseholdId(censusHouseholdId);
	}
	
	public CensusHouseholdPerson getCensusHouseholdPersonById(long censusHouseholdPersonId) {
		return censusHouseholdPersonDAO.findById(censusHouseholdPersonId);
	}
}
