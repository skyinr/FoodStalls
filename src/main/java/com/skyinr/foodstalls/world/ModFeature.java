package com.skyinr.foodstalls.world;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.skyinr.foodstalls.FoodStalls;
import com.skyinr.foodstalls.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModFeature {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ORE_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FoodStalls.MODID, "overworld_ore"));

    private static final TagMatchTest tagMatchTest = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    private static final TagMatchTest tagMatchTest1 = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    private static final Supplier<List<OreConfiguration.TargetBlockState>> target = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(tagMatchTest, ModBlocks.CHAIR.get().defaultBlockState()),
            OreConfiguration.target(tagMatchTest1, ModBlocks.CHAIR.get().defaultBlockState())));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, OVERWORLD_ORE_KEY, Feature.ORE, new OreConfiguration(target.get(), 4));
    }
}
