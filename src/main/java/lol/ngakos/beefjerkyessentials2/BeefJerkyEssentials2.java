package lol.ngakos.beefjerkyessentials2;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeefJerkyEssentials2 implements ModInitializer {
	public static final String MOD_ID = "beefjerkyessentials2";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
