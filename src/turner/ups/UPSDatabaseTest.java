package turner.ups;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/** 
	 * Add a Package to a Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		UPSDatabase database = new UPSDatabase();
		Package pkg = new Package("1234567");
		Location location = new Location(40687, 73452);
		database.addPackageToLocation(location, pkg);
		Assert.assertTrue(database.getPackages(location).contains(pkg));
		Assert.assertEquals(database.getLocation(pkg), location);
	}

	@Test
	/** 
	 * Add a Package to a Location then update the Package Location to a different Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with the first Location.
	 */
	public void testUpdatePackageLocation() {
		UPSDatabase database = new UPSDatabase();
		Package pkg = new Package("6758392");
		Location location = new Location(44444, 77777);
		database.addPackageToLocation(location, pkg);
		Location newLocation = new Location(55555, 66666);
		database.updatePackageLocation(pkg, newLocation);
		Assert.assertTrue(database.getPackages(newLocation).contains(pkg));
		Assert.assertEquals(database.getLocation(pkg), newLocation);
		Set<Package> emptySet = new HashSet<Package>();
		Assert.assertEquals(database.getPackages(location), emptySet);
	}

	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with
	 * a Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		UPSDatabase database = new UPSDatabase();
		Location location = new Location(68490, 78463);
		Set<Package> emptySet = new HashSet<Package>();
		Assert.assertEquals(database.getPackages(location), emptySet);
	}

	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		UPSDatabase database = new UPSDatabase();
		Package pkg = new Package("7654321");
		Assert.assertNull(database.getLocation(pkg));

	}

}
