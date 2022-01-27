public class Hospital {
    public static final float MIN_TEMP = 32.0F;
    public static final float MAX_TEMP = 40.0F;
    public static final float MIN_HEAL = 36.2F;
    public static final float MAX_HEAL = 36.9F;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        float[] patientsTemperature = new float[patientsCount];
        for(int i = 0; i < patientsTemperature.length; i++)
        {
            float value = (float) (Math.random() * (MAX_TEMP - MIN_TEMP)) + MIN_TEMP;
            float roundValue = (float) (Math.round(value * Math.pow(10, 2)) / Math.pow(10, 2));

            patientsTemperature[i] = roundValue;
        }

        return patientsTemperature;

    }
    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        String report = "Температуры пациентов:";

        float midTemp = 0;
        float midTemp2 = 0;
        int healthyPatients = 0;

        for(int i = 0; i < temperatureData.length; i++){
            report = report + " " + temperatureData[i];
            midTemp = midTemp + temperatureData[i];
            if(temperatureData[i] >= MIN_HEAL && temperatureData[i] <= MAX_HEAL){
                healthyPatients++;
            }
        }
        midTemp2 = midTemp/temperatureData.length;

        report = report + "\nСредняя температура: " + (Math.round(midTemp2 * Math.pow(10, 1)) / Math.pow(10, 1)) + "\nКоличество здоровых: " + healthyPatients;

//        String report =
//                "Температуры пациентов: " + 0 +
//                        "\nСредняя температура: " + 0 +
//                        "\nКоличество здоровых: " + 0;

        return report;
    }
}
