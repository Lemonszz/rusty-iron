package party.lemons.rusted_iron;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class RustingIronSlabBlock extends SlabBlock implements Rustable {
	   private final Rustable.OxidizationLevel oxidizationLevel;

	   public RustingIronSlabBlock(AbstractBlock.Settings settings, Rustable.OxidizationLevel oxidizationLevel) {
	      super(settings);
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
