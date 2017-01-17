package com.example.wellington.joke.backend;

import com.example.Joker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

/**
 * An endpoint class we are exposing
 */
@Api(name = "jokeApi", version = "v1")
public class JokeEndpoint {

    /**
     * A simple endpoint method that gets a joke
     */
    @ApiMethod(name = "getJoke")
    public JokeBean getJoke() {
        JokeBean jokeBean = new JokeBean();
        Joker joker = new Joker();
        String craftedJoke = joker.tellAHandCraftedJoke();
        jokeBean.setJoke(craftedJoke);

        return jokeBean;
    }
}
