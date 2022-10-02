package cTr.knowledgeMaraphone;

import cTr.knowledgeMaraphone.PFC.Carbon;
import cTr.knowledgeMaraphone.PFC.Fats;
import cTr.knowledgeMaraphone.PFC.Proteins;

public class Program{
//    public void egg() {
//        System.out.println("egg");
//    }
    public static void main(String[] args) {
        ProteinsFatCarbohydrates p = new Proteins("Proteins");//что бы былы только методы интерфейса без egg
        ProteinsFatCarbohydrates f = new Fats("Fats");//что бы былы только методы интерфейса без egg
        ProteinsFatCarbohydrates c = new Carbon("Carbon");//что бы былы только методы интерфейса без egg
        p.countPFC();
        f.countPFC();
        c.countPFC();



    }
}
