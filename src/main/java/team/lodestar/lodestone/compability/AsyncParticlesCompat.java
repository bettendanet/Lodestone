package team.lodestar.lodestone.compability;

import net.fabricmc.loader.api.FabricLoader;
import team.lodestar.lodestone.config.ClientConfig;

public class AsyncParticlesCompat {
    public static boolean LOADED;

    public static void init() {
        LOADED = FabricLoader.getInstance().isModLoaded("asyncparticles") && !ClientConfig.IGNORE_MOD_COMPATIBILITY_RENDERING.getConfigValue();
    }
}
