import org.apache.commons.collections.FactoryUtils
import org.apache.commons.collections.list.LazyList

class Person {
	
	static hasMany = [addresses:Address]
	
	static constraints = {
		firstName(blank:false)
		lastName(blank:false)
	}
	
	String firstName
	String lastName
	//List<Address> addresses = LazyList.decorate(new ArrayList(),FactoryUtils.instantiateFactory(Address.class));
	
	String toString()  {
		firstName + " " + lastName + " Addresses:"+addresses
	}
}
