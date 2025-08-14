package cn.qiuye.gtl_extend.common.data;

import com.gregtechceu.gtceu.api.capability.IParallelHatch;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;

import java.util.Optional;

public class GTL_Extend_RecipeModifiers {

    public static int getHatchParallel(MetaMachine machine, int maxParallel) {
        if (machine instanceof IMultiController controller && controller.isFormed()) {
            Optional<IParallelHatch> optional = controller.getParts().stream().filter(IParallelHatch.class::isInstance)
                    .map(IParallelHatch.class::cast).findAny();
            if (optional.isPresent()) {
                IParallelHatch hatch = optional.get();
                return hatch.getCurrentParallel();
            }
        }
        return maxParallel;
    }
}
