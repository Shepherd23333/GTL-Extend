package cn.qiuye.gtl_extend.api.registries;

import cn.qiuye.gtl_extend.GTL_Extend;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class GetRegistries {

    public static Block getBlock(String s) {
        Block b = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(s));
        if (b == Blocks.AIR) {
            GTL_Extend.LOGGER.error("未找到ID为{}的方块", s);
            return Blocks.BARRIER;
        }
        return b;
    }
}
