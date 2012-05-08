package introuble

class SearchSpec extends grails.plugin.spock.IntegrationSpec {
	def choc, muff

	def 'searchAll should return products and additives that match - THIS FAILS'() {
		setup:
			createTestProducts()
		expect:
			Product.searchAll("chocolate").list() == [choc, muff]
	}


	def 'searchProducts should return only products that match - THIS PASSES'() {
		setup:
			createTestProducts()
		expect:
			Product.searchProducts("chocolate").list() == [choc]
	}

	def 'searchAdditives should return only additives that match - THIS PASSES'() {
		setup:
			createTestProducts()
		expect:
			Product.searchAdditives("chocolate").list() == [muff]
	}

	private def createTestProducts() {
		// create chocolate
		choc = new Product(name:'chocolate').save(failOnError:true, flush:true)
		// create a chocoloate-flavored muffin
		muff = new Product(name:'muffin').addToAdditives(flavor:'chocolate').save(failOnError:true, flush:true)
	}
}
