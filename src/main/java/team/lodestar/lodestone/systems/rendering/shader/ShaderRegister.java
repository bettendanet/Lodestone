package team.lodestar.lodestone.systems.rendering.shader;

import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.resources.ResourceLocation;
import team.lodestar.lodestone.LodestoneLib;
import team.lodestar.lodestone.events.LodestoneShaderRegistrationEvent;

import java.util.ArrayList;
import java.util.List;

public class ShaderRegister {
    public final List<LodestoneShader> shaders = new ArrayList<>();
    public final String modId;

    public ShaderRegister(String modId) {
        this.modId = modId;
    }

    public ShaderHolder register(String id, VertexFormat format) {
        return register(new ShaderHolder(ResourceLocation.fromNamespaceAndPath(modId, id), format));
    }

    public <T extends LodestoneShader> T register(T shader) {
        shaders.add(shader);
        return shader;
    }

    public void init() {
        LodestoneLib.LOGGER.info("Registering shaders for mod: {}", this.modId);
        LodestoneShaderRegistrationEvent.EVENT.register((provider, shaderList1) -> {
            for (LodestoneShader shaderHolder : this.shaders)
                shaderHolder.register(provider, shaderList1);
        });
    }
}