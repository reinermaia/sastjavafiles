  private void mapMouseToPlane(Simple1DOFCamera camera, Point point2d, double[] vec) {
    // Far plane
    camera.unproject(point2d.x, point2d.y, -100., far);
    // Near plane
    camera.unproject(point2d.x, point2d.y, 1., near);
    // Delta vector: far -= near.
    VMath.minusEquals(far, near);
    // Intersection with z=0 plane:
    // far.z - a * near.z = 0 -> a = far.z / near.z
    if (near[2] < 0 || near[2] > 0) {
      double a = far[2] / near[2];
      vec[0] = far[0] - a * near[0];
      vec[1] = far[1] - a * near[1];
      vec[2] = 0;
    }
  }