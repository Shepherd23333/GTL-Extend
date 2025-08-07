package cn.qiuye.gtl_extend.client.renderer.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.client.renderer.machine.IControllerRenderer;
import com.gregtechceu.gtceu.client.renderer.machine.WorkableCasingMachineRenderer;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;

import java.util.List;

import org.jetbrains.annotations.Nullable;

public class BlackHoleMatterDecompressorRender extends WorkableCasingMachineRenderer implements IControllerRenderer {

    public BlackHoleMatterDecompressorRender() {
        super(GTCEu.id("block/casings/hpca/high_power_casing"), GTCEu.id("block/multiblock/cosmos_simulation"));
    }

    /**
     *
     * @param quads
     * @param machine
     * @param part
     * @param frontFacing
     * @param side
     * @param rand
     * @param modelFacing
     * @param modelState
     */
    @Override
    public void renderPartModel(List<BakedQuad> quads, IMultiController machine, IMultiPart part, Direction frontFacing, @Nullable Direction side, RandomSource rand, Direction modelFacing, ModelState modelState) {}
}
