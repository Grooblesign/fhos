package uk.me.paulgarner.fh.conversion;

import uk.me.paulgarner.fh.domain.Citation;
import uk.me.paulgarner.fh.entity.CitationEntity;

public class CitationEntityToCitation {

	public static Citation adapt(CitationEntity in) {
		
		Citation out = null;
		
		if (null != in) {
			out = new Citation();
			
			out.setId(in.getId());
			out.setDetails(in.getDetails());
			out.setSourceId(in.getSourceId());
		}
		
		return out;	
	}
}
