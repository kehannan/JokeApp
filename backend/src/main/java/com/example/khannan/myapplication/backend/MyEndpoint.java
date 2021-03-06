/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.khannan.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.khannan.Joke;
import com.khannan.Jokes;


/**
 * Based on starter code from Google Developer web site.
 *
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.khannan.example.com",
                ownerName = "backend.myapplication.khannan.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name="getJokeRemote")
    public MyBean getJokeRemote() {

        MyBean response = new MyBean();

        Jokes jokes = new Jokes();
        Joke joke = jokes.getJoke();
        response.setData(joke.getJokeText());

        return response;
    }

}
