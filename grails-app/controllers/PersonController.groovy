

class PersonController {
	
	def index = { redirect(action:list,params:params)
	}
	
	// the delete, save and update actions only accept POST requests
	static allowedMethods = [delete:'POST', save:'POST', update:'POST']
	
	def list = {
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		[ personInstanceList: Person.list( params ), personInstanceTotal: Person.count() ]
	}
	
	def show = {
		def personInstance = Person.get( params.id )
		
		if(!personInstance) {
			flash.message = "Person not found with id ${params.id}"
			redirect(action:list)
		}
		else { return [ personInstance : personInstance ]
		}
	}
	
	def delete = {
		def personInstance = Person.get( params.id )
		if(personInstance) {
			try {
				personInstance.delete()
				flash.message = "Person ${params.id} deleted"
				redirect(action:list)
			}
			catch(org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "Person ${params.id} could not be deleted"
				redirect(action:show,id:params.id)
			}
		}
		else {
			flash.message = "Person not found with id ${params.id}"
			redirect(action:list)
		}
	}
	
	def edit = {
		def personInstance = Person.get( params.id )
		
		if(!personInstance) {
			flash.message = "Person not found with id ${params.id}"
			redirect(action:list)
		}
		else {
			return [ personInstance : personInstance ]
		}
	}
	
	def update = {
		def personInstance = Person.get( params.id )
		if(personInstance) {
			if(params.version) {
				def version = params.version.toLong()
				if(personInstance.version > version) {
					
					personInstance.errors.rejectValue("version", "person.optimistic.locking.failure", "Another user has updated this Person while you were editing.")
					render(view:'edit',model:[personInstance:personInstance])
					return
				}
			}
			personInstance.properties = params
			if(!personInstance.hasErrors() && personInstance.save()) {
				flash.message = "Person ${params.id} updated"
				redirect(action:show,id:personInstance.id)
			}
			else {
				render(view:'edit',model:[personInstance:personInstance])
			}
		}
		else {
			flash.message = "Person not found with id ${params.id}"
			redirect(action:edit,id:params.id)
		}
	}
	
	def create = {
		def personInstance = new Person()
		personInstance.properties = params
		return ['personInstance':personInstance]
	}
	
	/*    def save = {
	 //def personInstance = bindPerson(params)
	 //println params
	 def personInstance = new Person(params)
	 if(!personInstance.hasErrors() && personInstance.save()) {
	 flash.message = "Person ${personInstance.id} created"
	 redirect(action:show,id:personInstance.id)
	 }
	 else {
	 render(view:'create',model:[personInstance:personInstance])
	 }
	 }
	 */    

	// this validation doesn't work - probably need to split out the 
	// creation of the Person and the Address objects...
	def save = {
		println params
		def personInstance = new Person(params)
		if(!personInstance.hasErrors()) {
			if (personInstance?.addresses && !personInstance.addresses.hasErrors()) {
				personInstance.save()
				flash.message = "Person ${personInstance.id} created"
				redirect(action:show,id:personInstance.id)
			} else {
				render(view:'create',model:[personInstance:personInstance])
			}
		}
		else {
			render(view:'create',model:[personInstance:personInstance])
		}
	}
	
	def Person bindPerson(params)  {
		def personInstance = new Person()
		def count = params.addrCount.toInteger()
		for (int i=0; i<count; i++) {
			def addr = new Address()
			bindData(addr, params["addresses["+i+"]"])
			personInstance.addresses[i] = addr
		}
		personInstance.properties = params  
		return personInstance
	}
}
