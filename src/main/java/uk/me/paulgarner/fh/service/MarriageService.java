package uk.me.paulgarner.fh.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import uk.me.paulgarner.fh.dao.MarriageDAO;
import uk.me.paulgarner.fh.domain.Marriage;
import uk.me.paulgarner.fh.entity.MarriageEntity;

@Model
public class MarriageService {

	@Inject
	private MarriageDAO marriageDAO;
	
	public Marriage getById(long marriageId) {
		return adapt(marriageDAO.findById(marriageId));
	}
	
	@SuppressWarnings("unchecked")
	public List<Marriage> getAllForPersonId(long personId) {
		
		List<Marriage> result = new ArrayList<Marriage>();

		List<MarriageEntity> marriageEntities = marriageDAO.findAllByPersonId(personId);
		
		for (MarriageEntity marriageEntity : marriageEntities) {
			result.add(adapt(marriageEntity));
		}
		
		Collections.sort(result);
		
		return result;
	}
	
	private Marriage adapt(MarriageEntity in) {
		Marriage out = new Marriage();
		
		out.setCitationId(in.getCitationId());
		out.setDate(in.getDate());
		out.setHusbandId(in.getHusbandId());
		out.setId(in.getId());
		out.setLocation(in.getLocation());
		out.setNotes(in.getNotes());
		out.setWifeId(in.getWifeId());

		return out;
	}
}
