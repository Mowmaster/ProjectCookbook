package com.mowmaster.projectcookbook.PCDataGeneration;

import com.mowmaster.projectcookbook.Items.FirstDraftItemRegistry;
import com.mowmaster.projectcookbook.PCReferences;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.MultiRegistryBootstrap;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.crafting.DataComponentIngredient;

import java.util.List;

public class PCBasicRecipeProvider extends RecipeProvider {


    protected PCBasicRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }

    public static MultiRegistryBootstrap create()
    {
        return RecipeProvider.asBootstrap(PCBasicRecipeProvider::new);
    }

    @Override
    protected void buildRecipes() {

        oreSmelting(List.of(FirstDraftItemRegistry.FIRSTDRAFT_DOUGH_SOURDOUGH_PRIMITIVE), RecipeCategory.FOOD, CookingBookCategory.FOOD, FirstDraftItemRegistry.FIRSTDRAFT_BREAD_SOURDOUGH.get(),0.1f,400, PCReferences.MODID);
        oreSmelting(List.of(FirstDraftItemRegistry.FIRSTDRAFT_WATER), RecipeCategory.FOOD, CookingBookCategory.FOOD, FirstDraftItemRegistry.FIRSTDRAFT_SALT.get(),0.1f,100, PCReferences.MODID);

        shapeless(RecipeCategory.FOOD, FirstDraftItemRegistry.FIRSTDRAFT_MORTAR_AND_PESTLE.get(),1)
                .requires(Items.STICK)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                .save(output, PCReferences.MODID+".mortar_and_pestle");
        shapeless(RecipeCategory.FOOD, FirstDraftItemRegistry.FIRSTDRAFT_WATER.get(),8)
                .requires(Items.WATER_BUCKET)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .save(output, PCReferences.MODID+".simple_water_from_bucket");
        Ingredient waterBottleIngredient = DataComponentIngredient.of(Items.POTION.canFitInsideContainerItems(), DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER));
        shapeless(RecipeCategory.FOOD, FirstDraftItemRegistry.FIRSTDRAFT_WATER.get(),2)
                .requires(waterBottleIngredient)
                .unlockedBy(getHasName(Items.GLASS_BOTTLE), has(Items.GLASS_BOTTLE))
                .save(output,PCReferences.MODID+".simple_water_from_waterbottle");
        shapeless(RecipeCategory.FOOD, FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get(),1)
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_MORTAR_AND_PESTLE.get())
                .requires(Items.WHEAT)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(output,PCReferences.MODID+".mnp_wheat_to_whole_wheat");
        shapeless(RecipeCategory.FOOD, FirstDraftItemRegistry.FIRSTDRAFT_TOOL_YEAST_PRIMITIVE.get(),1)
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_WATER.get())
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get()), has(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get()))
                .save(output,PCReferences.MODID+".tool_prim_yeast");
        shapeless(RecipeCategory.FOOD, FirstDraftItemRegistry.FIRSTDRAFT_TOOL_YEAST_PRIMITIVE.get(),1)
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_TOOL_YEAST_PRIMITIVE.get())
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(FirstDraftItemRegistry.FIRSTDRAFT_TOOL_YEAST_PRIMITIVE.get()), has(FirstDraftItemRegistry.FIRSTDRAFT_TOOL_YEAST_PRIMITIVE.get()))
                .save(output,PCReferences.MODID+".recharge_tool_yeast");
        shapeless(RecipeCategory.FOOD, FirstDraftItemRegistry.FIRSTDRAFT_YEAST_PRIMITIVE.get(),1)
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_TOOL_YEAST_PRIMITIVE.get())
                .unlockedBy(getHasName(FirstDraftItemRegistry.FIRSTDRAFT_TOOL_YEAST_PRIMITIVE.get()), has(FirstDraftItemRegistry.FIRSTDRAFT_TOOL_YEAST_PRIMITIVE.get()))
                .save(output,PCReferences.MODID+".primitive_yeast");
        shapeless(RecipeCategory.FOOD, FirstDraftItemRegistry.FIRSTDRAFT_DOUGH_SOURDOUGH_PRIMITIVE.get(),1)
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_WATER.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_YEAST_PRIMITIVE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_SALT.get())
                .requires(Items.SUGAR)
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(output,PCReferences.MODID+".dough_one");
        shapeless(RecipeCategory.FOOD, FirstDraftItemRegistry.FIRSTDRAFT_DOUGH_SOURDOUGH_PRIMITIVE.get(),2)
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_WATER.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_YEAST_PRIMITIVE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_SALT.get())
                .requires(Items.SUGAR)
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(output,PCReferences.MODID+".dough_two");
        shapeless(RecipeCategory.FOOD, FirstDraftItemRegistry.FIRSTDRAFT_DOUGH_SOURDOUGH_PRIMITIVE.get(),3)
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_WATER.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_YEAST_PRIMITIVE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_SALT.get())
                .requires(Items.SUGAR)
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(output,PCReferences.MODID+".dough_three");
        shapeless(RecipeCategory.FOOD, FirstDraftItemRegistry.FIRSTDRAFT_DOUGH_SOURDOUGH_PRIMITIVE.get(),4)
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_WATER.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_YEAST_PRIMITIVE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_SALT.get())
                .requires(Items.SUGAR)
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(output,PCReferences.MODID+".dough_four");
        shapeless(RecipeCategory.FOOD, FirstDraftItemRegistry.FIRSTDRAFT_DOUGH_SOURDOUGH_PRIMITIVE.get(),5)
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_WATER.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_YEAST_PRIMITIVE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_SALT.get())
                .requires(Items.SUGAR)
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .requires(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get())
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(output,PCReferences.MODID+".dough_five");



    }
}
