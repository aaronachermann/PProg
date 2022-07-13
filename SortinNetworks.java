void createSortingNetwork(int N) {
  int d = 0;
  for (int i = 0; i < N; i++) {
    for (int j = i + 1; j < N; j++) {
      comp(d, i, j);
      d++;
    }
  }
}
