package com.skyinr.foodstalls.world;

import com.skyinr.foodstalls.FoodStalls;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> OVERWORLD_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FoodStalls.MODID, "overworld_ore"));
    public static final TagKey<PlacedFeature> OVERWORLD_PLACED = new TagKey<>(Registries.PLACED_FEATURE,new ResourceLocation("overworld_ore"));

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> lookup = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context,
                OVERWORLD_PLACED_KEY,
                lookup.getOrThrow(ModFeature.OVERWORLD_ORE_KEY),
                List.of(CountPlacement.of(7),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-20),
                                VerticalAnchor.absolute(80)),
                        BiomeFilter.biome()));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, modifiers));
    }
}
