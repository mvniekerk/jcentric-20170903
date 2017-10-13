package za.co.dvt.jhb.bddspock

import spock.lang.Shared
import spock.lang.Specification

class StubbingSpec extends Specification {
    interface Subscriber {
        String receive(String message)
    }


    def "Make subscriber always return ok"() {
        setup:
        Subscriber subscriber = Stub()
        subscriber.receive(_) >> "ok"

        expect: "Invocation returns ok"
        subscriber.receive("hello") == "ok"
        and: "And invocation returns ok again"
        subscriber.receive("bye") == "ok"
    }

    def "Make subscriber return values in a list"() {
        setup:
        Subscriber subscriber = Stub()
        subscriber.receive(_) >>> ["ok", "no", "maybe"]

        expect: "First invocation returns ok"
        subscriber.receive("1") == "ok"
        and: "Second invocation returns no"
        subscriber.receive("2") == "no"
        and: "Third returns maybe"
        subscriber.receive("3") == "maybe"
    }

    def "Make a computed effort on the stubbed implementation"() {
        setup:
        Subscriber subscriber = Stub()
        subscriber.receive(_) >> {String val1 -> "${val1.size()}"}

        expect: "ABC returns 3"
        subscriber.receive("ABC") == "3"
        and: "Hello returns 5"
        subscriber.receive("Hello") == "5"
    }
}
