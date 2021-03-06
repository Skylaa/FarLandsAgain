package com.minefit.XerxesTireIron.FarLandsAgain.v1_8_R2;

import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.craftbukkit.v1_8_R2.CraftWorld;

import com.minefit.XerxesTireIron.FarLandsAgain.Messages;
import com.minefit.XerxesTireIron.FarLandsAgain.FarLandsAgain;
import com.minefit.XerxesTireIron.FarLandsAgain.v1_8_R2.FLAChunkProviderGenerate;
import com.minefit.XerxesTireIron.FarLandsAgain.v1_8_R2.FLAChunkProviderHell;
import com.minefit.XerxesTireIron.FarLandsAgain.v1_8_R2.FLAChunkProviderTheEnd;

import net.minecraft.server.v1_8_R2.WorldServer;
import net.minecraft.server.v1_8_R2.IChunkProvider;

public class LoadFarlands {
    private final FarLandsAgain plugin;
    private final World world;
    private final WorldServer nmsWorld;
    private final Messages messages;
    private IChunkProvider originalProvider;

    public LoadFarlands(FarLandsAgain instance, World world) {
        this.plugin = instance;
        this.world = world;
        this.nmsWorld = ((CraftWorld) world).getHandle();
        this.messages = new Messages(plugin);
        overrideGenerator();
    }

    public void restoreGenerator()
    {
        this.nmsWorld.chunkProviderServer.chunkProvider = this.originalProvider;
    }

    public void overrideGenerator() {
        String worldName = this.world.getName();
        long worldSeed = this.world.getSeed();
        this.originalProvider = this.nmsWorld.chunkProviderServer.chunkProvider;
        String originalGenName = this.originalProvider.getClass().getSimpleName();
        boolean genFeatures = this.nmsWorld.getWorldData().shouldGenerateMapFeatures();
        String genOptions = this.nmsWorld.getWorldData().getGeneratorOptions();
        Environment environment = this.world.getEnvironment();

        if(originalGenName.equals("FLAChunkProviderGenerate")
        || originalGenName.equals("FLAChunkProviderHell")
        || originalGenName.equals("FLAChunkProviderTheEnd"))
        {
            this.messages.alreadyEnabled(worldName);
            return;
        }

        if (environment == Environment.NORMAL) {
            if (!originalGenName.equals("NormalChunkGenerator")) {
                this.messages.unknownGenerator(worldName, originalGenName);
                return;
            }

            this.nmsWorld.chunkProviderServer.chunkProvider = new FLAChunkProviderGenerate(this.nmsWorld, worldSeed, genFeatures, genOptions);
        } else if (environment == Environment.NETHER) {
            if (!originalGenName.equals("NetherChunkGenerator")) {
                this.messages.unknownGenerator(worldName, originalGenName);
                return;
            }

            this.nmsWorld.chunkProviderServer.chunkProvider = new FLAChunkProviderHell(this.nmsWorld, genFeatures, worldSeed);
        } else if (environment == Environment.THE_END) {
            if (!originalGenName.equals("SkyLandsChunkGenerator")) {
                this.messages.unknownGenerator(worldName, originalGenName);
                return;
            }

            this.nmsWorld.chunkProviderServer.chunkProvider = new FLAChunkProviderTheEnd(this.nmsWorld, worldSeed);
        } else {
            this.messages.unknownEnvironment(worldName, environment.toString());
        }

        this.messages.enabledSuccessfully(worldName);
    }
}
