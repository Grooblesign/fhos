package uk.me.paulgarner.fh.domain;

public class SourceCitation {

	private Citation citation;
	private Source source;
	
	public SourceCitation(Source source, Citation citation) {
		this.citation = citation;
		this.source = source;
	}

	public Citation getCitation() {
		return citation;
	}

	public void setCitation(Citation citation) {
		this.citation = citation;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}
}
