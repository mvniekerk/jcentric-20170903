package za.co.dvt.jhb.bddspock

import spock.lang.Specification

class SimpleSpecification extends Specification {
    def "Your test name goes here"() {
        expect: "Every line after an expect label must return Groovy truthiness"
        true
        and:
        true

    }

    def "Example test that fails on string comparison"() {
        expect: "Groovy calls .equals() for all == operations"
        "This is not" == "This is not the same"
    }

    def "Example test that fails on map comparison"() {
        setup: "Setup is run before all other code in a test"
        println "Hello from test"
        and: "And labels repeat the previous label"
        def mapA = [a: 'A', b: 'b']
        def mapB = [a: 'A', b: 'B']

        expect:
        mapA == mapB

        cleanup: "Cleanup is run after a test"
        println "Bye from test"
    }
}
