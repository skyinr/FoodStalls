package com.skyinr.foodstalls.datagen;

import com.mojang.logging.LogUtils;
import com.skyinr.foodstalls.FoodStalls;
import com.skyinr.foodstalls.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.slf4j.Logger;

public class ModBlockStateProvider extends BlockStateProvider {
    private static final Logger LOGGER = LogUtils.getLogger();

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FoodStalls.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        try {

            simpleBlockWithItem(ModBlocks.CHAIR.get(), cubeAll(ModBlocks.CHAIR.get()));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

    }
}
