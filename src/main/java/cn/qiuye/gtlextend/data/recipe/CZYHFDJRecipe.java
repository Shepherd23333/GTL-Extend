package cn.qiuye.gtlextend.data.recipe;

import cn.qiuye.gtlextend.GTL_Extend;
import cn.qiuye.gtlextend.common.data.GTL_Extend_Item;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static cn.qiuye.gtlextend.common.data.GTL_Extend_RecipeTypes.CZYHFDJ_RECIPES;

public class CZYHFDJRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {
        CZYHFDJ_RECIPES.recipeBuilder(GTL_Extend.id("kumingyuanyang"))
                .notConsumable(GTL_Extend_Item.ABA)
                .notConsumable(GTL_Extend_Item.CZYH)
                .duration(114514 * 20)
                .EUt(-350234)
                .save(provider);
    }
}
