package project3;

import java.util.ArrayList;
/**
 * This class represents a single species, encapsulating its common name, 
 * scientific name, taxonomic information, conservation status in New York, 
 * and presence in counties. 
 * It implements the Comparable interface.
 *
 * @author Joanna Klukowska
 */
public class Species implements Comparable<Species> {

	
	private String commonName;
	private String scientificName;
	private String category;
	private String taxonomicGroup;
	private String taxonomicSubGroup;
	private String NYListingStatus;
	private ArrayList<String> counties; 
	
	
	
	
	
	/**
     * Creates a new Species object with the specified details.
     *
     * @param category        the category of the species
     * @param taxonomicGroup  the taxonomic group of the species
     * @param taxonomicSubGroup the taxonomic subgroup of the species
     * @param scientificName   the scientific name of the species
     * @param commonName       the common name of the species
     * @param NYListingStatus  the conservation status of the species in New York
     * @throws IllegalArgumentException if any of the parameters are null or empty
     */
	public Species(
			String category, 
			String taxonomicGroup,
			String taxonomicSubGroup, 
			String scientificName, 
			String commonName, 
			String NYListingStatus
			) {
		if (category == null || category.isEmpty()) 
			throw new IllegalArgumentException ("category cannot be null or emtpy"); 
		if (taxonomicGroup == null || taxonomicGroup.isEmpty()) 
			throw new IllegalArgumentException ("taxonomicGroup cannot be null or emtpy"); 
		if (taxonomicSubGroup == null || taxonomicSubGroup.isEmpty()) 
			throw new IllegalArgumentException ("taxonomicSubGroup cannot be null or emtpy"); 
		if (scientificName == null || scientificName.isEmpty()) 
			throw new IllegalArgumentException ("scientificName cannot be null or emtpy"); 
		if (commonName == null || commonName.isEmpty()) 
			throw new IllegalArgumentException ("commonName cannot be null or emtpy"); 
		if (NYListingStatus == null || NYListingStatus.isEmpty()) 
			throw new IllegalArgumentException ("NYListingStatus cannot be null or emtpy"); 
		
		
		this.commonName = commonName;
		this.scientificName = scientificName;
		this.category = category;
		this.taxonomicGroup = taxonomicGroup;
		this.taxonomicSubGroup = taxonomicSubGroup;
		this.NYListingStatus = NYListingStatus;
		
		counties = new ArrayList<String>(62);
	}
    /**
     * Checks if the species is present in the specified county.
     *
     * @param county The name of the county to check.
     * @return true if the species is present in the specified county, 
     * false otherwise.
     */
	public boolean isPresentIn(String county ) {
		return counties.contains(county); 
	}


    /**
     * Adds a county to the list of counties where the species is present.
     *
     * @param county The name of the county to add.
     * @return true if the county was added successfully, false if the county 
     * was already present.
     */
	public boolean addCounty(String county) {
		if (!counties.contains(county)) {
			counties.add(county);
			return true;
		}
		else {
			return false; 
		}
	}

	
	
	/**
	 * Returns the value of the common name for this species. 
	 * @return the commonName
	 */
	public String getCommonName() {
		return commonName;
	}

	/**
	 * Returns the value of the scientific name for this species. 
	 * @return the scientificName
	 */
	public String getScientificName() {
		return scientificName;
	}

	/**
	 * Returns the value of the category for this species. 
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Returns the value of the taxonomic group for this species. 
	 * @return the taxonomicGroup
	 */
	public String getTaxonomicGroup() {
		return taxonomicGroup;
	}

	/**
	 * Returns the value of the taxonomic subgroup for this species. 
	 * @return the taxonomicSubGroup
	 */
	public String getTaxonomicSubGroup() {
		return taxonomicSubGroup;
	}

	/**
	 * Returns the value of the NY listing status for this species. 
	 * @return the nYListingStatus
	 */
	public String getNYListingStatus() {
		return NYListingStatus;
	}

	/**
	 * Returns the string representation of this Species object.
	 * @return the string representation of this Species object 
	 */
	@Override
	public String toString () {
		
		return String.format("%s (%s)\n%s, %s\n%s\npresent in %d / 62 counties", 
					commonName, scientificName, taxonomicGroup, taxonomicSubGroup, 
					NYListingStatus, counties.size() );
	}
	
	/**
    * Compares this <code>Species</code> object to the specified object.  
    * The result is <code>true</code> if and only if the argument is not 
    * <code>null</code> and is a <code>Species</code> object that represents 
    * the same species, i.e., the category, common name, scientific name, 
    * taxonomic group and subgroup are all equal. All comparisons are 
    * case insensitive.     *
    * @param  obj the object to compare this <code>Species</code> object to
    * @return  <code>true</code> if the given object represents a <code>Species</code> 
    *          equivalent to this object, <code>false</code> otherwise
    */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Species other = (Species) obj;
		if (!category.equalsIgnoreCase(other.category)) {
			return false;
		}
		if (!commonName.equalsIgnoreCase(other.commonName)) {
			return false;
		}
		if (!scientificName.equalsIgnoreCase(other.scientificName)) {
			return false;
		}
		if (!taxonomicGroup.equalsIgnoreCase(other.taxonomicGroup)) {
			return false;
		}
		if (!taxonomicSubGroup.equalsIgnoreCase(other.taxonomicSubGroup)) {
			return false;
		}
		return true;
	}
	
	/** Compares this object with the specified object for order. 
	 * @param o the object to be compared. The comparison is based on the alphanumeric
	 * case-insensitive comparison of common names, followed by scientific names. 
	 * @return a negative integer, zero, or a positive integer as this object 
	 * is less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(Species o) {
		int comp = this.commonName.compareToIgnoreCase(o.commonName);
		if (comp == 0 )
			return this.scientificName.compareToIgnoreCase(o.scientificName);
		else 
			return comp;
	}
	
	/**
	 * Returns the list of counties where this species is present.
	 * 
	 * @return the counties
	 */
	public ArrayList<String> getCounties() {
		return counties;
		
	}
	
	
	
		
}
