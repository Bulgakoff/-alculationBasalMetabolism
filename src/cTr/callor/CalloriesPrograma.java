package cTr.callor;

import cTr.callor.fourWorkPhase.FatBurning;
import cTr.callor.fourWorkPhase.Hard;
import cTr.callor.fourWorkPhase.Kardio;
import cTr.callor.fourWorkPhase.LFK;

public class CalloriesPrograma implements CautntAllForNewClient {
    public static void main(String[] args) {
        //        ==для ввода данных==================начало============================
        double sedentary = 1.2;
        double moderateActivity = 1.375; // 1-3 time/week
        double averageActivity = 1.55; // 3 -5 time/week
        double activePeople = 1.725; // 6 -7 time/week
        double sportmans = 1.9; // 6 -7 time/week hard

        int age = 49;
        double growth = 177.0;
        double weight = 72.0;
        String phase = "kardio";//fat kardio hard lfk ЦЕЛЬ
//        ======================конец данных==========================
        CautntAllForNewClient ri = new CalloriesPrograma();
        if (phase.equals("fat")) {
            ri.ChSSmax(age, weight, phase);
        } else if (phase.equals("kardio")) {
            ri.ChSSmax(age, weight, phase);
        } else if (phase.equals("hard")) {
            ri.ChSSmax(age, weight, phase);
        } else if (phase.equals("lfk")) {
            ri.ChSSmax(age, weight, phase);
        }
        double resIMT = ri.Imt(growth, weight);
        ri.P1P2P3();
        ri.BMRAMR(moderateActivity, weight, age, growth, resIMT, phase);
    }

    @Override
    public double Imt(double growth, double weight) {
        double imt = (weight / Math.pow(growth, 2)) * Math.pow(10, 4);
        if (imt <= 16.0) {
            System.out.println("Индекс массы тела = " + imt + " - 16 и менее: Выраженный дефицит массы тела");
        } else if (imt > 16.0 & imt <= 18.0) {
            System.out.println("Индекс массы тела = " + imt + " - 16—18,5 Недостаточная (дефицит) масса тела");
        } else if (imt > 18.0 & imt <= 25.0) {
            System.out.println("Индекс массы тела = " + imt + " - 18,5—25  Норма");
        } else if (imt > 25.0 & imt <= 30.0) {
            System.out.println("Индекс массы тела = " + imt + " - 25—30  Избыточная масса тела " +
                    "(предожирение)");
        } else if (imt > 30.0 & imt <= 35.0) {
            System.out.println("Индекс массы тела = " + imt + " - 30—35  Ожирение 1 степени");
        } else if (imt > 35.0 & imt <= 40.0) {
            System.out.println("Индекс массы тела = " + imt + " - 35—40 Ожирение 2 степени");
        } else if (imt > 40.0) {
            System.out.println("Индекс массы тела = " + imt + " - 40 и более  Ожирение 3 степени");
        }
        return Math.ceil(imt);
    }

    @Override
    public void P1P2P3() {
        int p1 = 15;// замеряем
        int p2 = 25;// замеряем
        int p3 = 19;// замеряем
        int ip = (4 * (p1 + p2 + p3) - 200) / 10;
        if (ip <= 3) {
            System.out.println(
                    +ip + " И ЭТО ОЧЕНЬ ХОРОШО! т.к." + ip + " <= 3");
        } else if (ip > 3 & ip <= 6) {
            System.out.println("Индекс первичной экспертизы (работа сердца) = "
                    + ip + " И это не отлично, но ok! т.к. " + ip + " больше 3, но меньше(равна) 6");
        } else if (ip > 6 & ip <= 9) {
            System.out.println("Индекс первичной экспертизы (работа сердца) = "
                    + ip + " И это не то не сеееее! т.к." + ip + " больше 6, но меньше(равна) 9");
        } else if (ip > 9 & ip <= 14) {
            System.out.println("Индекс первичной экспертизы (работа сердца) = "
                    + ip + " И это не ОЧЕНЬ (средняя сердечная недостаточность)!" +
                    " т.к." + ip + " больше 10, но меньше(равна) 14");
        } else if (ip > 14) {
            System.out.println("Индекс первичной экспертизы (работа сердца) = "
                    + ip + " И это не ОЧЕНЬ плохо (сильная сердечная недостаточность)!" +
                    " т.к." + ip + " больше 14");
        }
    }


    @Override
    public void ChSSmax(int age, double weight, String phase) {
        double pressureMax = 220;
        double chssPeace = 70;
        if (phase.equals("fat")) {
            FatBurning fb = new FatBurning();
            double bountsLow = fb.getLOW_BOUNT();
            double bountsHigh = fb.getHIGN_BOUNT();
            ChSSFormul(pressureMax, age, chssPeace, bountsLow, bountsHigh, phase);
        } else if (phase.equals("kardio")) {
            Kardio k = new Kardio();
            double bountsLow = k.getLOW_BOUNT();
            double bountsHigh = k.getHIGN_BOUNT();
            ChSSFormul(pressureMax, age, chssPeace, bountsLow, bountsHigh, phase);
        } else if (phase.equals("hard")) {
            Hard hard = new Hard();
            double bountsLow = hard.getLOW_BOUNT();
            double bountsHigh = hard.getHIGN_BOUNT();
            ChSSFormul(pressureMax, age, chssPeace, bountsLow, bountsHigh, phase);
        } else if (phase.equals("lfk")) {
            LFK lfk = new LFK();
            double bountsLow = lfk.getLOW_BOUNT();
            double bountsHigh = lfk.getHIGN_BOUNT();
            ChSSFormul(pressureMax, age, chssPeace, bountsLow, bountsHigh, phase);
        }


    }

    public static void ChSSFormul(double pressureMax, int age, double chssPeace, double bountsLow, double bountsHigh, String phase) {
//        ЧССр = [(220 – возраст) – ЧССп] х ИТН + ЧССп
        double chssMax1 = Math.ceil(((pressureMax - age) - chssPeace) * bountsLow + chssPeace);
        double chssMax2 = Math.ceil(((pressureMax - age) - chssPeace) * bountsHigh + chssPeace);
        System.out.println("===============ЧСС максимальные для режима== " + phase + " ==========================");
        System.out.println("ЧСС максимальный = " + chssMax1);
        System.out.println("ЧСС максимальный = " + chssMax2);
        System.out.println("===============Целевая зона чсс конец============================");
    }


    @Override
    public void BMRAMR(double param, double weight, int age, double growth, double resIMT, String phase) {
//         main Metabolism: 447,593 + (9,247 х 80) + (3,098 х 170) – (4.330 х 28)
//        double bmr = 447.593 + (9.247 * weight) + (3.098 * growth) - (4.330 * age); // female
        double bmr = 88.362 + (13.397 * weight) + (4.799 * growth) - (5.677 * age); // man
//        double bmr = (662 - (9.53 * age)) + param * ((15.91 * weight) + (539.6 * growth));
        double bmrCeil = Math.ceil(bmr);
        // target Metabolism:
//        double targetMetabolism = bmr * 1;
        double targetMetabolism = bmr * param;
//        double targetMetabolism = 2207.0;
        //грамм белков =146.0 g.:
        if (phase.equals("fat")) {
            FatBurning fb = new FatBurning();
            double targetFatMetabolism = Math.ceil(fb.
                    getFatBurningMetabolism(targetMetabolism));
            System.out.println(" Необходимый колораж для режима 'fat' (похудения) ======> " + targetFatMetabolism);
//            =================================
            double protein = (targetFatMetabolism * 0.25) / 4; // g. 25 %

            //калорий для белков =581.0 kk:
            double proteinKk = protein * 4;// kk
            double proteinG = protein / weight;
            System.out.println("Нужно грамм белков = " + Math.ceil(protein) +
                    " g., калорий для белков = " + Math.ceil(proteinKk) + " kk");
            double fat = (targetFatMetabolism * 0.35) / 9; // 35 %

            double fatKk = fat * 9;
            double fatG = fat / weight;


            System.out.println("Нужно грамм жиров = " + Math.ceil(fat) + " g., калорий для жиров = "

                    + Math.ceil(fatKk) + " kk");
            double carbohydrate = (targetFatMetabolism * 0.4) / 4;  // 40 %

            double carbohydrateKk = carbohydrate * 4;
            double carbohydrateG = carbohydrate / weight;
            System.out.println("Нужно грамм углеводов = " + Math.ceil(carbohydrate) +
                    " g., калорий для углеводов = " + Math.ceil(carbohydrateKk) + " kk");
            double summKk = proteinKk + fatKk + carbohydrateKk;
            double summKkTargetAvarage = (summKk + targetFatMetabolism) / 2;
            //=====================
            double eggsOO = 10 * weight + 6.25 * growth - 5 * age + 5;
            //=====================

            System.out.println("Базальный обмен (BMR) = " + bmrCeil + " ккал");
            System.out.println("Целевой  обмен РАСХОДА при обределенной занятости " +
                    "(BMR*AMR(" + param + ") ) = " + Math.ceil(targetFatMetabolism) + " кк ");
            System.out.println("Сумма kk НАЖРАННЫХ КАЛЛОРИЙ " + Math.ceil(summKk) + " kk ");
            System.out.println("================================>");
            System.out.println("Среднее по больнице ПОСЛЕДНЕЕ значение каллорий "
                    + Math.ceil(summKkTargetAvarage) + " kk ");
//        System.out.println("Целевой  обмен РАСХОДА при обределенной занятости  = " + Math.ceil(eggsOO) + " кк "); 2207.0
            System.out.println("================================>");


            System.out.println("На кг веса  " + proteinG + " г. белков (Норма : 1,5 - 2 г.)");
            System.out.println("На кг веса  " + fatG + " г. жиров (Норма : 0,8 - 1,5 г.)\n" +
                    " • При сильно избыточном весе – 0,4-0,6 г на каждый килограмм массы тела;\n" +
                    " • При избыточном весе – 0,7-0,8 г на каждый килограмм массы тела;\n" +
                    " • При нормальном весе – 0,9-1,1 г на каждый килограмм массы тела.");
            double shouldBeFat;
            if (resIMT > 18 & resIMT <= 25) {
                System.out.println("====-----------------------------" +
                        "--------------------------------------" +
                        "-------------==>Индекс массы тела = " + resIMT + " - 18,5—25  Норма");
                shouldBeFat = fatG;
                shouldBeFat = 1.1;
                System.out.println(" При нормальном весе – 0,9-1,1 г  (как тут) – " +
                        "на каждый килограмм массы тела == следует уменьшить  до 1,1 г. жиров \nно расчитано  ==> " + fatG);


            } else if (resIMT > 25.0 & resIMT <= 30.0) {
                System.out.println("------------------------------=--------------------------------" +
                        "--------------------------" +
                        "---->Индекс массы тела = " + resIMT + " - 25—30  Избыточная масса тела " +
                        "(предожирение)");
                shouldBeFat = fatG;
                shouldBeFat = 0.8;
                System.out.println(" При избыточном весе – 0,7-0,8 г на каждый килограмм массы тела (как тут) – " +
                        "на каждый килограмм массы тела ==  следует уменьшить   до 0,8 г. жиров,\n но расчитано ==> " + fatG);


            } else if (resIMT > 30.0) {
                System.out.println("-------------------------------------" +
                        "---------------------------" +
                        "------->Индекс массы тела = " + resIMT + " - 30—40 and more   Ожирение 1.2.3.....");
                shouldBeFat = fatG;
                shouldBeFat = 0.6;
                System.out.println("При сильно избыточном весе (как тут) – 0,4-0,6 г " +
                        "на каждый килограмм массы тела ==  следует уменьшить   до 0,6 г. жиров \n но расчитано  ==> " + fatG);

            }

            System.out.println("На кг веса  " + carbohydrateG + " г. углей (Норма : 2 г.)");


            double diffKk = summKk - targetFatMetabolism;
            System.out.println("Разница в каллориях = " + Math.ceil(diffKk));
            if (diffKk <= 0) {
                System.out.println(Math.ceil(diffKk) + " значение о сожженных кк и значит " +
                        " немного снизить угли (при необходимости )");
            } else {
                System.out.println(Math.ceil(diffKk) + " знчение о излишке кк  и значит  больше снизить угли ");
            }
            //        1. Умножьте количество белков в граммах на 4;
//        double p = 0;// gr
            double multP = protein * 4;
//        2. Умножьте количество жиров в граммах на 9;
//        double f = 0;// gr
            double multf = fat * 9;
//        3. Сложите результаты 1 и 2;
            double sumPF = multf + multP;
//        4. Вычтите из суточной калорийности сумму 1 и 2;
//        5. Получившееся число разделите на 4.
            double targetCarb = (targetFatMetabolism - sumPF) / 4;
            System.out.println("Тут вроде будет значение по углям по дополнительной формуле == " + Math.ceil(targetCarb) + " грамм");
        } else {

            double protein = (targetMetabolism * 0.25) / 4; // g. 25 %

            //калорий для белков =581.0 kk:
            double proteinKk = protein * 4;// kk
            double proteinG = protein / weight;
            System.out.println("Нужно грамм белков = " + Math.ceil(protein) +
                    " g., калорий для белков = " + Math.ceil(proteinKk) + " kk");
            double fat = (targetMetabolism * 0.35) / 9; // 35 %

            double fatKk = fat * 9;
            double fatG = fat / weight;


            System.out.println("Нужно грамм жиров = " + Math.ceil(fat) + " g., калорий для жиров = "

                    + Math.ceil(fatKk) + " kk");
            double carbohydrate = (targetMetabolism * 0.4) / 4;  // 40 %

            double carbohydrateKk = carbohydrate * 4;
            double carbohydrateG = carbohydrate / weight;
            System.out.println("Нужно грамм углеводов = " + Math.ceil(carbohydrate) +
                    " g., калорий для углеводов = " + Math.ceil(carbohydrateKk) + " kk");
            double summKk = proteinKk + fatKk + carbohydrateKk;
            double summKkTargetAvarage = (summKk + targetMetabolism) / 2;
            //=====================
            double eggsOO = 10 * weight + 6.25 * growth - 5 * age + 5;
            //=====================

            System.out.println("Базальный обмен (BMR) = " + bmrCeil + " ккал");
            System.out.println("Целевой  обмен РАСХОДА при обределенной занятости " +
                    "(BMR*AMR(" + param + ") ) = " + Math.ceil(targetMetabolism) + " кк ");
            System.out.println("Сумма kk НАЖРАННЫХ КАЛЛОРИЙ " + Math.ceil(summKk) + " kk ");
            System.out.println("================================>");
            System.out.println("Среднее по больнице ПОСЛЕДНЕЕ значение каллорий "
                    + Math.ceil(summKkTargetAvarage) + " kk ");
//        System.out.println("Целевой  обмен РАСХОДА при обределенной занятости  = " + Math.ceil(eggsOO) + " кк "); 2207.0
            System.out.println("================================>");


            System.out.println("На кг веса  " + proteinG + " г. белков (Норма : 1,5 - 2 г.)");
            System.out.println("На кг веса  " + fatG + " г. жиров (Норма : 0,8 - 1,5 г.)\n" +
                    " • При сильно избыточном весе – 0,4-0,6 г на каждый килограмм массы тела;\n" +
                    " • При избыточном весе – 0,7-0,8 г на каждый килограмм массы тела;\n" +
                    " • При нормальном весе – 0,9-1,1 г на каждый килограмм массы тела.");
            double shouldBeFat;
            if (resIMT > 18 & resIMT <= 25) {
                System.out.println("====-----------------------------" +
                        "--------------------------------------" +
                        "-------------==>Индекс массы тела = " + resIMT + " - 18,5—25  Норма");
                shouldBeFat = fatG;
                shouldBeFat = 1.1;
                System.out.println(" При нормальном весе – 0,9-1,1 г  (как тут) – " +
                        "на каждый килограмм массы тела == следует уменьшить  до 1,1 г. жиров \nно расчитано  ==> " + fatG);


            } else if (resIMT > 25.0 & resIMT <= 30.0) {
                System.out.println("------------------------------=--------------------------------" +
                        "--------------------------" +
                        "---->Индекс массы тела = " + resIMT + " - 25—30  Избыточная масса тела " +
                        "(предожирение)");
                shouldBeFat = fatG;
                shouldBeFat = 0.8;
                System.out.println(" При избыточном весе – 0,7-0,8 г на каждый килограмм массы тела (как тут) – " +
                        "на каждый килограмм массы тела ==  следует уменьшить   до 0,8 г. жиров,\n но расчитано ==> " + fatG);


            } else if (resIMT > 30.0) {
                System.out.println("-------------------------------------" +
                        "---------------------------" +
                        "------->Индекс массы тела = " + resIMT + " - 30—40 and more   Ожирение 1.2.3.....");
                shouldBeFat = fatG;
                shouldBeFat = 0.6;
                System.out.println("При сильно избыточном весе (как тут) – 0,4-0,6 г " +
                        "на каждый килограмм массы тела ==  следует уменьшить   до 0,6 г. жиров \n но расчитано  ==> " + fatG);

            }

            System.out.println("На кг веса  " + carbohydrateG + " г. углей (Норма : 2 г.)");


            double diffKk = summKk - targetMetabolism;
            System.out.println("Разница в каллориях = " + Math.ceil(diffKk));
            if (diffKk <= 0) {
                System.out.println(Math.ceil(diffKk) + " значение о сожженных кк и значит " +
                        " немного снизить угли (при необходимости )");
            } else {
                System.out.println(Math.ceil(diffKk) + " знчение о излишке кк  и значит  больше снизить угли ");
            }
            //        1. Умножьте количество белков в граммах на 4;
//        double p = 0;// gr
            double multP = protein * 4;
//        2. Умножьте количество жиров в граммах на 9;
//        double f = 0;// gr
            double multf = fat * 9;
//        3. Сложите результаты 1 и 2;
            double sumPF = multf + multP;
//        4. Вычтите из суточной калорийности сумму 1 и 2;
//        5. Получившееся число разделите на 4.
            double targetCarb = (targetMetabolism - sumPF) / 4;
            System.out.println("Тут вроде будет значение по углям по дополнительной формуле == " + Math.ceil(targetCarb) + " грамм");
        }
    }


}
