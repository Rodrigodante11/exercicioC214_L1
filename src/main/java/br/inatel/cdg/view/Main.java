package br.inatel.cdg.view;

import br.inatel.cdg.model.Jogo;
import br.inatel.cdg.model.Platform;
import br.inatel.cdg.model.Publisher;
import br.inatel.cdg.service.ServiceGame;
import br.inatel.cdg.utils.CsvUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Path caminho = Paths.get("vendas-games.csv");

        List<Jogo> gameList = CsvUtils.readGameCsv(caminho);

        int numLines = gameList.size();
        System.out.println("linhas: " + numLines);

        List<Jogo> ps4Games = ServiceGame.getListByPlatform(gameList, Platform.PS4);

        System.out.println("jogos de ps4: " + ps4Games.size());
        ps4Games.forEach(e -> System.out.println(e.getName()));//imprimindo o nome dos jogos de ps4
        System.out.println("");
        List<Jogo> activisionGames = ServiceGame.getByPuBlisher(gameList, Publisher.Activision);
        System.out.println("activision: " + activisionGames.size());
        activisionGames.forEach(e -> System.out.println(e.getName()));//imprimindo o nome dos jogos da activison

    }

}