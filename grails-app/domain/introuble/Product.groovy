package introuble

class Product {
	String name
	static hasMany = [additives:Additive]

	static constraints = {
		name nullable:true
	}

	static namedQueries = {
		search { taste ->
			or {
				eq('name', taste)
				additives { eq('flavor', taste) }
			}
		}
	}
}
