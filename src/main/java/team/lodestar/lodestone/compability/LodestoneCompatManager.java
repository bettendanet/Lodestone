package team.lodestar.lodestone.compability;

public class LodestoneCompatManager {
    public static void init() {
        CuriosCompat.init();
        AsyncParticlesCompat.init();
    }

    public static boolean stopBufferingParticles() {
        return AsyncParticlesCompat.LOADED;
    }
}
