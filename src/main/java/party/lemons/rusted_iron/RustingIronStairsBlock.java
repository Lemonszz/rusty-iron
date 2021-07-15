package party.lemons.rusted_iron;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.OxidizableStairsBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class RustingIronStairsBlock extends StairsBlock implements Rustable {
	   private final Rustable.OxidizationLevel oxidizationLevel;

	   public RustingIronStairsBlock(BlockState baseBlockState, AbstractBlock.Settings settings, Rustable.OxidizationLevel oxidizationLevel) {
	      super(baseBlockState, settings);
	      this.oxidizationLevel = oxidizationLevel;
	   }

	   public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
	      this.tickDegradation(state, world, pos, random);
	   }

	   public boolean hasRandomTicks(BlockState state) {
	      return Rustable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
	   }

	   public Rustable.OxidizationLevel getDegradationLevel() {
	      return this.oxidizationLevel;
	   }
	}
