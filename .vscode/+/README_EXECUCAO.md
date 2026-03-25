# como executar o projeto (sem maven)

## execução rápida

na raiz do repositório (onde está esta pasta):

**windows (cmd ou powershell):**

```text
javac -encoding UTF-8 -d out/classes src/main/java/br/pucrs/App.java src/main/java/br/pucrs/MergeSort.java src/main/java/br/pucrs/MaxVal1.java
java -cp out/classes br.pucrs.App
```

o diretório `out/classes` é criado pelo `javac` se ainda não existir.

## por que `java MaxVal1` ou `java MergeSort` dão erro

as classes estão no pacote `br.pucrs`. o nome completo da classe é `br.pucrs.MaxVal1`, não `MaxVal1`. além disso, o classpath precisa apontar para a pasta que contém a pasta `br` (aqui: `out/classes`), e você deve invocar `java -cp out/classes br.pucrs.<nome>`.

`MaxVal1` e `MergeSort` **não** têm método `main`; quem inicia o programa é `br.pucrs.App`.

erro típico do code runner: compilar dentro de `.../br/pucrs` e rodar `java MaxVal1` — o bytecode declara `br.pucrs.MaxVal1`, daí aparece `wrong name: br/pucrs/MaxVal1`.

## code runner (vscode)

o arquivo `.vscode/settings.json` define o executor de java para compilar as três classes na raiz do workspace e executar `br.pucrs.App`. use "run code" com qualquer um desses `.java` abertos para rodar a demo completa.

## o que o programa faz

testa merge sort e maxval1 com vetores de tamanho 32, 2048 e 1.048.576, mostrando iterações e tempo.

## testes unitários (opcional)

o arquivo `AppTest.java` usa junit; sem maven você precisa do jar do junit no classpath para compilar e rodar os testes manualmente.

## estrutura

```text
src/main/java/br/pucrs/
  App.java       # main — rode esta via java -cp ... br.pucrs.App
  MergeSort.java
  MaxVal1.java
```
