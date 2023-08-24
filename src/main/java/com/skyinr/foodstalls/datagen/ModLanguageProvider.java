package com.skyinr.foodstalls.datagen;

import com.skyinr.foodstalls.FoodStalls;
import com.skyinr.foodstalls.block.ModBlocks;
import com.skyinr.foodstalls.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, FoodStalls.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.food_stalls", "Food Stalls");

        ModBlocks.BLOCKS.getEntries()
                .forEach(block -> addBlock(block, block.getId().getPath()));

        ModItems.ITEMS.getEntries()
                .stream()
                .filter(item -> !(item.get() instanceof BlockItem))
                .forEach(item -> addItem(item, item.getId().getPath()));
    }
}
