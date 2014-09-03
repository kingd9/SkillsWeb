package net.daneking.skillstool.person;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonRepresentation {
	private final Person person;
	private final Link[] links;

	public Person getPerson() {
		return person;
	}

	public Link[] getLinks() {
		return links;
	}

	public PersonRepresentation(final Person person, final Link... links) {
		this.person = person;
		this.links = links;
	}

}
