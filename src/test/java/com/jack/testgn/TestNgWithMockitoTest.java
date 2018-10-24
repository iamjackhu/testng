package com.jack.testgn;

import org.junit.Assert;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jack.testng.StringValueObject;

public class TestNgWithMockitoTest {

	private StringValueObject ov1;

	@BeforeClass
	public void init() {
		ov1 = new StringValueObject();
		ov1 = Mockito.mock(StringValueObject.class);
		Mockito.when(ov1.getValue()).thenReturn("StringValueObject");
	}

	@DataProvider(name = "dp")
	private Object[] serviceData() {
		ov1.setValue("ov1");
		StringValueObject ov2 = new StringValueObject();
		ov2.setValue("ov2");
		return new Object[] { ov1, ov2 };
	}

	@Test(dataProvider = "dp")
	public void testWithDataProvider(StringValueObject svo) {
		System.out.println(svo.getValue());
		Assert.assertTrue(svo.getValue().equals("ov2") || svo.getValue().equals("StringValueObject"));
	}

}
