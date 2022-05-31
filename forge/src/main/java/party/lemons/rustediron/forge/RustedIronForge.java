package party.lemons.rustediron.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import party.lemons.rustediron.Constants;
import party.lemons.rustediron.RustedIron;

@Mod(Constants.MOD_ID)
public class RustedIronForge
{
	public RustedIronForge() {
		EventBuses.registerModEventBus(Constants.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
		RustedIron.init();
	}
}