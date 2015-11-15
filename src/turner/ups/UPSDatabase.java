package turner.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class. No
 * loops
 */

public class UPSDatabase {

	private HashMap<Package, Location> packageLocation = new HashMap<Package, Location>();
	private HashMap<Location, Set<Package>> locationPackages = new HashMap<Location, Set<Package>>();

	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation(Location location, Package pkg) {
		// add to packageLocation
		packageLocation.put(pkg, location);
		// ad to locationPackages
		Set<Package> pkgs = locationPackages.get(location);
		if (pkgs == null) {
			pkgs = new HashSet<Package>();
		}
		pkgs.add(pkg);
		locationPackages.put(location, pkgs);
	}

	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation(Package pkg, Location location) {
		// find pkg at its current location and replace it
		if (packageLocation.containsKey(pkg)) {
			packageLocation.put(pkg, location);
			Set<Package> pkgs = locationPackages.get(location);
			if (pkgs == null) {
				pkgs = new HashSet<Package>();
			}
			pkgs.add(pkg);
			locationPackages.put(location, pkgs);
		}
	}

	/**
	 * @return a Set of Packages at the specified Location or an empty Set if
	 *         the Location doesn't exist or there are no Packages at that
	 *         Location.
	 */
	public Set<Package> getPackages(Location location) {
		Set<Package> set = new HashSet<Package>();

		if (!locationPackages.containsKey(location)) {
			return set; // return empty set
		} else {
			// return packages based on location
			if (packageLocation.containsValue(location)) {
				return locationPackages.get(location);
			}
		}
		return set; // returns empty set if location doesn't exist

	}

	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		if (packageLocation.containsKey(pkg)) {
			return packageLocation.get(pkg);
		}
		return null;
	}
}
