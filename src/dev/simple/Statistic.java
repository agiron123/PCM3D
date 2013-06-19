package dev.simple;

import java.util.ArrayList;
import java.util.List;

import pcm.model.geom.Vector;

public class Statistic {

  // The cooridinates for the photon's collisions
  public List<List<List<Vector>>> rv = new ArrayList<List<List<Vector>>>();
  // The cooridinates for the photon's absorbsions
  public List<Vector> xv = new ArrayList<Vector>();
  public int n, N = 1, x, X = 1;

  public void newPhoton(Vector v) {
    n++;
    if (n <= N) {
      rv.add(new ArrayList<List<Vector>>());
      newBranch(v);
      addPath(v);
    }
  }

  public void newBranch(Vector v) {
    if (n <= N) {
      rv.get(rv.size() - 1).add(new ArrayList<Vector>());
      addPath(v);
    }
  }

  public void addPath(Vector v) {
    if (n <= N)
      rv.get(rv.size() - 1).get(rv.get(rv.size() - 1).size() - 1).add(v.clone());
  }

  public void absorb(Vector v) {
    x++;
    if (x <= X) {
      xv.add(v.clone());
    }
  }

  public void printAll() {
    System.out.println();
    System.out.println("Photon Paths:");
    for (List<List<Vector>> i : rv) {
      for (List<Vector> j : i) {
        for (Vector k : j)
          System.out.printf("%1.3f %1.3f %1.3f | ", k.x, k.y, k.z);
        System.out.println();
      }
      System.out.println();
    }
    System.out.println();
    System.out.println("Absorbsion Points:");
    for (Vector i : xv)
      System.out.printf("%1.3f %1.3f %1.3f | ", i.x, i.y, i.z);
    System.out.println();
    System.out.println();
    System.out.println("Ratio:");
    System.out.printf("%d:%d | %1.2f | ", x, n, ((double) x) / n);
  }

  public void print() {
    System.out.println("Ratio:");
    System.out.printf("%d:%d | %1.2f | ", x, n, ((double) x) / n);
  }

}
