package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.weapon.KNIFE
import cl.uchile.dcc.finalreality.model.weapon.STAFF
import cl.uchile.dcc.finalreality.model.weapon.SWORD
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue

class BlackMageTest : FunSpec({

    lateinit var blackMage1: BlackMage
    lateinit var blackMage2: BlackMage
    lateinit var blackMage3: BlackMage

    val knife = KNIFE("knife", 10, 10)
    val staff = STAFF("staff", 10, 10)
    val sword = SWORD("sword", 10, 10)

    beforeEach {
        val queue = LinkedBlockingQueue<GameCharacter>()

        blackMage1 = BlackMage("black mage", 10, 10, 10, queue)
        blackMage2 = BlackMage("black mage", 10, 10, 10, queue)
        blackMage3 = BlackMage("black magen't", 15, 20, 20, queue)
    }

    test("Two black mages with the same name, maxHP, maxMP and defense should be equals") {
        blackMage1 shouldNotBeSameInstanceAs blackMage2
        blackMage1 shouldBe blackMage2
    }

    test("Two black mages with different names, maxHP, maxMP and defense should not be equal") {
        blackMage1 shouldNotBe blackMage3
    }

    test("The string representation of a black mage should be correct") {
        "$blackMage1" shouldBe "BlackMage { name: 'black mage', maxMp: 10, maxHp: 10, defense: 10, currentMp: 10 }"
    }

    test("A black mage should be able to equip a knife") {
        blackMage1.equip(knife)
        blackMage1.equippedWeapon shouldBe knife
    }

    test("A black mage should be able to equip a staff") {
        blackMage2.equip(staff)
        blackMage2.equippedWeapon shouldBe staff
    }

    test("A black mage shouldn't be able to equip a sword") {
        blackMage3.equip(sword)
        blackMage3.equippedWeapon shouldBe null
    }

    test("The current Mp of a mage should be less than their max Mp") {
        blackMage3.currentMp = 15
        blackMage3.currentMp shouldBeLessThanOrEqual blackMage3.maxMp
    }

    test("The current Hp of a mage should be less than their max Hp") {
        blackMage3.currentHp = 12
        blackMage3.currentHp shouldBeLessThanOrEqual blackMage3.maxHp
    }
})
