package net.daneking.skillstool.person;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PersonResourceTest {
	@InjectMocks
	private PersonResource underTest;
	@Mock
	private PersonRespository factory;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIdCallsFactoryGetOne() {
		Long id = Long.valueOf(1);
		underTest.get(id);
		verify(factory).getOne(id);
	}

	@Test
	public void getCallsFactoryGetAll() {
		Long id = Long.valueOf(1);
		underTest.get();
		verify(factory).getAll();
	}
}
