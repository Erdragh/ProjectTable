package com.github.erdragh.projecttable.block

import com.github.erdragh.projecttable.ProjectTable
import com.github.erdragh.projecttable.block.entity.ProjectTableBlockEntity
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.core.Registry
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.entity.BlockEntityType

object ModBlocks {
    val PROJECT_TABLE = register(ProjectTableBlock(), "projecttable", true, CreativeModeTab.TAB_DECORATIONS)
    val PROJECT_TABLE_ENTITY_TYPE: BlockEntityType<ProjectTableBlockEntity> = Registry.register(Registry.BLOCK_ENTITY_TYPE, ProjectTable.id("projecttable_entity"),
        FabricBlockEntityTypeBuilder.create(::ProjectTableBlockEntity, PROJECT_TABLE).build())

    fun initialize() {
    }
}

fun <T : Block> register(block: T, name: String, shouldRegisterItem: Boolean, creativeTab: CreativeModeTab): T {
    val resourceLocation = ProjectTable.id(name)

    if (shouldRegisterItem) {
        val blockItem = BlockItem(block, FabricItemSettings().group(creativeTab))
        Registry.register(Registry.ITEM, resourceLocation, blockItem)
    }

    return Registry.register(Registry.BLOCK, resourceLocation, block)
}
