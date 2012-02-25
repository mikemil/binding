class Address implements Serializable {
	
	static constraints = {
		street(blank:false)
		city(blank:false)
		state(blank:false)
		zip(blank:false, size:5..10)
	}

    static belongsTo = [person:Person]
	
	String street
	String city
	String state
	String zip
	
	String toString() {
		street + "\n" + city + ", " + state + " " + zip
	}
	
	int hashCode() {
		street?.hashCode() + city?.hashCode() + state?.hashCode() + zip?.hashCode()
	}
	
	boolean equals(o) {
		if (this.is(o)) return true
		if (!(o instanceof Address)) return false
		return street?.equals(o.street) && (city?.equals(o.city)) && (state?.equals(o.state)) && (zip?.equals(o.zip))
	}
	
	
}
