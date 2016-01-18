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
 * An endpoint class we are exposing
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

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name="getJoke")
    public MyBean getJoke() {

    //@ApiMethod(name = "sayHi")
   // public MyBean sayHi(@Named("name") String name) {

        MyBean response = new MyBean();
        // response.setData("Hi, " + name);

        Jokes jokes = new Jokes();
        Joke joke = jokes.getNextJoke();
        response.setData(joke.getJoke());

        return response;
    }

}
