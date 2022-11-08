package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.weapon.AXE
import cl.uchile.dcc.finalreality.model.weapon.KNIFE
import cl.uchile.dcc.finalreality.model.weapon.SWORD
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import java.util.concurrent.LinkedBlockingQueue

lateinit var engineer: Engineer
lateinit var knight: Knight
lateinit var thief: Thief
lateinit var enemy: Enemy

lateinit var axe: AXE
lateinit var knife: KNIFE
lateinit var sword: SWORD

lateinit var queue: LinkedBlockingQueue<GameCharacter>

class CharacterTest : FunSpec({
    beforeEach {
        queue = LinkedBlockingQueue<GameCharacter>()

        engineer = Engineer("engineer", 10, 10, queue)
        axe = AXE("axe", 10, 1)
        engineer.equip(axe)

        knight = Knight("knight", 10, 10, queue)
        sword = SWORD("sword", 10, 3)
        knight.equip(sword)

        thief = Thief("thief", 10, 10, queue)
        knife = KNIFE("knife", 10, 5)
        thief.equip(knife)

        enemy = Enemy("enemy", 10, 10, queue, 2)
    }

    test("Player characters with equipped weapons and enemies should be able to wait turn in the queue") {
        engineer.waitTurn()
        knight.waitTurn()
        thief.waitTurn()
        enemy.waitTurn()

        Thread.sleep(6000)
        queue.size shouldBe 4
        queue.shouldContain(engineer)
        queue.shouldContain(enemy)
        queue.shouldContain(knight)
        queue.shouldContain(thief)
    }
})
