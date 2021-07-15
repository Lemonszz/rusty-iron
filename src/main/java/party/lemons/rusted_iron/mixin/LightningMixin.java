package party.lemons.rusted_iron.mixin;

import java.util.Iterator;
import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LightningRodBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import party.lemons.rusted_iron.Rustable;

@Mixin(LightningEntity.class)
public abstract class LightningMixin extends Entity {

	@Shadow
	private int ambientTick;

	public LightningMixin(EntityType<?> type, World world) {
		super(type, world);
		// TODO Auto-generated constructor stub
	}

	@Shadow
	private BlockPos getAffectedBlockPos() {
		Vec3d vec3d = this.getPos();
		return new BlockPos(vec3d.x, vec3d.y - 1.0E-6D, vec3d.z);
	}

	@Inject(method = "tick", at = @At("HEAD"))
	public void tick(CallbackInfo ci) {
		if (this.ambientTick == 2 && !this.world.isClient()) {

			BlockPos pos = this.getAffectedBlockPos();

			BlockState blockState = world.getBlockState(pos);

			if (blockState.getBlock() instanceof Rustable) {
				world.setBlockState(pos, Rustable.getUnaffectedOxidationState(world.getBlockState(pos)));
				BlockPos.Mutable mutable = pos.mutableCopy();
				int i = world.random.nextInt(3) + 3;

				for (int j = 0; j < i; ++j) {
					int k = world.random.nextInt(8) + 1;
					cleanRustAround(world, pos, mutable, k);
				}

			}

		}
	}

	private static void cleanRustAround(World world, BlockPos pos, BlockPos.Mutable mutablePos, int count) {
		mutablePos.set(pos);

		for (int i = 0; i < count; ++i) {
			Optional<BlockPos> optional = cleanRustAround(world, mutablePos);
			if (!optional.isPresent()) {
				break;
			}

			mutablePos.set((Vec3i) optional.get());
		}

	}

	private static Optional<BlockPos> cleanRustAround(World world, BlockPos pos) {
		Iterator var2 = BlockPos.iterateRandomly(world.random, 10, pos, 1).iterator();

		BlockPos blockPos;
		BlockState blockState;
		do {
			if (!var2.hasNext()) {
				return Optional.empty();
			}

			blockPos = (BlockPos) var2.next();
			blockState = world.getBlockState(blockPos);
		} while (!(blockState.getBlock() instanceof Rustable));

		BlockPos blockPos1 = blockPos;
		
		Rustable.getDecreasedOxidationState(blockState).ifPresent((state) -> {
			world.setBlockState(blockPos1, state);
		});
		System.out.println(blockState);
		world.syncWorldEvent(WorldEvents.ELECTRICITY_SPARKS, blockPos, -1);
		return Optional.of(blockPos);
	}

}
