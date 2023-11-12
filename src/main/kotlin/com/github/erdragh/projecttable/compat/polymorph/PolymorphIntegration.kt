package com.github.erdragh.projecttable.compat.polymorph

import net.minecraft.world.Container
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.item.crafting.Recipe
import net.minecraft.world.item.crafting.RecipeType
import net.minecraft.world.level.Level
import top.theillusivec4.polymorph.common.crafting.RecipeSelection
import java.util.Optional

/**
 * Wrapper function around the Polymorph implementation.
 * This only gets called if the Polymorph mod is loaded, so the polymorph
 * classes only get loaded when they actually exist
 */
fun <T : Recipe<C>, C : Container> getPlayerRecipe(
    menu: AbstractContainerMenu,
    pType: RecipeType<T>,
    inventory: C,
    level: Level,
    player: Player
): Optional<T> {
    return RecipeSelection.getPlayerRecipe(menu, pType, inventory, level, player);
}
