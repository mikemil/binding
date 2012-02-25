import grails.test.*

class AddressIntegrationTestsTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testAddAddressToPerson() {
		def p = new Person(firstName:'Mike', lastName:'Miller').save()
		p.addToAddresses(new Address(street:'Main', city:'FM' , state:'TX', zip:'75022'))
		assertNotNull p
        assertEquals(1, p.addresses.size())
		//println p.addresses.getClass()
    }
	
	void testAddAddressesToPerson() {
		Person p = new Person(firstName:'Mike', lastName:'Miller').save()
		p.addToAddresses(new Address(street:'Main', city:'FM' , state:'TX', zip:'75022'))
		p.addToAddresses(new Address(street:'Elm', city:'AM' , state:'TX', zip:'75025'))
		p.addToAddresses(new Address(street:'Post', city:'TM' , state:'TX', zip:'75066'))
		p.addToAddresses(new Address(street:'Baker', city:'Addison' , state:'TX', zip:'75622'))
		p.addToAddresses(new Address(street:'Turner', city:'Allen' , state:'TX', zip:'752022'))
		
		assertEquals(5, p.addresses.size())
		println p
	}
	
	// Groovy Console testing statements
	//new Person(firstName:'Joe', lastName:'Miller').save()
	//new Person(firstName:'Scott', lastName:'Miller').save()
	//new Person(firstName:'Buzz', lastName:'Miller').save()
	//new Person(firstName:'Patty', lastName:'Miller').save()
	
	//Person.list([fetch:[addresses:'eager']])      
	//def p = Person.findByLastName('Miller')
	//def mikes = Person.findAllByFirstName('Mike')
	//Person.findAllByFirstNameOrLastName('Mike', 'Miller')
	//Person.countByLastName('Miller')
	//Person.listOrderByLastName()
	//def searchPerson = new Person(lastName:'Miller')
	//def result = Person.findAll(searchPerson)
}
