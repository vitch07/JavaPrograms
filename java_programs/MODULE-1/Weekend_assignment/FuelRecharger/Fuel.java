package FuelRecharger;

public class Fuel {

        private int FuelRemaining;
        private int DistanceNeedToTravel;
        private int mileage;
        Fuel(){}

        Fuel(int FuelRemaining,int DistanceNeedToTravel){
            this.FuelRemaining = FuelRemaining;
            this.DistanceNeedToTravel =  DistanceNeedToTravel;
        }
        public void setMileage(int mileage){
            this.mileage = mileage;
        }
        public void putFuel(int fuels){
            this.FuelRemaining += fuels;
        }
        public int getFuelRemaining(){
            return this.FuelRemaining;
        }
        public void setDistanceNeedToTravel(int km) {
            this.DistanceNeedToTravel  = km;
        }
        public int getDistanceNeedToTravelWithRemFuel(int number){
            if ((int)(this.FuelRemaining / mileage) > DistanceNeedToTravel) return (int)this.FuelRemaining / mileage;
                else return 0;
        }

        public int getMileage(){
            return this.mileage;
        }

        public String toString(){
            return  "The features are " + FuelRemaining + " " +
            DistanceNeedToTravel + " " + mileage + " ";
    }


    }


