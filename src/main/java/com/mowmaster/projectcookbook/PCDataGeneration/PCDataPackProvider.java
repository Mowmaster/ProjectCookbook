package com.mowmaster.projectcookbook.PCDataGeneration;

import net.minecraft.core.RegistrySetBuilder;

public class PCDataPackProvider {
    public static final RegistrySetBuilder WORLD_BUILDER = new RegistrySetBuilder();

    public static final RegistrySetBuilder RELOADABLE_BUILDER = new RegistrySetBuilder()
            .add(PCBasicRecipeProvider.create());
}
