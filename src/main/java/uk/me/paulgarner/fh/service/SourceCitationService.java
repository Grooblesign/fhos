package uk.me.paulgarner.fh.service;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import uk.me.paulgarner.fh.conversion.CitationEntityToCitation;
import uk.me.paulgarner.fh.conversion.SourceEntityToSource;
import uk.me.paulgarner.fh.dao.CitationDAO;
import uk.me.paulgarner.fh.dao.SourceDAO;
import uk.me.paulgarner.fh.domain.SourceCitation;
import uk.me.paulgarner.fh.entity.CitationEntity;
import uk.me.paulgarner.fh.entity.SourceEntity;

@Model
public class SourceCitationService {

	@Inject
	private CitationDAO citationDAO;

	@Inject
	private SourceDAO sourceDAO;

	public SourceCitation getByCitationId(long citationId) {
		SourceCitation result = null;
		
		if (citationId != 0) {
			CitationEntity citationEntity = citationDAO.findById(citationId);
			SourceEntity sourceEntity = null;
			
			if ((null != citationEntity) && (0 != citationEntity.getId())) {
				sourceEntity = sourceDAO.findById(citationEntity.getSourceId());

				result = new SourceCitation(SourceEntityToSource.adapt(sourceEntity), CitationEntityToCitation.adapt(citationEntity));
			}
		}
		
		return result;
	}
}
