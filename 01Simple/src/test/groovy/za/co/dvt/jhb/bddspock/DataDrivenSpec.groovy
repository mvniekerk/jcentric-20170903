package za.co.dvt.jhb.bddspock

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class DataDrivenSpec extends Specification {

    @Shared
    StringConcat stringConcat = new StringConcatImpl()

    @Unroll
    def "#valA + #valB = #ret"() {
        expect: "Do concatenation"
        stringConcat.concat(valA, valB) == ret
        and: "Reverse is a tabular decucted value"
        reverse == valB + valA
        and: "shared is always the same"
        shared == "shared between"

        where:
        valA    | valB      || ret
        "ba"    | "ba"      || "baba"
        "black" | "sheep"   || "blacksheep"
        "have"  | "you"     || "have you"

        reverse = stringConcat.concat valB, valA
        shared = "shared between"
    }

    def "Showcase Groovy method overrides"() {
        setup: "String concat to be our own implementation"
        stringConcat = [
                concat: { String a, String b ->
                    a + b
                }
        ] as StringConcat       // Only implement the methods we want to
        expect:
        "baba" == stringConcat.concat("ba", "ba")
    }
}
