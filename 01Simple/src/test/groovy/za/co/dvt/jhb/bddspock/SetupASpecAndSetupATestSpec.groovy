package za.co.dvt.jhb.bddspock

import spock.lang.Specification

class SetupASpecAndSetupATestSpec extends Specification {
    def setupSpec() {
        println "setupSpec() ran before all the tests are run"
    }

    def cleanupSpec() {
        println "cleanupSpec() ran after all the tests are finished in the specification"
    }

    def setup() {
        println "setup() is called before each test"
    }

    def cleanup() {
        println "cleanup() is called after each test"
    }

    def "Running test 1"() {
        setup:
        println "Test 1"
        expect:
        true
    }

    def "Running test 2"() {
        setup:
        println "Test 2"
        expect:
        true
    }
}
