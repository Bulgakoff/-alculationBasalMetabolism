package cTr.knowledgeMaraphone.PFC;

import cTr.knowledgeMaraphone.ProteinsFatCarbohydrates;

public class Carbon implements ProteinsFatCarbohydrates {

    private String name;

    public Carbon(String name) {

        this.name = name;
    }


    @Override
    public void countPFC() {
        System.out.println("here "+name);
    }
}
