package dev.simple;

public class Ceiling extends Surface {

  @Override
  public double collisionDistance(Photon p) {
    double d = (p.Z - p.r.z) / p.n.z;
    if (d < 0 || p.n.z < 0)
      d = Double.POSITIVE_INFINITY;
    return d;
  }

  @Override
  public boolean collision(Photon p) {
    double d = collisionDistance(p);
    p.move(d);
    p.stat.addPath(p.r);
    p.stat.extendHead(p.n);
    return true;
  }

}
