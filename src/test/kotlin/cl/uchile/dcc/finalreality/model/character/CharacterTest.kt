package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.weapon.AXE
import cl.uchile.dcc.finalreality.model.weapon.KNIFE
import cl.uchile.dcc.finalreality.model.weapon.SWORD
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe
import java.util.concurrent.LinkedBlockingQueue

lateinit var engineer: Engineer
lateinit var knight: Knight
lateinit var thief: Thief

lateinit var axe: AXE
lateinit var knife: KNIFE
lateinit var sword: SWORD

class CharacterTest : FunSpec({
    beforeEach {
        val queue = LinkedBlockingQueue<GameCharacter>()
        engineer = Engineer("engineer",10,10,queue)
        axe = AXE("axe",10,1)
        engineer.equip(axe)
        engineer.waitTurn()

        knight = Knight("knight",10,10,queue)
        sword = SWORD("sword",10,3)
        knight.equip(sword)
        knight.waitTurn()

        thief = Thief("thief",10,10,queue)
        knife = KNIFE("knife",10,5)
        thief.equip(knife)
        thief.waitTurn()

        Thread.sleep(5000)
        while (!queue.isEmpty()) {
            queue.size shouldBe 3
            queue.shouldContainInOrder(engineer, knight, thief)
        }
    }
})