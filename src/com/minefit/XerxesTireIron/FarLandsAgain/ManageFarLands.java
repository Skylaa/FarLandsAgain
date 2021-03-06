package com.minefit.XerxesTireIron.FarLandsAgain;

import org.bukkit.World;

public class ManageFarLands {

    private final FarLandsAgain plugin;
    private final World world;
    private com.minefit.XerxesTireIron.FarLandsAgain.v1_8_R1.LoadFarlands LF8R1;
    private com.minefit.XerxesTireIron.FarLandsAgain.v1_8_R2.LoadFarlands LF8R2;
    private com.minefit.XerxesTireIron.FarLandsAgain.v1_8_R3.LoadFarlands LF8R3;
    private com.minefit.XerxesTireIron.FarLandsAgain.v1_9_R1.LoadFarlands LF9R1;
    private com.minefit.XerxesTireIron.FarLandsAgain.v1_9_R2.LoadFarlands LF9R2;
    private com.minefit.XerxesTireIron.FarLandsAgain.v1_10_R1.LoadFarlands LF10R1;
    private com.minefit.XerxesTireIron.FarLandsAgain.v1_11_R1.LoadFarlands LF11R1;

    public ManageFarLands(World world, FarLandsAgain instance)
    {
        this.plugin = instance;
        this.world = world;

        if (this.plugin.version.equals("v1_8_R1")) {
            this.LF8R1 = new com.minefit.XerxesTireIron.FarLandsAgain.v1_8_R1.LoadFarlands(this.plugin, this.world);
        } else if (this.plugin.version.equals("v1_8_R2")) {
            this.LF8R2 = new com.minefit.XerxesTireIron.FarLandsAgain.v1_8_R2.LoadFarlands(this.plugin, this.world);
        } else if (this.plugin.version.equals("v1_8_R3")) {
            this.LF8R3 = new com.minefit.XerxesTireIron.FarLandsAgain.v1_8_R3.LoadFarlands(this.plugin, this.world);
        } else if (this.plugin.version.equals("v1_9_R1")) {
            this.LF9R1 = new com.minefit.XerxesTireIron.FarLandsAgain.v1_9_R1.LoadFarlands(this.plugin, this.world);
        } else if (this.plugin.version.equals("v1_9_R2")) {
            this.LF9R2 = new com.minefit.XerxesTireIron.FarLandsAgain.v1_9_R2.LoadFarlands(this.plugin, this.world);
        } else if (this.plugin.version.equals("v1_10_R1")) {
            this.LF10R1 = new com.minefit.XerxesTireIron.FarLandsAgain.v1_10_R1.LoadFarlands(this.plugin, this.world);
        } else if (this.plugin.version.equals("v1_11_R1")) {
            this.LF11R1 = new com.minefit.XerxesTireIron.FarLandsAgain.v1_11_R1.LoadFarlands(this.plugin, this.world);
        }
    }

    public void restoreGenerator()
    {
        if (this.plugin.version.equals("v1_8_R1")) {
            this.LF8R1.restoreGenerator();
        } else if (this.plugin.version.equals("v1_8_R2")) {
            this.LF8R2.restoreGenerator();
        } else if (this.plugin.version.equals("v1_8_R3")) {
            this.LF8R3.restoreGenerator();
        } else if (this.plugin.version.equals("v1_9_R1")) {
            this.LF9R1.restoreGenerator();
        } else if (this.plugin.version.equals("v1_9_R2")) {
            this.LF9R2.restoreGenerator();
        } else if (this.plugin.version.equals("v1_10_R1")) {
            this.LF10R1.restoreGenerator();
        } else if (this.plugin.version.equals("v1_11_R1")) {
            this.LF11R1.restoreGenerator();
        }
    }
}
