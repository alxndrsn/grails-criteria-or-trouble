package introuble

class SearchSpec extends grails.plugin.spock.IntegrationSpec {
	def 'search should work'() {
		setup:
			// create chocolate
			def choc = new Product(name:'chocolate').save(failOnError:true, flush:true)
			// create a chocoloate-flavored muffin
			def muff = new Product(name:'muffin').addToAdditives(flavor:'chocolate').save(failOnError:true, flush:true)
		expect:
			Product.search("chocolate").list() == [choc, muff]
	}
}
