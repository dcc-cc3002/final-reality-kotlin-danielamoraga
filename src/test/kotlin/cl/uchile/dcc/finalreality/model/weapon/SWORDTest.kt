package cl.uchile.dcc.finalreality.model.weapon

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

class SWORDTest : FunSpec({

    lateinit var sword1: SWORD
    lateinit var sword2: SWORD
    lateinit var sword3: SWORD

    beforeEach {
        sword1 = SWORD("sword", 10, 10)
        sword2 = SWORD("sword", 10, 10)
        sword3 = SWORD("swordn't", 20, 20)
    }

    test("Two swords with the same name, damage and weight should be equals") {
        sword1 shouldNotBeSameInstanceAs sword2
        sword1 shouldBe sword2
    }

    test("Two swords with different names, damage or weight should not be equal") {
        sword1 shouldNotBe sword3
    }

    test("The string representation of a sword should be correct") {
        "$sword1" shouldBe "SWORD { name: sword, damage: 10, weight: 10 }"
    }
})
