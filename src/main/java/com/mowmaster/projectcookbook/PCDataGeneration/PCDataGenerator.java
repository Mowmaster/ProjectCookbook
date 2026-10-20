package com.mowmaster.projectcookbook.PCDataGeneration;

import com.mowmaster.projectcookbook.PCReferences;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(modid = PCReferences.MODID)
public class PCDataGenerator
{
    @SubscribeEvent
    public static void gatherClientDate(GatherDataEvent.Client event)
    {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var lookupProvider = event.getReloadableLookupProvider();

        generator.addProvider(true, new PCBasicModelProvider(packOutput));
    }

    @SubscribeEvent
    public static void gatherDataRegistryEntries(GatherDataRegistryEntriesEvent event) {
        event.gatherFor(PCReferences.MODID, Identifier.DEFAULT_NAMESPACE)
                .add(PCBasicRecipeProvider.create());
    }
}
