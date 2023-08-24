package com.skyinr.foodstalls.item;

import com.skyinr.foodstalls.FoodStalls;
import com.skyinr.foodstalls.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = FoodStalls.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FoodStalls.MODID);
    public static final RegistryObject<Item> CHAIR = ITEMS.register("chair", () -> new BlockItem(ModBlocks.CHAIR.get(), new Item.Properties()));

    @SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ModTabs.FOOD_STALLS_TAB.get()) {
            event.acceptAll(ITEMS.getEntries()
                    .stream()
                    .map(itemRegistryObject -> itemRegistryObject.get().getDefaultInstance())
                    .collect(Collectors.toSet()));
        }
    }
    public static class ModTabs {
        public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FoodStalls.MODID);
        public static final RegistryObject<CreativeModeTab> FOOD_STALLS_TAB = TABS.register("food_stalls", () -> CreativeModeTab.builder()
                .icon(() -> CHAIR.get().getDefaultInstance())
                .title(Component.translatable("itemGroup.food_stalls"))
                .build());
    }
}
