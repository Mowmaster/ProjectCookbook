package com.mowmaster.projectcookbook.PCDataGeneration;

import com.mowmaster.projectcookbook.Items.FirstDraftItemRegistry;
import com.mowmaster.projectcookbook.PCReferences;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class PCBasicModelProvider extends ModelProvider {
    public PCBasicModelProvider(PackOutput output) {
        super(output, PCReferences.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(FirstDraftItemRegistry.FIRSTDRAFT_MORTAR_AND_PESTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(FirstDraftItemRegistry.FIRSTDRAFT_TOOL_YEAST_PRIMITIVE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(FirstDraftItemRegistry.FIRSTDRAFT_FLOUR_WHEAT_WHOLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(FirstDraftItemRegistry.FIRSTDRAFT_YEAST_PRIMITIVE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(FirstDraftItemRegistry.FIRSTDRAFT_DOUGH_SOURDOUGH_PRIMITIVE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(FirstDraftItemRegistry.FIRSTDRAFT_WATER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(FirstDraftItemRegistry.FIRSTDRAFT_SALT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(FirstDraftItemRegistry.FIRSTDRAFT_BREAD_SOURDOUGH.get(), ModelTemplates.FLAT_ITEM);

    }
}

