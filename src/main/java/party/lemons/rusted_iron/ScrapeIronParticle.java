package party.lemons.rusted_iron;

import java.util.Random;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.GlowParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class ScrapeIronParticle extends SpriteBillboardParticle {
   static final Random RANDOM = new Random();
   private final SpriteProvider spriteProvider;

   ScrapeIronParticle(ClientWorld clientWorld, double d, double e, double f, double g, double h, double i, SpriteProvider spriteProvider) {
      super(clientWorld, d, e, f, g, h, i);
      this.field_28786 = 0.96F;
      this.field_28787 = true;
      this.spriteProvider = spriteProvider;
      this.scale *= 0.75F;
      this.collidesWithWorld = false;
      this.setSpriteForAge(spriteProvider);
   }

   public ParticleTextureSheet getType() {
      return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
   }

   public int getBrightness(float tint) {
      float f = ((float)this.age + tint) / (float)this.maxAge;
      f = MathHelper.clamp(f, 0.0F, 1.0F);
      int i = super.getBrightness(tint);
      int j = i & 255;
      int k = i >> 16 & 255;
      j += (int)(f * 15.0F * 16.0F);
      if (j > 240) {
         j = 240;
      }

      return j | k << 16;
   }

   public void tick() {
      super.tick();
      this.setSpriteForAge(this.spriteProvider);
   }
   
   public static class Factory implements ParticleFactory<DefaultParticleType> {
	      private final SpriteProvider spriteProvider;

	      public Factory(SpriteProvider spriteProvider) {
	         this.spriteProvider = spriteProvider;
	      }

	      public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
	         ScrapeIronParticle scrapeIronParticle = new ScrapeIronParticle(clientWorld, d, e, f, 0.0D, 0.0D, 0.0D, this.spriteProvider);
	         if (clientWorld.random.nextBoolean()) {
	        	 //scrapeIronParticle.setColor(1F, 0.58F, 0.51F);
	        	 scrapeIronParticle.setColor(0.74F, 0.36F, 0.19F);

	         } else {
	        	 scrapeIronParticle.setColor(0.47F, 0.17F, 0.05F);
	         }

	         scrapeIronParticle.setVelocity(g * 0.01D, h * 0.01D, i * 0.01D);
	         scrapeIronParticle.setMaxAge(clientWorld.random.nextInt(30) + 10);
	         return scrapeIronParticle;
	      }
	   }

}
