package org.example.lesson2_3.case2;

public class Park {
    private String adress;
    private String name;

    public class Attraction {
        private String name;
        private String cost;
        private String workTime;

        public Attraction() {
            this.name = "Неизвестно";
            this.workTime = "Не указано";
            this.cost = "0.0";
        }

        public Attraction(String name, String cost, String workTime) {
            this.name = name;
            this.cost = cost;
            this.workTime = workTime;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

        public void setWorkTime(String workTime) {
            this.workTime = workTime;
        }

        public void displayInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workTime);
            System.out.println("Стоимость: " + cost);
            System.out.println("---------------------------");
        }
    }
}
