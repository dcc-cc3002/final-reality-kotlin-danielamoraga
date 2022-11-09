package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.weapon.AXE
import cl.uchile.dcc.finalreality.model.weapon.BOW
import cl.uchile.dcc.finalreality.model.weapon.KNIFE
import cl.uchile.dcc.finalreality.model.weapon.SWORD
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue

/**
 * Tests for the class Thief and its methods
 * including inherited methods from father classes
 *
 * @constructor creates tests for thief
 *
 * @author Daniela Moraga
 */
class ThiefTest : FunSpec({

    lateinit var thief1: Thief
    lateinit var thief2: Thief
    lateinit var thief3: Thief

    val axe = AXE("axe", 10, 10)
    val bow = BOW("bow", 10, 10)
    val knife = KNIFE("knife", 10, 10)
    val sword = SWORD("sword", 10, 10)

    beforeEach {
        val queue = LinkedBlockingQueue<GameCharacter>()

        thief1 = Thief("thief", 10, 10, queue)
        thief2 = Thief("thief", 10, 10, queue)
        thief3 = Thief("thiefn't", 15, 15, queue)
    }

    test("Two thieves with the same name, maxHP and defense should be equals") {
        thief1 shouldNotBeSameInstanceAs thief2
        thief1 shouldBe thief2
    }

    test("Two thieves with different names, maxHP or defense should not be equal") {
        thief1 shouldNotBe thief3
    }

    test("The string representation of a thief should be correct") {
        "$thief1" shouldBe "Thief { name: 'thief', maxHp: 10, defense: 10, currentHp: 10 }"
    }

    test("A thief should be able to equip a bow") {
        thief1.equip(bow)
        thief1.equippedWeapon shouldBe bow
    }

    test("A thief should be able to equip a knife") {
        thief2.equip(knife)
        thief2.equippedWeapon shouldBe knife
    }

    test("A thief should be able to equip a sword") {
        thief3.equip(sword)
        thief3.equippedWeapon shouldBe sword
    }

    test("A thief shouldn't be able to equip an axe") {
        thief3.equip(axe)
        thief3.equippedWeapon shouldNotBe axe
    }

    test("The current Hp of a thief should be less than their max Hp") {
        thief3.currentHp = 12
        thief3.currentHp shouldBeLessThanOrEqual thief3.maxHp
    }
})
