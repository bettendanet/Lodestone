package team.lodestar.lodestone.systems.rendering.shader;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.server.packs.resources.ResourceProvider;

import java.util.List;
import java.util.function.Consumer;

public interface LodestoneShader {
    void register(ResourceProvider provider, List<Pair<ShaderInstance, Consumer<ShaderInstance>>> shaderList);
}