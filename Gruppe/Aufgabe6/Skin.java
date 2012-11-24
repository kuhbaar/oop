public abstract class Skin {
  public boolean accept(SkinInspector visitor) {
    return visitor.visit(this); /* this needs to be implemented in each subclass
      the only reason I've provided a default implementation here is because
      I'm to lazy to add it in all classes right now */
  }
}
