package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.weapon.AXE
import cl.uchile.dcc.finalreality.model.weapon.KNIFE
import cl.uchile.dcc.finalreality.model.weapon.STAFF
import cl.uchile.dcc.finalreality.model.weapon.SWORD
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue

/**
 * Tests for the class Knight and its methods
 * including inherited methods from father classes
 *
 * @constructor creates tests for knight
 *
 * @author Daniela Moraga
 */

class KnightTest : FunSpec({

    lateinit var knight1: Knight
    lateinit var knight2: Knight
    lateinit var knight3: Knight

    val axe = AXE("axe", 10, 10)
    val knife = KNIFE("knife", 10, 10)
    val sword = SWORD("sword", 10, 10)
    val staff = STAFF("staff", 10, 10)

    beforeEach {
        val queue = LinkedBlockingQueue<GameCharacter>()

        knight1 = Knight("knight", 10, 10, queue)
        knight2 = Knight("knight", 10, 10, queue)
        knight3 = Knight("knightn't", 15, 15, queue)
    }

    test("Two knights with the same name, maxHP and defense should be equals") {
        knight1 shouldNotBeSameInstanceAs knight2
        knight1 shouldBe knight2
    }

    test("Two knights with different names, maxHP or defense should not be equal") {
        knight1 shouldNotBe knight3
    }

    test("The string representation of a knight should be correct") {
        "$knight1" shouldBe "Knight { name: 'knight', maxHp: 10, defense: 10, currentHp: 10 }"
    }

    test("A knight should be able to equip an axe") {
        knight1.equip(axe)
        knight1.equippedWeapon shouldBe axe
    }

    test("A knight should be able to equip a knife") {
        knight2.equip(knife)
        knight2.equippedWeapon shouldBe knife
    }

    test("A knight should be able to equip a sword") {
        knight3.equip(sword)
        knight3.equippedWeapon shouldBe sword
    }

    test("A knight shouldn't be able to equip a staff") {
        knight3.equip(staff)
        knight3.equippedWeapon shouldNotBe staff
    }

    test("The current Hp of a knight should be less than their max Hp") {
        knight3.currentHp = 12
        knight3.currentHp shouldBeLessThanOrEqual knight3.maxHp
    }
})
