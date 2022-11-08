package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.weapon.BOW
import cl.uchile.dcc.finalreality.model.weapon.STAFF
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue

class WhiteMageTest : FunSpec({

    lateinit var whiteMage1: WhiteMage
    lateinit var whiteMage2: WhiteMage
    lateinit var whiteMage3: WhiteMage

    val staff = STAFF("staff", 10, 10)
    val bow = BOW("bow", 10, 10)

    beforeEach {
        val queue = LinkedBlockingQueue<GameCharacter>()

        whiteMage1 = WhiteMage("white mage", 10, 10, 10, queue)
        whiteMage2 = WhiteMage("white mage", 10, 10, 10, queue)
        whiteMage3 = WhiteMage("white magen't", 15, 20, 20, queue)
    }

    test("Two white mages with the same name, maxHP, maxMP and defense should be equals") {
        whiteMage1 shouldNotBeSameInstanceAs whiteMage2
        whiteMage1 shouldBe whiteMage2
    }

    test("Two white mages with different names, maxHP, maxMP and defense should not be equal") {
        whiteMage1 shouldNotBe whiteMage3
    }

    test("The string representation of a white mage should be correct") {
        "$whiteMage1" shouldBe "WhiteMage { name: 'white mage', maxMp: 10, maxHp: 10, defense: 10, currentMp: 10 }"
    }

    test("A white mage should be able to equip a staff") {
        whiteMage1.equip(staff)
        whiteMage1.equippedWeapon shouldBe staff
    }

    test("A white mage shouldn't be able to equip a bow") {
        whiteMage2.equip(bow)
        whiteMage2.equippedWeapon shouldNotBe bow
    }

    test("The currentMp of a mage should be less than their maxMp") {
        whiteMage3.currentMp = 15
        whiteMage3.currentMp shouldBeLessThanOrEqual whiteMage3.maxMp
    }

    test("The current Hp of a mage should be less than their max Hp") {
        whiteMage3.currentHp = 12
        whiteMage3.currentHp shouldBeLessThanOrEqual whiteMage3.maxHp
    }
})
