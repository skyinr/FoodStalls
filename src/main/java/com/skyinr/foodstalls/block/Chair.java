package com.skyinr.foodstalls.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class Chair extends Block {

    public Chair() {
        super(BlockBehaviour.Properties.of());
    }

    @Override
    @NotNull
    @SuppressWarnings("all")
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        //TODO 生成隐形实体坐上去 或许可以将音乐改为实体播放
//        level.playLocalSound(blockPos, soundType.getPlaceSound(), SoundSource.MUSIC, 1, 1, false);
        return super.use(blockState, level, blockPos, player, hand, blockHitResult);
    }
}
