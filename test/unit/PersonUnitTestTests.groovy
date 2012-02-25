import grails.test.*

class PersonUnitTestTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCreateEmptyPerson() {
    	def p = new Person()
		assertNotNull p
    }
	
	void testCreatePersonNoFirstName() {
		def p = new Person(lastName:'Miller')
		assertNotNull p
	}
	
	void testCreatePersonNoLastName() {
		def p = new Person(firstName:'Mike')
		assertNotNull p
	}
	
	
	void testCreatePerson() {
		def p = new Person(firstName:'Mike', lastName:'Miller')
		assertNotNull p
	}
	
	void testCreatePersonWithAddress() {
		def p = new Person(firstName:'Mike', lastName:'Miller')
		p.addToAddresses(new Address(street:'Main', city:'FM' , state:'TX', zip:'75022'))
		assertNotNull p
		assertEquals(1, p.addresses.size())
	}
}
