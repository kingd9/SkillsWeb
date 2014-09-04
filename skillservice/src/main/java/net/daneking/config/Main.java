package net.daneking.config;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.core.UriBuilder;

import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;

public class Main {

	// Base URI the Grizzly HTTP server will listen on
	public static final String BASE_URI = "http://localhost:8080/skillservice/resource";
	// Setup a reusable RepresentationFactory with standard links/settings
	public static final RepresentationFactory representationFactory = new StandardRepresentationFactory().withFlag(
			RepresentationFactory.PRETTY_PRINT).withLink("website", "http://gotohal.net");
	public static URI makeUri(final Class resourceClass) throws URISyntaxException {
		URI href = UriBuilder.fromResource(resourceClass).build();
		return new URI(BASE_URI).resolve(href);
	}

}
