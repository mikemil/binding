class User {
	
	String firstName
	String lastName
	IconType type
	byte[] photo
	
    static constraints = {
		firstName(blank:false)
		lastName(blank:false)
		photo(nullable:true, size:0..10000000) 
		type(nullable: false,
		   validator: { iconType, user ->
			  // local photo requires the photo!
			  if (IconType.LOCAL_PHOTO == iconType) 
				  if (user.photo?.size() == 0)  
					  return "picture.required.for.local.photo.icontype"
    		})
    }
}

//validator: { iconType, user ->
//	//println "checking for local photo but no picture provided..."
//	if (IconType.LOCAL_PHOTO  == iconType) {
//		//return user.photo != null
//		if (user.photo?.size() != 0) {
//			println 'photo length not 0'
//			return true		
//		} else {
//			println 'photo length=0'
//			return false
//		}
//	} else {
//		println 'no match on the iconType'
//	}
//})
// probably change this around to put the validator on the photo