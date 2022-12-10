package src.day7;

public class Day7 {


    public static void main(String[] args) {

        String input = "$ cd /\n" +
                "$ ls\n" +
                "dir a\n" +
                "14848514 b.txt\n" +
                "8504156 c.dat\n" +
                "dir d\n" +
                "$ cd a\n" +
                "$ ls\n" +
                "dir e\n" +
                "29116 f\n" +
                "2557 g\n" +
                "62596 h.lst\n" +
                "$ cd e\n" +
                "$ ls\n" +
                "584 i\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd d\n" +
                "$ ls\n" +
                "4060174 j\n" +
                "8033020 d.log\n" +
                "5626152 d.ext\n" +
                "7214296 k";

        Cartella root = new Cartella();
        root.nome = "/";
        Cartella cartellaAttuale = root;

        String[] lines = input.split("\n");
        for (String line : lines) {

            String[] partiLinea = line.split(" ");
            switch (partiLinea[0]) {
                case "$":

                    if ("cd".equals(partiLinea[1])) {

                        cartellaAttuale = ("..".equals(partiLinea[2]))
                                ? cartellaAttuale.parent
                                : cartellaAttuale.contenuti.stream()
                                .filter(Cartella.class::isInstance)
                                .filter(n -> n.nome.equals(partiLinea[2]))
                                .map(Cartella.class::cast).findFirst().orElse(cartellaAttuale);
                    }
                    break;

                case "dir":
                    Cartella cartella = new Cartella();
                    cartella.parent = cartellaAttuale;
                    cartella.nome = partiLinea[1];
                    cartellaAttuale.contenuti.add(cartella);
                    break;

                default:
                    // caso primi caratteri numerici di lettura dei i file
                    File file = new File();
                    file.parent = cartellaAttuale;
                    file.nome = partiLinea[1];
                    file.dimensioneFile = Long.parseLong(partiLinea[0]);
                    cartellaAttuale.contenuti.add(file);

                    break;
            }
        }

        System.out.println(
                root.streamContenuti()
                        .filter(c -> c.getSize() < 100000)
                        .mapToLong(Cartella::getSize).sum()
        );

            //"-------------------seconda parte :--------------- "
        //trovo in ricorsione la cartella più piccola che sia >= minimoSpazioCartellaDaEliminare
        System.out.print("valore cartella da eliminare: ");
        System.out.println(
                root.streamContenuti()
                        .filter(c -> c.getSize() >= 30000000 - (70000000 - root.getSize()))
                        .mapToLong(Cartella::getSize).reduce(Long::min).getAsLong()
        );

    }
}