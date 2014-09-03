package net.daneking.skillstool.person;

import java.net.URI;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

class IsNotAURIPath extends TypeSafeMatcher<URI> {
	/**
	 *
	 */
	private final String path;

	public IsNotAURIPath(final String path) {
		this.path = path;
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("was not").appendValue(path);

	}

	@Override
	protected void describeMismatchSafely(final URI item, final Description mismatchDescription) {
		mismatchDescription.appendText("was").appendValue(item.toString());
	}

	@Override
	protected boolean matchesSafely(final URI uri) {
		return uri.getPath().equals(path);
	}

}