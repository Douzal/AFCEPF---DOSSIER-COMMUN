

public class Human  implements Unite {
  public enum HumanType  {
    Soldier(30,1,15), 
    Medic(-5,2,10),
    Marine(10,3,20),
    Aviator(10,3,20),
    GrenadeLauncher(-5,2,15),
    FlameThrower(20,2,15);
    
    private HumanType(int fire,int speed, int health){
      this.fire = fire;
      this.speed = speed;
      this.health = health;
    }
    
    final int fire;
    final int speed;
    final int health;
  }
  
  public Human(HumanType type){
    this.type=type;
    this.fire=type.fire;
    this.speed=type.speed;
    this.health=type.health;
  }
  
  public int speed() {
    return speed;
  }
  
  public int health() {
    return health;
  }
  
  public int fire() {
    return fire;
  }
  
  public HumanType type() {
    return type;
  }
  
  private final HumanType type;
  private final int fire;
  private final int speed;
  private final int health;
}
