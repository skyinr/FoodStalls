package com.skyinr.foodstalls.datagen;

import com.mojang.serialization.JsonOps;
import com.skyinr.foodstalls.world.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ModAddFeaturesProvider extends JsonCodecProvider<ForgeBiomeModifiers.AddFeaturesBiomeModifier> {
    private static final Map<ResourceLocation, ForgeBiomeModifiers.AddFeaturesBiomeModifier> addFeaturesBiomeModifiers = new HashMap<>();
    private final CompletableFuture<HolderLookup.Provider> completableFuture;

    public ModAddFeaturesProvider(PackOutput output, ExistingFileHelper existingFileHelper, String modid,CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, existingFileHelper, modid, JsonOps.COMPRESSED, PackType.SERVER_DATA, "forge/biome_modifier", ForgeMod.ADD_FEATURES_BIOME_MODIFIER_TYPE.get(), addFeaturesBiomeModifiers);
        this.completableFuture = completableFuture;
    }

    @Override
    @NotNull
    public CompletableFuture<?> run(@NotNull CachedOutput cache) {
        start();


        return super.run(cache);
    }

    protected void start() {
        try {
            add(new ResourceLocation("add_biome_modifier"),
                    RegistryOps.create(JsonOps.COMPRESSED,completableFuture.get()).getter(Registries.BIOME).get().getOrThrow(BiomeTags.IS_OVERWORLD),
                    RegistryOps.create(JsonOps.COMPRESSED,completableFuture.get()).getter(Registries.PLACED_FEATURE).get().getOrThrow(ModPlacedFeatures.OVERWORLD_PLACED),
                    GenerationStep.Decoration.UNDERGROUND_ORES);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected final void add(ResourceLocation resourceLocation, HolderSet<Biome> biomeHolderSet, HolderSet<PlacedFeature> placedFeatureHolderSet, GenerationStep.Decoration step) throws ExecutionException, InterruptedException {

        ForgeBiomeModifiers.AddFeaturesBiomeModifier addFeaturesBiomeModifier = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeHolderSet,
                placedFeatureHolderSet,
                step
        );

        addFeaturesBiomeModifiers.put(resourceLocation, addFeaturesBiomeModifier);
    }

    @Override
    @NotNull
    public String getName() {
        return "Add Features" + modid;
    }
}
