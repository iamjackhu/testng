package com.jack.testgn;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jack.testng.TestNgMain;

@PowerMockIgnore({ "javax.net.ssl.*", "javax.security.*", "javax.management.*" })
@RunWith(PowerMockRunner.class)
@PrepareForTest({ TestNgMain.class })
public class TestNgMainWithPowerMockitoTest {

	@BeforeTest
	public void init() {
		PowerMockito.mockStatic(TestNgMain.class);
		PowerMockito.when(TestNgMain.squre(10)).thenReturn(1);
	}

	@Test
	public void testStaticSquare() {
		int result = TestNgMain.squre(10);
		Assert.assertEquals(1, result);
	}

	@Test
	public void testPrivateInstance() {
		TestNgMain tm = new TestNgMain();

		Whitebox.setInternalState(tm, "value", 10);

		Assert.assertEquals(10, tm.getValue());
	}

	@Test
	public void testPrivateStaticInstance() {
		TestNgMain tm = new TestNgMain();

		Whitebox.setInternalState(TestNgMain.class, "staticValue", "world!");

		Assert.assertEquals("world!", tm.getStaticValue());
	}

}
