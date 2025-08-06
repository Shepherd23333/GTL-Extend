package cn.qiuye.gtl_extend.common.data.machines.MultiBlock;

import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;

public class MultiBlockStructure {

    public static final FactoryBlockPattern GENERAL_ENERGY_FURNACE;
    public static final FactoryBlockPattern GENERAL_PURPOSE_STEAM_ENGINE;
    public static final FactoryBlockPattern GENERAL_PURPOSE_AE_PRODUCTION;

    static {

        GENERAL_PURPOSE_STEAM_ENGINE = FactoryBlockPattern.start()
                .aisle("AAAAA", "A A A", "AA AA", "A A A", "AAAAA")
                .aisle("AAAAA", "     ", "A   A", "     ", "AAAAA")
                .aisle("AAAAA", "A A A", "  B  ", "A A A", "AAAAA")
                .aisle("AAAAA", "     ", "A   A", "     ", "AAAAA")
                .aisle("AA~AA", "A A A", "AA AA", "A A A", "AAAAA");

        GENERAL_ENERGY_FURNACE = FactoryBlockPattern.start()
                .aisle("aaaaaaa", "ccccccc", "ccccccc", "ccccccc", "eeeeeee", "ccccccc", "ccccccc", "ccccccc", "aaaaaaa")
                .aisle("aaaaaaa", "c     c", "c     c", "c     c", "e     e", "c     c", "c     c", "c     c", "aaaaaaa")
                .aisle("aaaaaaa", "c     c", "c     c", "c fff c", "e fff e", "c fff c", "c     c", "c     c", "aaaaaaa")
                .aisle("aaaaaaa", "c     c", "c     c", "c fff c", "e f f e", "c fff c", "c     c", "c     c", "aaaaaaa")
                .aisle("aaaaaaa", "c     c", "c     c", "c fff c", "e fff e", "c fff c", "c     c", "c     c", "aaaaaaa")
                .aisle("aaaaaaa", "c     c", "c     c", "c     c", "e     e", "c     c", "c     c", "c     c", "aaaaaaa")
                .aisle("aaa~aaa", "ccccccc", "ccccccc", "ccccccc", "eeeeeee", "ccccccc", "ccccccc", "ccccccc", "aaaaaaa");

        GENERAL_PURPOSE_AE_PRODUCTION = FactoryBlockPattern.start()
                .aisle("AAAAAAAAA", "CCCCCCCCC", "         ", "         ", "         ", "         ", "         ", "         ")
                .aisle("AAAAAAAAA", "C       C", "         ", "         ", "         ", "         ", "         ", "         ")
                .aisle("AAAAAAAAA", "C D C D C", "  D C D  ", "  D D D  ", "  E E E  ", "    C    ", "         ", "         ")
                .aisle("AAAAAAAAA", "C       C", "         ", "    C    ", "         ", "    C    ", "         ", "         ")
                .aisle("AAAAAAAAA", "C C C C C", "  C F C  ", "  DCDCD  ", "  E E E  ", "  CCECC  ", "    E    ", "    C    ")
                .aisle("AAAAAAAAA", "C       C", "         ", "    C    ", "         ", "    C    ", "         ", "         ")
                .aisle("AAAAAAAAA", "C D C D C", "  D C D  ", "  D D D  ", "  E E E  ", "    C    ", "         ", "         ")
                .aisle("AAAAAAAAA", "C       C", "         ", "         ", "         ", "         ", "         ", "         ")
                .aisle("AAAA~AAAA", "CCCCCCCCC", "         ", "         ", "         ", "         ", "         ", "         ");
    }
}
