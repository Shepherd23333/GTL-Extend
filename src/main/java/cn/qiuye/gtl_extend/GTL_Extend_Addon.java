package cn.qiuye.gtl_extend;

import cn.qiuye.gtl_extend.api.registries.GTLEXRegistration;
import cn.qiuye.gtl_extend.common.data.GTL_Extend_Blocks;
import cn.qiuye.gtl_extend.common.data.GTL_Extend_Item;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.addon.events.MaterialCasingCollectionEvent;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@GTAddon
public class GTL_Extend_Addon implements IGTAddon {
    private static Consumer<FinishedRecipe> provider;

    @Override
    public GTRegistrate getRegistrate() {
        return GTLEXRegistration.REGISTRATE;
    }

    @Override
    public void initializeAddon() {
        GTL_Extend_Item.init();
        GTL_Extend_Blocks.init();
    }

    @Override
    public void registerElements() {
//        GTL_Extend_Elements.init();
    }

    @Override
    public String addonModId() {
        return GTL_Extend.MODID;
    }

    @Override
    public void collectMaterialCasings(MaterialCasingCollectionEvent event) {
        IGTAddon.super.collectMaterialCasings(event);
    }

    @Override
    public void registerSounds() {
        IGTAddon.super.registerSounds();
    }

    @Override
    public void registerOreVeins() {
//        GTL_Extend_Ores.init();
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
//        CustomRecipe.init(provider);
//        MiscRecipes.init(provider);
    }
}
