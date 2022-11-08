package cl.uchile.dcc.finalreality.model.weapon

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

/**
 * Tests for the class AXE and its methods
 * including inherited methods from father classes
 *
 * @constructor creates tests for axe
 *
 * @author Daniela Moraga
 */

class AXETest : FunSpec({

    lateinit var axe1: AXE
    lateinit var axe2: AXE
    lateinit var axe3: AXE

    beforeEach {
        axe1 = AXE("axe", 10, 10)
        axe2 = AXE("axe", 10, 10)
        axe3 = AXE("axen't", 20, 20)
    }

    test("Two axes with the same name, damage and weight should be equals") {
        axe1 shouldNotBeSameInstanceAs axe2
        axe1 shouldBe axe2
    }

    test("Two axes with different names, damage or weight should not be equal") {
        axe1 shouldNotBe axe3
    }

    test("The string representation of an axe should be correct") {
        "$axe1" shouldBe "AXE { name: axe, damage: 10, weight: 10 }"
    }
})
