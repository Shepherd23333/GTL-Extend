package cn.qiuye.gtl_extend.mixin.gtmt;

import cn.qiuye.gtl_extend.utils.NumberUtils;
import com.hepdd.gtmthings.common.block.machine.electric.WirelessEnergyMonitor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.math.BigDecimal;
import java.math.BigInteger;

@Mixin(WirelessEnergyMonitor.class)
public class WirelessEnergyMonitorMixin {

    @Redirect(
            method = "addDisplayText",
            at = @At(
                    value = "INVOKE",
                    // 使用Object类型匹配实际运行时签名
                    target = "Lcom/gregtechceu/gtceu/utils/FormattingUtil;formatNumbers(Ljava/lang/Object;)Ljava/lang/String;",
                    // 指定替换第一次出现的调用（总能量显示）
                    ordinal = 0
            ),
            remap = false)
    private String FormatNumbers1(Object number) {
        return NumberUtils.formatBigIntegerNumberOrSic((BigInteger) number);
    }

    @Redirect(
            method = "addDisplayText",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/gregtechceu/gtceu/utils/FormattingUtil;formatNumbers(Ljava/lang/Object;)Ljava/lang/String;",
                    ordinal = 1
            ),
            remap = false
    )
    private String FormatNumbers2(Object number) {
        return NumberUtils.formatBigDecimalNumberOrSic((BigDecimal) number);
    }
}
