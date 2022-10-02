package cTr.callor.fourWorkPhase;

public class FatBurning {
    private double LOW_BOUNT = 0.6;
    private double HIGN_BOUNT = 0.7;

    public double getLOW_BOUNT() {
        return LOW_BOUNT;
    }

    public double getHIGN_BOUNT() {
        return HIGN_BOUNT;
    }

    public double getFatBurningMetabolism(double targetMetabolism) {
        double targetFatMetabolism= targetMetabolism * 0.8;
        return targetFatMetabolism;
    }

}
