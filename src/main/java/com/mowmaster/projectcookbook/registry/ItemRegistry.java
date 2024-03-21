package com.mowmaster.projectcookbook.registry;

import com.mowmaster.projectcookbook.ProjectCookbook;
import com.mowmaster.projectcookbook.item.BaseDrinkableItem;
import com.mowmaster.projectcookbook.item.BaseItem;
import com.mowmaster.projectcookbook.util.References;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegistry
{
    public static final FoodComponent FOOD_GROUND_SALT = new FoodComponent.Builder().hunger(1).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200), 0.25f).build();
    public static final FoodComponent FOOD_BOTTLED_SALT = new FoodComponent.Builder().hunger(1).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.25f).build();

    public static final Item ITEM_GROUND_SALT = registerItem("ground_salt", new BaseItem(new FabricItemSettings().food(FOOD_GROUND_SALT)));
    public static final Item ITEM_BOTTLED_SALT = registerItem("bottled_salt", new BaseDrinkableItem(new FabricItemSettings().food(FOOD_BOTTLED_SALT)));

    public static final Item ITEM_UNPROCESSED_BUTTER = registerItem("unprocessed_butter", new BaseItem(new FabricItemSettings()));
    public static final Item ITEM_RINSED_BUTTER = registerItem("rinsed_butter", new BaseItem(new FabricItemSettings()));
    public static final Item ITEM_BUTTER = registerItem("butter", new BaseItem(new FabricItemSettings()));
    public static final Item ITEM_SEASONED_SALT_BUTTER = registerItem("salted_butter", new BaseItem(new FabricItemSettings()));
    public static final Item ITEM_SEASONED_HERB_BUTTER = registerItem("herb_butter", new BaseItem(new FabricItemSettings()));




    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(References.MODID, name),item);
    }

    public static void registerModItems()
    {
        ProjectCookbook.LOGGER.info("Registering Mod Items for " + References.MODNAME);
    }
}
