package com.mowmaster.projectcookbook.registry;

import com.mowmaster.projectcookbook.ProjectCookbook;
import com.mowmaster.projectcookbook.util.References;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CreativeTabGroup
{
    public static final ItemGroup RAW_INGREDIENTS_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(References.MODID,"raw_ingredients_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.raw_ingredients"))
                    .icon(() -> new ItemStack(ItemRegistry.ITEM_CROP_SEED))
                    .entries((displayContext, entries) -> {
                        entries.add(ItemRegistry.ITEM_CROP_SEED);
                        entries.add(ItemRegistry.ITEM_DOUBLE_CROP_SEED);
                    })
                    .build());

    public static final ItemGroup INGREDIENTS_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(References.MODID,"ingredients_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ingredients"))
                    .icon(() -> new ItemStack(ItemRegistry.ITEM_BOTTLED_SALT))
                    .entries((displayContext, entries) -> {
                        entries.add(ItemRegistry.ITEM_BOTTLED_SALT);
                        entries.add(ItemRegistry.ITEM_BUTTER);
                        entries.add(ItemRegistry.ITEM_SEASONED_SALT_BUTTER);
                    })
                    .build());

    public static final ItemGroup UNPROCESSED_INGREDIENTS_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(References.MODID,"unprocessed_ingredients_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.unprocessed_ingredients"))
                    .icon(() -> new ItemStack(ItemRegistry.ITEM_RINSED_BUTTER))
                    .entries((displayContext, entries) -> {
                        entries.add(ItemRegistry.ITEM_UNPROCESSED_BUTTER);
                        entries.add(ItemRegistry.ITEM_RINSED_BUTTER);
                    })
                    .build());

    public static final ItemGroup STORAGE_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(References.MODID,"storage_block_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.storage_block"))
                    .icon(() -> new ItemStack(BlockRegistry.SALT_BLOCK))
                    .entries((displayContext, entries) -> {
                        entries.add(BlockRegistry.BUTTER_BLOCK);
                        entries.add(BlockRegistry.SALT_BLOCK);
                    })
                    .build());

    public static final ItemGroup SEASONINGS_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(References.MODID,"seasonings_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.seasonings"))
                    .icon(() -> new ItemStack(ItemRegistry.ITEM_GROUND_SALT))
                    .entries((displayContext, entries) -> {
                        entries.add(ItemRegistry.ITEM_GROUND_SALT);
                        //entries.add(ItemRegistry.ITEM_SEASONED_HERB_BUTTER);
                    })
                    .build());

    public static void registerItemGroups()
    {
        ProjectCookbook.LOGGER.info("Registering Item Groups for " + References.MODNAME);
    }
}
