package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.weapon.AXE
import cl.uchile.dcc.finalreality.model.weapon.BOW
import cl.uchile.dcc.finalreality.model.weapon.KNIFE
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue

/**
 * Tests for the class Engineer and its methods
 * including inherited methods from father classes
 *
 * @constructor creates tests for engineer
 *
 * @author Daniela Moraga
 */

class EngineerTest : FunSpec({

    lateinit var engineer1: Engineer
    lateinit var engineer2: Engineer
    lateinit var engineer3: Engineer

    val axe = AXE("axe", 10, 10)
    val bow = BOW("bow", 10, 10)
    val knife = KNIFE("knife", 10, 10)

    beforeEach {
        val queue = LinkedBlockingQueue<GameCharacter>()

        engineer1 = Engineer("engineer", 10, 10, queue)
        engineer2 = Engineer("engineer", 10, 10, queue)
        engineer3 = Engineer("engineern't", 15, 15, queue)
    }

    test("Two engineers with the same name, maxHP and defense should be equals") {
        engineer1 shouldNotBeSameInstanceAs engineer2
        engineer1 shouldBe engineer2
    }

    test("Two engineers with different names, maxHP or defense should not be equal") {
        engineer1 shouldNotBe engineer3
    }

    test("The string representation of an engineer should be correct") {
        "$engineer1" shouldBe "Engineer { name: 'engineer', maxHp: 10, defense: 10, currentHp: 10 }"
    }

    test("An engineer should be able to equip an axe") {
        engineer1.equip(axe)
        engineer1.equippedWeapon shouldBe axe
    }

    test("An engineer should be able to equip a bow") {
        engineer2.equip(bow)
        engineer2.equippedWeapon shouldBe bow
    }

    test("An engineer shouldn't be able to equip a sword") {
        engineer3.equip(knife)
        engineer3.equippedWeapon shouldBe null
    }

    test("The current Hp of an engineer should be less than their max Hp") {
        engineer3.currentHp = 12
        engineer3.currentHp shouldBeLessThanOrEqual engineer3.maxHp
    }
})
