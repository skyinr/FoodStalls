package com.skyinr.foodstalls.datagen;

import com.skyinr.foodstalls.FoodStalls;
import com.skyinr.foodstalls.datagen.loottable.ModLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = FoodStalls.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenEvent {
    @SubscribeEvent
    public static void registry(GatherDataEvent event) {
        PackOutput packOutput = event.getGenerator().getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.getGenerator().addProvider(event.includeClient(), new ModLanguageProvider(packOutput, "en_us"));
        event.getGenerator().addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));


        event.getGenerator().addProvider(event.includeServer(), new ModAddFeaturesProvider(packOutput, existingFileHelper, FoodStalls.MODID, lookupProvider));
        event.getGenerator().addProvider(event.includeServer(), new ModLootTableProvider(packOutput));
        event.getGenerator().addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));


    }
}
