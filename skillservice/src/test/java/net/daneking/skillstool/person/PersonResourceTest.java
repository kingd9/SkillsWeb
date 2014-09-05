package net.daneking.skillstool.person;

import static org.mockito.Mockito.verify;

import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PersonResourceTest {
	private static final int ID = 1;
	@InjectMocks
	private PersonResource underTest;
	@Mock
	private PersonResponseFactory factory;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIdCallsFactoryGetOne() {
		underTest.get(Long.valueOf(ID));
		verify(factory).getOne(Long.valueOf(1));
	}

	@Test
	public void getToRootCallsGetRoot() throws URISyntaxException {
		underTest.get();
		verify(factory).getRoot();
	}

	@Test
	public void postCallsFactoryAdd() {
		Person person = new Person();
		underTest.add(person);
		verify(factory).add(person);
	}
}
