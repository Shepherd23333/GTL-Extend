package cn.qiuye.gtlextend.data.recipe;

import cn.qiuye.gtlextend.GTL_Extend;

import org.gtlcore.gtlcore.common.data.GTLMaterials;
import org.gtlcore.gtlcore.utils.Registries;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

import static cn.qiuye.gtlextend.common.data.GTL_Extend_RecipeTypes.STABLE_SPACETIME_COMPRESSION_RECIPES;

public class StableSpacetimeCompression {

    public static void init(Consumer<FinishedRecipe> provider) {
        STABLE_SPACETIME_COMPRESSION_RECIPES.recipeBuilder(GTL_Extend.id("astral_array_compression"))
                .inputItems(Registries.getItemStack("gtladditions:black_hole_seed", 144),
                        Registries.getItemStack("gtceu:eternity_nanoswarm", 64),
                        Registries.getItemStack("gtceu:spacetime_nanoswarm", 64),
                        new ItemStack(Blocks.REPEATING_COMMAND_BLOCK, 64),
                        Registries.getItemStack("gtladditions:astral_array", 4300800))
                .inputFluids(GTLMaterials.Miracle.getFluid(576000))
                .outputItems(Registries.getItemStack("gtladditions:compressed_astral_array", 42))
                .duration(600)
                .save(provider);
    }
}
