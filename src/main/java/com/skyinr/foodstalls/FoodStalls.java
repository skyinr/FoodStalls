package com.skyinr.foodstalls;

import com.mojang.logging.LogUtils;
import com.skyinr.foodstalls.block.ModBlocks;
import com.skyinr.foodstalls.entity.ModEntity;
import com.skyinr.foodstalls.item.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(FoodStalls.MODID)
public class FoodStalls {
    public static final String MODID = "food_stalls";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FoodStalls() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        LOGGER.info("Food Stalls Block loading");
        ModBlocks.BLOCKS.register(modEventBus);

        LOGGER.info("Food Stalls Item loading");
        ModItems.ITEMS.register(modEventBus);

        LOGGER.info("Food Stalls Tab loading");
        ModItems.ModTabs.TABS.register(modEventBus);

        LOGGER.info("Food Stalls Entity loading");
        ModEntity.ENTITY_TYPE.register(modEventBus);
    }
}
