package cTr.periodize;

public class HardEx {
    public static void main(String[] args) {
        int repetitions = 10;//повторения // input here
        int setEx = 3;// sets all in one exercise // input here
        HardEx periodBody = new HardEx();
        periodBody.getDataExerciseProgram(repetitions, setEx);
    }

    //========================================
    public void getInfoAboutHardTraining(int setEx) {
        if (setEx == 3) {
            System.out.println("Тренировка первая в микроцикле легкая," +
                    " т.к. sets all in one exercise  == " + setEx + " сетам");
        } else if (setEx == 4) {
            System.out.println("Тренировка первая в микроцикле средняя," +
                    " т.к.sets all in one exercise  == " + setEx + " сетам");
        } else if (setEx == 5) {
            System.out.println("Тренировка первая в микроцикле тяжелая," +
                    " т.к. sets all in one exercise  == " + setEx + " сетам");
        }
    }

    public void getDataExerciseProgram(int repetitions, int setEx) {
        int oneExercise = 2 + 1;// //Длительность одного подхода
        double relax = 120;// отдых 2 мин

        int durationExercise = oneExercise * repetitions;//Длительность одного упражнения
        double durationExercisePlusRelax = durationExercise + relax;//Длительность одного упражнения  + отдых
        double durationExerciseAll = durationExercisePlusRelax * setEx / 60;// общая длительность упражнений с отдыхом
        double quantityExercisesAllInHour = 60 / durationExerciseAll;// количество упражнений за час (одна тренька)
        //========================================
        System.out.println("Длительность одного упражнения\n (под нагрузкой) с учетом "
                + repetitions + " повторений в нем = " + durationExercise + " секунд");
        System.out.println("Длительность одного упражнения\n (под нагрузкой) с учетом "
                + repetitions + " повторений в нем + отдых = " + durationExercisePlusRelax + " секунд");
        System.out.println("================================================================================");
        System.out.println("ОБЩАЯ длительность упражнений \n с учетом " + repetitions +
                " повторений в них + отдых = " + durationExerciseAll + " минут");
        System.out.println("КОЛИЧЕСТВО упражнений за час \n(одна тренька) " + quantityExercisesAllInHour + " шт");
        System.out.println("================================================================================");
        //========================================
        if (8 <= repetitions & repetitions <= 15) {
            System.out.println(repetitions + " === 70-80 % от ПМ -  это (1 - 3 НЕДЕЛЯ (15,12,8):" +
                    " САРКО+миофибрил)" +
                    "\n Преимущественное увеличение МЫШЕЧНОЙ МАССЫ \nс одновременным приростом максимальной СИЛЫ," +
                    " тут нужно сделать 8-15 повторений,\n 3-6 подходов (сетов) тут по факту - " + setEx + "," +
                    "\n 2-3 мин. отдыха,\n скорость движения - средняя,\n темп - средний");
            getInfoAboutHardTraining(setEx);
        } else if (1 <= repetitions & repetitions <= 3) {
            System.out.println(repetitions + " === 100 % от ПМ -  это (ПЕРЕБОР ВОЗМОЖНО)" +
                    " рАЗВИТИЕ МАКСИМАЛЬНОЙ СИЛЫ \n," +
                    " тут нужно сделать 1 -3 повторений,\n 2-5 подходов (сетов) тут по факту - " + setEx + "," +
                    "\n 2-5 мин. отдыха,\n скорость движения - медленнвя,\n темп - произвольный ");
            getInfoAboutHardTraining(setEx);
        } else if (3 < repetitions & repetitions <= 5) {
            System.out.println(repetitions + " === 90-95 % от ПМ -  это  ( 7 - 9 неделя (3,4,5):" +
                    " МИОФИБРИЛ) " +
                    "\nрАЗВИТИЕ МАКСИМАЛЬНОЙ СИЛЫ с незначитильным приростом мышечной массы\n," +
                    " тут нужно сделать 3 -5 повторений," +
                    "\n 2-5 подходов (сетов) тут по факту - " + setEx + ",\n 2-5 мин. отдыха," +
                    "\n скорость движения - медленнвя," +
                    "\n темп - произвольный ");
            getInfoAboutHardTraining(setEx);
        } else if (5 < repetitions & repetitions <= 7) {
            System.out.println(+repetitions + " === 80-90 % от ПМ -  это  ( 4 - 6 неделя (5,6,7): миоибрил)" +
                    " \n БОЛЬШЕ рАЗВИТИЕ МАКСИМАЛЬНОЙ СИЛЫ с небольшим приростом  мышечной массы\n, " +
                    "тут нужно сделать 5 -7 повторений,\n 3-6 подходов (сетов) тут по факту - " + setEx + "," +
                    "\n 2-3 мин. отдыха,\n скорость движения - средняя,\n темп - средний ");
            getInfoAboutHardTraining(setEx);
        } else if (15 < repetitions & repetitions <= 30) {
            System.out.println(repetitions + " === 50-70 % от ПМ - ( 10 - 12 неделя (15,22,30): САРКО)" +
                    " \nэто Уменьшение жирового компонента \nс одновременным совершенствованием " +
                    "силовой выносливости," +
                    " тут нужно сделать 15 -30 повторений,\n 3-6 подходов (сетов) тут по факту - "
                    + setEx + "," +
                    "\n 3-6 мин. отдыха,\n скорость движения - средняя,\n темп - высокий до максимального");
            getInfoAboutHardTraining(setEx);
        } else if (50 <= repetitions & repetitions <= 100) {
            System.out.println(repetitions + " === 30-50 % от ПМ -  это ( 13 - 15 неделя (50,75,100): САРКО-САРКО)" +
                    "\n Уменьшение жирового компонента, \nсовершенствованием силовой выносливости " +
                    "\nс одновременным РЕЛЬЕФОМ МЫШЦ, тут нужно сделать 50 -100 повторений," +
                    "\n 2-6 подходов (сетов) тут по факту - " + setEx + ",\n 3-6 мин. отдыха," +
                    "\n скорость движения - высокая,\n темп - высокий ");
            getInfoAboutHardTraining(setEx);
        }

    }
}
