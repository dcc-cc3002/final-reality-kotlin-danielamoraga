/*
 * "Final Reality" (c) by R8V and Daniela Moraga
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.Weapon

/**
 * A character controlled by the user.
 *
 * @property equippedWeapon
 *    the weapon that the character is currently using
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Daniela Moraga
 */
interface PlayerCharacter {
  val equippedWeapon: Weapon

  /**
   * Equips a weapon to the character.
   */
  fun equip(weapon: Weapon)
}