package structural.decorator1;

public abstract class Pizza {
      private Mushroon mushroon;

      private Onion onion;

      private Olive olive;


      public double getCost(){
          double cost = 0;
          if(mushroon!=null){
              cost+=mushroon.getPrice();
          }
          if(onion!=null){
              cost+= onion.getPrice();
          }
          if(olive!=null){
              cost+= olive.getPrice();
          }
          return cost;
      }

      public String getName(){
          String name ="";
          if(mushroon!=null){
              name+=mushroon.getName();
          }
          if(onion!=null){
              name+= onion.getName();
          }
          if(olive!=null){
              name+= olive.getName();
          }
          return name;
      }

}
