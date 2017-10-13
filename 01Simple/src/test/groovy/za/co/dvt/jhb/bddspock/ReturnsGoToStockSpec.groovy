package za.co.dvt.jhb.bddspock

import spock.lang.Shared
import spock.lang.Specification

class ReturnsGoToStockSpec extends Specification {
    @Shared
    StockKeeper stockKeeper = new StockKeeper()

    def "Refunded items should go to stock"() {
        given: "That a customer bought a black garment from me"
        def blackGarment = new Garment(Color.BLACK)
        and: "I have three black sweaters in stock"
        stockKeeper.garments[Color.BLACK] = (0..<3).collect {new Garment(Color.BLACK)}
        when: "He returns the sweater"
        stockKeeper.returnGarment blackGarment
        then: "I should have four black sweaters in stock"
        stockKeeper.garments[Color.BLACK].size() == 4

    }

    def "Replaced items should be returned to stock"() {
        given: "That a customer buys a blue garment"
        and: "I have 2 blue garments in stock"
        and: "3 black garments in stock"

        when: "He returns the blue garment for a replacement black one"

        then: "I should have 3 blue garments in stock"
        and: "Two black garments in stock"
    }
}
