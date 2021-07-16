package party.lemons.rusted_iron;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.particle.ParticleType;

public class RustedIronClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ParticleFactoryRegistry.getInstance().register((ParticleType)RustedIron.SCRAPE_IRON, ScrapeIronParticle.Factory::new);
	}

}
