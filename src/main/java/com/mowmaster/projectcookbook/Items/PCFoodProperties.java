package com.mowmaster.projectcookbook.Items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class PCFoodProperties
{
    public static final FoodProperties PRIMITIVE_CARBS = new FoodProperties.Builder().nutrition(5).saturationModifier(0.6F).build();

    public static final Consumable PRIMITIVE_CARBS_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect( new MobEffectInstance(MobEffects.SPEED,1200, 1), 0.25f))
            .build();

}
