package br.inatel.cdg.service;

import br.inatel.cdg.model.Jogo;
import br.inatel.cdg.model.Platform;
import br.inatel.cdg.model.Publisher;

import java.util.ArrayList;
import java.util.List;

public class ServiceGame {

    public static List<Jogo> getListByPlatform(List<Jogo> games, Platform platform){
        List<Jogo> gamesByPlatform = new ArrayList<>();

        games.stream().filter((game ->
                        game.getPlatform().equals(platform.name()))).
                forEach(game -> gamesByPlatform.add(game));

        return gamesByPlatform;

    }

    public static List<Jogo> getByPuBlisher(List<Jogo> games ,
                                            Publisher publisher){
        List<Jogo> gamesByPublisher = new ArrayList<>();

        games.stream().filter((game ->
                        game.getPublisher().replaceAll("\\s+", "").equals(publisher.name()))).
                forEach(game -> gamesByPublisher.add(game));

        return gamesByPublisher;
    }

}
