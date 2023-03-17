package TestVagrant.com.test;

import org.testng.annotations.Test;

import TestVagrant.com.pom.TestVagrant.LRU;

public class TestVagrant_TestCase {

	// Assuming with initial capacity to store is 3
	LRU playlist = new LRU(3); 

	@Test(priority = 1)
	public void testCase1() { // The user has played the 3 songs(S)

		System.out.println("#When user has played  3 songs(S)");

		playlist.put("U1", "S1");
		playlist.put("U2", "S2");
		playlist.put("U3", "S3");

		System.out.println(" The playlist should look like(Most recent to least)- ");

		playlist.get("U3");
	}

	@Test(priority = 2, dependsOnMethods = { "testCase1" })
	public void testCase2() { // When s4 song is played

		System.out.println("#When s4 song is played");

		playlist.put("U4", "S4");

		System.out.println(" The playlist should look like(Most recent to least)- ");

		playlist.get("U4");
	}

	@Test(priority = 3, dependsOnMethods = { "testCase2" })
	public void testCase3() { // When S2 song is played

		System.out.println("#When S2 song is played ");

		System.out.println(" The playlist should look like(Most recent to least)- ");

		playlist.get("U2");
	}

	@Test(priority = 4, dependsOnMethods = { "testCase3" })
	public void testCase4() { // When S1 song is played

		System.out.println("#When S1 song is played ");

		playlist.put("U1", "S1");

		System.out.println(" The playlist should look like(Most recent to least)- ");

		playlist.get("U1");
	}

	@Test(priority = 5)
	public void testCase5() { // When random song played

		System.out.println("#When random song played Then it gives -");

		String x = playlist.get("S8");
		System.out.println(x);

	}

}
