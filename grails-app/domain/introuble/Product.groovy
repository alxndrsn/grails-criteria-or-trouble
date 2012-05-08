package introuble

class Product {
	String name
	static hasMany = [additives:Additive]

	static constraints = {
		name nullable:true
	}

	static namedQueries = {
		searchAll { taste ->
			or {
				eq('name', taste)
				additives { eq('flavor', taste) }
			}
		}
		searchAdditives { taste ->
			or {
				additives { eq('flavor', taste) }
			}
		}
		searchProducts { taste ->
			or {
				eq('name', taste)
			}
		}
	}
}
