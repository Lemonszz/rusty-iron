package party.lemons.rusted_iron;

import java.util.Optional;
import java.util.function.Supplier;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Degradable;

public interface Rustable extends Degradable<Rustable.OxidizationLevel> {
	Supplier<ImmutableBiMap<Object, Object>> OXIDATION_LEVEL_INCREASES = Suppliers.memoize(() -> {
		return ImmutableBiMap.builder().put(Blocks.IRON_BLOCK, RustedIron.EXPOSED_IRON)
				.put(RustedIron.EXPOSED_IRON, RustedIron.WEATHERED_IRON)
				.put(RustedIron.WEATHERED_IRON, RustedIron.RUSTED_IRON)
				.put(RustedIron.CUT_IRON, RustedIron.EXPOSED_CUT_IRON)
				.put(RustedIron.EXPOSED_CUT_IRON, RustedIron.WEATHERED_CUT_IRON)
				.put(RustedIron.WEATHERED_CUT_IRON, RustedIron.RUSTED_CUT_IRON)
				.put(RustedIron.CUT_IRON_SLAB, RustedIron.EXPOSED_CUT_IRON_SLAB)
				.put(RustedIron.EXPOSED_CUT_IRON_SLAB, RustedIron.WEATHERED_CUT_IRON_SLAB)
				.put(RustedIron.WEATHERED_CUT_IRON_SLAB, RustedIron.RUSTED_CUT_IRON_SLAB)
				.put(RustedIron.CUT_IRON_STAIRS, RustedIron.EXPOSED_CUT_IRON_STAIRS)
				.put(RustedIron.EXPOSED_CUT_IRON_STAIRS, RustedIron.WEATHERED_CUT_IRON_STAIRS)
				.put(RustedIron.WEATHERED_CUT_IRON_STAIRS, RustedIron.RUSTED_CUT_IRON_STAIRS)
				.put(RustedIron.IRON_SLAB, RustedIron.EXPOSED_IRON_SLAB)
				.put(RustedIron.EXPOSED_IRON_SLAB, RustedIron.WEATHERED_IRON_SLAB)
				.put(RustedIron.WEATHERED_IRON_SLAB, RustedIron.RUSTED_IRON_SLAB)
				.put(RustedIron.IRON_STAIRS, RustedIron.EXPOSED_IRON_STAIRS)
				.put(RustedIron.EXPOSED_IRON_STAIRS, RustedIron.WEATHERED_IRON_STAIRS)
				.put(RustedIron.WEATHERED_IRON_STAIRS, RustedIron.RUSTED_IRON_STAIRS).build();
	});
	Supplier<BiMap<Object, Object>> OXIDATION_LEVEL_DECREASES = Suppliers.memoize(() -> {
		return ((BiMap<Object, Object>) OXIDATION_LEVEL_INCREASES.get()).inverse();
	});

	static Optional<Block> getDecreasedOxidationBlock(Block block) {
		return Optional.ofNullable((Block) ((BiMap<?, ?>) OXIDATION_LEVEL_DECREASES.get()).get(block));
	}

	static Block getUnaffectedOxidationBlock(Block block) {
		Block block2 = block;

		for (Block block3 = (Block) ((BiMap<?, ?>) OXIDATION_LEVEL_DECREASES.get())
				.get(block); block3 != null; block3 = (Block) ((BiMap<?, ?>) OXIDATION_LEVEL_DECREASES.get()).get(block3)) {
			block2 = block3;
		}

		return block2;
	}

	static Optional<BlockState> getDecreasedOxidationState(BlockState state) {
		return getDecreasedOxidationBlock(state.getBlock()).map((block) -> {
			return block.getStateWithProperties(state);
		});
	}

	static Optional<Block> getIncreasedOxidationBlock(Block block) {
		return Optional.ofNullable((Block) ((BiMap<?, ?>) OXIDATION_LEVEL_INCREASES.get()).get(block));
	}

	static BlockState getUnaffectedOxidationState(BlockState state) {
		return getUnaffectedOxidationBlock(state.getBlock()).getStateWithProperties(state);
	}

	default Optional<BlockState> getDegradationResult(BlockState state) {
		return getIncreasedOxidationBlock(state.getBlock()).map((block) -> {
			return block.getStateWithProperties(state);
		});
	}

	default float getDegradationChanceMultiplier() {
		return this.getDegradationLevel() == Rustable.OxidizationLevel.UNAFFECTED ? 1.0F : 1.5F;
	}

	public static enum OxidizationLevel {
		UNAFFECTED, EXPOSED, WEATHERED, OXIDIZED;
	}
}
