package time;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class TimeTest {
// test getTotalSeconds()
	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The total seconds were not CALCULATED properly", seconds == 18305);
	}
	@Test
	void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("05:0");});
	}
	
	@Test
	void testGetTotalSecondsBoundry() {
		int seconds = Time.getTotalSeconds("00:00:00");
		assertTrue("The total seconds were not CALCULATED properly (boundry)", seconds == 0);	}

	
// test getTotalHours()
	@Test
	void testGetTotalHoursGood() {
		int hours = Time.getTotalHours("08:05:03");
		assertTrue("The hours were not got properly", hours == 8);
	}
	@Test
	void testGetTotalHoursBad() {
		assertThrows(NumberFormatException.class, ()-> {Time.getTotalHours(":05:");});
	}
	@Test
	void testGetTotalHoursBoundry() {
		int hours = Time.getTotalHours("99:99:99");
		assertTrue("The hours were not got properly(boundry)", hours == 99);
	}
	
	
// test getTotalMinutes()

	@Test
	void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("02:09:04");
		assertTrue("The minutes were not got properly", minutes == 9);	
	}
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(NumberFormatException.class, ()-> {Time.getTotalMinutes(":05:00");});
	}
	
	@Test
	void testGetTotalMinutesBoundry() {
		int minutes = Time.getTotalMinutes("00:00:00");
		assertTrue("The minutes were not got properly(boundry)", minutes == 0);	
	}
	
// test getSeconds()
		@Test
		void testGetSecondsGood() {
			int seconds = Time.getSeconds("06:05:04");
			assertTrue("The seconds were not got properly", seconds == 4);	
		}
		
		@Test
		void testGetSecondsBad() {
			assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getSeconds("0:0:1");});
		}
		
		@Test
		void testGetSecondsBoundry() {
			int seconds = Time.getSeconds("99:99:99");
			assertTrue("The seconds were not got properly(boundry)", seconds == 99);	
		}
//first add a failing test: 	
		@Test
		void getMilliseconds() {
			int milliSeconds = Time.getMilliseconds("12:05:05:05");
			assertTrue("The seconds were not got properly(boundry)", milliSeconds == 5);	
		}
//unit tests
		@Test
		void getMillisecondsGood() {
			int milliSeconds = Time.getMilliseconds("12:08:09:02");
			assertTrue("The milliseconds were not got properly(boundry)", milliSeconds == 2);	
		}
		
		@Test
		void getMillisecondsBad() {
			assertThrows(NumberFormatException.class, ()-> {Time.getMilliseconds("05:05:07:08:9");});
		}
		
		@Test
		void getMillisecondsBoundary() {
			int milliSeconds = Time.getMilliseconds("00:00:00:00");
			assertTrue("The milliseconds were not got properly(boundry)", milliSeconds == 0);	
		}
		
	
}