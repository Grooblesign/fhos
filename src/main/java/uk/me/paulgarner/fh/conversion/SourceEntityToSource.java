package uk.me.paulgarner.fh.conversion;

import uk.me.paulgarner.fh.domain.Source;
import uk.me.paulgarner.fh.entity.SourceEntity;

public class SourceEntityToSource {

	public static Source adapt(SourceEntity in) {
		
		Source out = null;
		
		if (null != in) {
			out = new Source();
			
			out.setId(in.getId());
			out.setAuthor(in.getAuthor());
			out.setDate(in.getDate());
			out.setNotes(in.getNotes());
			out.setPublisher(in.getPublisher());
			out.setTitle(in.getTitle());
			out.setType(in.getType());
			out.setUrl(in.getUrl());
		}
		
		return out;	
	}

}
