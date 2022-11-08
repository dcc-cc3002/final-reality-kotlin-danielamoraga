/*
 * "Final Reality" (c) by R8V and Daniela Moraga
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.weapon.Weapon
import java.util.Objects
import java.util.concurrent.BlockingQueue

/**
 * A Black Mage is a type of player character that can cast black magic.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param maxMp       the character's maximum magic points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new Black Mage.
 *
 * @property currentMp The current MP of the character.
 * @property currentHp The current HP of the character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Daniela Moraga
 */
class BlackMage(
    name: String,
    maxHp: Int,
    maxMp: Int, // Mana
    defense: Int,
    turnsQueue: BlockingQueue<GameCharacter>
) : Mage(name, maxHp, maxMp, defense, turnsQueue) {

    override fun equals(other: Any?) = when {
        this === other -> true
        other !is BlackMage -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        maxHp != other.maxHp -> false
        maxMp != other.maxMp -> false
        defense != other.defense -> false
        else -> true
    }

    override fun hashCode() =
        Objects.hash(BlackMage::class, name, maxHp, maxMp, defense)

    override fun toString() = "BlackMage { " +
        "name: '$name', " +
        "maxMp: $maxMp, " +
        "maxHp: $maxHp, " +
        "defense: $defense, " +
        "currentMp: $currentMp " +
        "}"

    override fun equip(weapon: Weapon) {
        weapon.equippedByBlackMage(this)
    }
}
