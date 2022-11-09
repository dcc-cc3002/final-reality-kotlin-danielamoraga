package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.exceptions.Require
import java.util.concurrent.BlockingQueue
import java.util.concurrent.ScheduledExecutorService

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @property name
 *    The name of the character.
 * @property maxHp
 *    The maximum health points of the character.
 * @property defense
 *    The defense of the character.
 * @property turnsQueue
 *    The queue with the characters waiting for their turn.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Daniela Moraga
 */
abstract class AbstractCharacter(
    override val name: String,
    maxHp: Int,
    defense: Int,
    private val turnsQueue: BlockingQueue<GameCharacter>
) : GameCharacter {

    lateinit var scheduledExecutor: ScheduledExecutorService
    override val maxHp = Require.Stat(maxHp, "Max Hp") atLeast 1
    override var currentHp = maxHp
        set(value) {
            field = Require.Stat(value, "Current Hp") inRange 0..maxHp
        }
    override val defense = Require.Stat(defense, "Defense") atLeast 0

    override fun waitTurn() {}

    /**
     * Adds this character to the turns queue.
     */
    fun addToQueue() {
        turnsQueue.put(this)
        scheduledExecutor.shutdown()
    }
}
