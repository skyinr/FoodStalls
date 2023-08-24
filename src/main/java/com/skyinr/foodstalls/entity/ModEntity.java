package com.skyinr.foodstalls.entity;

import com.skyinr.foodstalls.FoodStalls;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntity {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FoodStalls.MODID);
    public static final RegistryObject<EntityType<MusicBox>> MUSIC_BOX = ENTITY_TYPE.register("music_box", () ->
            EntityType.Builder
                    .of(MusicBox::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .noSummon()
                    .build("music_box"));
}
