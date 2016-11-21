package uk.me.paulgarner.fh.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import uk.me.paulgarner.fh.dao.SourceDAO;
import uk.me.paulgarner.fh.domain.Source;
import uk.me.paulgarner.fh.entity.SourceEntity;

@Model
public class SourceService {

	@Inject
	private SourceDAO sourceDAO;

	public List<Source> getAll() {
		List<SourceEntity> sourceEntities = sourceDAO.findAll();
		
		List<Source> result = new ArrayList<Source>();
		
		for (SourceEntity sourceEntity : sourceEntities) {
			Source source = new Source();
			
			source.setAuthor(sourceEntity.getAuthor());
			source.setDate(sourceEntity.getDate());
			source.setId(sourceEntity.getId());
			source.setNotes(sourceEntity.getNotes());
			source.setPublisher(sourceEntity.getPublisher());
			source.setTitle(sourceEntity.getTitle());
			source.setType(sourceEntity.getType());
			source.setUrl(sourceEntity.getUrl());
			
			result.add(source);
		}
		
		return result;
	}
}
