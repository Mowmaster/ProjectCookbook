package com.mowmaster.projectcookbook.Items;

import com.mowmaster.projectcookbook.Items.FirstDraftItems.BasicMnP;
import com.mowmaster.projectcookbook.Items.FirstDraftItems.BasicYeast;
import com.mowmaster.projectcookbook.PCReferences;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

public class FirstDraftItemRegistry {
    public static final DeferredRegister.Items FIRST_DRAFT_ITEMS = DeferredRegister.createItems(PCReferences.MODID);

    public static final DeferredItem<Item> FIRSTDRAFT_MORTAR_AND_PESTLE = FIRST_DRAFT_ITEMS.registerItem("mortar_and_pestle", properties -> new BasicMnP(properties.durability(100).stacksTo(1)));
    public static final DeferredItem<Item> FIRSTDRAFT_FLOUR_WHEAT_WHOLE = FIRST_DRAFT_ITEMS.registerSimpleItem("flour_wheat_whole", properties -> properties);
    public static final DeferredItem<Item> FIRSTDRAFT_TOOL_YEAST_PRIMITIVE = FIRST_DRAFT_ITEMS.registerItem("bottle_sourdough_starter", properties -> new BasicYeast(properties.durability(5).stacksTo(1)));
    public static final DeferredItem<Item> FIRSTDRAFT_YEAST_PRIMITIVE = FIRST_DRAFT_ITEMS.registerSimpleItem("sourdough_starter", properties -> properties);
    public static final DeferredItem<Item> FIRSTDRAFT_DOUGH_SOURDOUGH_PRIMITIVE = FIRST_DRAFT_ITEMS.registerSimpleItem("dough_sourdough", properties -> properties);
    public static final DeferredItem<Item> FIRSTDRAFT_WATER = FIRST_DRAFT_ITEMS.registerSimpleItem("simplified_water", properties -> properties);
    public static final DeferredItem<Item> FIRSTDRAFT_SALT = FIRST_DRAFT_ITEMS.registerSimpleItem("basic_salt", properties -> properties);
    public static final DeferredItem<Item> FIRSTDRAFT_BREAD_SOURDOUGH = FIRST_DRAFT_ITEMS.registerItem("bread_sourdough",
            properties -> new Item(properties.food(PCFoodProperties.PRIMITIVE_CARBS, PCFoodProperties.PRIMITIVE_CARBS_EFFECT)));

    public static void register(IEventBus eventBus)
    {
        FIRST_DRAFT_ITEMS.register(eventBus);
    }
}
