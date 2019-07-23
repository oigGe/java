package Board;
import java.util.concurrent.ThreadLocalRandom;

public enum Tiles {
    BLANC(0, 0, 0, 0),
    T(2, 0, 0, 0),
    B(0, 2, 0, 0),
    L(0, 0, 2, 0),
    R(0, 0, 0, 2),
    TB(2, 2, 0, 0),
    TL(2, 0, 2, 0),
    TR(2, 0, 0, 2),
    BL(0, 2, 2, 0),
    BR(0, 2, 0, 2),
    LR(0, 0, 2, 2),
    TBL(2, 2, 2, 0),
    TBR(2, 2, 0, 2),
    TLR(2, 0, 2, 2),
    BLR(0, 2, 2, 2),
    TBLR(2, 2, 2, 2),

    t(1, 0, 0, 0),
    b(0, 1, 0, 0),
    l(0, 0, 1, 0),
    r(0, 0, 0, 1),
    tb(1, 1, 0, 0),
    tl(1, 0, 1, 0),
    tr(1, 0, 0, 1),
    bl(0, 1, 1, 0),
    br(0, 1, 0, 1),
    lr(0, 0, 1, 1),
    tbl(1, 1, 1, 0),
    tbr(1, 1, 0, 1),
    tlr(1, 0, 1, 1),
    blr(0, 1, 1, 1),
    tblr(1, 1, 1, 1),

    Tb(2, 1, 0, 0),
    tB(1, 2, 0, 0),
    Tl(2, 0, 1, 0),
    tL(1, 0, 2, 0),
    Tr(2, 0, 0, 1),
    tR(1, 0, 0, 2),
    Bl(0, 2, 1, 0),
    bL(0, 1, 2, 0),
    Br(0, 2, 0, 1),
    bR(0, 1, 0, 2),
    Lr(0, 0, 2, 1),
    lR(0, 0, 1, 2),
    Tbl(2, 1, 1, 0),
    tBl(1, 2, 1, 0),
    tbL(1, 1, 2, 0),
    TBl(2, 2, 1, 0),
    TbL(2, 1, 2, 0),
    tBL(1, 2, 2, 0),
    Tbr(2, 1, 0, 1),
    tBr(1, 2, 0, 1),
    tbR(1, 1, 0, 1),
    TBr(2, 2, 0, 1),
    TbR(2, 1, 0, 2),
    tBR(1, 2, 0, 2),
    Tlr(2, 0, 1, 1),
    tLr(1, 0, 2, 1),
    tlR(1, 0, 1, 2),
    TLr(2, 0, 2, 1),
    TlR(2, 0, 1, 2),
    tLR(1, 0, 2, 2),
    Blr(0, 2, 1, 1),
    bLr(0, 1, 2, 1),
    blR(0, 1, 1, 2),
    BLr(0, 2, 2, 1),
    BlR(0, 2, 1, 2),
    bLR(0, 1, 2, 2),
    Tblr(2, 1, 1, 1),
    tBlr(1, 2, 1, 1),
    tbLr(1, 1, 2, 1),
    tblR(1, 1, 1, 2),
    TBlr(2, 2, 1, 1),
    TbLr(2, 1, 2, 1),
    TblR(2, 1, 1, 2),
    tBLr(1, 2, 2, 1),
    tBlR(1, 2, 1, 2),
    tbLR(1, 1, 2, 2),
    TBLr(2, 2, 2, 1),
    TBlR(2, 2, 1, 2),
    tBLR(1, 2, 2, 2),
    TbLR(2, 1, 2, 2),
    RAND(getRNDINT(),getRNDINT(),getRNDINT(),getRNDINT());

    private int top;
    private int bottom;
    private int left;
    private int right;
    private int[] coverInt;

    Tiles(int top, int bottom, int left, int right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        this.coverInt = new int[]{top, bottom, left, right};
    }

    public int[] getCoverInt() {
        return coverInt;
    }

    public static int getRNDINT(){
        return ThreadLocalRandom.current().nextInt(0, 2 + 1);
    }
}
