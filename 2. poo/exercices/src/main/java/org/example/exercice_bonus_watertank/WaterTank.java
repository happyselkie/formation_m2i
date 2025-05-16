package org.example.exercice_bonus_watertank;

public class WaterTank {
    private int weightEmpty;
    private int maxCapacity;
    private int fillLevel;
    private static int totalFillLevel = 0;

    public WaterTank(int weightEmpty, int maxCapacity, int fillLevel) {
        this.weightEmpty = weightEmpty;
        this.maxCapacity = maxCapacity;
        this.fillLevel = fillLevel;
        totalFillLevel += fillLevel;
    }

    public WaterTank(int weightEmpty, int maxCapacity) {
        this.weightEmpty = weightEmpty;
        this.maxCapacity = maxCapacity;
        this.fillLevel = 0;
    }

    public static int getTotalFillLevel(){
        return totalFillLevel;
    }

    public int fill(int qt){
        int rest = 0;

        if(this.fillLevel+qt > maxCapacity){
            rest = this.fillLevel+qt - maxCapacity;

            this.fillLevel += this.fillLevel+qt - rest;
            totalFillLevel += this.fillLevel+qt - rest;
        }else {
            this.fillLevel += qt;
            totalFillLevel += qt;
        }
        return rest;
    }

    public int empty(int qt){
        int rest = 0;
        if(qt > this.fillLevel){
            //   if(this.fillLevel-qt < 0){
            System.out.println("Vous souhaitez retirer plus que possible !!!!");
        }else {
            this.fillLevel -= qt;
            totalFillLevel -= qt;
        }
        return rest;
    }

    public int getWeightEmpty() {
        return weightEmpty;
    }

    public void setWeightEmpty(int weightEmpty) {
        this.weightEmpty = weightEmpty;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(int fillLevel) {
        this.fillLevel = fillLevel;
    }

    @Override
    public String toString() {
        return "WaterTank{" +
                "Poid a vide =" + weightEmpty +
                ", Capacite max =" + maxCapacity +
                ", Level de remplissage =" + fillLevel +
                '}';
    }

}
