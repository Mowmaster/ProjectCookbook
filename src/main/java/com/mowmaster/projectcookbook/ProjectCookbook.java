package com.mowmaster.projectcookbook;

import com.mowmaster.projectcookbook.registry.BlockRegistry;
import com.mowmaster.projectcookbook.registry.CreativeTabGroup;
import com.mowmaster.projectcookbook.registry.ItemRegistry;
import com.mowmaster.projectcookbook.util.References;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectCookbook implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(References.MODID);

	@Override
	public void onInitialize() {

		CreativeTabGroup.registerItemGroups();
		ItemRegistry.registerModItems();
		BlockRegistry.registerModBlocks();
	}
}