package me.nallar.whocalled;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WhoCalledTest {
	@Test
	public void testGetCallingClass() throws Exception {
		new Runnable() {
			@Override
			public void run() {
				assertEquals(WhoCalled.$.getCallingClass(), WhoCalledTest.class);
			}
		}.run();
	}

	@Test
	public void testGetCallingClass1() throws Exception {
		new Runnable() {
			@Override
			public void run() {
				assertEquals(WhoCalled.$.getCallingClass(1), WhoCalledTest.class);
				assertEquals(WhoCalled.$.getCallingClass(0), this.getClass());
			}
		}.run();
		assertEquals(WhoCalled.$.getCallingClass(0), WhoCalledTest.class);
	}

	@Test
	public void testIsCalledByClass() throws Exception {
		new Runnable() {
			@Override
			public void run() {
				assertTrue(WhoCalled.$.isCalledByClass(WhoCalledTest.class));
			}
		}.run();
	}
}
