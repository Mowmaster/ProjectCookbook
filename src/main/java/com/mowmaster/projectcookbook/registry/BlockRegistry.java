package com.mowmaster.projectcookbook.registry;

import com.mowmaster.projectcookbook.ProjectCookbook;
import com.mowmaster.projectcookbook.block.BaseFoodBlock;
import com.mowmaster.projectcookbook.block.crops.BaseCropBlock;
import com.mowmaster.projectcookbook.util.References;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class BlockRegistry
{

    public static final Block SALT_BLOCK = registerBlock("block_salt",
            new Block(FabricBlockSettings.copyOf(Blocks.SAND).mapColor(MapColor.OFF_WHITE)));

    public static final Block BUTTER_BLOCK = registerBlock("block_butter",
            new BaseFoodBlock(FabricBlockSettings.create().solid().strength(0.5f).sounds(BlockSoundGroup.CANDLE).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block CROP_BLOCK = Registry.register(Registries.BLOCK, new Identifier(References.MODID, "block_crop"),
            new BaseCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(References.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(References.MODID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        ProjectCookbook.LOGGER.info("Registering Mod Blocks for " + References.MODNAME);
    }
}
