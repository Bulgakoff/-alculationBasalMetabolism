package cTr.knowledgeMaraphone.PFC;

import cTr.knowledgeMaraphone.ProteinsFatCarbohydrates;

public class Proteins implements ProteinsFatCarbohydrates {
    private String name;

    public Proteins(String name) {

        this.name = name;
    }
    @Override
    public void countPFC() {
        System.out.println("here "+name);
//        Чтобы узнать свои потребности:
//        1. Умножьте количество белков в граммах на 4;
        double p = 143.0;// gr
        double multP = p * 4;
//        2. Умножьте количество жиров в граммах на 9;
        double f = 89.0;// gr
        double multf = f * 9;

//        3. Сложите результаты 1 и 2;
        double sumPF = multf + multP;
//        4. Вычтите из суточной калорийности сумму 1 и 2;
        double targetMetabolism = 2287.0;
//        5. Получившееся число разделите на 4.
        double targetProt = (targetMetabolism - sumPF)/4;
        System.out.println(targetProt+" gr.");


    }
}
