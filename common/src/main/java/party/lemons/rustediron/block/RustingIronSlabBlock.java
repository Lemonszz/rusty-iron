package party.lemons.rustediron.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class RustingIronSlabBlock extends SlabBlock implements WeatheringIron {
	private final IronState weatherState;

	public RustingIronSlabBlock(IronState weatherState, BlockBehaviour.Properties properties) {
		super(properties);
		this.weatherState = weatherState;
	}

	public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource random) {
		this.onRandomTick(blockState, serverLevel, blockPos, random);
	}

	public boolean isRandomlyTicking(BlockState blockState) {
		return WeatheringIron.getNext(blockState.getBlock()).isPresent();
	}

	public IronState getAge() {
		return this.weatherState;
	}
}
