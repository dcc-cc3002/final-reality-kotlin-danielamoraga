package cl.uchile.dcc.finalreality.model.weapon

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

class STAFFTest : FunSpec({

    lateinit var staff1: STAFF
    lateinit var staff2: STAFF
    lateinit var staff3: STAFF

    beforeEach {
        staff1 = STAFF("staff", 10, 10)
        staff2 = STAFF("staff", 10, 10)
        staff3 = STAFF("staffn't", 20, 20)
    }

    test("Two staffs with the same name, damage and weight should be equals") {
        staff1 shouldNotBeSameInstanceAs staff2
        staff1 shouldBe staff2
    }

    test("Two staffs with different names, damage or weight should not be equal") {
        staff1 shouldNotBe staff3
    }

    test("The string representation of a staff should be correct") {
        "$staff1" shouldBe "STAFF { name: staff, damage: 10, weight: 10 }"
    }
})
