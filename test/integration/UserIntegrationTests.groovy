import grails.test.*

class UserIntegrationTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSomething() {
    	
		def u = new User(firstName:'Mike', lastName:'Miller', type:IconType.AVATAR)
		assertTrue u.validate()
			
		def u1 = new User(firstName:'Matt', lastName:'Stine', type:IconType.AVATAR)
		assertTrue u1.validate()
		
		def u2 = new User(firstName:'John', lastName:'Public', type:IconType.LOCAL_PHOTO)
		assertTrue u2.validate()
    }
}
