package cl.uchile.dcc.finalreality.model.weapon

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

/**
 * Tests for the class KNIFE and its methods
 * including inherited methods from father classes
 *
 * @constructor creates tests for knife
 *
 * @author Daniela Moraga
 */
class KNIFETest : FunSpec({

    lateinit var knife1: KNIFE
    lateinit var knife2: KNIFE
    lateinit var knife3: KNIFE

    beforeEach {
        knife1 = KNIFE("knife", 10, 10)
        knife2 = KNIFE("knife", 10, 10)
        knife3 = KNIFE("knifen't", 20, 20)
    }

    test("Two knifes with the same name, damage and weight should be equals") {
        knife1 shouldNotBeSameInstanceAs knife2
        knife1 shouldBe knife2
    }

    test("Two knifes with different names, damage or weight should not be equal") {
        knife1 shouldNotBe knife3
    }

    test("The string representation of a knife should be correct") {
        "$knife1" shouldBe "KNIFE { name: knife, damage: 10, weight: 10 }"
    }
})
