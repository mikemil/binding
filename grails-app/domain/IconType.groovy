
enum IconType {
	
	LOCAL_PHOTO('Local photo'),
	AVATAR('Avatar')
	
	String name
	
	IconType(String name) {
		this.name = name
	}
	
	static list() {
		[LOCAL_PHOTO, AVATAR]
	}
}