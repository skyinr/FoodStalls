package com.skyinr.foodstalls.block;

import com.skyinr.foodstalls.FoodStalls;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FoodStalls.MODID);
    public static final RegistryObject<Block> CHAIR = BLOCKS.register("chair", Chair::new);
}
