#!/usr/bin/env bash
set -euo pipefail
root="$(cd "$(dirname "$0")/../.." && pwd)"
cd "$root"
mkdir -p out/classes
javac -encoding UTF-8 -d out/classes \
  src/main/java/br/pucrs/App.java \
  src/main/java/br/pucrs/MergeSort.java \
  src/main/java/br/pucrs/MaxVal1.java
java -cp out/classes br.pucrs.App
