package com.minefit.XerxesTireIron.FarLandsAgain.v1_9_R2;

import java.util.List;
import java.util.Random;

import net.minecraft.server.v1_9_R2.BiomeBase;
import net.minecraft.server.v1_9_R2.BlockFalling;
import net.minecraft.server.v1_9_R2.BlockPosition;
import net.minecraft.server.v1_9_R2.BlockPredicate;
import net.minecraft.server.v1_9_R2.Blocks;
import net.minecraft.server.v1_9_R2.Chunk;
import net.minecraft.server.v1_9_R2.ChunkCoordIntPair;
import net.minecraft.server.v1_9_R2.ChunkSnapshot;
import net.minecraft.server.v1_9_R2.IBlockData;
import net.minecraft.server.v1_9_R2.Material;
import net.minecraft.server.v1_9_R2.MathHelper;
import net.minecraft.server.v1_9_R2.World;
import net.minecraft.server.v1_9_R2.WorldGenBase;
import net.minecraft.server.v1_9_R2.WorldGenCavesHell;
import net.minecraft.server.v1_9_R2.WorldGenFire;
import net.minecraft.server.v1_9_R2.WorldGenHellLava;
import net.minecraft.server.v1_9_R2.WorldGenLightStone1;
import net.minecraft.server.v1_9_R2.WorldGenLightStone2;
import net.minecraft.server.v1_9_R2.WorldGenMinable;
import net.minecraft.server.v1_9_R2.WorldGenMushrooms;
import net.minecraft.server.v1_9_R2.WorldGenNether;
import net.minecraft.server.v1_9_R2.WorldGenerator;
import net.minecraft.server.v1_9_R2.ChunkGenerator;
import net.minecraft.server.v1_9_R2.EnumCreatureType;

public class FLAChunkProviderHell implements ChunkGenerator {

    protected static final IBlockData a = Blocks.AIR.getBlockData();
    protected static final IBlockData b = Blocks.NETHERRACK.getBlockData();
    protected static final IBlockData c = Blocks.BEDROCK.getBlockData();
    protected static final IBlockData d = Blocks.LAVA.getBlockData();
    protected static final IBlockData e = Blocks.GRAVEL.getBlockData();
    protected static final IBlockData f = Blocks.SOUL_SAND.getBlockData();
    private final World n;
    private final boolean o;
    private final Random p;
    private double[] q = new double[256];
    private double[] r = new double[256];
    private double[] s = new double[256];
    private double[] t;
    private final NoiseGeneratorOctaves u;
    private final NoiseGeneratorOctaves v;
    private final NoiseGeneratorOctaves w;
    private final NoiseGeneratorOctaves x;
    private final NoiseGeneratorOctaves y;
    public final NoiseGeneratorOctaves g;
    public final NoiseGeneratorOctaves h;
    private final WorldGenFire z = new WorldGenFire();
    private final WorldGenLightStone1 A = new WorldGenLightStone1();
    private final WorldGenLightStone2 B = new WorldGenLightStone2();
    private final WorldGenerator C;
    private final WorldGenHellLava D;
    private final WorldGenHellLava E;
    private final WorldGenMushrooms F;
    private final WorldGenMushrooms G;
    private final WorldGenNether H;
    private final WorldGenBase I;
    double[] i;
    double[] j;
    double[] k;
    double[] l;
    double[] m;

    public FLAChunkProviderHell(World world, boolean flag, long i) {
        this.C = new WorldGenMinable(Blocks.QUARTZ_ORE.getBlockData(), 14, BlockPredicate.a(Blocks.NETHERRACK));
        this.D = new WorldGenHellLava(Blocks.FLOWING_LAVA, true);
        this.E = new WorldGenHellLava(Blocks.FLOWING_LAVA, false);
        this.F = new WorldGenMushrooms(Blocks.BROWN_MUSHROOM);
        this.G = new WorldGenMushrooms(Blocks.RED_MUSHROOM);
        this.H = new WorldGenNether();
        this.I = new WorldGenCavesHell();
        this.n = world;
        this.o = flag;
        this.p = new Random(i);
        this.u = new NoiseGeneratorOctaves(this.p, 16);
        this.v = new NoiseGeneratorOctaves(this.p, 16);
        this.w = new NoiseGeneratorOctaves(this.p, 8);
        this.x = new NoiseGeneratorOctaves(this.p, 4);
        this.y = new NoiseGeneratorOctaves(this.p, 4);
        this.g = new NoiseGeneratorOctaves(this.p, 10);
        this.h = new NoiseGeneratorOctaves(this.p, 16);
        world.b(63);
    }

    public void a(int i, int j, ChunkSnapshot chunksnapshot) {
        byte b0 = 4;
        int k = this.n.K() / 2 + 1;
        int l = b0 + 1;
        byte b1 = 17;
        int i1 = b0 + 1;

        this.t = this.a(this.t, i * b0, 0, j * b0, l, b1, i1);

        for (int j1 = 0; j1 < b0; ++j1) {
            for (int k1 = 0; k1 < b0; ++k1) {
                for (int l1 = 0; l1 < 16; ++l1) {
                    double d0 = 0.125D;
                    double d1 = this.t[((j1 + 0) * i1 + k1 + 0) * b1 + l1 + 0];
                    double d2 = this.t[((j1 + 0) * i1 + k1 + 1) * b1 + l1 + 0];
                    double d3 = this.t[((j1 + 1) * i1 + k1 + 0) * b1 + l1 + 0];
                    double d4 = this.t[((j1 + 1) * i1 + k1 + 1) * b1 + l1 + 0];
                    double d5 = (this.t[((j1 + 0) * i1 + k1 + 0) * b1 + l1 + 1] - d1) * d0;
                    double d6 = (this.t[((j1 + 0) * i1 + k1 + 1) * b1 + l1 + 1] - d2) * d0;
                    double d7 = (this.t[((j1 + 1) * i1 + k1 + 0) * b1 + l1 + 1] - d3) * d0;
                    double d8 = (this.t[((j1 + 1) * i1 + k1 + 1) * b1 + l1 + 1] - d4) * d0;

                    for (int i2 = 0; i2 < 8; ++i2) {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for (int j2 = 0; j2 < 4; ++j2) {
                            double d14 = 0.25D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;

                            for (int k2 = 0; k2 < 4; ++k2) {
                                IBlockData iblockdata = null;

                                if (l1 * 8 + i2 < k) {
                                    iblockdata = FLAChunkProviderHell.d;
                                }

                                if (d15 > 0.0D) {
                                    iblockdata = FLAChunkProviderHell.b;
                                }

                                int l2 = j2 + j1 * 4;
                                int i3 = i2 + l1 * 8;
                                int j3 = k2 + k1 * 4;

                                chunksnapshot.a(l2, i3, j3, iblockdata);
                                d15 += d16;
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }

    }

    public void b(int i, int j, ChunkSnapshot chunksnapshot) {
        int k = this.n.K() + 1;
        double d0 = 0.03125D;

        this.q = this.x.a(this.q, i * 16, j * 16, 0, 16, 16, 1, d0, d0, 1.0D);
        this.r = this.x.a(this.r, i * 16, 109, j * 16, 16, 1, 16, d0, 1.0D, d0);
        this.s = this.y.a(this.s, i * 16, j * 16, 0, 16, 16, 1, d0 * 2.0D, d0 * 2.0D, d0 * 2.0D);

        for (int l = 0; l < 16; ++l) {
            for (int i1 = 0; i1 < 16; ++i1) {
                boolean flag = this.q[l + i1 * 16] + this.p.nextDouble() * 0.2D > 0.0D;
                boolean flag1 = this.r[l + i1 * 16] + this.p.nextDouble() * 0.2D > 0.0D;
                int j1 = (int) (this.s[l + i1 * 16] / 3.0D + 3.0D + this.p.nextDouble() * 0.25D);
                int k1 = -1;
                IBlockData iblockdata = FLAChunkProviderHell.b;
                IBlockData iblockdata1 = FLAChunkProviderHell.b;

                for (int l1 = 127; l1 >= 0; --l1) {
                    if (l1 < 127 - this.p.nextInt(5) && l1 > this.p.nextInt(5)) {
                        IBlockData iblockdata2 = chunksnapshot.a(i1, l1, l);

                        if (iblockdata2.getBlock() != null && iblockdata2.getMaterial() != Material.AIR) {
                            if (iblockdata2.getBlock() == Blocks.NETHERRACK) {
                                if (k1 == -1) {
                                    if (j1 <= 0) {
                                        iblockdata = FLAChunkProviderHell.a;
                                        iblockdata1 = FLAChunkProviderHell.b;
                                    } else if (l1 >= k - 4 && l1 <= k + 1) {
                                        iblockdata = FLAChunkProviderHell.b;
                                        iblockdata1 = FLAChunkProviderHell.b;
                                        if (flag1) {
                                            iblockdata = FLAChunkProviderHell.e;
                                            iblockdata1 = FLAChunkProviderHell.b;
                                        }

                                        if (flag) {
                                            iblockdata = FLAChunkProviderHell.f;
                                            iblockdata1 = FLAChunkProviderHell.f;
                                        }
                                    }

                                    if (l1 < k && (iblockdata == null || iblockdata.getMaterial() == Material.AIR)) {
                                        iblockdata = FLAChunkProviderHell.d;
                                    }

                                    k1 = j1;
                                    if (l1 >= k - 1) {
                                        chunksnapshot.a(i1, l1, l, iblockdata);
                                    } else {
                                        chunksnapshot.a(i1, l1, l, iblockdata1);
                                    }
                                } else if (k1 > 0) {
                                    --k1;
                                    chunksnapshot.a(i1, l1, l, iblockdata1);
                                }
                            }
                        } else {
                            k1 = -1;
                        }
                    } else {
                        chunksnapshot.a(i1, l1, l, FLAChunkProviderHell.c);
                    }
                }
            }
        }

    }

    public Chunk getOrCreateChunk(int i, int j) {
        this.p.setSeed((long) i * 341873128712L + (long) j * 132897987541L);
        ChunkSnapshot chunksnapshot = new ChunkSnapshot();

        this.a(i, j, chunksnapshot);
        this.b(i, j, chunksnapshot);
        this.I.a(this.n, i, j, chunksnapshot);
        if (this.o) {
            this.H.a(this.n, i, j, chunksnapshot);
        }

        Chunk chunk = new Chunk(this.n, chunksnapshot, i, j);
        BiomeBase[] abiomebase = this.n.getWorldChunkManager().getBiomeBlock((BiomeBase[]) null, i * 16, j * 16, 16, 16);
        byte[] abyte = chunk.getBiomeIndex();

        for (int k = 0; k < abyte.length; ++k) {
            abyte[k] = (byte) BiomeBase.a(abiomebase[k]);
        }

        chunk.m();
        return chunk;
    }

    private double[] a(double[] adouble, int i, int j, int k, int l, int i1, int j1) {
        if (adouble == null) {
            adouble = new double[l * i1 * j1];
        }

        double d0 = 684.412D;
        double d1 = 2053.236D;

        this.l = this.g.a(this.l, i, j, k, l, 1, j1, 1.0D, 0.0D, 1.0D);
        this.m = this.h.a(this.m, i, j, k, l, 1, j1, 100.0D, 0.0D, 100.0D);
        this.i = this.w.a(this.i, i, j, k, l, i1, j1, d0 / 80.0D, d1 / 60.0D, d0 / 80.0D);
        this.j = this.u.a(this.j, i, j, k, l, i1, j1, d0, d1, d0);
        this.k = this.v.a(this.k, i, j, k, l, i1, j1, d0, d1, d0);
        int k1 = 0;
        double[] adouble1 = new double[i1];

        int l1;

        for (l1 = 0; l1 < i1; ++l1) {
            adouble1[l1] = Math.cos((double) l1 * 3.141592653589793D * 6.0D / (double) i1) * 2.0D;
            double d2 = (double) l1;

            if (l1 > i1 / 2) {
                d2 = (double) (i1 - 1 - l1);
            }

            if (d2 < 4.0D) {
                d2 = 4.0D - d2;
                adouble1[l1] -= d2 * d2 * d2 * 10.0D;
            }
        }

        for (l1 = 0; l1 < l; ++l1) {
            for (int i2 = 0; i2 < j1; ++i2) {
                double d3 = 0.0D;

                for (int j2 = 0; j2 < i1; ++j2) {
                    double d4 = 0.0D;
                    double d5 = adouble1[j2];
                    double d6 = this.j[k1] / 512.0D;
                    double d7 = this.k[k1] / 512.0D;
                    double d8 = (this.i[k1] / 10.0D + 1.0D) / 2.0D;

                    if (d8 < 0.0D) {
                        d4 = d6;
                    } else if (d8 > 1.0D) {
                        d4 = d7;
                    } else {
                        d4 = d6 + (d7 - d6) * d8;
                    }

                    d4 -= d5;
                    double d9;

                    if (j2 > i1 - 4) {
                        d9 = (double) ((float) (j2 - (i1 - 4)) / 3.0F);
                        d4 = d4 * (1.0D - d9) + -10.0D * d9;
                    }

                    if ((double) j2 < d3) {
                        d9 = (d3 - (double) j2) / 4.0D;
                        d9 = MathHelper.a(d9, 0.0D, 1.0D);
                        d4 = d4 * (1.0D - d9) + -10.0D * d9;
                    }

                    adouble[k1] = d4;
                    ++k1;
                }
            }
        }

        return adouble;
    }

    public void recreateStructures(int i, int j) {
        BlockFalling.instaFall = true;
        BlockPosition blockposition = new BlockPosition(i * 16, 0, j * 16);
        ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(i, j);

        this.H.a(this.n, this.p, chunkcoordintpair);

        int k;

        for (k = 0; k < 8; ++k) {
            this.E.generate(this.n, this.p,
                    blockposition.a(this.p.nextInt(16) + 8, this.p.nextInt(120) + 4, this.p.nextInt(16) + 8));
        }

        for (k = 0; k < this.p.nextInt(this.p.nextInt(10) + 1) + 1; ++k) {
            this.z.generate(this.n, this.p,
                    blockposition.a(this.p.nextInt(16) + 8, this.p.nextInt(120) + 4, this.p.nextInt(16) + 8));
        }

        for (k = 0; k < this.p.nextInt(this.p.nextInt(10) + 1); ++k) {
            this.A.generate(this.n, this.p,
                    blockposition.a(this.p.nextInt(16) + 8, this.p.nextInt(120) + 4, this.p.nextInt(16) + 8));
        }

        for (k = 0; k < 10; ++k) {
            this.B.generate(this.n, this.p, blockposition.a(this.p.nextInt(16) + 8, this.p.nextInt(128), this.p.nextInt(16) + 8));
        }

        if (this.p.nextBoolean()) {
            this.F.generate(this.n, this.p, blockposition.a(this.p.nextInt(16) + 8, this.p.nextInt(128), this.p.nextInt(16) + 8));
        }

        if (this.p.nextBoolean()) {
            this.G.generate(this.n, this.p, blockposition.a(this.p.nextInt(16) + 8, this.p.nextInt(128), this.p.nextInt(16) + 8));
        }

        for (k = 0; k < 16; ++k) {
            this.C.generate(this.n, this.p, blockposition.a(this.p.nextInt(16), this.p.nextInt(108) + 10, this.p.nextInt(16)));
        }

        for (k = 0; k < 16; ++k) {
            this.D.generate(this.n, this.p, blockposition.a(this.p.nextInt(16), this.p.nextInt(108) + 10, this.p.nextInt(16)));
        }

        BlockFalling.instaFall = false;
    }

    public boolean a(Chunk chunk, int i, int j) {
        return false;
    }

    public List<BiomeBase.BiomeMeta> getMobsFor(EnumCreatureType enumcreaturetype, BlockPosition blockposition) {
        if (enumcreaturetype == EnumCreatureType.MONSTER) {
            if (this.H.b(blockposition)) {
                return this.H.b();
            }

            if (this.H.b(this.n, blockposition) && this.n.getType(blockposition.down()).getBlock() == Blocks.NETHER_BRICK) {
                return this.H.b();
            }
        }

        BiomeBase biomebase = this.n.getBiome(blockposition);

        return biomebase.getMobs(enumcreaturetype);
    }

    public BlockPosition findNearestMapFeature(World world, String s, BlockPosition blockposition) {
        return null;
    }

    public void recreateStructures(Chunk chunk, int i, int j) {
        this.H.a(this.n, i, j, (ChunkSnapshot) null);
    }
}
