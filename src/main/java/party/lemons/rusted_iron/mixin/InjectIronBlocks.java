package party.lemons.rusted_iron.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;
import party.lemons.rusted_iron.Rustable.OxidizationLevel;
import party.lemons.rusted_iron.RustedIron;
import party.lemons.rusted_iron.RustingIronBlock;

@Mixin(Blocks.class)
public class ReplaceIronBlockMixin {
	
	@Unique
	private static Block registerIronBlock(String id, Block block) {
	      return (Block)Registry.register(Registry.BLOCK, (String)id, block);
	}
	
	@Inject(method = "register", at = @At("HEAD"), cancellable = true)
	private static void replaceIronBlock(String id, Block block, CallbackInfoReturnable<Block> cir) {
		if (id.equals("iron_block")) {
			cir.setReturnValue(registerIronBlock("iron_block", new RustingIronBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(5F, 5F).sounds(BlockSoundGroup.METAL), OxidizationLevel.UNAFFECTED)));
		}
	}

}
