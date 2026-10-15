package com.mowmaster.projectcookbook;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(PCReferences.MODID)
public class projectcookbook {
    public static final Logger LOGGER = LogUtils.getLogger();

    public projectcookbook(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        /*DustItemRegistry.register(modEventBus);
        DustBlockRegistry.register(modEventBus);
        DustEntityRegistry.register(modEventBus);

        RegistryMenuTypePedestal.register(modEventBus);
        RegistryPedestalItem.register(modEventBus);
        RegistryPedestalBlock.register(modEventBus);
        RegistryPedestalEntity.register(modEventBus);

        DustComponentDataRegistry.register(modEventBus);
        DustAttachmentTypeRegistry.register(modEventBus);

        DustConsumeEffectsRegistry.register(modEventBus);
        DustEffectsRegistry.register(modEventBus);
        DustPotionRegistry.register(modEventBus);

        DustLootRegistry.register(modEventBus);

        DustCreativeTabRegistry.CREATIVE_MODE_TABS.register(modEventBus);

        DustParticleRegistry.PARTICLE_TYPES.register(modEventBus);

*/

        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event)
    {
        /*event.enqueueWork(()-> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DustBlockRegistry.BLOCK_FLOWER_WHINDWHEEL.getId(), DustBlockRegistry.BLOCK_POTTEDFLOWER_WINDWHEEL);
        });*/
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
